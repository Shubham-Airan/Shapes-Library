package extendedShapes;
import org.junit.Assert;
import org.junit.Test;
import shapes.*;
import shapes.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void invalidConstruction() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(1,1);
        Point point3=new Point(2,2);
        try {
            new Triangle(point1,point2,point3);
        } catch (ShapeException e) {
            assertEquals("points are collinear", e.getMessage());
        }

        try {
            new Triangle(null,point2,point3);
        }
        catch (ShapeException e){
            assertEquals("Invalid Points",e.getMessage());
        }

    }

    @Test
    public void getPoint1() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(3,0);
        Point point3=new Point(3,4);
        Triangle triangle=new Triangle(point1,point2,point3);
        assertEquals(point1.getX(),triangle.getPoint1().getX(),0);
        assertEquals(point1.getY(),triangle.getPoint1().getY(),0);
    }

    @Test
    public void getPoint2() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(3,0);
        Point point3=new Point(3,4);
        Triangle triangle=new Triangle(point1,point2,point3);
        assertEquals(point2.getX(),triangle.getPoint2().getX(),0);
        assertEquals(point2.getY(),triangle.getPoint2().getY(),0);
    }

    @Test
    public void getPoint3() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(3,0);
        Point point3=new Point(3,4);
        Triangle triangle=new Triangle(point1,point2,point3);
        assertEquals(point3.getX(),triangle.getPoint3().getX(),0);
        assertEquals(point3.getY(),triangle.getPoint3().getY(),0);
    }


    @Test
    public void move() throws ShapeException{
        Point point1=new Point(0,0);
        Point point2=new Point(3,0);
        Point point3=new Point(3,4);
        Triangle triangle=new Triangle(point1,point2,point3);
        triangle.move(2,3);
        assertEquals(point1.getX()+2,triangle.getPoint1().getX(),0);
        assertEquals(point1.getY()+3,triangle.getPoint1().getY(),0);
        assertEquals(point2.getX()+2,triangle.getPoint2().getX(),0);
        assertEquals(point2.getY()+3,triangle.getPoint2().getY(),0);
        assertEquals(point3.getX()+2,triangle.getPoint3().getX(),0);
        assertEquals(point3.getY()+3,triangle.getPoint3().getY(),0);
    }

    @Test
    public void computeArea() throws ShapeException{
        Triangle triangle=new Triangle(0,0,3,0,3,4);
        assertEquals(6,triangle.computeArea(),0);
    }

    @Test
    public void scale() throws ShapeException{
        Point point1=new Point(1,1);
        Point point2=new Point(5,1);
        Point point3=new Point(5,5);
        Triangle triangle=new Triangle(point1,point2,point3);
        triangle.scale(2);
        assertEquals(point1.getX(),triangle.getPoint1().getX(),0);
        assertEquals(point1.getY(),triangle.getPoint1().getY(),0);
        assertEquals(5,triangle.getPoint2().getX(),0);
        assertEquals(1,triangle.getPoint2().getY(),0);
        assertEquals(5,triangle.getPoint3().getX(),0);
        assertEquals(5,triangle.getPoint3().getY(),0);
    }

    @Test
    public void render() throws ShapeException{

        Point point1=new Point(0,0);
        Point point2=new Point(30,0);
        Point point3=new Point(30,40);
        Triangle triangle=new Triangle(point1,point2,point3);


        BufferedImage bImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bImg.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 100, 100);
        graphics.setColor(Color.BLACK);

        triangle.render(graphics);

        try {
            assertTrue(ImageIO.write(bImg, "png", new File("F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\Triangle.png")));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}