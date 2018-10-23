import com.builtio.contentstack.*;
import com.builtio.contentstack.Error;
import org.junit.Test;
import testcases.builtio.contentstack.AssetTestCase;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class testContent {
    private static final String TAG = "AssetTestCase";
    public static final String DEFAULT_APPLICATION_KEY = "bltc86da631848cae03";
    public static final String DEFAULT_ACCESS_TOKEN = "blt43359585f471685188b2e1ba";
    public static final String DEFAULT_ENV = "env1";

    private CountDownLatch latch;
    private Stack stack;
    private String[] containArray;
    private ArrayList<Entry> entries = null;

    public testContent() throws Exception {
//        stack = Contentstack.stack("siteApiKey", "deliveryToken", "enviroment_name");
        Config config = new Config();
        config.setHost("api.contentstack.io");
        stack = Contentstack.stack( DEFAULT_APPLICATION_KEY, DEFAULT_ACCESS_TOKEN, DEFAULT_ENV, config);
        latch = new CountDownLatch(1);
    }


    @Test
    public void legoStack() throws InterruptedException {
        final Entry entry = this.stack.contentType("multifield").entry("blt41217c3f7b805076");
//        https://images.contentstack.io/v3/assets/bltc0bb91d1ac4cba37/blt41217c3f7b805076/5b99134b83fc379f34f5b875/container.png
        entry.fetch(new EntryResultCallBack() {
            public void onCompletion(ResponseType responseType, Error error) {
                if (error == null) {
                    Asset asset = entry.getAsset("imagefile");
                    System.out.println( entry.toJSON());
                    System.out.println( asset.toJSON());
                    System.out.println( asset.getFileType());

                } else {

                }

            }
        });

        try {
            this.latch.await();
        } catch (Exception var3) {
            System.out.println("---------------||" + var3.toString());
        }

    }


    @Test
    public void test01_Asset_getAsset() throws InterruptedException {

        final Entry entry = stack.contentType("multifield").entry("blt1b1cb4f26c4b682e");
//        final Entry entry = stack.contentType("multifield").entry("blt69a06b75160147adc2c8b3a9");
        entry.fetch(new EntryResultCallBack() {
            @Override
            public void onCompletion(ResponseType responseType, Error error) {

                if (error == null) {
                    System.out.println( "----------Test--Asset-01--Success---------" + entry.toJSON());
                    Asset asset = entry.getAsset("imagefile");
                    System.out.println( "----------Test--Asset-01--Success---------" + asset.toJSON());
                    System.out.println( asset.getFileName());


                    latch.countDown();
                } else {
                    latch.countDown();
                    System.out.println( "----------Test--Asset--01--Error---------" + error.getErrorMessage());
                    System.out.println( "----------Test--Asset--01--Error---------" + error.getErrorCode());
                    System.out.println( "----------Test--Asset--01--Error---------" + error.getErrors());
                }

            }
        });

        try{
            latch.await();
        }catch(Exception e){
            System.out.println("---------------||"+e.toString());
        }

    }

}
