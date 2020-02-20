package extendedShapes;
import org.junit.Assert;
import shapes.*;
import org.junit.Test;
import shapes.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void invalidConstructionTest() throws ShapeException{
        try {
            new Rectangle(0,0,1,2,3,4,5,6);
        }
        catch (ShapeException e){
            assertEquals("Not valid points for rectangle",e.getMessage());
        }

        try {
            new Rectangle(null,null,null,null);
        }
        catch (ShapeException e){
            assertEquals("Invalid Point",e.getMessage());
        }


    }

    @Test
    public void move() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(30,0);
        Point point3=new Point(30,30);
        Point point4=new Point(0,30);
        Rectangle rectangle=new Rectangle(point1,point2,point3,point4);
        rectangle.move(10,20);

        assertEquals(point1.getX()+10,rectangle.getPoint1().getX(),0);
        assertEquals(point1.getY()+20,rectangle.getPoint1().getY(),0);
        assertEquals(point2.getX()+10,rectangle.getPoint2().getX(),0);
        assertEquals(point2.getY()+20,rectangle.getPoint2().getY(),0);
        assertEquals(point3.getX()+10,rectangle.getPoint3().getX(),0);
        assertEquals(point3.getY()+20,rectangle.getPoint3().getY(),0);
        assertEquals(point4.getX()+10,rectangle.getPoint4().getX(),0);
        assertEquals(point4.getY()+20,rectangle.getPoint4().getY(),0);

    }

    @Test
    public void getPoint1() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(30,0);
        Point point3=new Point(30,30);
        Point point4=new Point(0,30);
        Rectangle rectangle=new Rectangle(point1,point2,point3,point4);
        assertEquals(point1.getX(),rectangle.getPoint1().getX(),0);
        assertEquals(point1.getY(),rectangle.getPoint1().getY(),0);
    }

    @Test
    public void getPoint2() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(30,0);
        Point point3=new Point(30,30);
        Point point4=new Point(0,30);
        Rectangle rectangle=new Rectangle(point1,point2,point3,point4);
        assertEquals(point2.getX(),rectangle.getPoint2().getX(),0);
        assertEquals(point2.getY(),rectangle.getPoint2().getY(),0);
    }

    @Test
    public void getPoint3() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(30,0);
        Point point3=new Point(30,30);
        Point point4=new Point(0,30);
        Rectangle rectangle=new Rectangle(point1,point2,point3,point4);
        assertEquals(point3.getX(),rectangle.getPoint3().getX(),0);
        assertEquals(point3.getY(),rectangle.getPoint3().getY(),0);
    }

    @Test
    public void getPoint4() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(30,0);
        Point point3=new Point(30,30);
        Point point4=new Point(0,30);
        Rectangle rectangle=new Rectangle(point1,point2,point3,point4);
        assertEquals(point4.getX(),rectangle.getPoint4().getX(),0);
        assertEquals(point4.getY(),rectangle.getPoint4().getY(),0);
    }

    @Test
    public void scale() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(30,0);
        Point point3=new Point(30,30);
        Point point4=new Point(0,30);
        Rectangle rectangle=new Rectangle(point1,point2,point3,point4);
        rectangle.scale(2);
        assertEquals(point1.getX(),rectangle.getPoint1().getX(),0);
        assertEquals(point1.getY(),rectangle.getPoint1().getY(),0);
        assertEquals(30,rectangle.getPoint2().getX(),0);
        assertEquals(0,rectangle.getPoint2().getY(),0);
        assertEquals(30,rectangle.getPoint3().getX(),0);
        assertEquals(30,rectangle.getPoint3().getY(),0);
        assertEquals(0,rectangle.getPoint4().getX(),0);
        assertEquals(30,rectangle.getPoint4().getY(),0);
    }

    @Test
    public void computeArea() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(30,0);
        Point point3=new Point(30,30);
        Point point4=new Point(0,30);
        Rectangle rectangle=new Rectangle(point2,point3,point4,point1);
        assertEquals(900,rectangle.computeArea(),0);
    }

    @Test
    public void render() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(15,15);
        Point point3=new Point(0,30);
        Point point4=new Point(-15,15);
        Rectangle rectangle=new Rectangle(point1,point2,point3,point4);

        BufferedImage bImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bImg.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 100, 100);
        graphics.setColor(Color.BLACK);

        rectangle.render(graphics);

        try {
            assertTrue(ImageIO.write(bImg, "png", new File("F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\Rectangle.png")));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}