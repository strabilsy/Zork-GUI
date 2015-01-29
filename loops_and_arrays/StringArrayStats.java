package loops_and_arrays;

/**
 * Lab Section B55
 * @author Victor Oza
 * Used to print information from an array of Strings
 */
public class StringArrayStats
{
  private int minStringLength;
  private int maxStringLength;
  private String firstStringWithMinLength;
  private int indexFirstMin;
  private String lastStringWithMinLength;
  private int indexLastMin;
  private String firstStringWithMaxLength;
  private int indexFirstMax;
  private String lastStringWithMaxLength;
  private int indexLastMax;
  private double averageLength;
  private double medianLength;
  
  /**
   * Explicit Value Constructor
   * @param minStringLength Minimum String Length
   * @param maxStringLength Maximum String Length
   * @param firstStringWithMinLength First String with Min Length
   * @param indexFirstMin Index of that String
   * @param lastStringWithMinLength Last String with Min Length
   * @param indexLastMin Index of that String
   * @param firstStringWithMaxLength First String with Max Length
   * @param indexFirstMax Index of that String
   * @param lastStringWithMaxLength Last String with Max Length
   * @param indexLastMax Index of that String
   * @param averageLength Average length of all Strings in an array
   * @param medianLength Median Length of strings in an array
   */
  public StringArrayStats(int minStringLength, int maxStringLength,
      String firstStringWithMinLength, int indexFirstMin, 
      String lastStringWithMinLength, int indexLastMin, 
      String firstStringWithMaxLength, int indexFirstMax, 
      String lastStringWithMaxLength, int indexLastMax, double averageLength,
      double medianLength)
  {
    this.minStringLength = minStringLength;
    this.maxStringLength = maxStringLength;
    this.firstStringWithMinLength = firstStringWithMinLength;
    this.indexFirstMin = indexFirstMin;
    this.lastStringWithMinLength = lastStringWithMinLength;
    this.indexLastMin = indexLastMin;
    this.firstStringWithMaxLength = firstStringWithMaxLength;
    this.indexFirstMax = indexFirstMax;
    this.lastStringWithMaxLength = lastStringWithMaxLength;
    this.indexLastMax = indexLastMax;
    this.averageLength = averageLength;
    this.medianLength = medianLength;
  }
  
  /**
   * overrides toString method
   * @return String Representation of String Array Stats Object
   */
  public String toString()
  {
    return ("\nMin String Length: " + minStringLength + "     Max String Length:  " +
  maxStringLength + "\nFirst String With Min Length:  " + firstStringWithMinLength
  + "     Index First Min:  " + indexFirstMin + "\nLast String With Min Length:  " + 
  lastStringWithMinLength + "     Index Last Min:  " + indexLastMin +
  "\nFirst String With Max Length:  " + firstStringWithMaxLength + "     Index First Max:  "
  + indexFirstMax + "\nLast String With Max Length:  " + lastStringWithMaxLength +
  "     Index Last Max:  " + indexLastMax + "\nAverage Length:  " + averageLength +
  "     Median Length:  " + medianLength);
  }
}
