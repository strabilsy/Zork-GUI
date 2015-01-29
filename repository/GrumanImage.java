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
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * This class models a generic player in the game of NewZork
 * 
 * @author Rose Williams
 * 
 */
public class GrumanImage
{
  // Class Constants -----------------------------------------------------------
  
  // Are there certain feature sizes that remain constant?
  // Are there other feature sizes that can be defined relative to them?
  // Are there colors or color schemes to be defined?
  // Should these numbers be replaced by formulas?
  // Add or replace as needed
  public final static int SCALE1 = 36; // Face size * (1/3)
  public final static int SCALE2 = 72; // Face size * (2/3)
  public final static int SCALE3 = 108; // Face width and height
  public final static int PEN_WIDTH = 2; // Will be more visible than default
  
  // Instance Variables --------------------------------------------------------
  
  // You can use variables to represent EITHER
  // the top-left corner of the bounding boxes surrounding your player OR
  // the coordinate of the midpoint of your player
  // My coords start at midpoint of player
  // Note: just make all calculations relative to it and document
  private double xLeft;
  private double yTop;
  private Game game;
  
  // Constructors --------------------------------------------------------------
  
  /**
   * Create Player Image object with x,y reference point This reference point
   * starts at the middle of the player
   */
  public GrumanImage(double xLeft, double yTop, Game game)
  {
    this.xLeft = xLeft;
    this.yTop = yTop - 150;
    this.game = game;
  }
  
  // Instance methods ----------------------------------------------------------
  
  // Accessors -----------------------------------------------------------------
  /**
   * Gets x coordinate of reference point
   * 
   * @return x coordinate
   */
  public double getXLeft()
  {
    return xLeft;
  }
  
  /**
   * Gets y coordinate of reference point
   * 
   * @return y coordinate
   */
  public double getYTop()
  {
    return yTop;
  }
  
  public Game getGame()
  {
    return game;
  }
  
  // Drawing Methods -----------------------------------------------------------
  
  // First draw your player on graph paper
  // Then work out size and placement relationships
  
  /**
   * Draw player image instructions
   * 
   * @param g2
   *          Graphics 2D context
   */
  public void draw(Graphics2D g2)
  {
    // think of g2 as a well-equipped drawing kit
    
    // Insert drawing instructions for generic player,
    // or invoke methods for drawing each part
    
    // Here's my instructions for a generic player
    // Replace w/instructions for drawing your generic player after running
    // Watch out for order of operations:
    // each set of features will obscure portions of features drawn previously!
    // (i.e.,That's why legs have to be drawn first)
    
    // Get a pen and set its thickness
    BasicStroke penWidth = new BasicStroke(PEN_WIDTH); // This is > default
    g2.setStroke(penWidth);
    
    // Delegate the drawing tasks to the helper methods
    // Note that you must send the "virtual drawing kit" to each of them
    drawLegs(g2);
    drawLegs2(g2);
    drawShoes(g2);
    drawShoeTongues(g2);
    drawShoeSole(g2);
    drawFace(g2);
    drawEyes(g2); // leave out for truly generic player
    drawMouth(g2); // leave out for truly generic player
    drawEyeballs(g2);
    drawEars(g2);
    drawEars2(g2);
    drawBody(g2);
    drawNeck(g2);
    drawLogo(g2);
    drawLogo2(g2);
    drawLogo3(g2);
    drawNecklace(g2);
    drawNecklace2(g2);
    drawArms(g2);
    drawAccessories(g2);
    
  }
  
  // Instance Helper Methods ---------------------------------------------------
  /**
   * Draw ears instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawArms(Graphics2D g2)
  {
    int earSpace = SCALE3 / 2 - 6; // Half size of space between eyeballs
    int earWidth = SCALE3 * 2 / 3;
    int earHeight = SCALE3;
    int earLevel = SCALE1 - (earHeight); // y postion offset
    
    // Use ellipse to model
    Rectangle2D.Double leftEar = new Rectangle2D.Double(xLeft - earWidth
        - earSpace * 2 / 3 + 10, yTop - earLevel - 9, earWidth / 2,
        earHeight * 1.5);
    Rectangle2D.Double rightEar = new Rectangle2D.Double(xLeft + earSpace + 10,
        yTop - earLevel - 9, earWidth / 2, earHeight * 1.5);
    
    // Set pen color
    g2.setColor(Color.ORANGE);
    
    g2.fill(leftEar); // Fill ellipse with set color
    g2.fill(rightEar); // Fill ellipse with set color
    g2.draw(leftEar); // Outline ellipse with set color
    g2.draw(rightEar); // Outline ellipse with set color
  }
  
  /**
   * Draw ears instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawShoeTongues(Graphics2D g2)
  {
    int earSpace = SCALE1 / 2; // Half size of space between eyeballs
    int earWidth = SCALE1 / 4 * 3;
    int earHeight = SCALE1 / 5;
    int earLevel = SCALE1 + (earHeight / 5); // y postion offset
    
    // Use ellipse to model
    Rectangle2D.Double leftEar = new Rectangle2D.Double(xLeft - earWidth
        - earSpace + 4, yTop + 374, earWidth * 3 / 2 - 7, earHeight - 2);
    Rectangle2D.Double rightEar = new Rectangle2D.Double(xLeft + earSpace * 3
        / 2 - 19, yTop + 374, earWidth * 3 / 2 - 7, earHeight - 2);
    
    // Set pen color
    g2.setColor(Color.gray);
    
    g2.fill(leftEar); // Fill ellipse with set color
    g2.fill(rightEar); // Fill ellipse with set color
    
  }
  
  /**
   * Draw ears instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawEars(Graphics2D g2)
  {
    int earSpace = SCALE1 + 8; // Half size of space between eyeballs
    int earWidth = SCALE1 / 4 * 3;
    int earHeight = SCALE1 / 5;
    int earLevel = SCALE1 + (earHeight / 5); // y postion offset
    
    // Use ellipse to model
    Rectangle2D.Double leftEar = new Rectangle2D.Double(xLeft - earWidth
        - earSpace + 4, yTop - earLevel + 15, earWidth / 2, earHeight - 2);
    Rectangle2D.Double rightEar = new Rectangle2D.Double(xLeft + earSpace + 10,
        yTop - earLevel + 15, earWidth / 2, earHeight - 2);
    
    // Set pen color
    g2.setColor(Color.YELLOW);
    
    g2.fill(leftEar); // Fill ellipse with set color
    g2.fill(rightEar); // Fill ellipse with set color
    g2.setColor(Color.YELLOW); // Change pen color
    g2.draw(leftEar); // Outline ellipse with set color
    g2.draw(rightEar); // Outline ellipse with set color
  }
  
  /**
   * Draw outer ears (the knobs) instructions Can leave this out for generic
   * player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawEars2(Graphics2D g2)
  {
    int earSpace = SCALE1 + 22; // Half size of space between eyeballs
    int earWidth = SCALE1 / 5;
    double earHeight = SCALE1 / 4 * 3.5;
    double earLevel = SCALE1 + (earHeight / 5); // y postion offset
    
    // Use ellipse to model
    Rectangle2D.Double leftEar = new Rectangle2D.Double(xLeft - earWidth
        - earSpace - 4, yTop - earLevel + 10, earWidth / 4, earHeight - 6);
    Rectangle2D.Double rightEar = new Rectangle2D.Double(xLeft + earSpace + 11,
        yTop - earLevel + 10, earWidth / 4, earHeight - 6);
    
    // Set pen color
    g2.setColor(Color.YELLOW);
    
    g2.fill(leftEar); // Fill ellipse with set color
    g2.fill(rightEar); // Fill ellipse with set color
    g2.setColor(Color.YELLOW); // Change pen color
    g2.draw(leftEar); // Outline ellipse with set color
    g2.draw(rightEar); // Outline ellipse with set color
  }
  
  /**
   * Draw legs instructions
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawLegs(Graphics2D g2)
  {
    // Use rectangles to model, create them first
    // Right leg
    Rectangle2D.Double leg1 = new Rectangle2D.Double(xLeft, yTop + 200,
        SCALE1 * 3 / 2, SCALE2 * 4 / 3);
    // Left leg
    Rectangle2D.Double leg2 = new Rectangle2D.Double(xLeft - SCALE1 * 3 / 2,
        yTop + 200, SCALE1 * 3 / 2, SCALE2 * 4 / 3);
    
    // Set pen to desired thickness and color
    g2.setStroke(new BasicStroke(1.5F));
    g2.setColor(Color.YELLOW);
    
    g2.fill(leg1); // Fill rectangle with set color
    g2.fill(leg2); // Fill rectangle with set color
    g2.setColor(Color.DARK_GRAY); // Change pen color
    g2.draw(leg1); // Outline leg with set color
    g2.draw(leg2); // Outline leg with set color
  }
  
  /**
   * Draw legs instructions
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawLegs2(Graphics2D g2)
  {
    // Use rectangles to model, create them first
    // Right leg
    Rectangle2D.Double leg1 = new Rectangle2D.Double(xLeft, yTop + 296,
        SCALE1 * 4 / 3, SCALE2);
    // Left leg
    Rectangle2D.Double leg2 = new Rectangle2D.Double(xLeft - SCALE1 * 4 / 3,
        yTop + 296, SCALE1 * 4 / 3, SCALE2);
    
    // Set pen to desired thickness and color
    g2.setStroke(new BasicStroke(1.5F));
    g2.setColor(Color.ORANGE);
    
    g2.fill(leg1); // Fill rectangle with set color
    g2.fill(leg2); // Fill rectangle with set color
    g2.setColor(Color.DARK_GRAY); // Change pen color
    g2.draw(leg1); // Outline leg with set color
    g2.draw(leg2); // Outline leg with set color
  }
  
  /**
   * Draw legs instructions
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawShoes(Graphics2D g2)
  {
    // Use rectangles to model, create them first
    // Right leg
    Rectangle2D.Double shoe1 = new Rectangle2D.Double(xLeft, yTop + 370,
        SCALE1 * 4 / 3, SCALE2 / 8);
    // Left leg
    Rectangle2D.Double shoe2 = new Rectangle2D.Double(xLeft - SCALE1 * 4 / 3,
        yTop + 370, SCALE1 * 4 / 3, SCALE2 / 8);
    
    // Set pen to desired thickness and color
    g2.setStroke(new BasicStroke(1.5F));
    g2.setColor(Color.BLACK);
    
    g2.fill(shoe1); // Fill rectangle with set color
    g2.fill(shoe2); // Fill rectangle with set color
    g2.setColor(Color.DARK_GRAY); // Change pen color
    g2.draw(shoe1); // Outline leg with set color
    g2.draw(shoe2); // Outline leg with set color
  }
  
  /**
   * Draw legs instructions
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawShoeSole(Graphics2D g2)
  {
    // Use rectangles to model, create them first
    // Right leg
    Rectangle2D.Double shoe1 = new Rectangle2D.Double(xLeft, yTop + 380,
        SCALE1 * 4 / 3, SCALE2 / 4);
    // Left leg
    Rectangle2D.Double shoe2 = new Rectangle2D.Double(xLeft - SCALE1 * 4 / 3,
        yTop + 380, SCALE1 * 4 / 3, SCALE2 / 4);
    
    // Set pen to desired thickness and color
    g2.setStroke(new BasicStroke(1.5F));
    g2.setColor(Color.WHITE);
    
    g2.fill(shoe1); // Fill rectangle with set color
    g2.fill(shoe2); // Fill rectangle with set color
    g2.setColor(Color.DARK_GRAY); // Change pen color
    g2.draw(shoe1); // Outline leg with set color
    g2.draw(shoe2); // Outline leg with set color
  }
  
  /**
   * Draw face instructions
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawFace(Graphics2D g2)
  {
    // Use circle to model:
    // In Java must use Ellipse2D.Double class, where width == height
    Rectangle2D.Double face = new Rectangle2D.Double(xLeft - ((SCALE3) / 2),
        yTop - SCALE2, SCALE3, SCALE3 + 20);
    
    // Set pen color
    g2.setColor(Color.YELLOW);
    
    g2.fill(face); // Fill circle with set color
    g2.setColor(Color.BLACK); // Change pen color
    g2.draw(face); // Outline circle with set color
  }
  
  /**
   * Draw eyeballs instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawEyeballs(Graphics2D g2)
  {
    int eyeSpace = SCALE1 / 4; // Half size of space between eyeballs
    int eyeWidth = SCALE1 / 4 * 3;
    int eyeHeight = SCALE1 / 4 * 3;
    int eyeLevel = SCALE1 + (eyeHeight / 5); // y postion offset
    
    // Use ellipse to model
    Rectangle2D.Double leftEyeball = new Rectangle2D.Double(xLeft - eyeWidth
        - eyeSpace + 12, yTop - eyeLevel - 7, eyeWidth / 6, eyeHeight - 8);
    Rectangle2D.Double rightEyeball = new Rectangle2D.Double(xLeft + eyeSpace
        + 12, yTop - eyeLevel - 7, eyeWidth / 6, eyeHeight - 8);
    
    // Set pen color
    g2.setColor(Color.RED);
    
    g2.fill(leftEyeball); // Fill ellipse with set color
    g2.fill(rightEyeball); // Fill ellipse with set color
    g2.setColor(Color.RED); // Change pen color
    g2.draw(leftEyeball); // Outline ellipse with set color
    g2.draw(rightEyeball); // Outline ellipse with set color
  }
  
  /**
   * Draw eyes instructions Can leave out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawEyes(Graphics2D g2)
  {
    int eyeSpace = SCALE1 / 4; // Half size of space between eyes
    int eyeWidth = SCALE1 / 4 * 3;
    int eyeHeight = SCALE1 / 4 * 3;
    int eyeLevel = SCALE1 + (eyeHeight / 5); // y postion offset
    
    // Use ellipse to model
    Ellipse2D.Double leftEye = new Ellipse2D.Double(
        xLeft - eyeWidth - eyeSpace, yTop - eyeLevel - 10, eyeWidth, eyeHeight);
    Ellipse2D.Double rightEye = new Ellipse2D.Double(xLeft + eyeSpace, yTop
        - eyeLevel - 10, eyeWidth, eyeHeight);
    
    // Set pen color
    g2.setColor(Color.BLACK);
    
    g2.fill(leftEye); // Fill ellipse with set color
    g2.fill(rightEye); // Fill ellipse with set color
    g2.setColor(Color.BLACK); // Change pen color
    g2.draw(leftEye); // Outline ellipse with set color
    g2.draw(rightEye); // Outline ellipse with set color
  }
  
  /**
   * Draw mouth instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawMouth(Graphics2D g2)
  {
    // Use circle to model:
    // In Java must use Ellipse2D.Double class, where width == height
    Rectangle2D.Double face = new Rectangle2D.Double(
        xLeft - ((SCALE3) / 4 + 9), yTop - (SCALE2 / 12 - 25), SCALE3 / 1.5,
        SCALE3 / 5);
    
    // Set pen color
    g2.setColor(Color.BLACK);
    
    g2.fill(face); // Fill circle with set color
    g2.setColor(Color.BLACK); // Change pen color
    g2.draw(face); // Outline circle with set color
  }
  
  /**
   * Draw mouth instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawNecklace2(Graphics2D g2)
  {
    // Use circle to model:
    // In Java must use Ellipse2D.Double class, where width == height
    Rectangle2D.Double face = new Rectangle2D.Double(
        xLeft - ((SCALE3) / 4 + 9), yTop - (SCALE2 - 200), SCALE3 / 1.5,
        SCALE3 / 3);
    
    // Set pen color
    g2.setColor(Color.YELLOW);
    
    g2.fill(face); // Fill circle with set color
    g2.setColor(Color.BLACK); // Change pen color
    g2.draw(face); // Outline circle with set color
  }
  
  /**
   * Draw body instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawBody(Graphics2D g2)
  {
    // Use circle to model:
    // In Java must use Ellipse2D.Double class, where width == height
    Rectangle2D.Double body = new Rectangle2D.Double(xLeft - ((SCALE3) / 2),
        yTop - (SCALE2 / 12 - 25) * 3, SCALE3, SCALE3 * 1.5);
    
    // Set pen color
    g2.setColor(Color.LIGHT_GRAY);
    
    g2.fill(body); // Fill circle with set color
    g2.setColor(Color.BLACK); // Change pen color
    g2.draw(body); // Outline circle with set color
  }
  
  /**
   * Draw neck instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawNeck(Graphics2D g2)
  {
    final int HALF_SCALE = SCALE1 / 2; // x position offset
    int neckLevel = HALF_SCALE; // y position offset
    
    // Use arc to model: open not closed
    Arc2D.Double neck = new Arc2D.Double(xLeft - HALF_SCALE * 2, yTop
        - neckLevel + 38, SCALE1 * 2, SCALE1 * 2, 180, 180, Arc2D.CHORD);
    
    // Make it the color you like
    g2.setColor(Color.ORANGE);
    // Draw arc with set color
    g2.fill(neck); // Fill circle with set color
    g2.setColor(Color.BLACK); // Change pen color
    g2.draw(neck); // Draw arc with set color
  }
  
  /**
   * Draw mouth instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawNecklace(Graphics2D g2)
  {
    final int HALF_SCALE = SCALE1 / 2; // x position offset
    int mouthLevel = HALF_SCALE + (HALF_SCALE / 5); // y position offset
    
    // Smile!
    // Use arc to model: open not closed
    Arc2D.Double mouth = new Arc2D.Double(xLeft - HALF_SCALE * 2, yTop
        - mouthLevel + 10, SCALE1 * 2, SCALE1 * 4, 180, 180, Arc2D.OPEN);
    g2.setStroke(new BasicStroke(10));
    // Make it the color you like
    g2.setColor(Color.YELLOW);
    // Draw arc with set color
    g2.draw(mouth); // Draw arc with set color
  }
  
  /**
   * Draw mouth instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawLogo(Graphics2D g2)
  {
    final int HALF_SCALE = SCALE1 / 2; // x position offset
    int mouthLevel = HALF_SCALE + (HALF_SCALE / 5); // y position offset
    
    // Smile!
    // Use arc to model: open not closed
    Arc2D.Double logo = new Arc2D.Double(xLeft - HALF_SCALE * 2, yTop
        - mouthLevel + 130, SCALE1 * 2, SCALE1 * 2, 0, 180, Arc2D.OPEN);
    g2.setStroke(new BasicStroke(20));
    // Make it the color you like
    g2.setColor(Color.ORANGE);
    // Draw arc with set color
    g2.draw(logo); // Draw arc with set color
  }
  
  /**
   * Draw mouth instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawLogo2(Graphics2D g2)
  {
    final int HALF_SCALE = SCALE1 / 2; // x position offset
    int mouthLevel = HALF_SCALE + (HALF_SCALE / 5); // y position offset
    
    // Smile!
    // Use arc to model: open not closed
    Arc2D.Double logo = new Arc2D.Double(xLeft - HALF_SCALE * 2, yTop
        - mouthLevel + 130, SCALE1 * 2, SCALE1 * 2, 0, 180, Arc2D.OPEN);
    g2.setStroke(new BasicStroke(18));
    // Make it the color you like
    g2.setColor(Color.WHITE);
    // Draw arc with set color
    g2.draw(logo); // Draw arc with set color
  }
  
  /**
   * Draw ears instructions Can leave this out for generic player
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawLogo3(Graphics2D g2)
  {
    int earSpace = SCALE1 + 8; // Half size of space between eyeballs
    int earWidth = SCALE1 / 4 * 3;
    int earHeight = SCALE1 / 5;
    int earLevel = SCALE1 + (earHeight / 5); // y postion offset
    
    // Use ellipse to model
    Rectangle2D.Double I = new Rectangle2D.Double(xLeft - earWidth - earSpace
        + 30, yTop - earLevel + 210, earWidth / 12, earHeight - 2);
    Rectangle2D.Double WORK = new Rectangle2D.Double(xLeft - 12, yTop
        - earLevel + 210, earWidth / 2, earHeight - 2);
    Rectangle2D.Double OUT = new Rectangle2D.Double(xLeft + earSpace - 16, yTop
        - earLevel + 210, earWidth / 2, earHeight - 2);
    
    // Set pen color
    g2.setColor(Color.ORANGE);
    
    g2.fill(I); // Fill ellipse with set color
    g2.fill(WORK); // Fill ellipse with set color
    g2.fill(OUT);
    g2.setColor(Color.ORANGE); // Change pen color
    g2.draw(I); // Outline ellipse with set color
    g2.draw(WORK); // Outline ellipse with set color
    g2.draw(OUT);
    
  }
  
  /**
   * Draw accessories instructions Human has a stick Human may eventually have
   * sacks also!
   * 
   * @param g2
   *          Graphics 2D context
   */
  private void drawAccessories(Graphics2D g2)
  {
    for (int i = 0; i < getGame().getGrumanSacks(); i++)
    {
      Sack sack = new Sack(getXLeft() + 65, getYTop() + 290);
      sack.drawSack(g2);
      Rectangle2D.Double rectangle = 
          new Rectangle2D.Double(getXLeft() - 100, getYTop() + 420, 400, 50);
      g2.setStroke(new BasicStroke(1.5F));
      
      g2.setColor(Color.RED);
      
      g2.fill(rectangle);  // Fill rectangle with set color
      g2.draw(rectangle);
      int grumanHealth = (int) game.getGrumanHealth();
      Rectangle2D.Double rectangle2 = 
          new Rectangle2D.Double(getXLeft() - 100, getYTop() + 420, grumanHealth * 4, 50);
      g2.setStroke(new BasicStroke(1.5F));
      
      g2.setColor(Color.GREEN);
      
      g2.fill(rectangle2);  // Fill rectangle with set color
      g2.draw(rectangle2);
      
    }
  }
}