package loops_and_arrays;
import java.util.Arrays;

/**
 * Lab Section B55
 * @author Victor Oza
 * Used to analyze an array of Strings
 */
public class StringArrayAnalyzer
{
  /**
   * Used to analyze an array of Strings
   * @param array input Array
   * @return a StringArrayStats object
   */
  public static StringArrayStats analyze(String[ ] array)
  {
    
    // MIN
    int min = 0;
    if(array != null && array.length > 0)
    {
      min = array[0].length();
      for (int i = 0; i < array.length; i++)
      {
        min = Math.min(array[i].length(), min);
      }
    }
    
    // MAX
    int max = 0;
    if(array != null && array.length > 0)
    {
      max = array[0].length();
      for (int i = 0; i < array.length; i++)
      {
        max = Math.max(array[i].length(), max);
      }
    }
    
    // First String With Min Length & Index
    String fMin = null;
    int fMinIndex = -1;
    boolean keepChecking = true;
    int count = 0;
    while(array != null && keepChecking && array.length > 0)
    {
      if (array[count].length() == min)
      {
        fMinIndex = count;
        fMin = array[count];
        keepChecking = false;
      }
      count++;
    }
    
    // Last String With Min Length & Index
    String lMin = null;
    int lMinIndex = -1;
    keepChecking = true;
    if(array != null &&  array.length > 0)
    {
      count = array.length - 1;
    }
    while(array != null && keepChecking && array.length > 0)
    {
      if (array[count].length() == min)
      {
        lMinIndex = count;
        lMin = array[count];
        keepChecking = false;
      }
      count--;
    }
    
    // First String With Max Length & Index
    String fMax = null;
    int fMaxIndex = -1;
    keepChecking = true;
    count = 0;
    while(array != null && keepChecking && array.length > 0)
    {
      if (array[count].length() == max)
      {
        fMaxIndex = count;
        fMax = array[count];
        keepChecking = false;
      }
      count++;
    }
    
    // Last String With Max Length & Index
    String lMax = null;
    int lMaxIndex = -1;
    keepChecking = true;
    if(array != null &&  array.length > 0)
    {
      count = array.length - 1;
    }
    while(array != null && keepChecking && array.length > 0)
    {
      if (array[count].length() == max)
      {
        lMaxIndex = count;
        lMax = array[count];
        keepChecking = false;
      }
      count--;
    }
    
    // Average
    double sum = 0.0;
    double average = 0.0;
    if(array != null && array.length > 0)
    {
      for(int i = 0; i < array.length; i++)
      {
        sum += array[i].length();
      }
      average = sum / array.length;
    }
    
    // Median
    double median = 0.0;
    if(array != null && array.length > 0)
    {
      int temp[] = new int[array.length];
      for(int i = 0; i < array.length; i++)
      {
        temp[i] = array[i].length();
      }
      Arrays.sort(temp);
      if(temp.length%2 == 0)
      {
        median = ((temp[(temp.length/2)]) + (temp[(temp.length/2) -1 ])) * .5;
      }
      if(temp.length%2 != 0 && temp.length > 0)
      {
        median = temp[(int) ((temp.length/2) - .5)];
      }
    }
    
    return new StringArrayStats(min, max, fMin, fMinIndex, lMin, lMinIndex, 
        fMax, fMaxIndex, lMax, lMaxIndex, average, median);
  }
}
