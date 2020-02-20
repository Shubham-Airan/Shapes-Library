package shapes;

public class Validator {
    public static void validateDouble(double value, String errorMessage) throws ShapeException {
        if (Double.isInfinite(value) || Double.isNaN(value))
            throw new ShapeException(errorMessage);
    }

    public static void validatePositiveDouble(double value, String errorMessage) throws ShapeException {
        validateDouble(value, errorMessage);
        if (value<0)
            throw new ShapeException(errorMessage);
    }

    public static void validTriangle(Point point1, Point point2,Point point3 ,String errorMessage) throws ShapeException{
        Line side1=new Line(point1,point2);
        Line side2=new Line(point1,point3);
        if(side1.computeSlope()==side2.computeSlope())
            throw new ShapeException(errorMessage);
    }

    public static void ValidRectangle(Point point1, Point point2,Point point3, Point point4  ,String errorMessage) throws ShapeException{
        Line side1=new Line(point1,point2);
        Line side2=new Line(point2,point3);
        if(side1.computeSlope()*side2.computeSlope()==-1)
            return;
        else if(side1.computeSlope()==0 && Double.isInfinite(side2.computeSlope()))
            return;
        else if(side2.computeSlope()==0 && Double.isInfinite(side1.computeSlope()))
            return;
        else
            throw new ShapeException(errorMessage);
    }
}
