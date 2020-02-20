package shapes;

import extendedShapes.CompositeShape;
import extendedShapes.EmbeddedPictures;
import extendedShapes.Rectangle;
import extendedShapes.Triangle;

import java.io.*;

public class InputOutputShape {

    public static void saveShape(String fileName, Shape shape) {
        try {
            File file = new File(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            System.out.println("saveShape method");
            bufferedWriter.write(shape.toText());
            bufferedWriter.close();
        }

        catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public static Shape load(String fileName) throws IOException {

        try {
            File file=new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String[] shapesSplitted = null;
            String text = null;
            String fullString = "";

            while ((text = bufferedReader.readLine()) != null) {
                fullString = fullString.concat(text).concat("\n");
            }

            System.out.println("full string is " + fullString);

            shapesSplitted = fullString.split(",");

            Shape shape = getObject(shapesSplitted);
            if (shape != null) return shape;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private static Shape getObject(String[] shapesSplitted) throws ShapeException {
        if (shapesSplitted[0].equals(ShapesEnum.ShapeType.POINT)) {
            return new Point(Double.parseDouble(shapesSplitted[1]), Double.parseDouble(shapesSplitted[2]));
        }
        if (shapesSplitted[0].equals(ShapesEnum.ShapeType.LINE)) {
            return new Line(Double.parseDouble(shapesSplitted[1]), Double.parseDouble(shapesSplitted[2]),Double.parseDouble(shapesSplitted[3]),Double.parseDouble(shapesSplitted[4]));
        }
        if (shapesSplitted[0].equals(ShapesEnum.ShapeType.CIRCLE)) {
            return new Circle(Double.parseDouble(shapesSplitted[1]), Double.parseDouble(shapesSplitted[2]),Double.parseDouble(shapesSplitted[3]));
        }
        if (shapesSplitted[0].equals(ShapesEnum.ShapeType.TRIANGLE)) {
            return new Triangle(Double.parseDouble(shapesSplitted[1]), Double.parseDouble(shapesSplitted[2]),Double.parseDouble(shapesSplitted[3]),Double.parseDouble(shapesSplitted[4]),Double.parseDouble(shapesSplitted[5]),Double.parseDouble(shapesSplitted[6]));
        }
        if (shapesSplitted[0].equals(ShapesEnum.ShapeType.RECTANGLE)) {
            return new Rectangle(Double.parseDouble(shapesSplitted[1]), Double.parseDouble(shapesSplitted[2]),Double.parseDouble(shapesSplitted[3]),Double.parseDouble(shapesSplitted[4]),Double.parseDouble(shapesSplitted[5]),Double.parseDouble(shapesSplitted[6]),Double.parseDouble(shapesSplitted[7]), Double.parseDouble(shapesSplitted[8]));
        }
        if (shapesSplitted[0].equals(ShapesEnum.ShapeType.EMBEDDEDPICTURES)) {
            return new EmbeddedPictures(Double.parseDouble(shapesSplitted[1]), Double.parseDouble(shapesSplitted[2]),Double.parseDouble(shapesSplitted[3]),Double.parseDouble(shapesSplitted[4]),shapesSplitted[5]);
        }
        if(shapesSplitted[0].equals(ShapesEnum.ShapeType.COMPOSITESHAPE)){
            return new CompositeShape(shapesSplitted);
        }
        return null;
    }
}
