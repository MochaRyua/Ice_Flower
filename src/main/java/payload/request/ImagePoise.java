package payload.request;

import lombok.Getter;

@Getter
public class ImagePoise {

    private Float area;

    private Float[] bbox;

    private int category_id;

    private Float[] keypoints;

    private Float score;

}
