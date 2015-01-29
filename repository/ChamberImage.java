package repository;

import game.Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
//Put additional imports here
//i.e., shapes, lines, points, etc.

// Nested packages
// Note that importing java.awt.geom would NOT include classes
// Inner classes
// Note that we do NOT import the inner class
import java.awt.geom.Arc2D; // We will be using Arc2D.Double
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import demesnes.Location;


/**
 * This class models a generic map in the game of NewZork
 * @author Corey Hom
 *
 */
public class ChamberImage
{
  // Class Constants -----------------------------------------------------------

  public final static int SCALE1 = 26; 
  public final static int SCALE2 = 72; 
  public final static int SCALE3 = 144; 
  public final static int SCALE4 = 216;
  public final static int PEN_WIDTH = 2; 

  
  // Instance Variables --------------------------------------------------------
  private double xLeft;
  private double yTop;
  private Game game;
  private ColorScheme colors;
  private Location location;
  
  
  // Constructors --------------------------------------------------------------
  
  /**
   * Create ChamberImage object with x,y reference point
   * This reference point starts at the middle of the player
   */
  public ChamberImage(double xLeft, double yTop, Game game, Location location)  
  {
    this.xLeft = xLeft;
    this.yTop = yTop;
    colors = new ColorScheme(Color.BLUE, Color.WHITE, 
        Color.BLACK, Color.RED,
        Color.GREEN, Color.YELLOW);
    this.game = game;
    this.location = location;
  }
  
  /**
   * Create this player image with midpoint at given reference point and
   * with given color scheme
   */
  public ChamberImage(double xLeft, double yTop, 
      ColorScheme colors, Game game)
  {
    this.xLeft = xLeft;
    this.yTop = yTop;
    this.colors = colors;
    this.game = game;
  }
    
  // Instance methods ----------------------------------------------------------
  
  // Accessors -----------------------------------------------------------------

  /**
   * Gets x coordinate of reference point
   * @return x coordinate
   */
  public double getXLeft()
  {
    return xLeft; 
  }
  
  /**
   * Gets y coordinate of reference point
   * @return y coordinate
   */
  public double getYTop()
  {
    return yTop;
  }
  
  /**
   * Used to return game
   * @return game
   */
  public Game getGame()
  {
    return game;
  }
  
  /**
   * Returns ColorScheme object of colors
   * @return colors
   */
  public ColorScheme getColorScheme()
  {
    return colors;
  }
  // Drawing Methods -----------------------------------------------------------

  /**
   * Draw player image instructions  
   * @param g2 Graphics 2D context
   */
  public void draw(Graphics2D g2)
  {
    BasicStroke penWidth = new BasicStroke(PEN_WIDTH);  //This is > default
    g2.setStroke(penWidth);
    drawChamber(g2);
  }

  // Instance Helper Methods ---------------------------------------------------
 
  /**
   * Draw legs instructions  
   * @param g2 Graphics 2D context
   */  
  public void drawChamber(Graphics2D g2)
  {
    Rectangle2D.Double rectangle = 
    	new Rectangle2D.Double(xLeft, yTop, SCALE3, SCALE3);
    
    // Set pen to desired thickness and color
    g2.setStroke(new BasicStroke(1.5F));
    
    g2.setColor(colorSPOT(location));
    
    g2.fill(rectangle);  // Fill rectangle with set color
    g2.setColor(Color.BLACK);  // Change pen color
    g2.draw(rectangle); // Outline leg with set color
  }
  public void drawWall(Graphics2D g2)
  {
    Rectangle2D.Double rectangle = 
      new Rectangle2D.Double(xLeft, yTop, SCALE2, SCALE2);
    
    // Set pen to desired thickness and color
    g2.setStroke(new BasicStroke(1.5F));
    
    g2.setColor(Color.WHITE);
    
    g2.fill(rectangle);  // Fill rectangle with set color
    g2.setColor(Color.WHITE);  // Change pen color
    g2.draw(rectangle); // Outline leg with set color
  }
  
  public Color colorSPOT(Location location)
  {
    Color color;
    if((game.getCount() > 1 
        && game.hasChamber(location) 
          && game.hasVisited(location))
       || location.isOrigin())
    {
      color = Color.RED;
    }
    else if (game.getCount() > 0 && !game.hasChamber(location))
    {
      color = Color.BLACK;
    }
    else
    {
      color = Color.BLUE;
    }
    return color;
    
  }
}