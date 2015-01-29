package repository;

import game.Game;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * This class models the image for a Gruman in the game of NewZork
 * @author Rose Williams
 */
public class CopyOfGrumanImage extends PlayerImage
{  
  //Constructors ---------------------------------------------------------------
  
  /**
   * Create this Gruman image with midpoint at given reference point and
   *    with given color scheme
   */
  public CopyOfGrumanImage(double xLeft, double yTop, Game game)
  {
    super(xLeft, yTop, new ColorScheme(
      Color.RED, Color.GREEN, 
      Color.MAGENTA, Color.YELLOW, 
      Color.MAGENTA, Color.RED),
      game);   
  }
  
  /**
   * Create this Gruman image with midpoint at given reference point and
   *    with given color scheme
   */
  public CopyOfGrumanImage(double xLeft, double yTop, ColorScheme colors, Game game)
  {
    super(xLeft, yTop, colors, game);  
  }

  // Drawing Methods -----------------------------------------------------------  
  
  /**
   * Here are the instructions for drawing this Gruman image
   * @param g2 - Graphics 2D context
   */
  public void draw(Graphics2D g2)
  {
    super.drawLegs(g2);
    drawFace(g2);
    drawEyes(g2);
    drawMouth(g2);
    drawAccessories(g2);
  } 
  
  // Drawing "Helper Methods" --------------------------------------------------
  
  /**
   * Draw eyes instructions 
   * Overrides superclass, so must be public 
   * @param g2 Graphics 2D context
   */  
  public void drawEyes(Graphics2D g2)
  {
    int eyeSpace = PlayerImage.SCALE1/4;// space between eyes
    int eyeWidth = PlayerImage.SCALE1/4 * 3;
    int eyeHeight = PlayerImage.SCALE1/2;
    int eyeLevel = PlayerImage.SCALE1 + (eyeHeight/5);  
    
    // Create an ellipse for each eye
    Ellipse2D.Double leftEye = new Ellipse2D.Double(
        getXLeft() - eyeWidth - eyeSpace, getYTop() - eyeLevel, 
        eyeWidth, eyeHeight);
    Ellipse2D.Double rightEye = new Ellipse2D.Double(
        getXLeft() + eyeSpace, getYTop() - eyeLevel, eyeWidth, eyeHeight);
    
    // Fill and draw each eye
    g2.setColor(getColorScheme().featureFillColor);     
    g2.fill(leftEye);
    g2.fill(rightEye);
    g2.setColor(getColorScheme().featureOutlineColor);
    g2.draw(leftEye);
    g2.draw(rightEye);
  }
  
  /**
   * Draw mouth instructions  
   * @param g2 Graphics 2D context
   */    
  public void drawMouth(Graphics2D g2)
  {
    // Make size and position of mouth relative to eyes
    int eyeSpace = PlayerImage.SCALE1/4;
    int eyeWidth = PlayerImage.SCALE1/4 * 3;
    int mouthLevel = eyeSpace/2;
    
    Rectangle2D.Double mouth = new Rectangle2D.Double(
      getXLeft() - eyeWidth/2, getYTop() - mouthLevel, 
      eyeWidth, PlayerImage.SCALE1/10);

    g2.setColor(getColorScheme().featureOutlineColor);
    g2.draw(mouth);  
  }
  
  /**
   * Draw accessories instructions  
   * Gruman has sacks
   * @param g2 Graphics 2D context
   */  
  public void drawAccessories(Graphics2D g2)
  {
    for (int i = 0; i < getGame().getGrumanSacks(); i++)
    {  
      Sack sack = new Sack(getXLeft(), getYTop());
      sack.drawSack(g2);
    }
  }
}
