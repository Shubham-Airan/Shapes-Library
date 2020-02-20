package shapes;

import java.awt.Graphics;


public class Line implements Shape {
    private Point point1;
    private Point point2;

    public Line(double x1, double y1, double x2, double y2) throws ShapeException {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
    }

    public Line(Point point1, Point point2) throws ShapeException {
        if (point1==null || point2==null)
            throw new ShapeException("Invalid Point");

        this.point1 = point1.copy();
        this.point2 = point2.copy();
    }

    public Point getPoint1() throws ShapeException { return point1.copy(); }

    public Point getPoint2() throws ShapeException { return point2.copy(); }

    public void move(double deltaX, double deltaY) throws ShapeException {
        point1.move(deltaX, deltaY);
        point2.move(deltaX, deltaY);
    }

    public double computeLength() {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));
    }

    public double computeSlope() {
        return (point2.getY() - point1.getY())/(point2.getX() - point1.getX());
    }

    public double computeArea(){
        return 0;
    }

    public void scale (double scaleFactor) throws ShapeException{
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");

        double length=Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));

        double lengthScaled= length*scaleFactor;

        double sineLine = (point2.getY()-point1.getY())/length;
        double cosLine = (point2.getX()-point1.getX())/length;

        point2.setY(point1.getY()+lengthScaled*sineLine);
        point2.setX(point1.getX()+lengthScaled*cosLine);
    }

    public void render(Graphics line){

        line.drawLine((int)point1.getX(), (int)point1.getY(), (int)point2.getX(), (int)point2.getY());

    }

    public String toText() throws ShapeException{

        return ShapesEnum.ShapeType.LINE+","+getPoint1().getX()+","+getPoint1().getY()+","+getPoint2().getX()+","+getPoint2().getY();

    }



}