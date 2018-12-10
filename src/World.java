import java.awt.Graphics;

public class World {

  private int width, height;
  private int[][] tiles;
  private int spawnX, spawnY;
  private Handler handler;

  // CONSTRUCTOR
  public World(Handler handler, String path){
    this.handler = handler;
    loadWorld(path);
  }

  /**
   * Update variables of world
   */
  public void tick(){

  }

  /**
   * Display graphics of world
   */
  public void render(Graphics g){

    int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH); // Starting location to render x
    int xEnd = (int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
    int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
    int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

    for (int y = yStart ; y < yEnd ; y++){
      for (int x = xStart ; x < xEnd ; x++){
        getTile(x,y).render(g, (int)(x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
                               (int)(y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
      }
    }
  }

  /**
   * Retrieves a specific tile and makes sure that the tile exists
   * @param x location of tile in relation to x-axis
   * @param y location of tile in relation to y-axis
   * @return the tiles at the specific location in the world
   */
  public Tile getTile(int x, int y){

    if (x < 0 || y < 0 || x >= width || y >= height)
      return Tile.brickTile;


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
    String file = Utils.loadFileAsString(path);


    String[] tokens = file.split("\\s+"); // Regex to split string


    width = Utils.parseInt(tokens[0]);
    height = Utils.parseInt(tokens[1]);

    spawnX = Utils.parseInt(tokens[2]);
    spawnY = Utils.parseInt(tokens[3]);


    tiles = new int[width][height];

    for (int y = 0; y < height ; y++){
      for (int x = 0 ; x < width ; x++){
        tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
      }
    }

  }


  // GETTERS AND SETTERS
  public int getWidth() {
    return width;
  }
  public int getHeight() {
    return height;
  }
}
