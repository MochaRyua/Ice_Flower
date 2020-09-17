package payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImagePoise {

    private Float area;

    private Float[] bbox;

    private int category_id;

    private Float[] keypoints;

    private Float score;

}
