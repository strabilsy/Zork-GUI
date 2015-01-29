package demesnes;

import java.io.Serializable;
import java.util.EnumMap;
import utility.SingleRandom;
import demesnes.Location;

/**
 * Chamber class
 * @author Victor Oza
 * Lab section B55
 * It is okay to return an alias because it is going
 * to return an object of Location which is only 
 * comprised of int primitives
 */
public class Chamber
implements Serializable
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private EnumMap<Direction, Wall> walls;
  private static final int NONE = -1;
  private boolean visited;
  private Location location;
  private int grumanID;
  private int pID;
  
  /**
   * Default Constructor
   */
  public Chamber()
  {
    //SingleRandom.getInstance().setSeed(29);
    int door = 
        SingleRandom.getInstance().nextInt(1,Direction.values().length);
    int count = 0;
    location = new Location();
    this.visited = false;
    this.grumanID = NONE;
    this.pID = NONE;
    walls = new EnumMap<Direction, Wall>(Direction.class);
    for(Direction direction : Direction.values())
    {
      count++;
      walls.put(direction, Wall.BLANK);
      if(count == door)
      {
        walls.put(direction, Wall.DOOR);
      }
    }
  }
  
  /**
   * Explicit value constructor
   * @param location
   */
  public Chamber(EnumMap<Direction, Wall> walls, Location location, int grumanID,
      int pID)
  {
    this.walls = walls;
    this.location = location;
    this.visited = false;
    this.grumanID = grumanID;
    this.pID = pID;
  }
  
  /**
   * Location accessor method
   * @return Location object of location
   */
  public Location getLocation()
  {
    return location;
  }
  
  /**
   * gets gruman ID
   * @return grumanID
   */
  public int getGrumanID()
  {
    return grumanID;
  }
  
  /**
   * gets pID
   * @return pID
   */
  public int getPID()
  {
    return pID;
  }
  
  /**
   * Predicate to get wall in direction
   * @param direction
   * @return wall object in direction
   */
  public Wall getWall(Direction direction)
  {
    return walls.get(direction);
  }
  
  
  /**
   * predicate for visited
   * @return true or false if visited
   */
  public boolean hasVisited()
  {
    return visited;
  }
  
  /**
   * predicate for if gruman exists
   * @return true or false if grumanID > NONE
   */
  public boolean hasGruman()
  {
    return grumanID > NONE;
  }
  
  /**
   * predicate for if location is at origin
   * @return true if location is (0,0)
   */
  public boolean isOrigin()
  {
    return (location.getColumn() == 0 &&
        location.getRow() == 0);
  }
  
  
  
  public boolean hasDoor(Direction direction)
  {
    return walls.get(direction).equals(Wall.DOOR);
  }
  /**
   * Sets visited to true
   */
  public void setVisited()
  {
    this.visited = true;
  }
  
  /**
   * toString override
   */
  public String toString()
  {
    return "\n" + getClass().getName() + "\n" +
  getLocation() + "\nVisited: " + hasVisited() + 
        "\nGrumans: " + hasGruman() + "\nNorth Wall: " + getWall(Direction.NORTH) +
        "\nEast Wall: " + getWall(Direction.EAST) +
        "\nSouth Wall: " + getWall(Direction.SOUTH) +
        "\nWest Wall: " + getWall(Direction.WEST);
  }

  public boolean hasPlankton()
  {
    // TODO Auto-generated method stub
    return pID > NONE;
  }
}
