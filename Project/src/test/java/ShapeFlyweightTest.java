import extendedShapes.EmbeddedPictures;
import org.junit.Test;
import shapes.ShapeException;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class ShapeFlyweightTest {

    @Test
    public void getEmbeddedImage() throws ShapeException {
        assertEquals(ShapeFlyweight.getembeddedImageHashMap().isEmpty(),true);

        BufferedImage bImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bImg.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 100, 100);
        graphics.setColor(Color.BLACK);

        (ShapeFlyweight.getEmbeddedImage("java")).render(graphics);
        (ShapeFlyweight.getEmbeddedImage("java")).render(graphics);

        (ShapeFlyweight.getEmbeddedImage("python")).render(graphics);

        (ShapeFlyweight.getEmbeddedImage("intelliJ")).render(graphics);

        (ShapeFlyweight.getEmbeddedImage("visual Paradigm")).render(graphics);
        }
}