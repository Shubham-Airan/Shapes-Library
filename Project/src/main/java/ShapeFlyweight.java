import java.util.HashMap;

import extendedShapes.EmbeddedPictures;
import shapes.*;

public class ShapeFlyweight  {

    private static HashMap<String, EmbeddedPictures> embeddedImageHashMap = new HashMap<String, EmbeddedPictures>();

    public static EmbeddedPictures getEmbeddedImage(String imageType) throws ShapeException{

        EmbeddedPictures embeddedPictures=null;

        if(embeddedImageHashMap.containsKey(imageType))
            return embeddedImageHashMap.get(imageType);

        else{
            switch (imageType) {
                case "java":
                    embeddedPictures = new EmbeddedPictures(20, 20, 10, 10, "E:\\MS\\CS 5700\\HW 3\\HW-3--CS5700\\Project\\Image\\java Cup.jpg");
                    break;

                case "visual Paradigm":
                    embeddedPictures = new EmbeddedPictures(20, 20, 10, 10, "E:\\MS\\CS 5700\\HW 3\\HW-3--CS5700\\Project\\Image\\Visual Paradigm.jpg");
                    break;

                case "python":
                    embeddedPictures = new EmbeddedPictures(20, 20, 10, 10, "E:\\MS\\CS 5700\\HW 3\\HW-3--CS5700\\Project\\Image\\Python.jpg");
                    break;

                case "intelliJ":
                    embeddedPictures = new EmbeddedPictures(20, 20, 10, 10, "E:\\MS\\CS 5700\\HW 3\\HW-3--CS5700\\Project\\Image\\intellij-idea.jpg");
                    break;
            }
            embeddedImageHashMap.put(imageType,embeddedPictures);
            return embeddedPictures;

            }
        }

        public static HashMap<String, EmbeddedPictures> getembeddedImageHashMap(){
             return embeddedImageHashMap;
        }

    }

