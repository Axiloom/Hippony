public abstract class Creature extends Entity{

  public static final int DEFAULT_HEALTH = 10;

  public static final float DEFAULT_SPEED = 1.5f;

  protected int health;
  protected float speed;
  protected float xMove, yMove;

  public Creature(Handler handler, float x, float y, int width, int height) {
    super(handler, x, y, width, height);
    health = DEFAULT_HEALTH;
    speed = DEFAULT_SPEED;
    xMove = 0;
    yMove = 0;
  }

  /**
   * Move creature
   */
  public void move(){
    moveX();
    moveY();
  }

  /**
   * Move creature along the x axis
   */
  public void moveX(){

    // Means we are moving right
    if (xMove > 0){
      int tx = (int)(x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH; // Temporary x variable

      if (!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILE_HEIGHT)
              && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height / Tile.TILE_HEIGHT))){ // Second portion gets upper right of box
        x += xMove;
      }
    }

    // Means we are moving left
    else if (xMove < 0){
      int tx = (int)(x + xMove + bounds.x) / Tile.TILE_WIDTH; // Temporary x variable

      if (!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILE_HEIGHT) &&
              !collisionWithTile(tx, (int)(y + bounds.y + bounds.height / Tile.TILE_HEIGHT))){ // Second portion gets upper right of box
        x += xMove;
      }
    }
  }

  /**
   * Move creature along the y axis
   */
  public void moveY() {

    // Means we are moving up
    if (yMove < 0){
      int ty = (int)(y + yMove + bounds.y) / Tile.TILE_HEIGHT;

      if (!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) &&
          !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty))
        y += yMove;
    }

    // Means we are moving down
    else if (yMove > 0){
      int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

      if (!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) &&
              !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty))
        y += yMove;
    }
  }

  /**
   * Determine if a specific tile is walkable or not
   *
   * @param x x-coordinate of tile
   * @param y y-coordinate of tile
   * @return true if the tile is solid
   */
  protected boolean collisionWithTile(int x, int y){
    return !handler.getWorld().getTile(x,y).isWalkable();
  }

  // GETTERS AND SETTERS
  public float getxMove() {
    return xMove;
  }

  public void setxMove(float xMove) {
    this.xMove = xMove;
  }

  public float getyMove() {
    return yMove;
  }

  public void setyMove(float yMove) {
    this.yMove = yMove;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public float getSpeed() {
    return speed;
  }

  public void setSpeed(float speed) {
    this.speed = speed;
  }
}
