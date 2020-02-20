import extendedShapes.Rectangle;
import extendedShapes.Triangle;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;
import shapes.*;

import static org.junit.Assert.*;

public class ShapeFactoryTest {

    @Test
    public void testValidConstruction() throws ShapeException {

        assertEquals(shapes.Point.class,(ShapeFactory.getShape(ShapesEnum.ShapeType.POINT)).getClass());
        assertEquals(shapes.Line.class,(ShapeFactory.getShape(ShapesEnum.ShapeType.LINE)).getClass());
        assertEquals(shapes.Circle.class,(ShapeFactory.getShape(ShapesEnum.ShapeType.CIRCLE)).getClass());
        assertEquals(extendedShapes.Rectangle.class,(ShapeFactory.getShape(ShapesEnum.ShapeType.RECTANGLE)).getClass());
        assertEquals(extendedShapes.Triangle.class,(ShapeFactory.getShape(ShapesEnum.ShapeType.TRIANGLE)).getClass());
        assertEquals(extendedShapes.CompositeShape.class,(ShapeFactory.getShape(ShapesEnum.ShapeType.COMPOSITESHAPE)).getClass());
        assertEquals(extendedShapes.EmbeddedPictures.class,(ShapeFactory.getShape(ShapesEnum.ShapeType.EMBEDDEDPICTURES)).getClass());

    }
}