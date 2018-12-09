import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

/**
 * This class is used to construct and display our window with graphics
 */
public class Display {

  private JFrame frame; // hold our frame
  private Canvas canvas; // used to store drawing

  // JFrame needs 3 things; Title, Width, and Height
  private String title;
  private int width, height; // This is in pixels

  public Display(String title, int width, int height) {
    this.title = title;
    this.width = width;
    this.height = height;

    // Pass variables to create the display
    createDisplay(title, width, height);
  }


  public void createDisplay(String title, int width, int height){

    frame = new JFrame(title);// Create the frame with the given title
    frame.setSize(width,height); // Set the width and height of the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This is required to make sure the game closes properly (all processes close)
    frame.setResizable(false); // Make sure the user cannot resize the window
    frame.setLocationRelativeTo(null); // this will center our window
    frame.setVisible(true); // Make the window viewable
    canvas = new Canvas(); // create the canvas instance to draw to

    // Sets the size of the canvas to the size of the frame
    canvas.setPreferredSize(new Dimension(width, height)); // Set preferred size
    canvas.setMaximumSize(new Dimension(width, height)); // Set max size (no change)
    canvas.setMinimumSize(new Dimension(width, height)); // Set min size (no change)
    canvas.setFocusable(false); // allows the focus to be set on the JFrame

    frame.add(canvas); // add the canvas to the JFrame
    frame.pack(); // Resizes the JFrame a little bit to accomidate for the canvas
  }

  /**
   * Getter for canvas
   * @return the current canvas
   */
  public Canvas getCanvas() {
    return canvas;
  }

  /**
   * Getter for JFrame
   * we need to get the JFrame for use with Key's
   *
   * @return the current JFrame
   */
  public JFrame getFrame() {
    return frame;
  }
}
