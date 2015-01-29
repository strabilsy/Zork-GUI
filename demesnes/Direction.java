package demesnes;

/**
 * Direction enum
 * @author Victor Oza
 * Lab section B55
 */
public enum Direction
{
  NORTH(0,1)
  {
    public Direction next()
    {
      return EAST;
    }
  },
  EAST(1,0)
  {
    public Direction next()
    {
      return SOUTH;
    }
  },
  SOUTH(0,-1)
  {
    public Direction next()
    {
      return WEST;
    }
  },
  WEST(-1,0)
  {
    public Direction next()
    {
      return NORTH;
    }
  };
  
  
  private int horizontalOffset;
  private int verticalOffset;

  /**
   * Private constructor
   * @param horizontalOffset
   * @param verticalOffset
   */
  private Direction(int horizontalOffset, int verticalOffset)
  {
    this.horizontalOffset = horizontalOffset;
    this.verticalOffset = verticalOffset;
  }
  
  /**
   * abstract method
   * @return next direction
   */
  public abstract Direction next();
  
  /**
   * Accessor method for horizontal offset
   * @return horizontalOffset
   */
  public int getHorizontalOffset()
  {
    return horizontalOffset;
  }
    
  /**
   * Accessor method for vertical offset
   * @return verticalOffset
   */
  public int getVerticalOffset()
  {
    return verticalOffset;
  }
  
  /**
   * Used to return opposite value
   * @return the opposite direction
   */
  public Direction opposite()
  {
    return next().next();
  }
  
  /**
   * toString override
   * returns toString
   */
  public String toString()
  {
    String name = name();
    return name.substring(0,1) + name.substring(1, name.length()).toLowerCase();  
  }
}


