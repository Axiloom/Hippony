import java.awt.image.BufferedImage;

/**
 * This class will load all images immediatly so we dont have to do it everytime in our ImageLoader
 * this method is only called once
 */
public class Assets {

  // Width and height of sprite images
  private static final int TEXTURE_WIDTH = 80;
  private static final int TEXTURE_HEIGHT = 80;
  private static final int CHARACTER_WIDTH = 30;
  private static final int CHARACTER_HEIGHT = 30;

  // List out all tiles in spritesheet
  public static BufferedImage
          dirtWGrassOnTop,
          dirt,
          brick,
          water,
          lava,
          wood,
          character;

  /**
   * This is used to load sprite into different buffered images
   */
  public static void init(){

    // 80x80 sprite
    SpriteSheet textureSheet = new SpriteSheet(ImageLoader.loadImage("/textures/backgroundTextures.png"));
    // 30x30 sprite
    SpriteSheet characterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/characters.png"));

    // Dirt with grass
    dirtWGrassOnTop = textureSheet.crop(0,0,TEXTURE_WIDTH,TEXTURE_HEIGHT);

    dirt = textureSheet.crop(TEXTURE_WIDTH,0, TEXTURE_WIDTH, TEXTURE_HEIGHT);

    brick = textureSheet.crop(TEXTURE_WIDTH*2,0, TEXTURE_WIDTH, TEXTURE_HEIGHT);

    water = textureSheet.crop(TEXTURE_WIDTH*3,0, TEXTURE_WIDTH, TEXTURE_HEIGHT);

    lava = textureSheet.crop(TEXTURE_WIDTH*4,0, TEXTURE_WIDTH, TEXTURE_HEIGHT);

    wood = textureSheet.crop(TEXTURE_WIDTH*5,0, TEXTURE_WIDTH, TEXTURE_HEIGHT);

    character = characterSheet.crop(CHARACTER_WIDTH*2,0,CHARACTER_WIDTH,CHARACTER_HEIGHT);

  }
}
