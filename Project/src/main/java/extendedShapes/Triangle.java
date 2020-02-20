package extendedShapes;

import shapes.*;
import shapes.Point;
import shapes.Shape;

import java.awt.*;

public class Triangle implements Shape {

    private Point point1;
    private Point point2;
    private Point point3;

    private Line side1;
    private Line side2;
    private Line side3;

    public Triangle(Point point1, Point point2, Point point3) throws ShapeException{
        if (point1==null || point2==null || point3==null)
            throw new ShapeException("Invalid Points");

        Validator.validTriangle(point1,point2,point3, "points are collinear");

        this.point1 = point1.copy();
        this.point2 = point2.copy();
        this.point3 = point3.copy();

        side1= new Line(point1,point2);
        side2= new Line(point2,point3);
        side3= new Line(point1,point3);

    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) throws ShapeException {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        point3 = new Point(x3, y3);

        Validator.validTriangle(point1,point2,point3, "points are collinear");

        side1= new Line(point1,point2);
        side2= new Line(point2,point3);
        side3= new Line(point1,point3);
    }

    public Point getPoint1() throws ShapeException { return point1.copy(); }

    public Point getPoint2() throws ShapeException { return point2.copy(); }

    public Point getPoint3() throws ShapeException { return point3.copy(); }

    public void move(double deltaX, double deltaY) throws ShapeException {
        point1.move(deltaX, deltaY);
        point2.move(deltaX, deltaY);
        point3.move(deltaX, deltaY);
    }

    public double computeArea(){
        double Area;
        double semiPerimeter;

        semiPerimeter=(side1.computeLength()+side2.computeLength()+side3.computeLength())/2;
        Area=Math.sqrt((semiPerimeter)*(semiPerimeter-side1.computeLength())*(semiPerimeter-side2.computeLength())*(semiPerimeter-side3.computeLength()));
        return Area;
    }

    public void scale(double scaleFactor) throws ShapeException{
        side1.scale(scaleFactor);
        side3.scale(scaleFactor);
    }

    public void render(Graphics line){
        line.drawLine((int)point1.getX(), (int)point1.getY(), (int)point2.getX(), (int)point2.getY());
        line.drawLine((int)point2.getX(), (int)point2.getY(), (int)point3.getX(), (int)point3.getY());
        line.drawLine((int)point3.getX(), (int)point3.getY(), (int)point1.getX(), (int)point1.getY());

    }

    public String toText() throws ShapeException{

        return ShapesEnum.ShapeType.TRIANGLE+","+getPoint1().getX()+","+getPoint1().getY()+","+getPoint2().getX()+","+getPoint2().getY()+","+getPoint3().getX()+","+getPoint3().getY();

    }


}