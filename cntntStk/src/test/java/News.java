import com.builtio.contentstack.*;

public class News {

    public static void main(String[] args) {
        Stack stack = null;
        try {
            stack = Contentstack.stack("blt920bb7e90248f607", "blt0c4300391e033d4a59eb2857", "production");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Query query = stack.contentType("news").query();
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
}