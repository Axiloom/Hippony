import java.awt.Graphics;
import java.awt.Color;

public class Player extends Creature{

  private static int width = 30;
  private static int height = 30;

  public Player(Handler handler, float x, float y) {
    super(handler , x, y, width ,height);
    bounds.x = 5;
    bounds.y = 15;
    bounds.width = 11;
    bounds.height = 10;
  }

  @Override
  public void tick() {
    getInput(); // Set the xMove and yMove
    move();
    handler.getGameCamera().centerOnEntity(this); // Center camera on player
  }


  private void getInput(){
    xMove = 0;
    yMove = 0;

    if (handler.getKeyManager().up)
      yMove = -speed;
    if (handler.getKeyManager().down)
      yMove =  speed;
    if (handler.getKeyManager().left)
      xMove = -speed;
    if (handler.getKeyManager().right)
      xMove = speed;
  }

  @Override
  public void render(Graphics g) {

    g.drawImage(Assets.character, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()) , width, height,null);

   //  Display red collision box around player (Uncomment for display)
    g.setColor(Color.red);
    g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
            (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
            bounds.width, bounds.height);

  }
}

