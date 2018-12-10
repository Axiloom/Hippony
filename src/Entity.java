import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity{
  protected float x; // X coordinate of entity
  protected float y; // Y coordinate of entity
  protected int width, height; // stores the size of the entity
  protected Handler handler;
  protected Rectangle bounds; //recangle around our character for collision detection

  // Constructor
  public Entity(Handler handler, float x, float y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.handler = handler;

    bounds = new Rectangle(0,0, width, height); // Set rectangle around entire entity
  }

  // Every entity needs to tick and render
  public abstract void tick();
  public abstract void render(Graphics g);

  // GETTERS AND SETTERS
  public float getX() {
    return x;
  }
  public void setX(float x) {
    this.x = x;
  }
  public float getY() {
    return y;
  }
  public void setY(float y) {
    this.y = y;
  }
  public int getWidth() {
    return width;
  }
  public void setWidth(int width) {
    this.width = width;
  }
  public int getHeight() {
    return height;
  }
  public void setHeight(int height) {
    this.height = height;
  }
}
