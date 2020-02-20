package extendedShapes;

import shapes.Point;
import shapes.Shape;
import shapes.ShapeException;
import shapes.ShapesEnum;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class EmbeddedPictures implements Shape {

    private double length;
    private double width;
    private Point pictureLocation;
    private String pictureSource;

    public EmbeddedPictures(double length, double width, double locationX, double locationY, String pictureSource) throws ShapeException{
        this.length=length;
        this.width=width;
        pictureLocation=new Point(locationX,locationY);
        this.pictureSource=pictureSource;
    }

    public String getPictureSource(){return pictureSource;}

    public void move(double deltaX, double deltaY) throws ShapeException {
        pictureLocation.move(deltaX,deltaY);
    }

    public Point getpictureLocation(){return pictureLocation;}

    public double getLength(){return length;}

    public double getWidth() {return width;}

    public void scale(double scaleFactor) throws ShapeException {
        length*=scaleFactor;
        width*=scaleFactor;
    }

    public double computeArea() {
        return length*width;
    }

    public void render(Graphics graphics) {
        File sourceFile = new File(pictureSource);
        BufferedImage picture = null;
        try{
            picture = ImageIO.read(sourceFile);}
        catch (java.io.IOException e){

        }
        graphics.drawImage(picture, (int)pictureLocation.getX(), (int)pictureLocation.getY(), (int)width, (int)length, null);


    }

    public String toText() throws ShapeException{

        return ShapesEnum.ShapeType.EMBEDDEDPICTURES+","+getLength()+","+getWidth()+","+pictureLocation.getX()+","+pictureLocation.getY()+","+getPictureSource();

    }


}