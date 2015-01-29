package utility;

import java.util.Random;

/**
 * This class implements Singleton Pattern from Horstmann OOD & Patterns
 * Provides one random number generator to be used by all classes in a program
 * 
 * Change Record:
 *   Added overloaded nextInt() and nextDouble() methods
 *   Added class constants
 *   RMR - 2/2012
 */
public class SingleRandom
{
  /**
   * Establishes/Limits range so no values printed in scientific notation
   */
  public final static int DEFAULT_MAX_POWER = 7;
  
  /**
   * Used to generate number that is a power of 10
   */
  private final static int BASE = 10;
  
  //Note:  these values would be safer as enums, and implementation could be
  //   more direct
  
  /**
   * Used to generate positive values only
   */
  public final static int POSITIVE = 1;
  
  /**
   * Used to generate nagative values only
   */
  public final static int NEGATIVE = -1;
  
  /**
   * Used to generate both positive and negative values
   */
  public final static int RANDOM_SIGN = 0;
  
  
  // Static Variables
  /**
   * This is the single instance accessed by members of other classes via the 
   *   getInstance() method
   */
  private static SingleRandom  instance;  
  static  //This instantiates it once                   
  {
    instance = new SingleRandom();
  }
  

  // Instance Variables
  /**
   * This is the instance of Random that is WRAPPED
   * This field remains hidden
   */
  private Random generator; 

  
  // Constructors
  
  /**
   * Default constructor
   * Creates a private SingleRandom object 
   * Private, so members of other classes cannot declare and instantiate it
   */
  private SingleRandom()  
  {
    generator = new Random();
  }
    

  // Instance methods 
  
  /**
   * Sets seed for pseudo-random calculation to incoming value
   * Invoke for testing to get same random series for multiple runs
   * Just a WRAPPER
   * @param seed - starting seed for pseudo-random number generator
   */
  public void setSeed(int seed)  //Can invoke this for testing if desired
  {
    generator.setSeed(seed);
  }

  /**
   * Returns pseudo-random integer number within interval 0 to range-1
   * @param range upper limit of random number generated, exclusive
   * Just a WRAPPER
   * @return  integer in range 0 to range-1 inclusive
   */
  public int nextInt(int range) 
  {
    return generator.nextInt(range);
  }
  
  /**
   * Returns pseudo-random integer number within interval 0 to range-1
   * @param range upper limit of random number generated, exclusive
   * Just a WRAPPER
   * @return  integer in range 0 to range-1 inclusive
   */
  public int nextInt(int min, int max) 
  {
    return generator.nextInt(max-min+1) + (min);
  }
  
  
  /**
   * Returns pseudo-random double number 
   * Wraps Random class nextDouble() method, but
   * NOT just a WRAPPER
   * 
   * DEFAULT_MAX_POWER - keeps values generated from being so large 
   *   that they have to be printed in scientific notation
   *   (Anything smaller, and you can easily control the formatting)
   * RANDOM_SIGN - insures that value can be either negative or positive
   * 
   * @return  "randomly generated"  double value 
   */
  public double nextDouble() 
  { 
    return nextDouble(DEFAULT_MAX_POWER, RANDOM_SIGN);
  }
  
  /**
   * Returns pseudo-random double number 
   * Wraps Random class nextDouble() method, but
   * NOT just a WRAPPER
   * 
   * DEFAULT_MAX_POWER - keeps values generated from being so large 
   *   that they have to be printed in scientific notation
   *   (Anything smaller, and you can easily control the formatting)
   * 
   * @param sign - Depending on value, will generate negative value, 
   *                 positive value, or either
   * @return  "randomly generated"  double value 
   */ 
  public double nextDouble(int sign)
  {
    return nextDouble(DEFAULT_MAX_POWER, sign);
  }
  
  /**
   * Returns pseudo-random double number  
   * Wraps Random class nextDouble() method, but
   * NOT just a WRAPPER
   * 
   * @param power - controls max range of values by power of 10
   * @param sign - determines whether value generated can be negative, 
   *                 positive, or either
   * @return  double value 
   */
  public double nextDouble(int power, int sign) 
  {
    int maxPower = Math.abs(power); //in case of negative input
    return generator.nextDouble() * Math.pow(BASE, nextInt(maxPower) +1 ) * 
        (sign == RANDOM_SIGN ? 
            (generator.nextBoolean() ? POSITIVE : NEGATIVE): sign);
  }
  
  
  // Static methods ----------------------------------------------------------//
  
  /**
   * Factory method - gives out reference to single instance of class
   * Cannot access otherwise
   * @return reference to random number generator
   */
  public static SingleRandom getInstance()
  {
    return instance;
  }
}
