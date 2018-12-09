import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class contains helper methods to assist us with our game creation
 */
public class Utils {

  /**
   * Used to convert our map files to usable data
   *
   * @param path the path where the map file is located
   * @return the string containing our map details
   */
  public static String loadFileAsString(String path){
    // String builder will make adding characters to a string easier
    StringBuilder builder = new StringBuilder();

    try{
      BufferedReader br = new BufferedReader(new FileReader(path)); // Used to read input from file
      String line; // Represents the current line we are working on

      // Go through file until we reach the end and add elements to string
      while ((line = br.readLine()) != null)
        builder.append(line + "\n");

      // Close reader
      br.close();
    }
    catch (IOException e){
      e.printStackTrace();
    }

    return builder.toString(); // Must include .toString() since we are using a StringBuilder
  }

  /**
   * converts any string representations of integers and converts them into int's
   * @param number number(string) to be converted into Integer
   * @return converted string to number
   */
  public static int parseInt(String number){
    try{
      return Integer.parseInt(number);
    }
    catch (NumberFormatException e){
      e.printStackTrace();
      return 0;
    }
  }
}
