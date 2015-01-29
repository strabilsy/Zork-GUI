package players;

public class Player
{
  private String name; //instance variable for Player name
  private int sacks; //instance variable for sacks
  private double strength; //instance variable for strength
  private double health; //instance variable for health
  public static double HEALTH_SCALE = 100.0;
  public static double STRENGTH_SCALE = 10.0;
  public static int MAX_HEALTH_POSSIBLE = (int)HEALTH_SCALE;
  public static int MAX_STRENGTH_POSSIBLE = (int)STRENGTH_SCALE;
  public double MAX_HEALTH = HEALTH_SCALE;
  public double MAX_STRENGTH = STRENGTH_SCALE;
  
  public Player(
      String name, 
      int sacks, 
      double health, 
      double strength)
  {
    this.name = name;
    this.health = Math.max(Math.min(MAX_HEALTH_POSSIBLE, health),1);
    this.strength = Math.max(Math.min(MAX_STRENGTH_POSSIBLE, strength),1);
    this.sacks = Math.max(0, sacks);
  }
  
  
  // Mutator Methods
  
  /**
   * Method used to increase sacks by 1
   */
  public void incrementSacks() // mutator method
  {
    sacks = Math.min(10, sacks + 1); // increases sacks value by 1
  }
  
  /**
   * Method used to decrease sacks by 1
   */
  public void decrementSacks() // mutator method
  {
    sacks = Math.max(0, sacks - 1); // decreases sacks value by 1
  }
  /**
   * Sets sacks to inputed value
   * @param inputSacks used to change sacks value
   */
  public void setSacks(int inputSacks) // mutator method
  {
    sacks = Math.max(inputSacks, 0);
  }
  /**
   * Sets health to inputed value
   * @param inputHealth used to change health value
   */
  public void setHealth(double inputHealth) // mutator method
  {
    health = Math.max(Math.min(MAX_HEALTH, inputHealth),0);
  }
  /**
   * Sets strength to inputed value
   * @param inputStrength used to change strength value
   */
  public void setStrength(double inputStrength) // mutator method
  {
    strength = Math.max(Math.min(MAX_STRENGTH, inputStrength),0);
  }
  
  /**
   * Used to set name
   * @param name input name to change to
   */
  public void setName(String name)
  {
    this.name = name;
  }
  /**
   * Used to reset health to MAX_HEALTH (initial health)
   */
  public void resetHealth() // mutator method
  {
    health = MAX_HEALTH;
  }
  /**
   * Used to reset to MAX_STRENGTH (initial strength)
   */
  public void resetStrength() // mutator method
  {
    strength = MAX_STRENGTH;
  }
  /**
   * Restores a fraction of health
   */
  public void restoreHealth() // mutator method
  {
    health = Math.min(((this.MAX_HEALTH / STRENGTH_SCALE) + health),
        this.MAX_HEALTH);
  }
  /**
   * Restores a fraction of strength
   */
  public void restoreStrength() // mutator method
  {
    strength = Math.min((((this.MAX_STRENGTH / 2) / STRENGTH_SCALE) + strength),
        MAX_STRENGTH);
  }
  public void reduceStrength() // mutator method
  {
    strength = Math.max((strength - ((this.MAX_STRENGTH / 2) / STRENGTH_SCALE))
        ,0);
  }
  
  
  
  // Accessor Methods
  
  public String getName() // accessor method
  {
    return name;
  }
  /**
   * Used to access the strength value
   * @return the strength value
   */
  public double getStrength() // accessor method
  {
    return strength;
  }
  /**
   * Used to access the health value
   * @return the health value
   */
  public double getHealth() // accessor method
  {
    return health;
  }
  /**
   * Used to access the sacks value
   * @return the sacks value
   */
  public int getSacks() // accessor method
  {
    return sacks;
  }
  
  // Predicate Methods
  
  public boolean hasSacks() // predicate method
  {
    return sacks > 0;
  }
  public boolean hasStrength()
  {
    return strength > 0;
  }
  public boolean hasHealth()
  {
    return health > 0;
  }
  
  /**
   * Gives string representation of class
   */
  public String toString() // String representation
  {
    return String.format("Name:  %7s%nSacks:  %12d%nHealth:  %13.1f%n" +
        "Strength:  %11.1f%n",
        name, sacks, health, strength);
  }
}
