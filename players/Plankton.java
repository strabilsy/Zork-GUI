package players;

import java.io.Serializable;

import demesnes.Location;

public class Plankton
implements Serializable
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private Location location;
  private int sacks;
  
  public Plankton()
  {
    this.location = null;
    this.sacks = 0;
  }
  
  public int getSacks()
  {
    return sacks;
  }

  public void setSacks(int sacks)
  {
    this.sacks = sacks;
  }

  public void setLocation(Location location)
  {
    this.location = location;
  }
  
  public Location getLocation()
  {
    return location;
  }
  
  public String toString()
  {
    return "(" + location.getColumn() + "," + location.getRow() + ")";
  }
}
