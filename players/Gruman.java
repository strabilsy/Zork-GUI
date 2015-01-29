package players;

import java.io.IOException;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import repository.BattleStrategy;
import repository.Coward;
import repository.GrumanNames;
import repository.Names;
import repository.Normal;
import repository.Offensive;
import utility.SingleRandom;

/**
 * @author Oza, Victor
 * Lab Section B55
 * 
 *Used as the Gruman class to apply attribute to the play
 */
public class Gruman extends Player
implements Serializable
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant of max sacks to start
   */
  public static int MAX_SACKS_TO_START = 10;
  
  /**
   * ArrayList used to determine type of gruman
   */
  public ArrayList<BattleStrategy> types = new ArrayList<BattleStrategy>();
  //private final static long serialVersionUID;   
  //static
  //{
  //  serialVersionUID = ObjectStreamClass.lookup(Gruman.class).getSerialVersionUID();
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
  
  private BattleStrategy type;
  //CONSTRUCTORS
    
  /**
   * Constructs a Gruman with all 0 variables
   */
  public Gruman() // default constructor
  {
    this((GrumanNames.getInstance().takeNames()),
        (Math.max(SingleRandom.getInstance().nextInt(MAX_SACKS_TO_START+1),1)),
        (1 + SingleRandom.getInstance().nextInt(MAX_HEALTH_POSSIBLE)),
        (1+SingleRandom.getInstance().nextInt(MAX_STRENGTH_POSSIBLE)));
    counter++; //Class variable that numbers each object as created
    id = counter; //Stores counter value for this instance
    log = Logger.getLogger("Human"+ id);
    log.setLevel(Level.OFF);
  //log information for trace
    log.info("Create Human #" + id + this);
  }
  
  /**
   * Constructs a Gruman with desired name and inputs
   * @param inputName inputed Name
   * @param inputSacks inputed sacks amount
   * @param inputStrength inputed strength amount
   * @param inputHealth inputed health amount
   */
  public Gruman(String inputName, int inputSacks, double inputHealth, double
      inputStrength) // explicit value constructor
  {
    super(inputName,
        (Math.max(Math.min(inputSacks, MAX_SACKS_TO_START), 0)),
        (Math.max(Math.min(MAX_HEALTH_POSSIBLE, inputHealth),1)),
        (Math.max(Math.min(MAX_STRENGTH_POSSIBLE, inputStrength),1)));
    counter++; //Class variable that numbers each object as created
    types.add(new Coward());
    types.add(new Normal());
    types.add(new Offensive());
    int random = SingleRandom.getInstance().nextInt(0,(types.size() - 1));
    type = types.get(random);
    id = counter; //Stores counter value for this instance
    log = Logger.getLogger("Human"+ id);
    log.setLevel(Level.OFF);
    //log information for trace
    log.info("Create Human #" + id + this);
  }
  public Gruman(
      String inputName)
  {
    this(inputName,
        (Math.max(SingleRandom.getInstance().nextInt(MAX_SACKS_TO_START+1),1)),
        (1 + SingleRandom.getInstance().nextInt(MAX_HEALTH_POSSIBLE)),
        (1+SingleRandom.getInstance().nextInt(MAX_STRENGTH_POSSIBLE)));
    counter++; //Class variable that numbers each object as created
    id = counter; //Stores counter value for this instance
    log = Logger.getLogger("Human"+ id);
    log.setLevel(Level.OFF);
    //log information for trace
    log.info("Create Human #" + id + this);
  }
  
    
  
  // METHODS
  
    
  // MUTATOR METHODS
  
  
  /**
   * Damage delt by Gruman to Human
   * @param force amount of damage done to human
   */
  public void sufferPoke(double force) //mutator method
  {
    setHealth(Math.max(0,getHealth() - force));
    log.info("ID =" + id + "Health = " + getHealth());
    setStrength(Math.max(0,getStrength() - (force / STRENGTH_SCALE)));
    log.info("ID = " + id + ", Strength = " + getStrength()); //lab3
  }
   
  
  // ACCESSOR METHODS
  
  
  /**
   * Used to roar at human
   * @return poke strength
   */
  public double terrifyHuman() // accessor method
  {
    log.info("Force of terror = " + (getStrength()/HEALTH_SCALE * getHealth()));
    //((getStrength() / this.HEALTH_SCALE) * getHealth());
    return type.getAttack(getHealth(), getStrength());
  }
  
  public String getType()
  {
    return type.toString();
  }
  
  
  // TO STRING
  
  /**
   * Gives string representation of class
   */
  public String toString() // String representation
  {
    return String.format("Name:  %-7s  ID:  %-2d  Sacks:  %- 2d  Health:  %-6.1f " +
        "Strength:  %-6.1f%n Type: %s",
        getName(), id, getSacks(), getHealth(), getStrength(), getType());
  }
  private static void setUpLogging()
  {
    //log.setLevel(Level.ALL);     
    log.setLevel(Level.OFF);
  }  
}
