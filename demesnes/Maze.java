package demesnes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.*;
import players.*;
import utility.SingleRandom;

/**
 * Used as the maze class to create mazes
 * @author Victor Oza
 * Lab Section B55
 */
public class Maze
implements Serializable
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final int NONE = -1;
  private static final int MAX_NUMBER_CHAMBERS = SingleRandom.getInstance().nextInt(50, 100);
  private static final int GRUMAN_ODDS = 2;
  private static final int DOOR_ODDS = 3;
  private static int chambersLeft;
  private static int counter;
  public static Logger logger;
  public HashMap<Location, Chamber> map;
  ArrayList<Gruman> grumans;
  ArrayList<Plankton> planktons;
  private Location pLocation;
  private int pPut;
  private int pID;
  private boolean planktonNeeded;
  public Plankton plankton;
  /**
   * Default constructor
   */
  public Maze()
  {
    this.pPut = 2;
    Maze.setUpLogging();
    int grumanCount = 0;
    int grumanID;
    ArrayList<Location> toDoList = new ArrayList<Location>();
    map = new HashMap<Location, Chamber>();
    grumans = new ArrayList<Gruman>();
    planktons = new ArrayList<Plankton>();
    planktonNeeded = true;
    Chamber newChamber = createEntranceChamber(toDoList);
    addToMap(map, newChamber);
    while(!toDoList.isEmpty())
    {
      grumanID = NONE;
      pID = NONE;
      if(SingleRandom.getInstance().nextInt(GRUMAN_ODDS) > 0)
      {
        Gruman newGruman = new Gruman();
        grumans.add(newGruman);
        grumanID = grumanCount;
        grumanCount++;
        if(pPut > 2)
        {
          pPut--;
        }
      }
      else if(SingleRandom.getInstance().nextInt(pPut) > 0 
          && planktonNeeded == true
            && grumanID == NONE)
      {
        //System.out.println("NEW PLANKTON");
        Plankton plankton = new Plankton();
        planktons.add(plankton);
        planktonNeeded = false;
        pID = 0;
      }
      else
      {
        if(pPut > 2)
        {
          pPut--;
        }
      }
      addToMap(map,createRemainingChambers(toDoList, grumanID, pID));
    }
    showFinishedMaze(this);
  }
  
  /**
   * sets up logging
   * and sets counter to 0 and chambersLEft to Max_NUMBER_Chambers
   */
  public static void setUpLogging()
  {
    logger = Logger.getLogger("Maze");
    //SingleRandom.getInstance().setSeed(29);
    //logger.setLevel(Level.ALL);     
    logger.setLevel(Level.OFF);
    counter = 0;
    chambersLeft = MAX_NUMBER_CHAMBERS;
  }
  
  /**
   * Creates the entrance chamber
   * @param toDoList
   * @return Chamber object
   */
  public Chamber createEntranceChamber(ArrayList<Location> toDoList)
  {
    Chamber chamber = new Chamber();
    chambersLeft--;
    for(Direction direction : Direction.values())
    {
      if(chamber.hasDoor(direction))
      {
        toDoList.add(new Location(direction.getHorizontalOffset(), 
            direction.getVerticalOffset()));
      }
    }
    return chamber;
  }
  
  /**
   * Creates the remaining other chambers
   * @param toDoList
   * @param grumanID
   * @return Chamber object
   */
  public Chamber createRemainingChambers(ArrayList<Location> toDoList, 
      int grumanID, int pID)
  {
    Location nextChamber = toDoList.get(0);
    if(pID != NONE)
    {
      planktons.get(0).setLocation(nextChamber);
      //System.out.println("PLANKTON LOCATION: " + nextChamber);
    }
    toDoList.remove(0);
    EnumMap<Direction, Wall> walls = 
        new EnumMap<Direction, Wall>(Direction.class);
    for(Direction direction : Direction.values())
    {
      Location locationD = new Location(nextChamber, direction);
      if(map.containsKey(locationD))
      {
        if(map.get(locationD).hasDoor(direction.opposite()))
        {
          walls.put(direction, Wall.DOOR);
        }
        else
        {
          walls.put(direction, Wall.BLANK);
        }
      }
      else if(!map.containsKey(locationD) &&
          chambersLeft > 0 &&
          (SingleRandom.getInstance().nextInt(DOOR_ODDS) > 0))
      {
        walls.put(direction, Wall.DOOR);
        if(!toDoList.contains(locationD))
        {
          toDoList.add(locationD);
          chambersLeft--;
        }
      }
      else
      {
        walls.put(direction, Wall.BLANK);
      }
    }
    Chamber rChamber = new Chamber(walls, nextChamber, grumanID, pID);
    if(rChamber.hasPlankton())
    {
      plankton = planktons.get(rChamber.getPID());
    }
    return rChamber;
    //return null;
  }
  
  /**
   * Adds the chamber location to the map
   * @param map
   * @param chamber
   */
  public void addToMap(HashMap<Location, Chamber> map, Chamber chamber)
  {
    map.put(chamber.getLocation(), chamber);
    counter++;
  }
  
  /**
   * Shows the finished Maze
   * @param maze
   */
  public void showFinishedMaze(Maze maze)
  {
    logger.info(maze.toString());
  }
  
  /**
   * Predicate to check for chamber in location
   * @param location
   * @return true if chamber present in location
   */
  public boolean hasChamber(Location location)
  {
    return map.containsKey(location);
  }
  
  /**
   * Predicate to check for gruman in chamber
   * @param chamber
   * @return true if chamber has gruman
   */
  public boolean hasGruman(Chamber chamber)
  {
    return chamber.hasGruman();
  }
  
  /**
   * Gets chamber at location
   * @param location
   * @return Chamber object
   */
  public Chamber getChamber(Location location)
  {
    return map.get(location);
  }
  
  /**
   * gets the keySet
   * @return keySet
   */
  public Set<Location> getKeySet()
  {
    return map.keySet();
  }
  
  /**
   * Gets the gruman in a certain chamber
   * @param chamber
   * @return gruman
   */
  public Gruman getGruman(Chamber chamber)
  {
    Gruman gruman = null;
    if(chamber.hasGruman())
    {
      gruman = grumans.get(chamber.getGrumanID());
    }
    return gruman;
  }
  
  /**
   * Gets the plankton in a certain chamber
   * @param chamber
   * @return plankton
   */
  public Plankton getPlankton(Chamber chamber)
  {
    Plankton plankton = null;
    if(planktons != null)
    {
      plankton = planktons.get(chamber.getPID());
    }
    return plankton;
  }
  
  public boolean hasPlankton()
  {
    boolean value = true;
    if(plankton == null)
    {
      value = false;
    }
    return value;
  }
  
  
  public String getPLocation()
  {
    return plankton.toString();
  }
  
  public Plankton getPlankton()
  {
    return plankton;
  }

  /**
   * toString override
   */
  @Override
  public String toString()
  {
    return String.format("Map: %s%nChambers Left: %s%nGrumans: %s%n",
        map, chambersLeft, grumans);
  }
}
