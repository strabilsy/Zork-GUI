package game;

import players.*;
import utility.SingleRandom;

import java.io.Serializable;
import java.util.Observable;
import java.util.logging.Logger;
import java.util.logging.Level;

import demesnes.Chamber;
import demesnes.Direction;
import demesnes.Location;
import demesnes.Maze;

/**
 * This class serves as the MODEL in the NewZorkGUI It pits a single human
 * against a single gruman Note that each method delegates its job to other
 * objects (i.e., this game class is a wrapper that uses a portion of the Zork
 * classes)
 * 
 * 
 * @author Rose Williams
 * 
 */
public class Game extends Observable implements Serializable

{
  // Instance constants
  public final static int MAX_SACKS = 10;
  public final static double MAX_HEALTH = 100.0;
  public final static double MAX_STRENGTH = 10.0;
  public final static int MID = 4;
  public final static int LOW = 2;
  public final static int HIGH = 8;
  
  // Class Variables -----------------------------------------------------------
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * Provides logging for our game
   */
  public static Logger log;
  static
  {
    log = Logger.getLogger("Game");
  }
  
  // Instance Variables --------------------------------------------------------
  
  /**
   * Player's human player. Must steal treasure from gruman to win
   */
  private Human human;
  
  /**
   * Game player that has treasure
   */
  private Gruman gruman;
  
  private Plankton plankton;
  /**
   * Maze variable
   */
  private Maze maze;
  
  private int count;
  
  // Constructors --------------------------------------------------------------
  
  /**
   * Constructs a new game having one human and one gruman
   */
  public Game()
  {
    count = 0;
    setUpLogging();
    human = null;
    gruman = null;
    createNewHuman();
    maze = new Maze();
    while (!maze.hasPlankton())
    {
      maze = new Maze();
    }
    setVisited();
    setHumanName("SpongeBob Squarepants");
    plankton = maze.getPlankton();
  }
  
  // Class Methods -------------------------------------------------------------
  
  /**
   * Enables or disables logging
   */
  private static void setUpLogging()
  {
    // log.setLevel(Level.ALL);
    log.setLevel(Level.OFF);
  }
  
  // Predicate Methods ---------------------------------------------------------
  
  public boolean hasDoor(Direction direction)
  {
    return (maze.getChamber(human.getLocation())).hasDoor(direction);
  }
  
  public boolean gHasHealth()
  {
    return gruman.hasHealth();
  }
  public boolean hHasHealth()
  {
    return human.hasHealth();
  }
  public boolean canRunAway()
  {
    boolean runaway = false;
    double hS = human.getStrength();
    double gS = gruman.getStrength();
    double hH = human.getHealth();
    double gH = gruman.getHealth();
    if (hS > gS)
    {
      if (hH > gH)
      {
        if (SingleRandom.getInstance().nextInt(MAX_SACKS) < HIGH)
        {
          runaway = true;
        }
      }
      else
      {
        if (SingleRandom.getInstance().nextInt(MAX_SACKS) < MID)
        {
          runaway = true;
        }
      }
    }
    else
    {
      if (hH > gH)
      {
        if (SingleRandom.getInstance().nextInt(MAX_SACKS) < MID)
        {
          runaway = true;
        }
      }
      else
      {
        if (SingleRandom.getInstance().nextInt(MAX_SACKS) < LOW)
        {
          runaway = true;
        }
      }
    }
    return runaway;
  }
  
  public boolean grumanInChamber()
  {
    if ((maze.getChamber(human.getLocation())).hasGruman())
    {
      gruman = (maze.getGruman(maze.getChamber(human.getLocation())));
    }
    return (maze.getChamber(human.getLocation())).hasGruman();
  }
  
  public boolean planktonInChamber()
  {
    if ((maze.getChamber(human.getLocation())).hasPlankton())
    {
      plankton = (maze.getPlankton(maze.getChamber(human.getLocation())));
    }
    return (maze.getChamber(human.getLocation())).hasPlankton();
  }
  
  /**
   * Determines whether or not an Human has been created
   * 
   * @return Human object status
   */
  public boolean hasHuman()
  {
    return human != null;
  }
  
  public boolean hasVisited(Location location)
  {
    return (maze.getChamber(location)).hasVisited();
  }
  
  /**
   * Determines whether or not a Gruman has been created
   * 
   * @return Gruman object status
   */
  public boolean hasGruman()
  {
    return gruman != null;
  }
  
  /**
   * Determines whether or not this gruman has sacks
   * 
   * @return true when has sacks, false when no sacks
   */
  public boolean grumanHasSacks()
  {
    boolean has = false;
    try
    {
     has = gruman.hasSacks();
    }
    catch(Exception e)
    {
      
    }
    return has;
  }
  
  public boolean hasChamber(Location location)
  {
    return maze.hasChamber(location);
  }
  
  public boolean hasDoor(Location location, Direction direction)
  {
    return maze.getChamber(location).hasDoor(direction);
  }
  
  // Accessor Methods ----------------------------------------------------------
  
  public Location getLocation()
  {
    return human.getLocation();
  }
  
  public Maze getMaze()
  {
    return maze;
  }
  
  /**
   * Returns the number of human sacks
   * 
   * @return human sacks
   */
  public int getHumanSacks()
  {
    return human.getSacks();
  }
  
  /**
   * Used to retrieve plankton character object
   * 
   * @return plankton
   */
  public Plankton getPlankton()
  {
    return plankton;
  }
  
  public String getPLocation()
  {
    return maze.getPLocation();
  }
  
  public double getGrumanHealth()
  {
    return gruman.getHealth();
  }
  
  /**
   * Returns the number of gruman sacks
   * 
   * @return gruman sacks
   */
  public int getGrumanSacks()
  {
    return gruman.getSacks();
  }
  
  /**
   * Returns formatted String representation of this human
   * 
   * @return formatted String that represents the state of this human
   */
  public String aString()
  {
    return human.toString();
  }
  
  /**
   * Returns formatted String representation of this gruman
   * 
   * @return formatted String that represents the state of this gruman
   */
  public String mString()
  {
    return gruman.toString();
  }
  
  /**
   * Causes gruman to roar at human and get force of roar
   * 
   * @return force of roar
   */
  public double attackHuman()
  {
    return gruman.terrifyHuman();
  }
  
  /**
   * Causes human to poke gruman and gets force of poke
   * 
   * @return force of poke
   */
  public double attackGruman()
  {
    return human.pokeGruman();
  }
  
  public Human getHuman()
  {
    return human;
  }
  
  public String getHumanName()
  {
    return human.getName();
  }
  
  public Gruman getGruman()
  {
    return gruman;
  }
  
  public int getCount()
  {
    return count;
  }
  
  public Chamber getChamber(Location location)
  {
    return maze.getChamber(location);
  }
  
  public int getPSacks()
  {
    return plankton.getSacks();
  }
  
  // Mutator Methods -----------------------------------------------------------
  
  public void setPSacks()
  {
    plankton.setSacks(MAX_SACKS);
  }
  
  public void lifeOnEdge()
  {
    human.setHealth(1.0);
    human.setStrength(0.1);
  }
  public void incrementCount()
  {
    count++;
  }
  
  /**
   * Creates a new Human
   */
  public void createNewHuman()
  {
    human = new Human();
  }
  
  public void setHumanName(String name)
  {
    human.setName(name);
  }
  
  /**
   * Creates a new Gruman
   */
  public void createNewGruman()
  {
    gruman = new Gruman();
  }
  
  /**
   * Causes human to suffer force of gruman's roar
   * 
   * @param force
   *          of gruman's roar
   */
  public void defendHuman(double attack)
  {
    //double attack = grumanAttack();
    human.sufferTerror(attack);
    if (!(human.hasStrength() && human.hasHealth()) && human.hasSacks())
    {
      human.decrementSacks();
      human.restoreStrength();
      gruman.incrementSacks();
      winRoundGruman();
    }
  }
  
  public double grumanAttack()
  {
    return gruman.terrifyHuman();
  }
  
  /**
   * Causes gruman to suffer force of humans poke
   * 
   * @param force
   *          of humans poke
   */
  public void defendGruman(double force)
  {
    gruman.sufferPoke(force);
    if (!(gruman.hasStrength() && gruman.hasHealth()) && gruman.hasSacks())
    {
      gruman.decrementSacks();
      human.restoreStrength();
      winRoundHuman();
    }
    if(!gruman.hasHealth() && gruman.hasStrength())
    {
      human.restoreStrength();
    }
  }
  
  /**
   * Causes human to gain a sack of treasure after poking gruman
   */
  public void winRoundHuman()
  {
    human.incrementSacks();
    human.restoreHealth();
    human.reduceStrength();
  }
  
  /**
   * Causes gruman to gain a sack of treasure after terrifying human
   */
  public void winRoundGruman()
  {
    gruman.incrementSacks();
    gruman.restoreHealth();
    gruman.reduceStrength();
  }
  
  public void setHumanToMax()
  {
    human.setHealth(MAX_HEALTH);
    human.setStrength(MAX_STRENGTH);
  }
  
  public void setHumanToFullMax()
  {
    human.setHealth(MAX_HEALTH);
    human.setStrength(MAX_STRENGTH);
    human.setSacks(MAX_SACKS);
  }
  
  public void setVisited()
  {
    incrementCount();
    (maze.getChamber(getLocation())).setVisited();
  }
  
  // Overridden Object Methods -------------------------------------------------
  /**
   * Returns formatted String version indicating status of game elements
   * 
   * @return current state of human and gruman objects
   */
  @Override
  public String toString()
  {
    return "Game Status:  \n" + human.toString() + "\n" + gruman.toString();
  }
  
  /**
   * Starts a new game
   */
  public Game newGame()
  {
    // human = null;
    // gruman = null;
    // this.maze = new Maze();
    // createNewHuman();
    Game gameNew = new Game();
    setChanged();
    notifyObservers("NEW");
    return gameNew;
  }
  
  /**
   * Used to move the human
   * 
   * @param direction
   */
  public void move(Direction direction)
  {
    human.changeLocation(direction);
    incrementCount();
  }
  
}
