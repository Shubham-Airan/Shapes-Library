package extendedShapes;
import shapes.*;
import org.junit.Test;
import shapes.Point;
import shapes.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CompositeShapeTest {

    @Test
    public void testValidConstruction() throws ShapeException{
        String compositeshape1="\nShapesEnum.ShapeType.POINT,1,1,\nShapesEnum.ShapeType.LINE,1,1,4,5";
        String compositeshape="\nShapesEnum.ShapeType.POINT,1,1,\nShapesEnum.ShapeType.LINE,1,1,4,5"+compositeshape1;
        String[] objectDetails = new String[]{"\n"+ShapesEnum.ShapeType.COMPOSITESHAPE,
                                            "\n"+ShapesEnum.ShapeType.POINT,"1","1",
                                            "\n"+ShapesEnum.ShapeType.LINE,"1","1","4","5",
                                            "\n"+ShapesEnum.ShapeType.CIRCLE,"0","0","5",
                                            "\n"+ShapesEnum.ShapeType.TRIANGLE,"0","0","3","0","3","4",
                                            "\n"+ShapesEnum.ShapeType.RECTANGLE,"0","0","4","0","4","4","0","4",
                                            "\n"+ShapesEnum.ShapeType.EMBEDDEDPICTURES,"20","20","10","10","F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\java Cup.jpg",
                                            "\n"+ShapesEnum.ShapeType.COMPOSITESHAPE,compositeshape};
        CompositeShape compositeShape=new CompositeShape(objectDetails);

    }


    @Test
    public void move() throws ShapeException{
        Point point=new Point(10,20);
        Line line = new Line(30,30,70,80);
        Triangle triangle=new Triangle(10,10,60,10,60,60);
        Rectangle rectangle=new Rectangle(0,0,30,0,30,30,0,30);

        CompositeShape compositeShape=new CompositeShape();
        compositeShape.addShape(point);
        compositeShape.addShape(line);
        compositeShape.addShape(triangle);
        compositeShape.addShape(rectangle);

        compositeShape.move(10,20);
        assertEquals(20,point.getX(),0);
        assertEquals(40,point.getY(),0);

        assertEquals(40,line.getPoint1().getX(),0);
        assertEquals(50,line.getPoint1().getY(),0);
        assertEquals(80,line.getPoint2().getX(),0);
        assertEquals(100,line.getPoint2().getY(),0);

        assertEquals(20,triangle.getPoint1().getX(),0);
        assertEquals(30,triangle.getPoint1().getY(),0);
        assertEquals(70,triangle.getPoint2().getX(),0);
        assertEquals(30,triangle.getPoint2().getY(),0);
        assertEquals(70,triangle.getPoint3().getX(),0);
        assertEquals(80,triangle.getPoint3().getY(),0);

        assertEquals(10,rectangle.getPoint1().getX(),0);
        assertEquals(20,rectangle.getPoint1().getY(),0);
        assertEquals(40,rectangle.getPoint2().getX(),0);
        assertEquals(20,rectangle.getPoint2().getY(),0);
        assertEquals(40,rectangle.getPoint3().getX(),0);
        assertEquals(50,rectangle.getPoint3().getY(),0);
        assertEquals(10,rectangle.getPoint4().getX(),0);
        assertEquals(50,rectangle.getPoint4().getY(),0);
    }

    @Test
    public void scale() throws ShapeException{
        Point point=new Point(10,20);
        Line line = new Line(30,30,70,70);
        CompositeShape compositeShape=new CompositeShape();
        compositeShape.addShape(point);
        compositeShape.addShape(line);
        compositeShape.scale(2);
        assertEquals(10,point.getX(),0);
        assertEquals(20,point.getY(),0);
        assertEquals(30,line.getPoint1().getX(),0);
        assertEquals(30,line.getPoint1().getY(),0);
        assertEquals(110,line.getPoint2().getX(),0);
        assertEquals(110,line.getPoint2().getY(),0);
    }

    @Test
    public void computeArea() throws ShapeException{
        Point point=new Point(10,20);
        Line line = new Line(30,30,70,80);
        Triangle triangle=new Triangle(10,10,60,10,60,60);
        Rectangle rectangle=new Rectangle(0,0,30,0,30,30,0,30);

        CompositeShape compositeShape=new CompositeShape();
        compositeShape.addShape(point);
        compositeShape.addShape(line);
        compositeShape.addShape(triangle);
        compositeShape.addShape(rectangle);

        assertEquals(2150,compositeShape.computeArea(),0);
    }

    @Test
    public void addShape() throws ShapeException{

    }

    @Test
    public void removeShape() throws ShapeException{
        Point point=new Point(10,20);
        Line line = new Line(30,30,70,80);

        CompositeShape compositeShape=new CompositeShape();
        compositeShape.addShape(point);
        compositeShape.addShape(line);

        compositeShape.removeShape(point);
        assertEquals(false,compositeShape.getShapes().contains(point));
        assertEquals(true,compositeShape.getShapes().contains(line));
    }

    @Test
    public void removeAllShape() throws ShapeException{
        Point point=new Point(10,20);
        Line line = new Line(30,30,70,80);
        Triangle triangle=new Triangle(10,10,60,10,60,60);
        Rectangle rectangle=new Rectangle(0,0,30,0,30,30,0,30);

        CompositeShape compositeShape=new CompositeShape();
        compositeShape.addShape(point);
        compositeShape.addShape(line);
        compositeShape.addShape(triangle);
        compositeShape.addShape(rectangle);

        compositeShape.removeAllShape();
        assertEquals(true,compositeShape.getShapes().isEmpty());
    }

    @Test
    public void render() throws ShapeException{
        Point point=new Point(10,20);
        Line line = new Line(30,30,70,80);
        Triangle triangle=new Triangle(10,10,60,10,60,60);
        Rectangle rectangle=new Rectangle(0,0,30,0,30,30,0,30);
        EmbeddedPictures embeddedPictures=new EmbeddedPictures(20,20,10,10,"F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\java Cup.jpg");

        CompositeShape compositeShape=new CompositeShape();

        compositeShape.addShape(point);
        compositeShape.addShape(line);
        compositeShape.addShape(triangle);
        compositeShape.addShape(rectangle);
        compositeShape.addShape(embeddedPictures);

        BufferedImage bImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bImg.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 100, 100);
        graphics.setColor(Color.BLACK);

        compositeShape.render(graphics);

        try {
            assertTrue(ImageIO.write(bImg, "png", new File("F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\CompositeShape.png")));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}