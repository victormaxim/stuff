import com.builtio.contentstack.*;
import com.builtio.contentstack.Error;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class legoStacks {

    private static final String DEFAULT_SITEAPIKEY_KEY = "blt30939a4536f1de9a";
    private static final String DEFAULT_ACCESS_TOKEN = "blta9faba80c01e6f2d";
    private static final String DEFAULT_ENV = "preview";
    private static final String AUTH_TOKEN = "blt7174192351983379";
    private static final String ORG_ID = "bltc86da631848cae03";
    private static final String CUSTOM_STACK_API_KEY = new String();
    private static String STACK_API_KEY = new String();

    private Stack stack;
    private String jsonBody;
    private RequestSpecification request;

    public legoStacks() throws Exception {
        Config config = new Config();
        config.setHost("api.contentstack.io");
        stack = Contentstack.stack( DEFAULT_SITEAPIKEY_KEY, DEFAULT_ACCESS_TOKEN, DEFAULT_ENV);
        RestAssured.baseURI ="https://api.contentstack.io/v3";

    }


    @Test
    public void getStackContent() throws Exception {
//        final Entry entry = this.stack.contentType("firstpage").entry("bltc5823a54e23aeb41");
//        final Entry entry = getStackContentByParams("firstpage", "bltc5823a54e23aeb41");
        stack = Contentstack.stack( "blt3f8ac92157533bc5", "bltbbdbb2a1098e45cc", DEFAULT_ENV);
        final Entry entry = getStackContentByParams("product", "bltfeb7ebbe2e352de1");

        entry.fetch(new EntryResultCallBack() {
            public void onCompletion(ResponseType responseType, Error error) {
                if (error == null) {
                    System.out.println(entry.getLanguage());
                    System.out.println(entry.getTitle());
                }
            }
        });
    }

    public Entry getStackContentByParams(String contentTypeName, String entryUid) {
        Entry entry = this.stack.contentType(contentTypeName).entry(entryUid);
        return entry;
    }

//    public void getStackContentOld() {
//        final Entry entry = this.stack.contentType("firstpage").entry("bltc5823a54e23aeb41");
//
//        entry.fetch(new EntryResultCallBack() {
//            public void onCompletion(ResponseType responseType, Error error) {
//                if (error == null) {
//                    System.out.println(entry.getLanguage());
//                    System.out.println(entry.getTitle());
//                }
//            }
//        });
//    }



    @Test
    public void createStack() throws URISyntaxException, IOException, NullPointerException {
        RestAssured.basePath="/stacks";
        requestBody("bodyStackInfo3.json");
        requestHeaders("createStack");
        Response response = request.post();
        String successCode = response.body().asString();
        System.out.println(response.getStatusLine());
        System.out.println(response.asString());
        STACK_API_KEY = response.jsonPath().get("stack.api_key").toString();

        //write stack ID to file so it can be deleted in another test
        try (PrintWriter out = new PrintWriter("resources/stack_api_key")) {
            out.println(STACK_API_KEY);
        }
        assertThat(successCode, containsString("Stack created successfully."));
    }

    @Test
    public void createContentType() throws URISyntaxException, IOException, NullPointerException {
        RestAssured.basePath="/content_types";
        requestBody("contentType.json");
        requestHeaders("createContentType");
        Response response = request.post();
        String successCode = response.body().asString();
        System.out.println(response.getStatusLine());
        System.out.println(response.asString());

        assertThat(successCode, containsString("Stack created successfully."));
    }

    @Test
    public void createEntry() throws URISyntaxException, IOException, NullPointerException {
        RestAssured.basePath="/content_types/product/entries?locale=en-us";
        requestBody("bodyEntry.json");
        requestHeaders("createEntry");
        Response response = request.post();
        String successCode = response.body().asString();
        System.out.println(response.getStatusLine());
        System.out.println(response.asString());

        assertThat(successCode, containsString("Stack created successfully."));
    }


    @Test
    public void deleteStack() throws URISyntaxException, IOException, NullPointerException {
        RestAssured.basePath="/stacks";
        requestHeaders("deleteStack");
        Response response = request.delete();
        String successCode = response.body().asString();
        System.out.println(response.getStatusLine());
        assertThat(successCode, containsString("Stack deleted successfully"));
    }

    private void  requestBody(String fileName) throws URISyntaxException, IOException {
        try {
            jsonBody = new String(Files.readAllBytes(Paths.get(getClass().getResource(fileName).toURI())));
        }
        catch (NullPointerException e){
            System.out.println(e);
        }
    }

    private RequestSpecification requestHeaders(String type) throws URISyntaxException, IOException {
        List<Header> headerList = new ArrayList<>();
        //reads the stack ID from a previous automatically created stack
        try {
            STACK_API_KEY = new String(Files.readAllBytes(Paths.get(getClass().getResource("stack_api_key").toURI()))).trim();
        }
        catch (NullPointerException e){
            System.out.println(e);
        }

        Header stack_api_key = new Header("api_key", STACK_API_KEY);
        Header api_key_custom = new Header("api_key", CUSTOM_STACK_API_KEY);
        Header auth_token = new Header("authtoken", AUTH_TOKEN);
        Header org_id = new Header("organization_uid", ORG_ID);
        headerList.clear();

        request = RestAssured.given().request().
                contentType("application/json");

        switch (type){
            case "createStack":
                headerList.add(auth_token);
                headerList.add(org_id);
                request.body(jsonBody);
                break;
            case "deleteStack":
                headerList.add(auth_token);
                headerList.add(stack_api_key);
                break;
            case "createEntry": case "createContentType":
                headerList.add(auth_token);
                headerList.add(stack_api_key);
                request.body(jsonBody);
                break;
        }

        Headers header = new Headers(headerList);
        request.headers(header);

        return request;
    }

    @Test
    public void parseQueryResults(){
        Query query = stack.contentType("firstpage").query();
        query.find(new QueryResultsCallBack() {
            @Override
            public void onCompletion(ResponseType responseType, QueryResult queryResult, com.builtio.contentstack.Error error) {
                if (error == null) {
                    for (Entry entry: queryResult.getResultObjects()) {
                        System.out.println("Title: " + entry.getString("title"));
                    }
                } else {
                    System.out.println("Failed: " + error.getErrorCode());
                }

            }
        });
    }

    @Test
    public void snippets() {
        ContentType contentType = stack.contentType("content_type_uid");
        final Entry entry = contentType.entry("blt41217c3f7b805076");

        entry.fetch(new EntryResultCallBack() {
            @Override
            public void onCompletion(ResponseType responseType, Error error) {
                if (error == null) {
                    Asset asset = entry.getAsset("imagefile");

                    System.out.println(entry.toJSON());
                    System.out.println(asset.toJSON());
                    System.out.println( asset.getFileName());
                } else {
                    System.out.println(error.getErrorMessage());
                    System.out.println(error.getErrorCode());
                    System.out.println(error.getErrors());
                }

            }
        });
    }


//    private RequestSpecification requestHeadersCreateStack() throws URISyntaxException, IOException {
//        request = RestAssured.given().request().
//                header("authtoken", AUTH_TOKEN).
//                header("organization_uid", ORG_ID).
//                contentType("application/json").
//                body(jsonBody);
//        return request;
//    }
//
//    private RequestSpecification requestHeadersCreateEntry() throws URISyntaxException, IOException {
//        //reads the stack ID from a previous automatically created stack
//        try {
//            STACK_API_KEY = new String(Files.readAllBytes(Paths.get(getClass().getResource("stack_api_key").toURI())));
//        }
//        catch (NullPointerException e){
//            System.out.println(e);
//        }
//        request = RestAssured.given().request().
//                header("api_key", STACK_API_KEY).
//                header("authtoken", AUTH_TOKEN).
//                contentType("application/json").
//                body(jsonBody);
//        return request;
//    }
//
//    private RequestSpecification requestHeadersCreateContentType() throws URISyntaxException, IOException {
//        //reads the stack ID from a previous automatically created stack
//        try {
//            STACK_API_KEY = new String(Files.readAllBytes(Paths.get(getClass().getResource("stack_api_key").toURI())));
//        }
//        catch (NullPointerException e){
//            System.out.println(e);
//        }
//        request = RestAssured.given().request().
//                header("api_key", STACK_API_KEY).
//                header("authtoken", AUTH_TOKEN).
//                contentType("application/json").
//                body(jsonBody);
//        return request;
//    }
//
//    private RequestSpecification requestHeadersDeleteStack(String api_key) throws URISyntaxException, IOException {
//        request = RestAssured.given().request().
//                header("api_key", api_key).
//                header("authtoken", AUTH_TOKEN);
//        return request;
//    }
//
//
//    private RequestSpecification createRequest(String fileName) throws URISyntaxException, IOException {
//        try {
//            jsonBody = new String(Files.readAllBytes(Paths.get(getClass().getResource(fileName).toURI())));
//        }
//        catch (NullPointerException e){
//            System.out.println(e);
//        }
//
//        request = RestAssured.given().request().
//                header("authtoken", AUTH_TOKEN).
//                header("api_key", "bltc86da631848cae03").
//                contentType("application/json").
//                body(jsonBody);
//        return request;
//    }

//    @Test
//    public void deleteStackOld() throws URISyntaxException, IOException, NullPointerException {
//        //reads the stack ID from a previous automatically created stack
//        try {
//            STACK_API_KEY = new String(Files.readAllBytes(Paths.get(getClass().getResource("stack_api_key").toURI())));
//            STACK_API_KEY.trim();
//        }
//        catch (NullPointerException e){
//            System.out.println(e);
//        }
//
//        requestHeadersDeleteStack(STACK_API_KEY.trim());
//        Response response = request.delete();
//        String successCode = response.body().asString();
//        System.out.println(response.getStatusLine());
//        assertThat(successCode, containsString("Stack deleted successfully"));
//
//    }
//
//    @Test
//    public void createStackOld() throws URISyntaxException, IOException, NullPointerException {
//        RestAssured.basePath="/stacks";
//        requestBody("bodyStackInfo.json");
//        requestHeadersCreateStack();
//        Response response = request.post();
//        String successCode = response.body().asString();
//        System.out.println(response.getStatusLine());
//        System.out.println(response.asString());
//        STACK_API_KEY = response.jsonPath().get("stack.api_key").toString();
//
//        //write stack ID to file so it can be deleted in another test
//        try (PrintWriter out = new PrintWriter("resources/stack_api_key")) {
//            out.println(STACK_API_KEY);
//        }
//        assertThat(successCode, containsString("Stack created successfully."));
//    }




}
