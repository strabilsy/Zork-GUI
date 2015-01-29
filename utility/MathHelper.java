package utility;

public class MathHelper
{
  
  /**
   * @param args
   */
  public MathHelper()
  {
    // TODO Auto-generated method stub
    
  }
  public double setBounds(int min, int max, double unbounded)
  {
    return Math.max(Math.min(max, unbounded),min);
  }
  
}
