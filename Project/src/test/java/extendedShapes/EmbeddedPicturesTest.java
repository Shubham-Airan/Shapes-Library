package extendedShapes;

import org.junit.Test;
import shapes.ShapeException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class EmbeddedPicturesTest {

    @Test
    public void move() throws ShapeException {
        EmbeddedPictures embeddedPictures=new EmbeddedPictures(20,20,10,10,"F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\java Cup.jpg");
        embeddedPictures.move(10,20);
        assertEquals(20,embeddedPictures.getpictureLocation().getX(),0);
        assertEquals(30,embeddedPictures.getpictureLocation().getY(),0);
    }

    @Test
    public void scale() throws ShapeException{
        EmbeddedPictures embeddedPictures=new EmbeddedPictures(20,30,10,10,"F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\java Cup.jpg");
        embeddedPictures.scale(2);
        assertEquals(40,embeddedPictures.getLength(),0);
        assertEquals(60,embeddedPictures.getWidth(),0);
    }

    @Test
    public void computeArea() throws ShapeException{
        EmbeddedPictures embeddedPictures=new EmbeddedPictures(20,30,10,10,"F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\java Cup.jpg");
        assertEquals(600,embeddedPictures.computeArea(),0);
    }

    @Test
    public void render() throws ShapeException{
        EmbeddedPictures embeddedPictures=new EmbeddedPictures(20,20,10,10,"F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\java Cup.jpg");

        BufferedImage bImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bImg.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 100, 100);
        graphics.setColor(Color.BLACK);

        embeddedPictures.render(graphics);

        try {
            assertTrue(ImageIO.write(bImg, "png", new File("F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\EmbeddedPicture.png")));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        EmbeddedPictures embeddedPictures1=new EmbeddedPictures(20,20,10,10,"F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\java Cup1.jpg");
        embeddedPictures1.render(graphics);

        try {
            assertTrue(ImageIO.write(bImg, "png", new File("F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\EmbeddedPicture1.png")));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }



}