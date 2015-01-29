package testers;

import utility.SingleRandom;

public class RandomIntTester
{
  
  /**
   * Tests the two-parameter nextInt() method
   */
  public static void main(String[] args)
  {
    //SingleRandom.getInstance().setSeed(5407);
    //SingleRandom.getInstance().setSeed(421);
    int lower = SingleRandom.getInstance().nextInt(101);
    int upper = SingleRandom.getInstance().nextInt(101) + lower;
    System.out.printf("50 random numbers in the range %d to %d are: \n",
        lower, upper);
    System.out.print(SingleRandom.getInstance().nextInt(lower, upper));
    for (int i = 0; i < 50; i++)      
    {
      System.out.print(", " + SingleRandom.getInstance().nextInt(lower, upper));
    }
  }
}