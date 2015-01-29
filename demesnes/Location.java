package demesnes;

import java.io.Serializable;

/**
 * Location class
 * @author Victor Oza
 * No you can change the values through the contructor
 * No because they are all numbers and its an object of location
 * that will never need to be copied
 */
public class Location
implements Serializable
{
	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  private int column;
	private int row;

	/**
	 * Default constructor
	 */
	public Location()
	{
		this.column = 0;
		this.row = 0;
	}

	/**
	 * explicit constructor
	 * 
	 * @param column
	 * @param row
	 */
	public Location(int column, int row)
	{
		this.column = column;
		this.row = row;
	}

	/**
	 * copy constructor
	 * 
	 * @param other
	 */
	public Location(Location other)
	{
		this(other.column, other.row);
	}

	/**
	 * Explicit constructor
	 * 
	 * @param other
	 * @param travelDirection
	 */
	public Location(Location other, Direction travelDirection)
	{
	  this.column = other.getColumn() + travelDirection.getHorizontalOffset();
    this.row = travelDirection.getVerticalOffset() + other.getRow();
	}
	
	/**
   * Explicit constructor
   * 
   * @param other
   * @param travelDirection
   */
  public Location(Location other, Direction tD1, Direction tD2)
  {
    this.column = other.getColumn() + tD1.getHorizontalOffset();
    this.row = tD1.getVerticalOffset() + other.getRow();
    this.column = column + tD2.getHorizontalOffset();
    this.row = tD2.getVerticalOffset() + row;
  }

	/**
	 * Accessor method for column
	 * 
	 * @return column
	 */
	public int getColumn()
	{
		return this.column;
	}

	/**
	 * Accessor method for row
	 * 
	 * @return row
	 */
	public int getRow()
	{
		return this.row;
	}

	/**
	 * Is origin?
	 * 
	 * @return true if column and row are 0
	 */
	public boolean isOrigin()
	{
		return (column == 0 && row == 0);
	}

	// Overridden methods from the Object class ------------------------------//

	/**
	 * Determines if this location is equal to another location
	 * @return true when equal, false when not equal
	 */
	@Override
	public boolean equals(Object otherObject)
	{
		boolean isEqual = false;

		if (otherObject != null
				&& this.getClass().equals(otherObject.getClass()))
		{
			Location other = (Location) otherObject; // NOTE CAST
			isEqual = column == other.column
					&& row == other.row;
		}
		return isEqual;
	}

	/**
	 * Generates this locations's hash code using row and column fields
	 * @return hash code for this location
	 */
	@Override
	public int hashCode()
	{
		final int HASH_MULTIPLIER = 1601; // use a prime number
		int columnHashCode = new Integer(column).hashCode();
		int rowHashCode = new Integer(row).hashCode();

		return HASH_MULTIPLIER * columnHashCode + HASH_MULTIPLIER
				* rowHashCode;
	}

	/**
	 * Returns formatted String representation of this book
	 * 
	 * @return formatted String representation of the current state of this book
	 */
	@Override
	public String toString()
	{
		return String.format(
				"Column: %d%n" +
				"Row: %d",
				column, row);
	}
}
