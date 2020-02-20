package shapes;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point p1 = new Point(0,0);
        Point p2 = new Point(30, 30);

        Line line = new Line(p1, p2);

        assertEquals(0,line.getPoint1().getX(),0);
        assertEquals(0,line.getPoint1().getY(),0);
        assertEquals(30,line.getPoint2().getX(),0);
        assertEquals(30,line.getPoint2().getY(),0);
    }

    @Test
    public void testInvalidConstruction() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(30, 30);

        try {
            new Line(p1, null);
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Line(Double.POSITIVE_INFINITY, 0, 30, 30);
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }
    }

    @Test
    public void getPoint1() throws ShapeException{
       Point point1 = new Point(10, 20);
       Point point2 = new Point(30,40);
       Line line=new Line(point1,point2);
       assertEquals(point1.getX(),line.getPoint1().getX(),0);
       assertEquals(point1.getY(),line.getPoint1().getY(),0);
    }

    @Test
    public void getPoint2() throws ShapeException {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30,40);
        Line line=new Line(point1,point2);
        assertEquals(point2.getX(),line.getPoint2().getX(),0);
        assertEquals(point2.getY(),line.getPoint2().getY(),0);
    }

    @Test
    public void move() throws ShapeException{
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30,40);
        Line line=new Line(point1,point2);
        line.move(20,30);
        assertEquals(point1.getX()+20,line.getPoint1().getX(),0);
        assertEquals(point1.getY()+30,line.getPoint1().getY(),0);
        assertEquals(point2.getX()+20,line.getPoint2().getX(),0);
        assertEquals(point2.getY()+30,line.getPoint2().getY(),0);
    }

    @Test
    public void computeLength() throws ShapeException{
        Point point1 = new Point(0, 0);
        Point point2 = new Point(30,40);
        Line line=new Line(point1,point2);
        assertEquals(50,line.computeLength(),0);
    }

    @Test
    public void computeSlope() throws ShapeException{
        Point point1 = new Point(0, 0);
        Point point2 = new Point(40,40);
        Line line=new Line(point1,point2);
        assertEquals(1,line.computeSlope(),0);
    }

    @Test
    public void computeArea() throws ShapeException{
        Point point1 = new Point(0, 0);
        Point point2 = new Point(40,40);
        Line line=new Line(point1,point2);
        assertEquals(0,line.computeArea(),0);
    }

    @Test
    public void scale() throws ShapeException{
        Point point1 = new Point(10, 10);
        Point point2 = new Point(40,40);
        Line line=new Line(point1,point2);
        line.scale(5);
        assertEquals(point1.getX(),line.getPoint1().getX(),0);
        assertEquals(point1.getY(),line.getPoint1().getY(),0);
        assertEquals(160,line.getPoint2().getX(),0);
        assertEquals(160,line.getPoint2().getY(),0);
    }

    @Test
    public void render() throws ShapeException{
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
            assertTrue(ImageIO.write(bImg, "png", new File("F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\Line.png")));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}