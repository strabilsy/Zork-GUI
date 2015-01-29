package repository;

public class GrumanNames extends Names
{
  /**
  * array of GRUMAN_NAMES
  */
  private static String [] GRUMAN_NAMES =
	  {"Inky", "Binky", "Blinky", "Dinky", "Jinky", "Pinky", 
		  "Slinky", "Stinky",  "Blimpy", "Gimpy", "Limpy", "Wimpy", 
		  "Dorky", "Beeky", "Geeky", "Gadget", "Didget", "Fidget", 
		  "Gidget", "Widget"};
  private static GrumanNames instance;  
  static
  {
    instance = new GrumanNames();
  }
  
  
  private GrumanNames()
  {
	  super(GRUMAN_NAMES);
  }
  
  
  /**
   * instance method
   * @return instance
   */
  public static GrumanNames getInstance()
  {
    return instance;
  }
  
}