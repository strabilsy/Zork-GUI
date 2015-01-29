package loops_and_arrays;
import java.util.Arrays;

/**
 * @param args
 * @author Victor Oza
 * LAB SECTION B55
 * ASSIGNMENT 5
 */
public class IntArrayAnalyzer
{
  /**
   * returns min value in the array
   * @param array input array
   * @return min value
   */
  private static int min(int[] array)
  {
    int minimum = 0;
    if(array.length > 0)
    {
      minimum = array[0];
      for (int i = 0; i < array.length; i++)
      {
        minimum = Math.min(array[i], minimum);
      }
    }
    return minimum;
  }
  
  /**
   * returns the max value in an array
   * @param array input array
   * @return max value in an array
   */
  private static int max(int[] array)
  {
    int maximum = 0;
    if(array.length > 0)
    {
      maximum = array[0];
      for (int i = 0; i < array.length; i++)
      {
        maximum = Math.max(array[i], maximum);
      }
    }
    return maximum;
  }
  
  /**
   * Finds first occurrence of a value in an array
   * @param value value to find
   * @param array input array
   * @return first index of value
   */
  private static int firstValueIndex(int value, int[]array)
  {
    int index = -1;
    int i = 0;
    while(index == -1 && i < array.length && array.length > 0)
    {
      if(value == array[i])
      {
        index = i;
      }
      i++;
    }
    return index;
  }
  
  /**
   * Finds last occurrence of a value in an array
   * @param value value to find
   * @param array input array
   * @return last index of value
   */
  private static int lastValueIndex(int value, int[] array)
  {
    int index = -1;
    int i = 0;
    while(i < array.length && array.length > 0)
    {
      if(value == array[i])
      {
        index = i;
      }
      i++;
    }
    return index;
  }
  
  /**
   * Calculates the average of an array
   * @param array inputed array
   * @return average of the values
   */
  private static double average(int[] array)
  {
    double sum = 0;
    int i = 0;
    while(i < array.length && array.length > 0)
    {
      sum += array[i];
      i++;
    }
    return sum / (array.length);
  }
  
  /**
   * Finds the median of an array
   * @param array inputed array
   * @return median of array
   */
  private static double median(int[] array)
  {
    int[] temp;
    temp = array.clone();
    Arrays.sort(temp);
    double median = 0;
    if(temp.length%2 == 0)
    {
      median = ((temp[(temp.length/2)]) + (temp[(temp.length/2) -1 ])) * .5;
    }
    if(temp.length%2 != 0 && temp.length > 0)
    {
      median = temp[(int) ((temp.length/2) - .5)];
    }
    return median;
  }
  
  /**
   * Returns IntArrayStats Object
   * @param array
   * @return IntArrayStats object using methods
   */
  public static IntArrayStats analyze1(int[] array)
  {
    int min = IntArrayAnalyzer.min(array);
    int max = IntArrayAnalyzer.max(array);
    int fMinI = IntArrayAnalyzer.firstValueIndex(min, array);
    int lMinI = IntArrayAnalyzer.lastValueIndex(min, array);
    int fMaxI = IntArrayAnalyzer.firstValueIndex(max, array);
    int lMaxI = IntArrayAnalyzer.lastValueIndex(max, array);
    double avg = IntArrayAnalyzer.average(array);
    double median = IntArrayAnalyzer.median(array);
    return new IntArrayStats(min,max,fMinI,lMinI,fMaxI,lMaxI,avg,median);  
  }

  /**
   * Returns IntArrayStats Object
   * @param array
   * @return IntArrayStats object without using methods
   */
  public static IntArrayStats analyze2(int[] array)
  {
    // MIN
    int min = 0;
    if(array.length > 0)
    {
      min = array[0];
      for (int i = 0; i < array.length; i++)
      {
        min = Math.min(array[i], min);
      }
    }
    // MAX
    int max = 0;
    if(array.length > 0)
    {
      max = array[0];
      for (int i = 0; i < array.length; i++)
      {
        max = Math.max(array[i], max);
      }
    }
    
    // FIRST VALUE MIN
    int fMinI = -1;
    int i = 0;
    while(fMinI == -1 && i < array.length && array.length > 0)
    {
      if(min == array[i])
      {
        fMinI = i;
      }
      i++;
    }
    
    // FIRST VALUE MAX
    int fMaxI = -1;
    i = 0;
    while(fMaxI == -1 && i < array.length && array.length > 0)
    {
      if(max == array[i])
      {
        fMaxI = i;
      }
      i++;
    }
    
    // LAST VALUE MIN
    int lMinI = -1;
    i = 0;
    while(i < array.length && array.length > 0)
    {
      if(min == array[i])
      {
        lMinI = i;
      }
      i++;
    }
    
    // LAST VALUE MAX
    int lMaxI = -1;
    i = 0;
    while(i < array.length && array.length > 0)
    {
      if(max == array[i])
      {
        lMaxI = i;
      }
      i++;
    }
    
    // AVERAGE
    double sum = 0;
    i = 0;
    double avg;
    while(i < array.length && array.length > 0)
    {
      sum += array[i];
      i++;
    }
    avg = sum / (array.length);
    
    // MEDIAN
    int[] temp;
    temp = array.clone();
    Arrays.sort(temp);
    double median = 0;
    if(temp.length%2 == 0)
    {
      median = ((temp[(temp.length/2)]) + (temp[(temp.length/2) -1 ])) * .5;
    }
    if(temp.length%2 != 0 && temp.length > 0)
    {
      median = temp[(int) ((temp.length/2) - .5)];
    }
    
    return new IntArrayStats(min,max,fMinI,lMinI,fMaxI,lMaxI,avg,median); 
  }
}
