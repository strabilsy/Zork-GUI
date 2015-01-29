package repository;

public class HumanNames extends Names
{
  /**
  * array of HUMAN_NAMES
  */
  private static String [] HUMAN_NAMES =
	  {"Thutmose", "Darius", "Alexander", "Ch'in", "Pompey", "Julius",
    "Atilla", "Charlemagne", "Hrorekr", "Genghis", "Napoleon", "Naughty"};
  private static HumanNames instance;  
  static
  {
    instance = new HumanNames();
  }
  
  
  private HumanNames()
  {
	  super(HUMAN_NAMES);
  }
  
  
  /**
   * instance method
   * @return instance
   */
  public static HumanNames getInstance()
  {
    return instance;
  }
  
}