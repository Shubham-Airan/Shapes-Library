package shapes;

import extendedShapes.CompositeShape;
import extendedShapes.EmbeddedPictures;
import extendedShapes.Rectangle;
import extendedShapes.Triangle;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ShapeTest {

    @Test
    public void saveShape() throws ShapeException{
       Point point1=new Point(0,0);
        Point point2=new Point(30,0);
        Point point3=new Point(30,30);
        Point point4=new Point(0,30);

        CompositeShape compositeShape=new CompositeShape();

        compositeShape.addShape(new Point(0,0));
        compositeShape.addShape(new Rectangle(point1,point2,point3,point4));
        compositeShape.addShape(new Line(point1,point2));
        compositeShape.addShape(new Triangle(point1,point2,point3));
        compositeShape.addShape(new Circle(0,0,5));
        compositeShape.addShape(new EmbeddedPictures(20,30,10,10,"F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\java Cup.jpg"));

        InputOutputShape.saveShape("F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Load & Save\\shapeSaved.txt",compositeShape);

    }

    @Test
    public void load() throws ShapeException{
        Shape shape=new Point(10,20);
        try {
            InputOutputShape.load("F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Load & Save\\shape1.txt");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        try {
            InputOutputShape.load("F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Load & Save\\shapeException.txt");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }


    }

}