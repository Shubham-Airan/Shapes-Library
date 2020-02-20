package shapes;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point center = new Point(1,2);
        Circle circle = new Circle(center, 5);
        assertEquals(5, circle.getRadius(), 0);
    }


    @Test
    public void testInvalidConstruction() {

        try {
            new Circle(null, 2.5);
        } catch (ShapeException e) {
            assertEquals("Invalid center point", e.getMessage());
        }

        try {
            new Circle(Double.POSITIVE_INFINITY, 2, 3);
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }


        try {
            new Circle(Double.NaN, 2, 3);
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }


        try {
            new Circle(1, 2, Double.POSITIVE_INFINITY);
        } catch (ShapeException e) {
            assertEquals("Invalid radius", e.getMessage());
        }

        try {
            new Circle(1, 2, Double.NaN);
        } catch (ShapeException e) {
            assertEquals("Invalid radius", e.getMessage());
        }
        try {
            new Circle(1, 2, -5);
        } catch (ShapeException e) {
            assertEquals("Invalid radius", e.getMessage());
        }
    }

    @Test
    public void getCenter() throws ShapeException{
        Circle circle=new Circle(0,1,5);
        assertEquals(0,circle.getCenter().getX(),0);
        assertEquals(1,circle.getCenter().getY(),0);
    }

    @Test
    public void getRadius() throws ShapeException{
        Circle circle=new Circle(0,1,5);
        assertEquals(5,circle.getRadius(),0);
    }

    @Test
    public void move() throws ShapeException{
        Circle circle=new Circle(0,1,5);
        circle.move(3,4);
        assertEquals(3,circle.getCenter().getX(),0);
        assertEquals(5,circle.getCenter().getY(),0);
    }

    @Test
    public void scale() throws ShapeException{
        Circle circle=new Circle(0,1,5);
        circle.scale(4);
        assertEquals(10,circle.getRadius(),0);
    }

    @Test
    public void computeArea() throws ShapeException{
        Circle circle=new Circle(0,1,5);
        assertEquals(78.53981633974483,circle.computeArea(),0);
    }

    @Test
    public void render() throws ShapeException{
        Circle circle=new Circle(10,10,5);

        BufferedImage bImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bImg.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 100, 100);
        graphics.setColor(Color.BLACK);

        circle.render(graphics);

        try {
            assertTrue(ImageIO.write(bImg, "png", new File("F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\Circle.png")));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}