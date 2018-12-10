import java.awt.Graphics;

/**
 * This abstract class is the foundation of a state
 */
public abstract class State {

  private static State currentState = null; // Will hold what state we want to tick and render

  protected Handler handler; // game object to be used by a state

  /**
   * Constuctor
   * @param handler handler to control our variables
   */
  public State(Handler handler) {
    this.handler = handler;
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
