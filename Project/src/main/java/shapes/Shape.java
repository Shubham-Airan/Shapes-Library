package shapes;
import extendedShapes.CompositeShape;
import extendedShapes.EmbeddedPictures;
import extendedShapes.Rectangle;
import extendedShapes.Triangle;

import java.awt.Graphics;
import java.io.*;

public interface Shape {

    abstract public void move(double deltaX, double deltaY) throws ShapeException;

    abstract public void scale(double scaleFactor) throws ShapeException;

    abstract public double computeArea();

    abstract public void render(Graphics graphics);

    abstract public String toText() throws ShapeException;
}