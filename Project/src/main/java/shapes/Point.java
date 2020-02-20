package shapes;

import java.awt.*;

public class Point implements Shape {
    private double x;
    private double y;

   public Point(double x, double y) throws ShapeException {
        if (Double.isInfinite(x) || Double.isInfinite(y) ||
                Double.isNaN(x) || Double.isNaN(y))
            throw new ShapeException("Invalid Point");

        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }

    public double getY() { return y; }

    public void setX(double x) { this.x=x; }

    public void setY(double y) { this.y=y; }

    public void moveX(double deltaX) throws ShapeException {
        if (Double.isInfinite(deltaX) || Double.isNaN(deltaX))
            throw new ShapeException("Invalid delta value for move operation");

        x += deltaX;
    }

    public void moveY(double deltaY) throws ShapeException {
        if (Double.isInfinite(deltaY) || Double.isNaN(deltaY))
            throw new ShapeException("Invalid delta value for move operation");

        y += deltaY;
    }
    public void move(double deltaX, double deltaY) throws ShapeException {
        moveX(deltaX);
        moveY(deltaY);
    }

    public Point copy() throws ShapeException {
        return new Point(x, y);
    }

    public void scale(double scaleFactor) throws ShapeException{

    }

    public double computeArea(){
           return 0;
    }

    public void render(Graphics point){

        point.drawLine((int)getX(),(int) getY(),(int) getX(), (int)getY());

    }

    public String toText() throws ShapeException{

       return ShapesEnum.ShapeType.POINT+","+x+","+y;

    }
}
