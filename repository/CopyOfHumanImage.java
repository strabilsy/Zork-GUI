package repository;

import game.Game;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * This class models the image for a Human in the game of NewZork
 * @author Rose Williams
 */
public class CopyOfHumanImage extends PlayerImage
{  
  //Constructors ---------------------------------------------------------------
  
  /**
   * Creates this Human image with midpoint at given position and with 
   *   default colors 
   * @param xLeft - x midpoint position 
   * @param yTop  - y midpoint position
   */
  public CopyOfHumanImage(double xLeft, double yTop, Game game)
  {
    super(xLeft, yTop, 
          new ColorScheme(Color.DARK_GRAY, Color.GRAY, 
                          Color.LIGHT_GRAY, Color.CYAN, 
                          Color.LIGHT_GRAY, Color.GRAY),
          game);
  }
  
  /**
   * Create this Human image with midpoint at given reference point and
   *    with given color scheme
   */
  public CopyOfHumanImage(double xLeft, double yTop, ColorScheme colorScheme, 
                         Game game)
  {
    super(xLeft, yTop, colorScheme, game);
  }

  // Instance methods ----------------------------------------------------------

  // Drawing Methods -----------------------------------------------------------  
  
  /**
   * Here are the instructions for drawing this Human image
   * @param g2 - Graphics 2D context
   */
  public void draw(Graphics2D g2)
  {
    super.drawLegs(g2);
    super.drawFace(g2);
    super.drawEyes(g2);
    drawMouth(g2);
    drawAccessories(g2);
  } 
  
  // Drawing "Helper Methods" --------------------------------------------------
  
  /**
   * Draw mouth instructions  
   * @param g2 Graphics 2D context
   */
  public void drawMouth(Graphics2D g2)
  {
    int eyeHeight = PlayerImage.SCALE1/2;
    int mouthLevel = eyeHeight + (eyeHeight/5);
    
    Arc2D.Double mouth = new Arc2D.Double(
      getXLeft()-eyeHeight, getYTop()-mouthLevel, 
      PlayerImage.SCALE1, PlayerImage.SCALE1, 180, 180, Arc2D.OPEN);

    g2.setColor(getColorScheme().featureOutlineColor);
    g2.draw(mouth);  
  }
  
  /**
   * Draw accessories instructions  
   * Human has a stick
   * Human may eventually have sacks also!
   * @param g2 Graphics 2D context
   */
  private void drawAccessories(Graphics2D g2)
  {
    for (int i = 0; i < getGame().getHumanSacks(); i++)
    {
      Sack sack = new Sack(getXLeft(), getYTop());
      sack.drawSack(g2);
    }
    
    int eyeSpace = PlayerImage.SCALE1/4; // #pixels desired left of center
    
    // Compute two endpoints for stick
    Point2D.Double p1 = new Point2D.Double(
      getXLeft() - eyeSpace, getYTop() + PlayerImage.SCALE2);
    Point2D.Double p2 = new Point2D.Double(
      getXLeft() + (PlayerImage.SCALE2), getYTop() - PlayerImage.SCALE2);
    Line2D.Double stick = new Line2D.Double(p1, p2);    

    g2.setColor(Color.YELLOW);
    g2.setStroke(new BasicStroke(2.0F));
    g2.draw(stick);
  }
}
