package posie;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;


public class Poise {

    private static final String several = System.getenv("Several");
    private static final String alone = System.getenv("Alone");
    private static final String url = System.getenv("Url");
    private static final String key = System.getenv("RestApiKey");
    private static final String keyPrefix = System.getenv("KeyPrefix");

    public static void main(String[] args) {
        post(url);
    }

    public static void post(String requestUrl) {
        File file = new File("asd.jpg");
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("file", file.getName(),
                            RequestBody.create(MediaType.parse("image/*"), file))
                    .build();

            Request request = new Request.Builder()
                    .addHeader("Authorization", keyPrefix + " " + key)
                    .addHeader("Content-Type", "multipart/form-data")
                    .url(requestUrl)
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();

            ObjectMapper mapper = new ObjectMapper();
            String message = response.body().string();
            System.out.println(message);
            List<LinkedHashMap> imagePoise = mapper.readValue(message, List.class);


            PosePosition posePosition = new PosePosition(file);
            posePosition.paint();
            for (LinkedHashMap poise : imagePoise) {
                List<Double> keyPoints = (List) poise.get("keypoints");
                for (int i = 0; i < keyPoints.size();) {
                    double x = keyPoints.get(i++);
                    double y = keyPoints.get(i++);
                    double score = keyPoints.get(i++);
                    if (score > 0.7) {
                        posePosition.drawPoint(x, y);
                    }
                }
            }
            posePosition.saveCanvas();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
