package shapes;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;

import static org.junit.Assert.*;

public class PointTest{

    @Test
    public void testValidConstruction() throws Exception {
        Point point = new Point(10,20);
        assertEquals(10, point.getX(), 0);
        assertEquals(20, point.getY(), 0);
}

    @Test
    public void testInvalidConstruction() {

        try {
            new Point(1, Double.POSITIVE_INFINITY);
        } catch (Exception e) {
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Point(1,Double.NaN);
        } catch (Exception e) {
            assertEquals("Invalid Point", e.getMessage());
        }

    }

    @Test
    public void getX() throws ShapeException {
        Point point=new Point(10,20);
        assertEquals(10,point.getX(),0);
    }

    @Test
    public void getY() throws ShapeException{
        Point point=new Point(10,20);
        assertEquals(20,point.getY(),0);
    }

    @Test
    public void setX() throws ShapeException {
        Point point=new Point(10,20);
        point.setX(20);
        assertEquals(20,point.getX(),0);
    }

    @Test
    public void setY() throws ShapeException {
        Point point=new Point(10,20);
        point.setX(30);
        assertEquals(30,point.getX(),0);
    }

    @Test
    public void moveX()  throws ShapeException{
        Point point=new Point(10,20);
        point.moveX(30);
        assertEquals(40,point.getX(),0);
    }

    @Test
    public void moveY() throws ShapeException{
        Point point=new Point(10,20);
        point.moveY(30);
        assertEquals(50,point.getY(),0);
    }

    @Test
    public void move() throws ShapeException{
        Point point=new Point(10,20);
        point.move(30,30);
        assertEquals(40,point.getX(),0);
        assertEquals(50,point.getY(),0);
        try{
        point.move((1.0/0.0),4.0);}
        catch (Exception e){
        assertEquals("Invalid delta value for move operation",e.getMessage());
        }

        try{
            point.move((1.0/0.0),4.0);}
        catch (Exception e){
            assertEquals("Invalid delta value for move operation",e.getMessage());
        }

        try{
            point.moveY(1.0/0.0);}
        catch (Exception e){
            assertEquals("Invalid delta value for move operation",e.getMessage());
        }


    }


    @Test
    public void copy() throws ShapeException{
        Point point1=new Point(10,20);
        Point point2= point1.copy();
        assertEquals(point1.getX(),point2.getX(),0);
        assertEquals(point1.getY(),point2.getY(),0);
    }

    @Test
    public void scale() throws ShapeException{
        Point point=new Point(10,20);
        Point point1=point.copy();
        point1.scale(5);
        assertEquals(point.getX(),point1.getX(),0);
        assertEquals(point.getY(),point1.getY(),0);
    }

    @Test
    public void computeArea() throws ShapeException{
        Point point=new Point(10,20);
        assertEquals(0,point.computeArea(),0);
    }

    @Test
    public void render() throws ShapeException{
        Point point=new Point(10,20);

        BufferedImage bImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bImg.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 100, 100);
        graphics.setColor(Color.BLACK);

        point.render(graphics);

        try {
            assertTrue(ImageIO.write(bImg, "png", new File("F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\Point.png")));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}