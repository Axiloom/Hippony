import java.awt.Graphics;

public class GameState extends State{


  private Player player;
  private World testWorld;

  public GameState(Handler handler) {
    super(handler);

    testWorld = new World(handler, "res/worlds/world1.txt");

    handler.setWorld(testWorld); // set the world as the gameworld

    player = new Player(handler,100,100); // Create a new player

  }

  @Override
  public void tick() {
    testWorld.tick(); // Tick the world
    player.tick(); // Calls the player tick method every second
  }

  @Override
  public void render(Graphics g) {

    testWorld.render(g);

    // Display character
    player.render(g);
  }
}
