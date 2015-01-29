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
import java.util.Random;


/**
 * This class models a generic player in the game of NewZork
 * @author Rose Williams
 *
 */
public class HumanImage
{
  // Class Constants -----------------------------------------------------------
  
  //Are there certain feature sizes that remain constant?
  //Are there other feature sizes that can be defined relative to them?
  //Are there colors or color schemes to be defined?
  //Should these numbers be replaced by formulas?
  //Add or replace as needed
  public final static int SCALE1 = 36;  //Face size * (1/3)
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
  
  
  // Constructors --------------------------------------------------------------
  
  /**
   * Create Player Image object with x,y reference point
   * This reference point starts at the middle of the player
   */
  public HumanImage(double xLeft, double yTop, Game game)  
  {
    this.xLeft = xLeft;
    this.yTop = yTop;
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
    drawPants(g2);
    drawNose(g2);
    drawTeeth(g2);
    drawShoes(g2);
    drawAccessories(g2);
    
  }

  // Instance Helper Methods ---------------------------------------------------
 
  /**
   * Drawing pants
   * @param g2 Graphics 2D context
   */  
  private void drawPants(Graphics2D g2)
  {
    // Set pen to desired thickness and color
    g2.setStroke(new BasicStroke(1.5F));
   // g2.setColor(Color.GRAY);
    
   // g2.fill(leg1);  // Fill rectangle with set color

    g2.setColor(new Color(136,69,19));  // Change pen color
    g2.fill3DRect((int)xLeft-SCALE3/2,(int)yTop+SCALE3/8, SCALE1*3,SCALE2/3, false); // Outline leg with set color
  }
  
  
  /**
   * Draw legs instructions  
   * @param g2 Graphics 2D context
   */  
  private void drawLegs(Graphics2D g2)
  {
    // Use rectangles to model, create them first
    // Right leg

    
    // Set pen to desired thickness and color
    g2.setStroke(new BasicStroke(1.5F));
   // g2.setColor(Color.GRAY);
    
   // g2.fill(leg1);  // Fill rectangle with set color

    g2.setColor(Color.YELLOW);  // Change pen color
    g2.fill3DRect((int)xLeft-SCALE3/5,(int)yTop, SCALE1/5,SCALE2, false); // Outline leg with set color
    g2.fill3DRect((int)xLeft-SCALE3/5+40,(int)yTop, SCALE1/5,SCALE2, false); // Outline leg with set color
  }
  
  /**
   * Draw face instructions  
   * @param g2 Graphics 2D context
   */  
  private void drawFace(Graphics2D g2)
  { 
    // Use circle to model:  
    // In Java must use Ellipse2D.Double class, where width == height
    Rectangle2D.Double face = 
      new Rectangle2D.Double(xLeft-((SCALE3)/2), yTop-SCALE2, SCALE3, SCALE3); 
    
    // Set pen color
    g2.setColor(Color.YELLOW);
    
    g2.fill(face);  //  Fill circle with set color
    
boolean loop = true;
double counter = 0;
    while (loop) {
      loop = drawSides(face, g2, counter);
      counter += SCALE1/2;
    }
    
  }
  
    
 private boolean drawSides(Rectangle2D.Double face, Graphics2D g2, double i) {
boolean loop = true;
double random = new Random().nextInt(3)+1;

    if (i < face.getMaxY()-face.getMinY())
    {
     

      final int HALF_SCALE = SCALE1/2;  // x position offset
      // Smile!
      // Use arc to model:  open not closed

      Arc2D.Double sides = new Arc2D.Double(
        face.getMinX()-(HALF_SCALE/4), -i + face.getMaxY()-HALF_SCALE, SCALE1 + random, SCALE1/2 + random, 90, 180, Arc2D.OPEN);
      g2.setColor(Color.YELLOW); // Change pen color
      g2.fill(sides);  // Outline ellipse with set color
      loop = true;
    }
    else loop = false;
    
    if (i < face.getMaxX()-face.getMinX()-18) //18 is enough so it doesn't run through this one more time
    {
     

      final int HALF_SCALE = SCALE1/2;  // x position offset
      // Smile!
      // Use arc to model:  open not closed
      
      Arc2D.Double sides = new Arc2D.Double(
        i + face.getMinX(), face.getMinY()-HALF_SCALE/2, SCALE1 - random, SCALE1 - random, 0, 180, Arc2D.OPEN);
      g2.setColor(Color.YELLOW); // Change pen color
      g2.fill(sides);  // Outline ellipse with set color
      loop = true;
    }
    else loop = false;

    
    if (i < face.getMaxY()-face.getMinY())
    {
     

      final int HALF_SCALE = SCALE1/2;  // x position offset
      // Smile!
      // Use arc to model:  open not closed

      Arc2D.Double sides = new Arc2D.Double(
        face.getMaxX()-(HALF_SCALE)*1.5, -i + face.getMaxY()-HALF_SCALE, SCALE1 - random, SCALE1/2 + random, 270, 180, Arc2D.OPEN);
      g2.setColor(Color.YELLOW); // Change pen color
      g2.fill(sides);  // Outline ellipse with set color
      loop = true;
    }
    else loop = false;
    return loop;
    
 }
  

 

  /**
   * Draw eyes instructions  
   * Can leave out for generic player
   * @param g2 Graphics 2D context
   */
  private void drawEyes(Graphics2D g2)
  {
    int eyeSpace = 0; // Half size of space between eyes
    int eyeWidth = SCALE1/4 * 3;
    int eyeHeight = SCALE1/4* 3;
    int eyeLevel = SCALE1 + (eyeHeight/2); // y postion offset 
    
    // Use ellipse to model
    Ellipse2D.Double leftEye = new Ellipse2D.Double(
      xLeft - eyeWidth-eyeSpace, yTop - eyeLevel, eyeWidth, eyeHeight);
    Ellipse2D.Double rightEye = new Ellipse2D.Double(
      xLeft + eyeSpace, yTop - eyeLevel, eyeWidth, eyeHeight);
    
    // Set pen color
    g2.setColor(Color.WHITE); 
    
    g2.fill(leftEye);   // Fill ellipse with set color
    g2.fill(rightEye);  // Fill ellipse with set color
    g2.setColor(Color.BLACK); // Change pen color
    g2.draw(leftEye);  // Outline ellipse with set color
    g2.draw(rightEye); // Outline ellipse with set color  
    
    eyeSpace = 4; // Half size of space between eyes
    eyeWidth = SCALE1 / 8 * 3;
    eyeHeight = SCALE1 / 8 * 3;
    eyeLevel = SCALE1 + (eyeHeight / 10); // y postion offset

    // Use ellipse to model
   leftEye = new Ellipse2D.Double(xLeft
        - eyeWidth - eyeSpace, yTop - eyeLevel,
        eyeWidth, eyeHeight);
     rightEye = new Ellipse2D.Double(xLeft
        + eyeSpace, yTop - eyeLevel, eyeWidth,
        eyeHeight);

    // Set pen color
    g2.setColor(Color.BLUE);

    g2.fill(leftEye); // Fill ellipse with set color
    g2.fill(rightEye); // Fill ellipse with set color
    g2.setColor(Color.BLACK); // Change pen color
    g2.draw(leftEye); // Outline ellipse with set color
    g2.draw(rightEye); // Outline ellipse with set color
  }
  
  /**
   * Draw mouth instructions  
   * Can leave this out for generic player
   * @param g2 Graphics 2D context
   */
  private void drawMouth(Graphics2D g2)
  {
    final int HALF_SCALE = SCALE1/2;  // x position offset
    int mouthLevel = HALF_SCALE + (HALF_SCALE/5);  // y position offset
    
    // Smile!
    // Use arc to model:  open not closed
    Arc2D.Double mouth = new Arc2D.Double(
      xLeft-HALF_SCALE*2, yTop-mouthLevel*2, SCALE1*2, SCALE1, 180, 180, Arc2D.OPEN);
    
    // Make it the color you like
    g2.setColor(Color.LIGHT_GRAY);
    // Draw arc with set color  
    g2.draw(mouth);  // Draw arc with set color   
    
  }
  
  /**
   * Drawing the teeth
   * @param g2 Graphics 2D context
   */
  private void drawTeeth(Graphics2D g2)
  {
    g2.setStroke(new BasicStroke(1.5F));

      g2.setPaint(Color.BLACK);  // Change pen color
      Rectangle2D teeth = new Rectangle2D.Double((int)xLeft-SCALE3/8,(int)yTop-SCALE3/8+6, SCALE1/3,SCALE2/4); // Outline leg with set color
      g2.draw(teeth);
      g2.setPaint(Color.WHITE);
      g2.fill(teeth);
      
      g2.setPaint(Color.BLACK);  // Change pen color
      teeth = new Rectangle2D.Double((int)xLeft,(int)yTop-SCALE3/8+6, SCALE1/3,SCALE2/4); // Outline leg with set color
      g2.draw(teeth);
      g2.setPaint(Color.WHITE);
      g2.fill(teeth);
  }
  
  
  /**
   * Drawing the nose 
   * Can leave out for generic player
   * @param g2 Graphics 2D context
   */
  private void drawNose(Graphics2D g2)
  {
      
      Arc2D.Double nose = new Arc2D.Double(
        xLeft-3, yTop-40, SCALE1/6, SCALE1, 0, 180, Arc2D.OPEN);
      g2.setStroke(new BasicStroke(2,1,1));
      // Make it the color you like
      g2.setColor(Color.BLACK);
      // Draw arc with set color  
      g2.draw(nose);  // Draw arc with set color  
    
  }
  
  /**
   * Drawing the shoes
   * Can leave out for generic player
   * @param g2 Graphics 2D context
   */
  private void drawShoes(Graphics2D g2)
  {
      
      Arc2D.Double shoes = new Arc2D.Double(
        xLeft-17, yTop+70, SCALE1*2, SCALE1/3, 270, 180, Arc2D.OPEN);
      g2.setStroke(new BasicStroke(2,1,1));
      // Make it the color you like
      g2.setColor(Color.DARK_GRAY);
      // Draw arc with set color  
      g2.fill(shoes);  // Draw arc with set color  
      
     shoes = new Arc2D.Double(
       xLeft-50, yTop+70, SCALE1*2, SCALE1/3, 270, -180, Arc2D.OPEN);
          g2.setStroke(new BasicStroke(2,1,1));
          // Make it the color you like
          g2.setColor(Color.DARK_GRAY);
          // Draw arc with set color  
          g2.fill(shoes);  // Draw arc with set color  
    
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
      Sack sack = new Sack(getXLeft() + 20, getYTop() - 30);
      sack.drawSack(g2);
    }
  }

  private Game getGame()
  {
    // TODO Auto-generated method stub
    return game;
  }
  
}