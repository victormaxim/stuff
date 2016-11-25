package base.data;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by optaros on 7/23/14.
 */
public enum PROP {

    BASE_URL,
    MAX_TIMEOUT,
	CHROME_DRIVER_PATH,
	SCREENSHOT_PATH;

	private String propValue;

	PROP(){
		Properties properties = new Properties();

		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("newpig.properties"));
			this.propValue = properties.getProperty(this.name());
		} catch (IOException e) { throw new RuntimeException("Cannot find properties file", e);
		}
	}

	public String get() {
		return propValue;
	}
}
