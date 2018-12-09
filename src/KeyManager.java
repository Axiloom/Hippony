import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

  private boolean[] keys;
  public boolean up, down, left, right;


  /**
   * Constructor
   */
  public KeyManager() {
    this.keys = new boolean[256]; // used to store all our keyboard keys
  }

  /**
   * This method is being called every second
   */
  public void tick(){
    up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];   // set up to w
    down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN]; // set down to s
    left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT]; // set left to a
    right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];// set right to d
  }

  /**
   * Called every time a key is pressed
   * @param e the key being pressed
   */
  @Override
  public void keyPressed(KeyEvent e) {
    keys[e.getKeyCode()] = true; // Get the keycode and set the index to true
  }

  /**
   * Called every time a key is released
   * @param e the key being released
   */
  @Override
  public void keyReleased(KeyEvent e) {
    keys[e.getKeyCode()] = false; // Get the keycode and set the index to false
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }
}
