import java.awt.image.BufferStrategy;
import java.awt.Graphics;

/**
 * This class is the main class of our game. All base code of our game (we put a lot of stuff in
 * here)
 */
public class Game implements Runnable {
  private Display display; // Create a new display
  public int width, height;
  public String title;
  private BufferStrategy bs; // Create a buffer to draw to
  private Graphics g; // This is our "paintbrush"
  private boolean running = false; // running state of game
  private Thread thread; // Create a thread for the game
  private KeyManager keyManager; // create instance of keyManager to use keyListener

  // States of our game
  private State gameState;
  private State menuState;

  /**
   * This is the constructor that creates our game
   *
   * @param title name of the game
   * @param width width of the display
   * @param height height of the display
   */
  public Game(String title, int width, int height) {
    this.width = width;
    this.height = height;
    this.title = title;
    keyManager = new KeyManager();
  }

  /**
   * Initalize everything for our game
   */
  private void init(){
    this.display = new Display(title,width,height); // Create a new display
    display.getFrame().addKeyListener(keyManager); // adding keyListener to our JFrame (keyboard ac)

    Assets.init(); // Initalize all sprite images

    // Initalize our multiple game states
    gameState = new GameState(this);
    menuState = new MenuState(this);

    State.setState(gameState); // Set the current gameState

    running = true; // Declare that the game is running
  }

  /**
   *  This method will update all variables in our game
   */
  private void tick(){

    keyManager.tick(); // calls the keyManager tick method every second


    // Check to see that a state has been set and call that states tick
    if (State.getState() != null)
      State.getState().tick();
  }

  /**
   * This method will render everything in our game (draw update to display)
   * Draw things to the screen
   */
  private void render(){

    bs = display.getCanvas().getBufferStrategy(); // applies the canvas to the buffer

    // If the canvas does not have a buffer strategy, we need to create one
    if (bs == null) {
      display.getCanvas().createBufferStrategy(2); // We say we will be using 2 buffers
      return; // Make sure we recheck before continuing
    }

    g = bs.getDrawGraphics(); // This allows us to draw to the buffer canvas

    g.clearRect(0,0, width, height); // this clears the screen so we dont have repeat items

    // DRAW REPEATED GRAPHICS HERE

    // call the render method in the current state
    if (State.getState() != null)
      State.getState().render(g);

    // END DRAW

    bs.show(); // This will move to buffer to the main screen (prevents flicker)

    g.dispose(); // Make sure our graphics object gets done properly FIXME Dont know why we use this

  }

  @Override
  public void run() {

    init(); // Initalize all starting components of game

    // This is a fps generator
    int fps = 60;
    double timePerTick = 1000000000 / fps; // Maximum time to run before ticking
    double delta = 0; // keep track of when to tick
    long now;
    long lastTime = System.nanoTime(); // clock of computer
    long timer = 0;
    int ticks = 0;

    // Loop for game to make sure we stay at 60fps
    while (running){
      now = System.nanoTime();
      delta += (now - lastTime) / timePerTick;
      timer += now - lastTime;
      lastTime = now;

      if (delta >= 1) {
        tick();
        render();
        ticks++;
        delta--; // Reset delta
      }
      if (timer >= 1000000000){
        System.out.println("Ticks and Frames: " + ticks);
        ticks = 0;
        timer = 0;
      }
    }
  }

  /**
   * Getter for our keyManager to be used with our player to move around
   * @return
   */
  public KeyManager getKeyManager(){
    return keyManager;
  }




  /**
   * This method will initialize our thread to start
   *
   * synchronized =
   *
   */
  public synchronized void start(){

    // check to see if the game is already running by checking running boolean
    if (running)
      return;

    // Set running to true to indicate game has started
    running = true;

    // Create a new thread
    thread = new Thread(this);

    // Start thread and call Run() method
    thread.start();
  }

  /**
   * This method will initialize our tread to stop
   */
  public synchronized void stop(){

    // Check to see if the game has already stopped
    if (!running)
      return;

    // Stop running loop
    running = false;

    try {
      // Close our thread properly
      thread.join();
    }

     // Could possible throw a checked exception
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
