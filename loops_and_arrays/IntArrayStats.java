package loops_and_arrays;

/**
 * @param args
 * @author Victor Oza
 * LAB SECTION B55
 * ASSIGNMENT 5
 */
public class IntArrayStats
{
  
  private int minimum; //smallest value in array
  private int maximum; //largest value in array
  private int firstMinIndex; //smallest array index
  private int lastMinIndex; //largest array index where the minimum occurs
  private int firstMaxIndex; //smallest array index where the maximum occurs
  private int lastMaxIndex; //largest array index where the maximum occurs
  private double average; //the average of all values in the array
  private double median; //center value of the sorted array if odd or avg of 2
  
  /**
   * explicit contructor
   * @param min value
   * @param max value
   * @param fMinI first min index
   * @param lMinI last min index
   * @param fMaxI first max index
   * @param lMaxI last max index
   * @param avg average of values
   * @param med median of values
   */
  public IntArrayStats(int min, int max, int fMinI, int lMinI, int fMaxI, 
      int lMaxI, double avg, double med)
  {
    this.minimum = min;
    this.maximum = max;
    this.firstMinIndex = fMinI;
    this.lastMinIndex = lMinI;
    this.firstMaxIndex = fMaxI;
    this.lastMaxIndex = lMaxI;
    this.average = avg;
    this.median = med;
  }
  /**
   * toString method
   */
  public String toString()
  {
    return ("Minimum: " + minimum + "\nMaximum: " + maximum +
        "\nSmallest array index of min: " + firstMinIndex + 
        "\nLargest array index of min: " + lastMinIndex +  
        "\nSmallest array index of max: " + firstMaxIndex + 
        "\nLargest array index of max: " + lastMaxIndex + 
        "\nAverage: " + average + "\nMedian: " + median);
  }
}
