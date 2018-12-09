import java.awt.image.BufferedImage;

/**
 * This is used to display a specific image within a bigger image
 */
public class SpriteSheet {

  private BufferedImage sheet;

  public SpriteSheet(BufferedImage sheet){
    this.sheet = sheet;
  }

  public BufferedImage crop(int x, int y, int width, int height){
    return sheet.getSubimage(x, y, width, height);
  }
}
