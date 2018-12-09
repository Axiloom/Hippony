import java.awt.Graphics;

public class World {

  private int width, height;
  private int[][] tiles;

  // CONSTRUCTOR
  public World(String path){
    loadWorld(path);
  }

  /**
   * Update variables
   */
  public void tick(){

  }

  /**
   * Display graphics
   */
  public void render(Graphics g){
    for (int y = 0 ; y < width ; y++){
      for (int x = 0 ; x < height ; x++){
        getTile(x,y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
      }
    }
  }

  public Tile getTile(int x, int y){
    Tile t = Tile.tiles[tiles[x][y]];

    // Make sure we are not getting a null tile
    if (t == null)
      return Tile.dirtTile;

    return t;
  }

  /**
   * Get the file of the world and store it into tiles array
   * @param path location of our map
   */
  private void loadWorld(String path){

  }
}
