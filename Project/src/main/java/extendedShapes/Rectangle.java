package extendedShapes;

import shapes.*;
import shapes.Point;
import shapes.Shape;

import java.awt.*;

public class Rectangle implements Shape {

    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    private Line side1;
    private Line side2;
    private Line side3;
    private Line side4;

    public Rectangle(Point point1, Point point2, Point point3, Point point4) throws ShapeException{
        if (point1==null || point2==null || point3==null || point4==null )
            throw new ShapeException("Invalid Point");

        Validator.ValidRectangle(point1,point2,point3,point4,"Not valid points for rectangle");

        this.point1 = point1.copy();
        this.point2 = point2.copy();
        this.point3 = point3.copy();
        this.point4 = point4.copy();

        side1= new Line(point1,point2);
        side2= new Line(point2,point3);
        side3= new Line(point3,point4);
        side4= new Line(point1,point4);
    }

    public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) throws ShapeException{
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        point3 = new Point(x3, y3);
        point4 = new Point(x4, y4);

        Validator.ValidRectangle(point1,point2,point3,point4,"Not valid points for rectangle");

        this.point1 = point1.copy();
        this.point2 = point2.copy();
        this.point3 = point3.copy();
        this.point4 = point4.copy();

        side1= new Line(point1,point2);
        side2= new Line(point2,point3);
        side3= new Line(point3,point4);
        side4= new Line(point1,point4);
    }

    public Point getPoint1() throws ShapeException { return point1.copy(); }

    public Point getPoint2() throws ShapeException { return point2.copy(); }

    public Point getPoint3() throws ShapeException { return point3.copy(); }

    public Point getPoint4() throws ShapeException { return point4.copy(); }

    public void move(double deltaX, double deltaY) throws ShapeException {
        point1.move(deltaX, deltaY);
        point2.move(deltaX, deltaY);
        point3.move(deltaX, deltaY);
        point4.move(deltaX, deltaY);
    }

    public void scale(double scaleFactor) throws ShapeException{
        side1.scale(scaleFactor);
        side4.scale(scaleFactor);
        Line diagonal=new Line(point1,point3);
        diagonal.scale(scaleFactor);
    }

    public double computeArea(){
        return (side1.computeLength()*side2.computeLength());
    }

    public void render(Graphics line){
        line.drawLine((int)point1.getX(), (int)point1.getY(), (int)point2.getX(), (int)point2.getY());
        line.drawLine((int)point2.getX(), (int)point2.getY(), (int)point3.getX(), (int)point3.getY());
        line.drawLine((int)point3.getX(), (int)point3.getY(), (int)point4.getX(), (int)point4.getY());
        line.drawLine((int)point4.getX(), (int)point4.getY(), (int)point1.getX(), (int)point1.getY());

    }

    public String toText() throws ShapeException{

        return ShapesEnum.ShapeType.RECTANGLE+","+getPoint1().getX()+","+getPoint1().getY()+","+getPoint2().getX()+","+getPoint2().getY()+","+getPoint3().getX()+","+getPoint3().getY()+","+getPoint4().getX()+","+getPoint4().getY();

    }

}
