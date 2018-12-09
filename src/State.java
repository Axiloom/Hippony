import java.awt.Graphics;

/**
 * This abstract class is the foundation of a state
 */
public abstract class State {

  private static State currentState = null; // Will hold what state we want to tick and render
  protected Game game; // game object to be used by a state

  /**
   * Constuctor
   * @param game game object to be used with a state
   */
  public State(Game game) {
    this.game = game;
  }

  /**
   * Sets the current state
   * @param state the current state being set
   */
  public static void setState(State state){
    currentState = state;
  }

  /**
   * getter for current state
   * @return the current state
   */
  public static State getState() {
    return currentState;
  }

  /**
   * every state must have a tick method
   */
  public abstract void tick();

  /**
   * every state must have a render method
   * @param g the graphics object
   */
  public abstract void render(Graphics g);

}
