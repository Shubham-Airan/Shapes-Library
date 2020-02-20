import java.util.HashMap;
import extendedShapes.*;
import shapes.*;

public class ShapeFactory {

	private static final HashMap<ShapesEnum.ShapeType,Shape> shapes = new HashMap<ShapesEnum.ShapeType,Shape>();

	public static Shape getShape(shapes.ShapesEnum.ShapeType type) throws ShapeException{
		Shape shapeObject = shapes.get(type);

		if (shapeObject == null) {
			if (type.equals(ShapesEnum.ShapeType.POINT)) {
				shapeObject = new Point(40,50);
			} else if (type.equals(ShapesEnum.ShapeType.LINE)) {
				shapeObject = new Line(0,0,20,40);
			} else if (type.equals(ShapesEnum.ShapeType.CIRCLE)) {
				shapeObject = new Circle(1,1,4);
			} else if (type.equals(ShapesEnum.ShapeType.RECTANGLE)) {
                shapeObject = new Rectangle(1,1,3,1,3,3,1,3);
            } else if (type.equals(ShapesEnum.ShapeType.TRIANGLE)) {
                shapeObject = new Triangle(1,1,3,1,3,3);
            } else if (type.equals(ShapesEnum.ShapeType.COMPOSITESHAPE)) {
                shapeObject = new CompositeShape();
            } else if (type.equals(ShapesEnum.ShapeType.EMBEDDEDPICTURES)) {
                shapeObject = new EmbeddedPictures(4,4,2,2,"F:\\MS\\CS 5700\\Homework\\Assignment 3\\HW 3 - CS 5700\\HW-3--CS5700\\Project\\Image\\java Cup.jpg");
            }
			shapes.put(type, shapeObject);
		}
		return shapeObject;
	}

}