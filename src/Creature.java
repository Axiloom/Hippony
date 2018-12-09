public abstract class Creature extends Entity{

  public static final int DEFAULT_HEALTH = 10,
                          DEFAULT_CREATURE_WIDTH = 40,
                          DEFAULT_CREATURE_HEIGHT = 40;

  public static final float DEFAULT_SPEED = 1.5f;

  protected int health;
  protected float speed;
  protected float xMove, yMove;

  public Creature(float x, float y, int width, int height) {
    super(x, y, width, height);
    health = DEFAULT_HEALTH;
    speed = DEFAULT_SPEED;
    xMove = 0;
    yMove = 0;
  }

  /**
   *
   */
  public void move(){
    x += xMove;
    y += yMove;
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



  /**
   * Get the health of the current creature
   * @return
   */
  public int getHealth() {
    return health;
  }

  /**
   * Set the health of the current creature
   * @param health
   */
  public void setHealth(int health) {
    this.health = health;
  }

  /**
   * Get the speed of the current creature
   * @return
   */
  public float getSpeed() {
    return speed;
  }

  /**
   * Set the speed of the current creature
   * @param speed
   */
  public void setSpeed(float speed) {
    this.speed = speed;
  }
}
