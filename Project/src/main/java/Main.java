import shapes.Line;
import shapes.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception{
        Point point1 = new Point(0, 0);
        Point point2 = new Point(40,40);
        Line line=new Line(point1,point2);

        BufferedImage bImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bImg.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 100, 100);
        graphics.setColor(Color.BLACK);

        line.render(graphics);

        try {
            ImageIO.write(bImg, "png", new File("E:\\image.png"));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
