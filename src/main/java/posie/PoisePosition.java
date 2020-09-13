package posie;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class PoisePosition extends Canvas {

    public static void main(String[] args) {
        Frame f = new Frame("Draw shape and text on Canvas");
        final Canvas canvas = new PoisePosition();

        f.add(canvas);

        f.setSize(626,352);
        f.setResizable(false);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                saveCanvas(canvas);
                System.exit(0);
            }
        });

    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Image image = (Toolkit.getDefaultToolkit().getImage("asd.jpg"));

        g2.drawImage(image, 0, 0, 626, 352, this);

        g2.setColor(Color.RED);

        g2.fill(new RoundRectangle2D.Double(255.7797, 98.5, 5, 5, 5, 5));
        g2.fill(new RoundRectangle2D.Double(272.4078, 91.5, 5, 5, 5, 5));
        g2.fill(new RoundRectangle2D.Double(236.2172, 85.5, 5, 5, 5, 5));
        g2.fill(new RoundRectangle2D.Double(289.0359, 108.5, 5, 5, 5, 5));
        g2.fill(new RoundRectangle2D.Double(206.8734, 97.5, 5, 5, 5, 5));
        g2.fill(new RoundRectangle2D.Double(324.2484, 220.5, 5, 5, 5, 5));
        g2.fill(new RoundRectangle2D.Double(149.1641, 193.5, 5, 5, 5, 5));


        Rectangle rectangle = new Rectangle();
        rectangle.setRect(128.8169, 59.7, 244.1662, 309.6);
        g2.draw(rectangle);

    }

    public static void saveCanvas(Canvas canvas) {

        BufferedImage image=new BufferedImage(canvas.getWidth(), canvas.getHeight(),BufferedImage.TYPE_INT_RGB);

        Graphics2D g2=(Graphics2D)image.getGraphics();


        canvas.paint(g2);
        try {
            System.out.println("asd");
            ImageIO.write(image, "jpg", new File("D:/test/test.jpg"));
        } catch (Exception e) {

        }
    }
}