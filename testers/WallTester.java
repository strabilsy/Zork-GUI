package testers;
import demesnes.Wall;


public class WallTester
{
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args)
  {
    
    for (Wall w : Wall.values())
    {
      System.out.println(w.toString() + "\tHas Entrance?  " +  w.hasDoor());
    }
  }
}
