package testers;

import static org.junit.Assert.*;
import org.junit.Test;
import demesnes.*;
import java.util.Set;
import java.util.ArrayList;
import demesnes.Maze;

public class MazeTest
{
  
  @Test
  public void testMaze()
  {
    Maze maze = new Maze(); //create random maze
    
  //get set of keys so that each chamber can be visited
    Set<Location> keySet = maze.getKeySet(); 
    ArrayList<Location> keyList = new ArrayList<Location>(keySet);
    for (Location key : keyList) //for each location in maze
    {
    	int doorCount = 0;
    	Chamber chamber1 = maze.getChamber(key); //access chamber
    	for (Direction d : Direction.values()) //for each direction in chamber
      {
      	if(chamber1.getWall(d).hasDoor())
      	  doorCount ++;
        Location location = new Location(key, d);
        //access chamber (if any) in that direction)
      	Chamber chamber2 = maze.getChamber(location); 
        if (chamber2 == null) //if chamber does not exist in that direction
          //check that wall is blank
          assertEquals("Wall must be blank",Wall.BLANK,chamber1.getWall(d)); 
        else  //OR
          //check that wall matches other wall
          assertEquals("Walls must match", 
            chamber2.getWall(d.opposite()),chamber1.getWall(d));  
      }
      if (key.isOrigin())
        //check entrance has only one door
      	assertEquals("Number doors must be one", 1, doorCount); 
      else
      	assertTrue("Number doors are >0 and <= 4", 
      	            doorCount > 0 && doorCount <= 4);
    }
  } 
}
