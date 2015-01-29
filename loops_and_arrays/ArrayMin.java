package loops_and_arrays;

import utility.SingleRandom;

/**
 * This class finds both the minimum element in an array of ints
 * as well as the index of this minimum element
 * But watch out!  Trouble is lurkning . . .
 * 
 * @author Rose Williams
 *
 */
public class ArrayMin
{
  
  /**
 * Finds the minimum value in an array
 *   or returns 0 if array is null or empty
 * Uses ordinary for loop
 * @param array of double
 * @return minVal or 0
 */
public static int minElementUseFor(int[] array)
{
  int minVal = 0;
  if(array != null && array.length > 0)
  {
    minVal = array[0];
    for (int i = 1; i < array.length; i++)
    {
      if (array[i] < minVal)
      {
        minVal = array[i];
      }
    }
  }
  return minVal;
}

/**
 * Finds the minimum value in an array
 *   or returns 0 if array is null or empty
 * Uses enhanced for loop
 * @param array of double
 * @return minVal or 0
 */
public static int minElementUseForEach(int[] array)
{
  int minVal = 0;
  if (array != null && array.length > 0)
  {
    minVal = array[0];
    for (int i : array)
    {
      if (i < minVal)
      {
        minVal = i;
      }
    }
  }
  return minVal;
}

/**
 * Finds the position (i.e., index) 
 *   of the smallest element in an array
 *   or returns -1 if array is null or empty
 * Uses ordinary for loop
 * @param array of double
 * @return minIndex or -1
 */
public static int indexFirstMinUseFor(int[] array)
{
  int minIndex = -1;
  if(array != null && array.length > 0)
  {  
    int minVal = array[0];
    minIndex = 0;
    for (int i = 1; i < array.length; i++)
    {
      if (array[i] < minVal)
      {
        minVal = array[i];
        minIndex = i;
      }
    }
  }
  return minIndex;
}

/**
 * Finds the position (i.e., index) 
 *   of the smallest element in an array
 *   or returns -1 if array is null or empty
 * Uses ordinary for loop
 * @param array of double
 * @return minIndex or -1
 */
public static int indexFirstMinUseForEach(int[] array)
{
  int minIndex = -1;
  if(array != null && array.length > 0)
  {
    int minVal = array[0];
    int count = 0;
    minIndex = 0;
    for (int i : array)
    {
      if (i < minVal)
      {
        minVal = i;
        minIndex = count;
      }
      count++;
    }
  }
  return minIndex;
}  
  
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    int SIZE = 50;
    //int[] seedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] seedArray = { 43, 47, 53, 59, 61, 67 };
    int[] testArray;
      
    for (int s : seedArray)
    {
      SingleRandom.getInstance().setSeed(s);
      testArray = new int[SIZE];
      System.out.print("testArray = ");
      for (int i = 0; i < 50; i++)
      {
        testArray[i] = SingleRandom.getInstance().nextInt(1, 10);
        System.out.print(testArray[i] + "  ");
      }
      System.out.printf(
        "%nMin Element (for):  %d, Min Element (for each):  %d, " +
        "Min Element Index (for):  %d, Min Element Index (for each):  %d",
        minElementUseFor(testArray), minElementUseForEach(testArray),
        indexFirstMinUseFor(testArray),
        indexFirstMinUseForEach(testArray));
      System.out.printf(
        "%nElement at Min Index (for):  %d, " +
        "Element at Min Index (for each):  %d%n",
        testArray[indexFirstMinUseFor(testArray)],
        testArray[indexFirstMinUseForEach(testArray)]);
      System.out.println();
    }
    
    int[] nullArray = null;
    if (indexFirstMinUseFor(nullArray) >= 0)
      System.out.printf(
          "%nElement at Min Index (for):  %d, ",
          nullArray[indexFirstMinUseFor(nullArray)]);
    else
      System.out.println("Array is null or empty");
    
    if (indexFirstMinUseForEach(nullArray) >= 0)
      System.out.printf(
          "Element at Min Index (for each):  %d",
          nullArray[indexFirstMinUseForEach(nullArray)]);
    else
      System.out.println("Array is null or empty");

      
    int[] emptyArray = {};
    if (indexFirstMinUseFor(emptyArray) >= 0)
      System.out.printf(
          "%nElement at Min Index (for):  %d, ",
          emptyArray[indexFirstMinUseFor(emptyArray)]);
    else
      System.out.println("Array is null or empty");
    
    if (indexFirstMinUseForEach(emptyArray) >= 0)
      System.out.printf(
          "Element at Min Index (for each):  %d",
          emptyArray[indexFirstMinUseForEach(emptyArray)]);
    else
      System.out.println("Array is null or empty"); 
  } 
}