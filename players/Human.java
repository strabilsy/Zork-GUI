package players;
import java.io.IOException;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.logging.*;
import java.util.Random;

import demesnes.Direction;
import demesnes.Location;
import utility.SingleRandom;
import repository.HumanNames;
/**
 * @author Oza, Victor
 * Lab Section B55
 * 
 *Used as the human class to apply attribute to the play
 */
public class Human extends Player
implements Serializable
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public static int NUMBER_SACKS_TO_WIN = 10;
  public static int MIN_SACKS_TO_WIN = 10;
  //private final static long serialVersionUID;   
  //static
  //{
  //  serialVersionUID = ObjectStreamClass.lookup(Human.class).getSerialVersionUID();
  //}
  
  
  //Setting up the data attributes

  /**
   * Assigns file number
   */
  private static int counter = 0;

  /**
   * This Human's ID number
   */
  private int id;

  /**
   * This Human's debug logger
   */
  public static Logger log;
  static
  {
    log = Logger.getLogger("Storage");
  }  

  /**
   * Configures logger output file
   */
  private Handler handler;  
  
  /**
   * Human location in chamber
   */
  private Location location;
  /**
   * Constructs a human with all 0 variables
   */
  public Human() // default constructor
  {
    this((HumanNames.getInstance().takeNames()),
        (SingleRandom.getInstance().nextInt(Player.MAX_HEALTH_POSSIBLE/2,Player.MAX_HEALTH_POSSIBLE)),
        (SingleRandom.getInstance().nextInt(Player.MAX_STRENGTH_POSSIBLE)+1));
    counter++; //Class variable that numbers each object as created
    id = counter; //Stores counter value for this instance
    log = Logger.getLogger("Human"+ id);
    log.setLevel(Level.OFF);
    log.info("Create Human #" + id + this);
    location = new Location();
  }
  
  /**
   * Constructs a Human with desired name and inputs
   * @param inputName inputed Name
   * @param inputSacks inputed sacks amount
   * @param inputStrength inputed strength amount
   * @param inputHealth inputed health amount
   */
  public Human(  // explicit value constructor
		  String inputName, 
		  double inputHealth, 
		  double inputStrength) 
  {
    super(inputName, 
        0, 
        Math.max(Math.min(MAX_HEALTH_POSSIBLE, inputHealth),1), 
        Math.max(Math.min(MAX_STRENGTH_POSSIBLE, inputStrength),1));
    counter++; //Class variable that numbers each object as created
    id = counter; //Stores counter value for this instance
    log = Logger.getLogger("Human"+ id);
  	log.setLevel(Level.OFF);
    //log information for trace
    log.info("Create Human #" + id + this);
  }
  
  
  public Human(
		  String inputName)
  {
    this(inputName,
        (SingleRandom.getInstance().nextInt(Player.MAX_HEALTH_POSSIBLE/2,Player.MAX_HEALTH_POSSIBLE)),
        (SingleRandom.getInstance().nextInt(Player.MAX_STRENGTH_POSSIBLE)+1));
    counter++; //Class variable that numbers each object as created
    id = counter; //Stores counter value for this instance
    log = Logger.getLogger("Human"+ id);
    log.setLevel(Level.OFF);    
    log.info("Create Human #" + id + this);
  }
  
  
  
  // METHODS
  
  
  // Mutator Methods
  
  /**
   * Damage delt by Gruman to Human
   * @param force amount of damage done to human
   */
  public void sufferTerror(double force) //mutator method
  {
    setHealth(Math.max(0,getHealth() - force));
    log.info("ID =" + id + "Health = " + getHealth());
    setStrength(Math.max(0,(getStrength() - (force / STRENGTH_SCALE))));
    log.info("ID = " + id + ", Strength = " + getStrength()); //lab3
  } 
  
  
  // ACCESSOR METHODS
  /**
   * Used to poke Gruman
   * @return poke strength
   */
  public double pokeGruman() // accessor method
  {
    log.info("Force of poke = " + (getStrength()/HEALTH_SCALE * getHealth()));
    return getStrength() / HEALTH_SCALE * getHealth();
  }

  //predicates
  public boolean hasSacksToWin()
  {
    log.info("ID =" + id + "Has Sacks to win = " + 
  (getSacks() > (NUMBER_SACKS_TO_WIN - 1)));
    return getSacks() > (NUMBER_SACKS_TO_WIN - 1);
  }
  
  /**
   * Gives string representation of class
   */
  public String toString() // String representation
  {
    return String.format("Name:  %-7s  ID:  %-2d  Sacks:  %- 2d  Health:  %-6.1f " +
        "Strength:  %-6.1f%n",
        getName(), id, getSacks(), getHealth(), getStrength());
  }
  private static void setUpLogging()
  {
    //log.setLevel(Level.ALL);     
    log.setLevel(Level.OFF);
  }  
  
  /**
   * Used to return human location
   * @return location
   */
  public Location getLocation()
  {
    return location;
  }
  
  /**
   * Used to move the human
   * @param direction
   */
  public void changeLocation(Direction direction)
  {
    location = new Location(location, direction);
  }
  
}
