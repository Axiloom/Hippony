import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Tile {

  // STATIC STUFF HERE
  public static Tile[] tiles = new Tile[256]; // to hold one instance of every tile
  public static Tile waterTile = new WaterTile(0);
  public static Tile brickTile = new BrickTile(1);
  public static Tile dirtTile = new DirtTile(2);

  // CLASS

  public static final int TILE_WIDTH = 32,
                          TILE_HEIGHT = 32;

  protected BufferedImage texture; // Import image to be used
  protected final int id; // Identification of tile (hash)

  public Tile(BufferedImage texture, int id){
    this.texture = texture;
    this.id = id;

    tiles[id] = this;
  }

  public void tick(){

  }


  public void render(Graphics g, int x, int y){
    g.drawImage(texture,x,y,TILE_WIDTH, TILE_HEIGHT, null);
  }

  public boolean isWalkable(){
    return false;
  }

  public int getId(){
    return id;
  }
}
