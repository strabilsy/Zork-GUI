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


/**
 * This class models a generic player in the game of NewZork
 * @author Rose Williams
 *
 */
public class PlayerImage
{
  // Class Constants -----------------------------------------------------------
	
  //Are there certain feature sizes that remain constant?
  //Are there other feature sizes that can be defined relative to them?
  //Are there colors or color schemes to be defined?
	//Should these numbers be replaced by formulas?
  //Add or replace as needed
  public final static int SCALE1 = 26;  //Face size * (1/3)
  public final static int SCALE2 = 72;  //Face size * (2/3)
  public final static int SCALE3 = 108; //Face width and height
  public final static int PEN_WIDTH = 2; //Will be more visible than default

  
  // Instance Variables --------------------------------------------------------
  
  // You can use variables to represent EITHER 
  //   the top-left corner of the bounding boxes surrounding your player OR
  //   the coordinate of the midpoint of your player
  //   My coords start at midpoint of player
  //   Note:  just make all calculations relative to it and document
  private double xLeft;
  private double yTop;
  private Game game;
  private ColorScheme colors;
  
  
  // Constructors --------------------------------------------------------------
  
  /**
   * Create Player Image object with x,y reference point
   * This reference point starts at the middle of the player
   */
  public PlayerImage(double xLeft, double yTop, Game game)  
  {
    this.xLeft = xLeft;
    this.yTop = yTop;
    colors = new ColorScheme(Color.DARK_GRAY, Color.GRAY, 
        Color.LIGHT_GRAY, Color.CYAN,
        Color.LIGHT_GRAY, Color.GRAY);
    this.game = game;
  }
  
  /**
   * Create this player image with midpoint at given reference point and
   * with given color scheme
   */
  public PlayerImage(double xLeft, double yTop, 
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
  
  //First draw your player on graph paper
	//Then work out size and placement relationships
  
  /**
   * Draw player image instructions  
   * @param g2 Graphics 2D context
   */
  public void draw(Graphics2D g2)
  {
    // think of g2 as a well-equipped drawing kit
    
    //Insert drawing instructions for generic player, 
    //or invoke methods for drawing each part
  	
  	//Here's my instructions for a generic player
  	//Replace w/instructions for drawing your generic player after running
  	//Watch out for order of operations:  
  	// each set of features will obscure portions of features drawn previously!
  	//(i.e.,That's why legs have to be drawn first)
  	
    // Get a pen and set its thickness
    BasicStroke penWidth = new BasicStroke(PEN_WIDTH);  //This is > default
    g2.setStroke(penWidth);
    
    // Delegate the drawing tasks to the helper methods
    // Note that you must send the "virtual drawing kit" to each of them
    drawLegs(g2);
    drawFace(g2);
    drawEyes(g2);   // leave out for truly generic player
    drawMouth(g2);  // leave out for truly generic player
  }

  // Instance Helper Methods ---------------------------------------------------
 
  /**
   * Draw legs instructions  
   * @param g2 Graphics 2D context
   */  
  public void drawLegs(Graphics2D g2)
  {
  	// Use rectangles to model, create them first
    // Right leg
    Rectangle2D.Double leg1 = 
    	new Rectangle2D.Double(xLeft, yTop, SCALE1, SCALE2);
    // Left leg
    Rectangle2D.Double leg2 = 
    	new Rectangle2D.Double(xLeft-SCALE1, yTop, SCALE1, SCALE2);
    
    // Set pen to desired thickness and color
    g2.setStroke(new BasicStroke(1.5F));
    g2.setColor(colors.legFillColor);
    
    g2.fill(leg1);  // Fill rectangle with set color
    g2.fill(leg2);  // Fill rectangle with set color
    g2.setColor(colors.legOutlineColor);  // Change pen color
    g2.draw(leg1); // Outline leg with set color
    g2.draw(leg2); // Outline leg with set color
  }
  
  /**
   * Draw face instructions  
   * @param g2 Graphics 2D context
   */  
  public void drawFace(Graphics2D g2)
  {	
  	// Use circle to model:  
    // In Java must use Ellipse2D.Double class, where width == height
  	Rectangle2D.Double face = 
  		new Rectangle2D.Double(xLeft-((SCALE3)/2), yTop-SCALE2, 100, 100); 
  	
  	// Set pen color
    g2.setColor(colors.faceFillColor);
    
    g2.fill(face);  //  Fill circle with set color
    g2.setColor(colors.faceOutlineColor); // Change pen color  
    g2.draw(face);  //  Outline circle with set color    
  }

  /**
   * Draw eyes instructions  
   * Can leave out for generic player
   * @param g2 Graphics 2D context
   */
  public void drawEyes(Graphics2D g2)
  {
  	int eyeSpace = SCALE1/4; // Half size of space between eyes
    int eyeWidth = SCALE1/4 * 3;
    int eyeHeight = SCALE1/2;
    int eyeLevel = SCALE1 + (eyeHeight/5); // y postion offset 
    
    // Use ellipse to model
    Rectangle2D.Double leftEye = new Rectangle2D.Double(
      xLeft - eyeWidth-eyeSpace, yTop - eyeLevel, eyeWidth, eyeHeight);
    Rectangle2D.Double rightEye = new Rectangle2D.Double(
      xLeft + eyeSpace, yTop - eyeLevel, eyeWidth, eyeHeight);
    
    // Set pen color
    g2.setColor(colors.featureFillColor); 
    
    g2.fill(leftEye);   // Fill ellipse with set color
    g2.fill(rightEye);  // Fill ellipse with set color
    g2.setColor(colors.faceOutlineColor); // Change pen color
    g2.draw(leftEye);  // Outline ellipse with set color
    g2.draw(rightEye); // Outline ellipse with set color 	
  }
  
  /**
   * Draw mouth instructions  
   * Can leave this out for generic player
   * @param g2 Graphics 2D context
   */
  public void drawMouth(Graphics2D g2)
  {
    final int HALF_SCALE = SCALE1/2;  // x position offset
  	int mouthLevel = HALF_SCALE + (HALF_SCALE/5);  // y position offset
  	
  	// Smile!
  	// Use arc to model:  open not closed
    //Arc2D.Double mouth = new Arc2D.Double(
    //  xLeft-HALF_SCALE, yTop-mouthLevel, SCALE1, SCALE1, 180, 180, Arc2D.OPEN);
  	Line2D.Double mouth = new Line2D.Double(xLeft - 10, yTop, xLeft + 10, yTop);
    
    // Make it the color you like
    g2.setColor(colors.featureOutlineColor);
    // Draw arc with set color  
    g2.draw(mouth);  // Draw arc with set color  	
  }
}