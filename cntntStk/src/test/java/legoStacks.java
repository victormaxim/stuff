import com.builtio.contentstack.*;
import com.builtio.contentstack.Error;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.Charsets;
//import org.json.JSONObject;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import javax.annotation.Resources;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class legoStacks {

    public static final String DEFAULT_SITEAPIKEY_KEY = "blt30939a4536f1de9a";
    public static final String DEFAULT_ACCESS_TOKEN = "blta9faba80c01e6f2d";
    public static final String DEFAULT_ENV = "preview";

    private CountDownLatch latch;
    private Stack stack;
    private String[] containArray;
    private ArrayList<Entry> entries = null;

    public legoStacks() throws Exception {
//        Config config = new Config();
//        config.setHost("api.contentstack.io");
//        stack = Contentstack.stack( DEFAULT_SITEAPIKEY_KEY, DEFAULT_ACCESS_TOKEN, DEFAULT_ENV);
        stack = Contentstack.stack( "blt3f8ac92157533bc5", DEFAULT_ACCESS_TOKEN, DEFAULT_ENV);
        latch = new CountDownLatch(1);
        System.out.println("x");
    }


    @Test
    public void legoD() throws InterruptedException {
        final Entry entry = this.stack.contentType("firstpage").entry("bltc5823a54e23aeb41");
//        https://images.contentstack.io/v3/assets/bltc0bb91d1ac4cba37/blt41217c3f7b805076/5b99134b83fc379f34f5b875/container.png
        entry.fetch(new EntryResultCallBack() {
            public void onCompletion(ResponseType responseType, Error error) {
                if (error == null) {
                    System.out.println(entry.getLanguage());
                    System.out.println(entry.getTitle());
//                    Asset asset = entry.getAsset("imagefile");
//                    System.out.println( entry.toJSON());
//                    System.out.println( asset.toJSON());
//                    System.out.println( asset.getFileType());

                } else {

                }

            }
        });

        try {
            //this.latch.await();
        } catch (Exception var3) {
            System.out.println("---------------||" + var3.toString());
        }

    }

    @Test
    public void createStackEntry() throws URISyntaxException, IOException {
//        URL url = Resources.getResource("foo.txt");
//        String text = Resources.toString(url, Charsets.UTF_8);
        System.out.println(new String(Files.readAllBytes(Paths.get(getClass().getResource("foo.txt").toURI()))));
        String jsonBody = new String(Files.readAllBytes(Paths.get(getClass().getResource("foo.txt").toURI())));

        RestAssured.baseURI ="https://api.contentstack.io/v3/stacks";
        RequestSpecification request = RestAssured.given().request().
                header("authtoken", "blt7174192351983379").
                header("organization_uid", "bltc86da631848cae03").
                contentType("application/json").
                body(jsonBody)
                ;
//request.auth();
//        JSONObject requestParams = new JSONObject();
//        requestParams.put("FirstName", "Virender2"); // Cast
//        requestParams.put("LastName", "Singh2");
//        requestParams.put("UserName", "alex12340987511");
//        requestParams.put("Password", "password1");
//
//        requestParams.put("Email",  "sample2ee26d9123568@gmail.com");
//        request.body(requestParams.toJSONString());
//
////        request.body(requestParams.toString());

        Response response = request.post();

        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode, 200);
        System.out.println(response.getStatusLine());

        System.out.println(statusCode);
        String successCode = response.body().asString();
        System.out.println(response.jsonPath().get("SuccessCode"));
//        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
        System.out.println(successCode);
    }


    @Test
    public void RegistrationSuccessful() throws URISyntaxException, IOException {
//        URL url = Resources.getResource("foo.txt");
//        String text = Resources.toString(url, Charsets.UTF_8);
        System.out.println(new String(Files.readAllBytes(Paths.get(getClass().getResource("foo.txt").toURI()))));


        RestAssured.baseURI ="http://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender2"); // Cast
        requestParams.put("LastName", "Singh2");
        requestParams.put("UserName", "alex12340987511");
        requestParams.put("Password", "password1");

        requestParams.put("Email",  "sample2ee26d9123568@gmail.com");
        request.body(requestParams.toJSONString());

//        request.body(requestParams.toString());

        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode, 200);
        System.out.println(response.getStatusLine());

        System.out.println(statusCode);
        String successCode = response.body().asString();
        System.out.println(response.jsonPath().get("SuccessCode"));
//        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
        System.out.println(successCode);
    }

    @Test
    public void testA(){
        ContentType contentType = stack.contentType("content_type_uid");
        Entry blogEntry = contentType.entry("entry_uid");
        Query query = stack.contentType("image").query();

        blogEntry.fetch(new EntryResultCallBack() {
//            @Override
            public void onCompletion(ResponseType responseType, Error error) {
                if (error == null) {
                } else {
                    System.out.println("error" + error.getErrorMessage());

                }
            }
        });

    }



    @Test
    public void testC() throws Exception {
        stack = Contentstack.stack( DEFAULT_SITEAPIKEY_KEY, DEFAULT_ACCESS_TOKEN, DEFAULT_ENV);

        ContentType contentType = stack.contentType("content_type_uid");
        final Entry entry = contentType.entry("blt41217c3f7b805076");

//        Query query = stack.contentType("imagefile").query();

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






    @Test
    public void legoB() throws InterruptedException {
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


}
