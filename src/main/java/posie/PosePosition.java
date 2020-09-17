package posie;

import lombok.SneakyThrows;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;

import javax.imageio.ImageIO;

public class PosePosition extends Canvas {

    private final File file;
    private final BufferedImage image;
    private final Graphics2D g2;

    public PosePosition(File file) {
        this.file = file;
        super.setSize(626 , 352);

        image = new BufferedImage(this.getWidth(), this.getHeight(),BufferedImage.TYPE_INT_RGB);
        g2 = (Graphics2D)image.getGraphics();
    }

    @SneakyThrows
    public void paint() {
        Image image = (Toolkit.getDefaultToolkit().createImage(Files.readAllBytes(file.toPath())));

        g2.drawImage(image, 0, 0, 626, 352, this);
        g2.setColor(Color.RED);

        Rectangle rectangle = new Rectangle();
        rectangle.setRect(128.8169, 59.7, 244.1662, 309.6);
        g2.draw(rectangle);
    }

    public void drawPoint(double x, double y) {
        g2.fill(new RoundRectangle2D.Double(x, y, 5, 5, 5, 5));
    }

    public void saveCanvas() {
        try {
            ImageIO.write(image, "jpg", new File("D:/test/test.jpg"));
        } catch (Exception ignored) {

        }
    }
}