import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * This class loads an image
 */
public class ImageLoader {

  /**
   * This method fetches an image from a particular location
   *
   * @param path path to the image
   * @return the image
   */
  public static BufferedImage loadImage(String path){
    try {
      return ImageIO.read(ImageLoader.class.getResource(path));
    }
    catch (IOException e){
      e.printStackTrace();
      System.exit(1);
    }
    return null;
  }
}
