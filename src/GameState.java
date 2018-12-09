import java.awt.Graphics;

public class GameState extends State{


  private Player player;
  private World testWorld;

  public GameState(Game game) {
    super(game);
    player = new Player(game,100,100); // Create a new player
    testWorld = new World("res/worlds/world1.txt");
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
