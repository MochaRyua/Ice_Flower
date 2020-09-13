package posie;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import payload.request.ImagePoise;

import java.util.List;


public class Poise {

    private static final String several = System.getenv("Several");
    private static final String alone = System.getenv("Alone");
    private static final String url = System.getenv("Url") + several;
    private static final String key = System.getenv("RestApiKey");
    private static final String keyPrefix = System.getenv("KeyPrefix");

    public static void main(String[] args) {
        post(url);
    }

    public static void post(String requestUrl) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("Authorization", keyPrefix + " " + key)
                    .url(requestUrl)
                    .post(
                            RequestBody.create(
                                    MediaType.parse("application/x-www-form-urlencoded"), ""
                            )
                    )
                    .build();

            Response response = client.newCall(request).execute();

            ObjectMapper mapper = new ObjectMapper();
            if (response.body() != null) {
                String message = response.body().string();
                List<ImagePoise> imagePoise = mapper.readValue(message, List.class);
                System.out.println(imagePoise);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
