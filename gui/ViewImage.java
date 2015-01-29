package gui;

import game.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import demesnes.Direction;
import demesnes.Location;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

import repository.ChamberImage;
import repository.GrumanImage;
import repository.GrumanImage;
import repository.HumanImage;
import repository.PlayerImage;
//Additional imports here
import utility.SingleRandom;

// JPanel is a subclass of JComponent and 
//  has more capabilities than JComponent,
//  so we can use it instead of JComponent
public class ViewImage extends JPanel
{  
	//-- Class variables --------------------------------------------------------	

  /**
   * Gets Logger object
   */
	public static Logger log;
  static
  {
    log = Logger.getLogger("ViewerPanel");
  }
  
	//-- Instance constants -----------------------------------------------------
  /**
  //panel width 
  public final int WIDTH;  
  
  //panel height
  public final int HEIGHT; 
  
  //generic player image
  private PlayerImage player; 
  // Other declarations here
  */
  // game instance variable
  private Game game;
  //-- Constructors -----------------------------------------------------------

  /**
   *  Creates a panel with a given width and height 
   *  @param width
   *  @param height
   */
  public ViewImage(Game game)
  {    
  	setUpLogging();
  	log.info("Viewer Panel");
  	
  	this.game = game;
  	updateView();
    //WIDTH = width;
    //HEIGHT = height;
    
    // Coordinates place player in middle of the screen
    // Modify as necessary for your own players
    // WATCH OUT FOR INTEGER DIVISION when it gets more complicated!!
    // create other objects here
  }

  //-- Class Methods ---------------------------------------------------

  private static void setUpLogging()
  {
    //log.setLevel(Level.ALL);     
    log.setLevel(Level.OFF);
  }  

  //-- Instance Methods -------------------------------------------------------
  // This method is never invoked directly
  // Responsible for "painting" panel
  public void paintComponent(Graphics g)
  {
    //log.info("BEGIN paintComponent");

  	// Invoke superclass methods first:  superclass is a JPanel
    super.paintComponent(g);
    
    // Set color and fill rectangle for backdrop
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());

    // Cast to Graphics2D
    Graphics2D g2 = (Graphics2D) g; 
    
    //Draw the player image 
    /**
    PlayerImage player = new PlayerImage(
        getWidth()/2, getHeight()/2, game);

    player.draw(g2); 
    */ 
    
    ChamberImage center = new ChamberImage(
        getWidth()/2, getHeight()/2, game, game.getLocation());
    ChamberImage east = new ChamberImage(
        (getWidth()/2)+144, getHeight()/2, game, new Location(
            game.getLocation(), Direction.EAST));
    ChamberImage south = new ChamberImage(
        getWidth()/2, (getHeight()/2)+144, game, new Location(
            game.getLocation(), Direction.SOUTH));
    ChamberImage southEast = new ChamberImage(
        (getWidth()/2)+144, (getHeight()/2)+144, game, new Location(
            game.getLocation(), Direction.SOUTH, Direction.EAST));
    ChamberImage northEast = new ChamberImage(
        (getWidth()/2)+144, (getHeight()/2)-144, game, new Location(
            game.getLocation(), Direction.NORTH, Direction.EAST));
    ChamberImage west = new ChamberImage(
        (getWidth()/2)-144, (getHeight()/2), game, new Location(
            game.getLocation(), Direction.WEST));
    ChamberImage northWest = new ChamberImage(
        (getWidth()/2)-144, (getHeight()/2)-144, game, new Location(
            game.getLocation(), Direction.NORTH, Direction.WEST));
    ChamberImage north = new ChamberImage(
        (getWidth()/2), (getHeight()/2)-144, game, new Location(
            game.getLocation(), Direction.NORTH));
    ChamberImage southWest = new ChamberImage(
        (getWidth()/2)-144, (getHeight()/2)+144, game, new Location(
            game.getLocation(), Direction.SOUTH, Direction.WEST));
    center.draw(g2);
    try
    {
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      InputStream input = classLoader.getResourceAsStream("icon.gif");
      Image image = ImageIO.read(input);
      g.drawImage(image, getWidth()/2 + 50, getHeight()/2 + 50, null);
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    north.draw(g2);
    south.draw(g2);
    east.draw(g2);
    west.draw(g2);
    northWest.draw(g2);
    northEast.draw(g2);
    southWest.draw(g2);
    southEast.draw(g2);
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    InputStream input = classLoader.getResourceAsStream("door.png");
    InputStream inputN = classLoader.getResourceAsStream("doorN.png");
    InputStream inputS = classLoader.getResourceAsStream("doorS.png");
    InputStream inputW = classLoader.getResourceAsStream("doorW.png");
    InputStream inputE = classLoader.getResourceAsStream("doorE.png");
    Image door;
    if(game.hasChamber(game.getLocation()))
    {
      Boolean northD = false;
      Boolean southD = false;
      Boolean eastD = false;
      Boolean westD = false;
      if(game.hasDoor(game.getLocation(), Direction.NORTH))
      {
        northD = true;
      }
      if(game.hasDoor(game.getLocation(), Direction.SOUTH))
      {
        southD = true;
      }
      if(game.hasDoor(game.getLocation(), Direction.WEST))
      {
        westD = true;
      }
      if(game.hasDoor(game.getLocation(), Direction.EAST))
      {
        eastD = true;
      }
      try
      {
        door = ImageIO.read(input);
        if(northD)
        {
          g.drawImage(door, getWidth()/2 + 50, getHeight()/2 - 20, null);
        }
        if(southD)
        {
          g.drawImage(door, getWidth()/2 + 50, getHeight()/2 + 125, null);
        }
        if(westD)
        {
          g.drawImage(door, getWidth()/2 + - 25, getHeight()/2 + 50, null);
        }
        if(eastD)
        {
          g.drawImage(door, getWidth()/2 + 120, getHeight()/2 + 50, null);
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    
    if(game.getPSacks() == Game.MAX_SACKS)
    {
      repaint();
    }
    
    if(game.hasChamber(new Location(game.getLocation(), Direction.NORTH)))
    {
      Boolean eastD = false;
      Boolean westD = false;
      if(game.hasDoor(new Location(game.getLocation(), Direction.NORTH), Direction.WEST))
      {
        westD = true;
      }
      if(game.hasDoor(new Location(game.getLocation(), Direction.NORTH), Direction.EAST))
      {
        eastD = true;
      }
      try
      {
        door = ImageIO.read(inputN);
        if(westD)
        {
          g.drawImage(door, getWidth()/2 + - 25, getHeight()/2 - 94, null);
        }
        if(eastD)
        {
          g.drawImage(door, getWidth()/2 + 120, getHeight()/2 - 94, null);
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    
    
    if(game.hasChamber(new Location(game.getLocation(), Direction.SOUTH)))
    {
      Boolean eastD = false;
      Boolean westD = false;
      if(game.hasDoor(new Location(game.getLocation(), Direction.SOUTH), Direction.WEST))
      {
        westD = true;
      }
      if(game.hasDoor(new Location(game.getLocation(), Direction.SOUTH), Direction.EAST))
      {
        eastD = true;
      }
      try
      {
        door = ImageIO.read(inputS);
        if(westD)
        {
          g.drawImage(door, getWidth()/2 + - 25, getHeight()/2 + 194, null);
        }
        if(eastD)
        {
          g.drawImage(door, getWidth()/2 + 120, getHeight()/2 + 194, null);
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    
    if(game.hasChamber(new Location(game.getLocation(), Direction.WEST)))
    {
      Boolean northD = false;
      Boolean southD = false;
      if(game.hasDoor(new Location(game.getLocation(), Direction.WEST), Direction.NORTH))
      {
        northD = true;
      }
      if(game.hasDoor(new Location(game.getLocation(), Direction.WEST), Direction.SOUTH))
      {
        southD = true;
      }
      try
      {
        door = ImageIO.read(inputW);
        if(northD)
        {
          g.drawImage(door, getWidth()/2 - 94, getHeight()/2 - 20, null);
        }
        if(southD)
        {
          g.drawImage(door, getWidth()/2 - 94, getHeight()/2 + 125, null);
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    
    if(game.hasChamber(new Location(game.getLocation(), Direction.EAST)))
    {
      Boolean northD = false;
      Boolean southD = false;
      if(game.hasDoor(new Location(game.getLocation(), Direction.EAST), Direction.NORTH))
      {
        northD = true;
      }
      if(game.hasDoor(new Location(game.getLocation(), Direction.EAST), Direction.SOUTH))
      {
        southD = true;
      }
      try
      {
        door = ImageIO.read(inputW);
        if(northD)
        {
          g.drawImage(door, getWidth()/2 + 194, getHeight()/2 - 20, null);
        }
        if(southD)
        {
          g.drawImage(door, getWidth()/2 + 194, getHeight()/2 + 125, null);
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    
    if(game.hasHuman())
    {
      HumanImage human = new HumanImage(//getWidth(),getHeight(),game);
          (double) (getWidth() - (3* getWidth()/4)),
          (double) (getHeight() - (getHeight() / 4)),
          game);
    
      human.draw(g2);
    }
    
    if(game.grumanInChamber())
    {
      GrumanImage gruman = new GrumanImage(
          getWidth() - (getWidth()/4),
          getHeight() - (3 * getHeight() / 4),
          game);
    
      gruman.draw(g2);
    }
    
    if (game.planktonInChamber())
    {
      InputStream plankton = classLoader.getResourceAsStream("plankton.png");
      try
      {
        Image planktonI = ImageIO.read(plankton);
        g.drawImage(planktonI, getWidth() - (getWidth()/4), 
            getHeight() - (3 * getHeight() / 4), null);
      }
      catch (IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    // Invoke draw() method for other object here
    // Watch out for order of operations 
  } 
  
  /**
   * used to repaint()
   */
  public void updateView()
  {
    repaint();
  }
  
  /**
   * New Game method
   * @param game
   */
  public void newGame(Game game)
  {
    this.game = game;
    updateView();
  }
}