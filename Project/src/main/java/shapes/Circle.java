package shapes;

import java.awt.*;

public class Circle implements Shape{
    private Point center;
    private double radius;

    public Circle(double x, double y, double radius) throws ShapeException {
        Validator.validatePositiveDouble(radius, "Invalid radius");
        center = new Point(x, y);
        this.radius = radius;
    }

    public Circle(Point center, double radius) throws ShapeException {
        Validator.validatePositiveDouble(radius, "Invalid radius");
        if (center==null)
            throw new ShapeException("Invalid center point");

        this.center = center.copy();
        this.radius = radius;
    }

    public Point getCenter() throws ShapeException { return center.copy(); }

    public double getRadius() { return radius; }

    public void move(double deltaX, double deltaY) throws ShapeException {
        center.move(deltaX, deltaY);
    }

    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        radius *= Math.sqrt(scaleFactor);
    }

    public double computeArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public void render(Graphics circle){

       circle.drawOval((int)(center.getX()-getRadius()),(int)(center.getY()-getRadius()),(int)(getRadius()), (int)(Math.round(getRadius())));
    }


    public String toText() throws ShapeException{

        return ShapesEnum.ShapeType.CIRCLE+","+getCenter().getX()+","+getCenter().getY()+","+getRadius();

    }
}