package base.utils;

import base.data.PROP;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;

/**
 * Created by optaros on 5/23/15.
 */
public class MyTNGListener extends TestListenerAdapter {

	private static String screenShotsFolderName=null;
	Logger log = Logger.getLogger("TESTS");

	@Override
	public void onTestStart(ITestResult result) {
		log.info(String.format("---------------------------------  STARTED TEST %s.%s  ---------------------------------",result.getInstanceName(), result.getMethod().getMethodName()));
		super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info(String.format("---------------------------------  ENDED TEST %s.%s  ---------------------------------",result.getInstanceName(), result.getMethod().getMethodName()));
		super.onTestSuccess(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info(String.format("---------------------------------  SKIPPED TEST %s.%s  ---------------------------------",result.getInstanceName(), result.getMethod().getMethodName()));
		super.onTestSkipped(result);
	}

	@Override
	public void onTestFailure(ITestResult tr){


		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] screens = ge.getScreenDevices();

		Rectangle allScreenBounds = new Rectangle();
		for (GraphicsDevice screen : screens) {
			Rectangle screenBounds = screen.getDefaultConfiguration().getBounds();

			allScreenBounds.width += screenBounds.width;
			allScreenBounds.height = Math.max(allScreenBounds.height, screenBounds.height);
		}



		Robot robot;
		try {
			robot = new Robot();
			BufferedImage screenShot = robot.createScreenCapture(allScreenBounds);
			String fileName = "FAILED_"+ tr.getMethod().getMethodName() + "_" + Calendar.getInstance().getTimeInMillis();
			ImageIO.write(screenShot, "png", new File(getScreenshotFolder().getPath() + File.separator + fileName + ".png"));
			log.info("TEST FAILED, SCREENSHOT CREATED.");
		} catch (Exception e) {
			log.error("COULD NOT WRITE SCREENSHOT TO FILE ");
		}finally {
			log.info(String.format("---------------------------------  FAILED TEST %s.%s  ---------------------------------",tr.getInstanceName(), tr.getMethod().getMethodName()));
		}

	}


	private String getScreenshotsFolderName(){
		if(screenShotsFolderName == null){
			Calendar calendar = Calendar.getInstance();
			Integer month = calendar.get(Calendar.MONTH);
			Integer year = calendar.get(Calendar.YEAR);
			Integer day = calendar.get(Calendar.DAY_OF_MONTH);
			Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
			screenShotsFolderName = String.format("%s_%s_%s_H%s", year, month, day, hour);
		}
		return screenShotsFolderName;
	}

	private String assureDefaultScreenshotsFolder(){

		String path = PROP.SCREENSHOT_PATH.get();
		File theDir = new File(path+"screenshots");
		if (!theDir.exists()) {
			log.info("Creating default screenshot folder with path " + theDir.getPath());
			boolean result = false;
			try{
				theDir.mkdir();
				result = true;
			} catch(Exception se){
				throw new RuntimeException(se);
			}
			if(result) {
				log.info("Created default screenshot folder with path " + theDir.getPath());
			}
		}
		return theDir.getPath()+File.separator;
	}

	public File getScreenshotFolder(){
		String path = assureDefaultScreenshotsFolder();
		String folderName = getScreenshotsFolderName();

		File theDir = new File(path+folderName);
		if (!theDir.exists()) {
			log.info("Creating today's screenshot folder with path " + theDir.getPath());
			boolean result = false;
			try{
				theDir.mkdir();
				result = true;
			} catch(Exception se){
				throw new RuntimeException(se);
			}
			if(result) {
				log.info("Created today's screenshot folder with path " + theDir.getPath());
			}
		}
		return theDir;
	}

}
