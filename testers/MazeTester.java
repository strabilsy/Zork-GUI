package testers;

// Note that if logging is used in the Maze class, log messages will be in red
// The logging output stream and System.out appear to be independent and NOT synchronized
// The output from System.out will often partially print out before the output from the logger has finished printing

import demesnes.Maze;
import utility.SingleRandom;

public class MazeTester
{  
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    Maze maze = new Maze();
    System.out.println(maze.toString());
    System.out.println("Done!");
  }     
}
