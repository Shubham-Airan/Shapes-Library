package extendedShapes;

import shapes.*;
import shapes.Point;
import shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

public class CompositeShape implements Shape{

    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public CompositeShape(){
    }

    public CompositeShape(String[] objectDetails) throws ShapeException {
        try {
            for (int i = 1; i < objectDetails.length; i++) {
                if (objectDetails[i].equals("\n"+ShapesEnum.ShapeType.POINT)) {
                    shapes.add(new Point(Double.parseDouble(objectDetails[i + 1]), Double.parseDouble(objectDetails[i + 2])));
                    i = i + 2;
                    continue;
                }
                if (objectDetails[i].equals("\n"+ShapesEnum.ShapeType.CIRCLE)) {
                    shapes.add(new Circle(Double.parseDouble(objectDetails[i + 1]), Double.parseDouble(objectDetails[i + 2]), Double.parseDouble(objectDetails[i + 3])));
                    i = i + 3;
                    continue;
                }
                if (objectDetails[i].equals("\n"+ShapesEnum.ShapeType.LINE)) {
                    shapes.add(new Line(Double.parseDouble(objectDetails[i + 1]), Double.parseDouble(objectDetails[i + 2]), Double.parseDouble(objectDetails[i + 3]), Double.parseDouble(objectDetails[i + 4])));
                    i = i + 4;
                    continue;
                }
                if (objectDetails[i].equals("\n"+ShapesEnum.ShapeType.TRIANGLE)) {
                    shapes.add(new Triangle(Double.parseDouble(objectDetails[i + 1]), Double.parseDouble(objectDetails[i + 2]), Double.parseDouble(objectDetails[i + 3]), Double.parseDouble(objectDetails[i + 4]), Double.parseDouble(objectDetails[i + 5]), Double.parseDouble(objectDetails[i + 6])));
                    i = i + 6;
                    continue;
                }
                if (objectDetails[i].equals("\n"+ShapesEnum.ShapeType.RECTANGLE)) {
                    shapes.add(new Rectangle(Double.parseDouble(objectDetails[i + 1]), Double.parseDouble(objectDetails[i + 2]), Double.parseDouble(objectDetails[i + 3]), Double.parseDouble(objectDetails[i + 4]), Double.parseDouble(objectDetails[i + 5]), Double.parseDouble(objectDetails[i + 6]), Double.parseDouble(objectDetails[i + 7]), Double.parseDouble(objectDetails[i + 8])));
                    i = i + 8;
                    continue;
                }
                if (objectDetails[i].equals("\n"+ShapesEnum.ShapeType.EMBEDDEDPICTURES)) {
                    shapes.add(new EmbeddedPictures(Double.parseDouble(objectDetails[i + 1]), Double.parseDouble(objectDetails[i + 2]), Double.parseDouble(objectDetails[i + 3]), Double.parseDouble(objectDetails[i + 4]), (objectDetails[i + 5])));
                    i = i + 5;
                    continue;
                }
                if (objectDetails[i].equals("\n"+ShapesEnum.ShapeType.COMPOSITESHAPE)) {
                    {
                        while (!(objectDetails[i].equals("\n"+ShapesEnum.ShapeType.COMPOSITESHAPE))) {
                            String packetString = "";
                            String[] objectDetails2;
                            while (!(objectDetails[i].equals("\n"+ShapesEnum.ShapeType.COMPOSITESHAPE))) {
                                packetString = packetString.concat(objectDetails[i]);
                                packetString = packetString.concat(",");
                                i++;
                            }
                            objectDetails2 = packetString.split(",");
                            CompositeShape compositeShape = new CompositeShape(objectDetails2);
                            shapes.add(compositeShape);
                        }
                    }
                }
            }}
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void move(double deltaX, double deltaY) throws ShapeException{
        for(Shape sh : shapes)
        {
            sh.move(deltaX,deltaY);
        }
    }

    public ArrayList<Shape> getShapes(){return shapes;}

    public void scale(double scaleFactor) throws ShapeException{
        for(Shape sh : shapes)
        {
            sh.scale(scaleFactor);
        }
    }

    public double computeArea(){
        double totalArea=0;
        for(Shape sh : shapes)
        {
            totalArea+=sh.computeArea();
        }
        return totalArea;
    }

    public void addShape(Shape s){
        this.shapes.add(s);
    }

    public void removeShape(Shape s){
        shapes.remove(s);
    }

    public void removeAllShape(){
        shapes.clear();
    }

    public void render(Graphics graphics){

        for(Shape sh : shapes)
        {
            sh.render(graphics);
        }
    }

    public String toText() throws ShapeException{

        String compositeText= ShapesEnum.ShapeType.COMPOSITESHAPE.toString();
        for(Shape sh: shapes)
        {
            compositeText=compositeText+",\n"+sh.toText();

        }
        return compositeText;
    }
}