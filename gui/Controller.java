package gui;

import game.Game;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import players.Gruman;
import players.Human;
import utility.SingleRandom;

import demesnes.Direction;
import demesnes.Maze;
import gui.ViewImage;

/**
 * This class serves as the CONTROLLER in NewZorkGUI It consists of the controls
 * that can be use to interact with the MODEL
 * 
 * @author Rose Williams
 * 
 */
public class Controller extends JPanel
{
  // Instance Variables --------------------------------------------------------
  /**
   * MODEL What this CONTROLLER will interact with
   */
  private Game game;
  
  /**
   * VIEWIMAGE What will display aspects of the MODEL
   */
  private ViewImage viewImage;
  
  /**
   * Subpanel of VIEW that will display aspects about the human
   */
  private ViewSubPanel viewHuman;
  
  /**
   * Subpanel of VIEW that will display aspects about the gruman
   */
  private ViewSubPanel viewGruman;
  
  /**
   * Button used to create a new game
   */
  private JButton newGame;
  
  /**
   * Button used to move north
   */
  private JButton north;
  
  /**
   * Button used to move south
   */
  private JButton south;
  
  /**
   * Button used to move east
   */
  private JButton east;
  
  /**
   * Button used to move north
   */
  private JButton west;
  
  /**
   * Button used to poke the gruman
   */
  private JButton pokeGruman;
  
  /**
   * JButton used to runaway from gruman
   */
  private JButton runAway;
  
  /**
   * Button used to save game state
   */
  private JButton saveGame;
  
  /**
   * Button used to load game state
   */
  private JButton loadGame;
  
  /**
   * Button used to enable cheats
   */
  private JButton cheat;
  
  /**
   * Button used to change name
   */
  private JButton changeName;
  /**
   * ArrayList of cheats
   */
  private ArrayList<String> cheatList;
  /**
   * Frame used to bring up dialog boxes
   */
  private JFrame frame;
  
  /**
   * Used to ViewInfo object
   */
  private ViewInfo viewInfo;
  
  /**
   * JLabel used to show plankton location on the map
   */
  private JLabel pLocation;
  
  // Constructors --------------------------------------------------------------
  
  /**
   * Initializes the game, creates the view and sends it the game, retrieves the
   * subpanels from the view, creates and registers the buttons, and adds the
   * buttons to this JPanel
   * 
   * @param game
   *          - the MODEL for this CONTROLLER
   */
  public Controller(final Game game, JPanel viewInfo, JPanel viewImage)
  {
    cheatList = new ArrayList<String>();
    this.cheatList.add("SpongeBob CheatPants");
    this.cheatList.add("The Chosen One");
    this.cheatList.add("Life on the edge");
    // Take in the MODEL and set it
    this.game = game;
    this.viewImage = (ViewImage) viewImage;
    this.viewInfo = (ViewInfo) viewInfo;
    // Take care of the VIEW:
    // Create the VIEW panel, send it the MODEL
    // this.view = new ViewInfo(game);
    // Get the subpanels from the VIEW
    viewHuman = ((ViewInfo) viewInfo).getHuman();
    viewGruman = ((ViewInfo) viewInfo).getGruman();
    
    // Take care of this CONTROLLER:
    
    // Create the poke gruman button and disable it
    pokeGruman = new JButton("Smash Robot!");
    pokeGruman.setEnabled(false);
    
    // Create the buttons that create BOTH players
    newGame = new JButton("New Game");
    
    // Create the buttons that create the directional buttons
    north = new JButton("NORTH");
    south = new JButton("SOUTH");
    east = new JButton("EAST");
    west = new JButton("WEST");
    
    // Create buttons for saving game to file
    saveGame = new JButton("Save Game");
    loadGame = new JButton("Load Game");
    
    // Cheat button
    cheat = new JButton("Cheat!");
    cheat.setEnabled(false);
    
    // Change Name Button
    changeName = new JButton("Change Name");
    
    // Runaway Button
    runAway = new JButton("Run Away!");
    runAway.setEnabled(false);
    
    // Listener Inner Classes
    // ----------------------------------------------------
    
    // Objects of Listener classes are "registered" to GUI components and
    // implement listener interfaces by providing implementations for their
    // event handler methods
    // When an event is fired that belongs to the component, the event handler
    // method, or callback, will then be run automatically
    // Note that an event handler is NEVER invoked explicitly
    
    /**
     * Objects of this class will listen to the new game button
     * 
     */
    // class CreateHumanListener implements ActionListener
    newGame.addActionListener(new ActionListener()
    {
      /**
       * When the create human button is clicked by the user, this event handler
       * will create a new human, update the human part of the view, and enable
       * the poke gruman button if appropriate
       */
      public void actionPerformed(ActionEvent event)
      {
        
        /**
         * Controller.this.game.createNewHuman();
         */
        newGame();
        viewGruman.updateView();
        viewHuman.updateView();
        Controller.this.viewImage.updateView();
      }
    });
    
    // Runaway button
    runAway.addActionListener(new ActionListener()
    {
      /**
       * When clicked will check if you can runaway
       */
      public void actionPerformed(ActionEvent event)
      {
        
        runAway();
        viewGruman.updateView();
        viewHuman.updateView();
        Controller.this.viewImage.updateView();
      }
    });
    
    //Cheat Button
    cheat.addActionListener(new ActionListener()
    {
      /**
       * When clicked will give things that the cheat is enabled for
       */
      public void actionPerformed(ActionEvent event)
      {
        
        cheat();
        viewGruman.updateView();
        viewHuman.updateView();
        Controller.this.viewImage.updateView();
      }
    });
    
    //Change Name Button
    changeName.addActionListener(new ActionListener()
    {
      /**
       * When clicked will give things that the cheat is enabled for
       */
      public void actionPerformed(ActionEvent event)
      {
        changeName();
        viewGruman.updateView();
        viewHuman.updateView();
        Controller.this.viewImage.updateView();
      }
    });
    
    // DIRECTION BUTTONS -------------------------------------------------------
    
    // NORTH ----------------------------------------------------------------+++
    /**
     * Objects of this class will listen to the create north button
     * 
     * 
     */
    // class CreateGrumanListener implements ActionListener
    north.addActionListener(new ActionListener()
    {
      /**
       * When the create gruman button is clicked by the user, this event
       * handler will create a new gruman, update the gruman part of theview,
       * and enable the poke gruman button if appropriate
       */
      public void actionPerformed(ActionEvent event)
      {
        if (game.hasDoor(Direction.NORTH))
        {
          game.move(Direction.NORTH);
          game.setVisited();
          //System.out.println(game.getLocation());
          //System.out.println(game.hasVisited(game.getLocation()));
          if (game.grumanInChamber())
          {
            if(game.gHasHealth())
            {
              takeTurn();
            }
            else
            {
              pokeGruman.setEnabled(false);
            }
            pokeGruman.setEnabled(true);
            changeDirection();
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else if (game.planktonInChamber())
          {
            endGame();
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView(); 
          }
          else
          {
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
        }
        else
        {
          JOptionPane.showMessageDialog(frame,
              "There is no door to the NORTH!", "NO DOOR!",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    
    // SOUTH ----------------------------------------------------------------+++
    /**
     * Objects of this class will listen to the create south button
     * 
     * 
     */
    // class CreateGrumanListener implements ActionListener
    south.addActionListener(new ActionListener()
    {
      /**
       * When the create gruman button is clicked by the user, this event
       * handler will create a new gruman, update the gruman part of theview,
       * and enable the poke gruman button if appropriate
       */
      public void actionPerformed(ActionEvent event)
      {
        if (game.hasDoor(Direction.SOUTH))
        {
          game.move(Direction.SOUTH);
          game.setVisited();
          //System.out.println(game.getLocation());
          //System.out.println(game.hasVisited(game.getLocation()));
          //System.out.println(game.hasVisited(game.getLocation()));
          if (game.grumanInChamber())
          {
            if(game.gHasHealth())
            {
              takeTurn();
            }
            else
            {
              pokeGruman.setEnabled(false);
            }
            changeDirection();
            pokeGruman.setEnabled(true);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else if (game.planktonInChamber())
          {
            endGame();
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else
          {
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
        }
        else
        {
          JOptionPane.showMessageDialog(frame,
              "There is no door to the SOUTH!", "NO DOOR!",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    
    // EAST ----------------------------------------------------------------+++
    /**
     * Objects of this class will listen to the create east button
     * 
     * 
     */
    // class CreateGrumanListener implements ActionListener
    east.addActionListener(new ActionListener()
    {
      /**
       * When the create gruman button is clicked by the user, this event
       * handler will create a new gruman, update the gruman part of theview,
       * and enable the poke gruman button if appropriate
       */
      public void actionPerformed(ActionEvent event)
      {
        if (game.hasDoor(Direction.EAST))
        {
          game.move(Direction.EAST);
          game.setVisited();
          //System.out.println(game.getLocation());
          //System.out.println(game.hasVisited(game.getLocation()));
          if (game.grumanInChamber())
          {
            if(game.gHasHealth())
            {
              takeTurn();
            }
            else
            {
              pokeGruman.setEnabled(false);
            }
            changeDirection();
            pokeGruman.setEnabled(true);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else if (game.planktonInChamber())
          {
            endGame();
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else
          {
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
        }
        else
        {
          JOptionPane.showMessageDialog(frame, "There is no door to the EAST!",
              "NO DOOR!", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    
    // WEST ----------------------------------------------------------------+++
    /**
     * Objects of this class will listen to the create north button
     * 
     * 
     */
    // class CreateGrumanListener implements ActionListener
    west.addActionListener(new ActionListener()
    {
      /**
       * When the create gruman button is clicked by the user, this event
       * handler will create a new gruman, update the gruman part of theview,
       * and enable the poke gruman button if appropriate
       */
      public void actionPerformed(ActionEvent event)
      {
        if (game.hasDoor(Direction.WEST))
        {
          game.move(Direction.WEST);
          game.setVisited();
          //System.out.println(game.getLocation());
          if (game.grumanInChamber())
          {
            if(game.gHasHealth())
            {
              takeTurn();
            }
            else
            {
              pokeGruman.setEnabled(false);
            }
            changeDirection();
            pokeGruman.setEnabled(true);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else if (game.planktonInChamber())
          {
            endGame();
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else
          {
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
        }
        else
        {
          JOptionPane.showMessageDialog(frame, "There is no door to the WEST!",
              "NO DOOR!", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    
    /**
     * Objects of this class will listen to the poke gruman button
     * 
     */
    // class PokeGrumanListener implements ActionListener
    pokeGruman.addActionListener(new ActionListener()
    {
      /**
       * When the poke gruman button is clicked by the user, this event handler
       * will cause the gruman to be poked by the human, suffer its effects,
       * disable the poke gruman button if it has no more sacks, and update the
       * view
       */
      public void actionPerformed(ActionEvent event)
      {
        Controller.this.game.defendGruman(Controller.this.game.attackGruman());
        if (!game.grumanHasSacks())
        {
          pokeGruman.setEnabled(false);
          changeDirection();
        }
        else
        {
          if(game.gHasHealth())
          {
            takeTurn();
          }
        }
        viewGruman.updateView();
        viewHuman.updateView();
        Controller.this.viewImage.updateView();
        setLabel();
      }
    });
    // Functions for Save/Load Game
    saveGame.addActionListener(new ActionListener()
    {
      /**
       * When the create human button is clicked by the user, this event handler
       * will create a new human, update the human part of the view, and enable
       * the poke gruman button if appropriate
       */
      public void actionPerformed(ActionEvent event)
      {
        JFileChooser c = new JFileChooser();
        c.setFileFilter(new FileNameExtensionFilter("Save File (*.sav)", "sav"));
        // Demonstrate "Save" dialog:
        int rVal = c.showSaveDialog(Controller.this);
        if (rVal == JFileChooser.APPROVE_OPTION)
        {
          String fileName = c.getSelectedFile().getName();
          String directory = c.getCurrentDirectory().toString();
          if (!fileName.contains(".sav"))
          {
            fileName += ".sav";
          }
          try
          {
            FileOutputStream saveFile = new FileOutputStream(directory + "\\"
                + fileName);
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            Game gameS = getGame();
            save.writeObject(gameS);
            save.close();
          }
          catch (FileNotFoundException e)
          {
            e.printStackTrace();
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }
        }
        if (rVal == JFileChooser.CANCEL_OPTION)
        {
          JOptionPane.showMessageDialog(frame, "Save Canceled!",
              "Save Canceled", JOptionPane.ERROR_MESSAGE);
        }
        viewGruman.updateView();
        viewHuman.updateView();
        Controller.this.viewImage.updateView();
      }
    });
    
    // used to load game
    loadGame.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        JFileChooser c = new JFileChooser();
        c.setFileFilter(new FileNameExtensionFilter("Save File (*.sav)", "sav"));
        // Demonstrate "Open" dialog:
        int rVal = c.showOpenDialog(Controller.this);
        if (rVal == JFileChooser.APPROVE_OPTION)
        {
          String fileName = c.getSelectedFile().getName();
          String directory = c.getCurrentDirectory().toString();
          if (!fileName.contains(".sav"))
          {
            fileName += ".sav";
          }
          try
          {
            FileInputStream savedFile = new FileInputStream(directory + "\\"
                + fileName);
            ObjectInputStream open = new ObjectInputStream(savedFile);
            Game loadGame = (Game) open.readObject();
            //System.out.println(loadGame);
            open.close();
            // newGame(loadGame);
          }
          catch (FileNotFoundException e)
          {
            e.printStackTrace();
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }
          catch (ClassNotFoundException e)
          {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        if (rVal == JFileChooser.CANCEL_OPTION)
        {
          JOptionPane.showMessageDialog(frame, "Save Canceled!",
              "Save Canceled", JOptionPane.ERROR_MESSAGE);
        }
        viewGruman.updateView();
        viewHuman.updateView();
        Controller.this.viewImage.updateView();
      }
    });
    // Create new listener objects for each button
    // ActionListener createHumanListener = new CreateHumanListener();
    // ActionListener createGrumanListener = new CreateGrumanListener();
    // ActionListener pokeGrumanListener = new PokeGrumanListener();
    
    // Register each listener with its button
    // createHuman.addActionListener(createHumanListener);
    // createGruman.addActionListener(createGrumanListener);
    // pokeGruman.addActionListener(pokeGrumanListener);
    
    // Instead of FlowLayout, set the layout manager to GridLayout and
    // prettify it
    this.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    
    pLocation = new JLabel();
    // Add the buttons to this panel
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 4;
    c.gridy = 1;
    this.add(pLocation, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 2;
    c.gridy = 1;
    this.add(cheat, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 4;
    c.gridy = 0;
    this.add(changeName, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 0;
    c.gridy = 0;
    this.add(newGame, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 0;
    c.gridy = 1;
    this.add(saveGame, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 0;
    c.gridy = 2;
    this.add(loadGame, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 2;
    c.gridy = 0;
    this.add(north, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 1;
    c.gridy = 1;
    this.add(west, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 2;
    c.gridy = 2;
    this.add(south, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 3;
    c.gridy = 1;
    this.add(east, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridwidth = 5;
    c.weighty = 1.0;
    c.gridx = 0;
    c.gridy = 4;
    this.add(pokeGruman, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridwidth = 5;
    c.weighty = 1.0;
    c.gridx = 0;
    c.gridy = 5;
    this.add(runAway, c);
    setLabel();
  }
  
  protected boolean ifFirst()
  {
    boolean isFirst = true;
    if(SingleRandom.getInstance().nextInt(0,1) == 0)
    {
      isFirst = false;
    }
    return isFirst;
  }

  public void takeTurn()
  {
    double attack = game.grumanAttack();
    if(attack == 0)
    {
      JOptionPane.showMessageDialog(frame,
          "THE ROBOT MISSED HIS ATTACK!!", "MISS!",
          JOptionPane.INFORMATION_MESSAGE);
    }
    else
    {
      JOptionPane.showMessageDialog(frame,
          "THE ROBOT DELT " + attack + " TO YOU!!", "MISS!",
          JOptionPane.ERROR_MESSAGE);
      game.defendHuman(attack);
      checkIfDead();
      pokeGruman.setEnabled(false);
      if(game.hHasHealth())
      {
        pokeGruman.setEnabled(true);
      }
    }
  }

  private void checkIfDead()
  {
    if(!game.hHasHealth())
    {
      JOptionPane.showMessageDialog(frame,
          "YOU FAILED YOUR MISSION!! \nPlease start a new game!", "DEAD!",
          JOptionPane.ERROR_MESSAGE);
      saveGame.setEnabled(false);
      north.setEnabled(false);
      south.setEnabled(false);
      east.setEnabled(false);
      west.setEnabled(false);
      runAway.setEnabled(false);
      cheat.setEnabled(false);
      pokeGruman.setEnabled(false);
      changeName.setEnabled(false);
    }
  }

  /**
   * Used as new game function creates a new game and then assigns that new
   * game() variable to all other receiving classes
   */
  
  public void newGame()
  {
    newGame(game.newGame());
  }
  
  /**
   * Used as new game function with game sender allows us to use it as load game
   * function creates a new game and then assigns that new game() variable to
   * all other receiving classes
   */
  public void newGame(final Game game)
  {
    this.game = game;
    changeName.setEnabled(true);
    viewInfo.newGame(game);
    setLabel();
    north.setEnabled(true);
    south.setEnabled(true);
    east.setEnabled(true);
    west.setEnabled(true);
    pokeGruman.setEnabled(false);
    saveGame.setEnabled(true);
    Controller.this.viewImage.newGame(game);
    this.viewImage = (ViewImage) viewImage;
    this.viewInfo = (ViewInfo) viewInfo;
    viewHuman = ((ViewInfo) viewInfo).getHuman();
    viewGruman = ((ViewInfo) viewInfo).getGruman();
    north.removeActionListener((north.getActionListeners()[0]));
    south.removeActionListener((south.getActionListeners()[0]));
    east.removeActionListener((east.getActionListeners()[0]));
    west.removeActionListener((west.getActionListeners()[0]));
// DIRECTION BUTTONS -------------------------------------------------------
    
    // NORTH ----------------------------------------------------------------+++
    /**
     * Objects of this class will listen to the create north button
     * 
     * 
     */
    // class CreateGrumanListener implements ActionListener
    north.addActionListener(new ActionListener()
    {
      /**
       * When the create gruman button is clicked by the user, this event
       * handler will create a new gruman, update the gruman part of theview,
       * and enable the poke gruman button if appropriate
       */
      public void actionPerformed(ActionEvent event)
      {
        if (game.hasDoor(Direction.NORTH))
        {
          game.move(Direction.NORTH);
          game.setVisited();
          //System.out.println(game.getLocation());
          //System.out.println(game.hasVisited(game.getLocation()));
          if (game.grumanInChamber())
          {
            if(!ifFirst())
            {
              if(game.gHasHealth())
              {
                takeTurn();
              }
            }
            pokeGruman.setEnabled(true);
            changeDirection();
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else if (game.planktonInChamber())
          {
            endGame();
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView(); 
          }
          else
          {
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
        }
        else
        {
          JOptionPane.showMessageDialog(frame,
              "There is no door to the NORTH!", "NO DOOR!",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    
    // SOUTH ----------------------------------------------------------------+++
    /**
     * Objects of this class will listen to the create south button
     * 
     * 
     */
    // class CreateGrumanListener implements ActionListener
    south.addActionListener(new ActionListener()
    {
      /**
       * When the create gruman button is clicked by the user, this event
       * handler will create a new gruman, update the gruman part of theview,
       * and enable the poke gruman button if appropriate
       */
      public void actionPerformed(ActionEvent event)
      {
        if (game.hasDoor(Direction.SOUTH))
        {
          game.move(Direction.SOUTH);
          game.setVisited();
          //System.out.println(game.getLocation());
          //System.out.println(game.hasVisited(game.getLocation()));
          //System.out.println(game.hasVisited(game.getLocation()));
          if (game.grumanInChamber())
          {
            if(!ifFirst())
            {
              if(game.gHasHealth())
              {
                takeTurn();
              }
            }
            changeDirection();
            pokeGruman.setEnabled(true);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else if (game.planktonInChamber())
          {
            endGame();
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else
          {
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
        }
        else
        {
          JOptionPane.showMessageDialog(frame,
              "There is no door to the SOUTH!", "NO DOOR!",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    
    // EAST ----------------------------------------------------------------+++
    /**
     * Objects of this class will listen to the create east button
     * 
     * 
     */
    // class CreateGrumanListener implements ActionListener
    east.addActionListener(new ActionListener()
    {
      /**
       * When the create gruman button is clicked by the user, this event
       * handler will create a new gruman, update the gruman part of theview,
       * and enable the poke gruman button if appropriate
       */
      public void actionPerformed(ActionEvent event)
      {
        if (game.hasDoor(Direction.EAST))
        {
          game.move(Direction.EAST);
          game.setVisited();
          //System.out.println(game.getLocation());
          //System.out.println(game.hasVisited(game.getLocation()));
          if (game.grumanInChamber())
          {
            if(!ifFirst())
            {
              if(game.gHasHealth())
              {
                takeTurn();
              }
            }
            changeDirection();
            pokeGruman.setEnabled(true);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else if (game.planktonInChamber())
          {
            endGame();
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else
          {
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
        }
        else
        {
          JOptionPane.showMessageDialog(frame, "There is no door to the EAST!",
              "NO DOOR!", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    
    // WEST ----------------------------------------------------------------+++
    /**
     * Objects of this class will listen to the create north button
     * 
     * 
     */
    // class CreateGrumanListener implements ActionListener
    west.addActionListener(new ActionListener()
    {
      /**
       * When the create gruman button is clicked by the user, this event
       * handler will create a new gruman, update the gruman part of theview,
       * and enable the poke gruman button if appropriate
       */
      public void actionPerformed(ActionEvent event)
      {
        if (game.hasDoor(Direction.WEST))
        {
          game.move(Direction.WEST);
          game.setVisited();
          //System.out.println(game.getLocation());
          if (game.grumanInChamber())
          {
            if(!ifFirst())
            {
              if(game.gHasHealth())
              {
                takeTurn();
              }
            }
            changeDirection();
            pokeGruman.setEnabled(true);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else if (game.planktonInChamber())
          {
            endGame();
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
          else
          {
            pokeGruman.setEnabled(false);
            viewGruman.updateView();
            viewHuman.updateView();
            Controller.this.viewImage.updateView();
          }
        }
        else
        {
          JOptionPane.showMessageDialog(frame, "There is no door to the WEST!",
              "NO DOOR!", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    
    /**
     * Objects of this class will listen to the poke gruman button
     * 
     */
    // class PokeGrumanListener implements ActionListener
    pokeGruman.addActionListener(new ActionListener()
    {
      /**
       * When the poke gruman button is clicked by the user, this event handler
       * will cause the gruman to be poked by the human, suffer its effects,
       * disable the poke gruman button if it has no more sacks, and update the
       * view
       */
      public void actionPerformed(ActionEvent event)
      {
        Controller.this.game.defendGruman(Controller.this.game.attackGruman());
        if (!game.grumanHasSacks())
        {
          pokeGruman.setEnabled(false);
          changeDirection();
        }
        else
        {
          if(game.gHasHealth())
          {
            takeTurn();
          }
          else
          {
            pokeGruman.setEnabled(false);
          }
        }
        viewGruman.updateView();
        viewHuman.updateView();
        Controller.this.viewImage.updateView();
        setLabel();
      }
    });
  }
  
  /** Returns an ImageIcon, or null if the path was invalid. */
  protected ImageIcon createImageIcon(String path, String description)
  {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null)
    {
      return new ImageIcon(imgURL, description);
    }
    else
    {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
  
  /**
   * Used to return current game()
   * 
   * @return game
   */
  public Game getGame()
  {
    return game;
  }
  
  /**
   * Used to set labels in the controller
   */
  public void setLabel()
  {
    pLocation.setText("Plankton Location: " + game.getPLocation());
  }
  
  public void endGame()
  {
    viewGruman.updateView();
    viewHuman.updateView();
    Controller.this.viewImage.updateView();
    if (game.getHumanSacks() == 10)
    {
      int n = JOptionPane.showOptionDialog(frame,
          "Would you like give Plankton 10 sacks " + "to save Bikini Bottom?",
          "Save Bikini Bottom!", JOptionPane.YES_NO_OPTION,
          JOptionPane.QUESTION_MESSAGE, null, null, null);
      if (n == JOptionPane.YES_OPTION)
      {
        north.setEnabled(false);
        south.setEnabled(false);
        east.setEnabled(false);
        west.setEnabled(false);
        pokeGruman.setEnabled(false);
        saveGame.setEnabled(false);
        cheat.setEnabled(false);
        changeName.setEnabled(false);
        game.getHuman().setSacks(0);
        game.setPSacks();
        JOptionPane.showMessageDialog(frame, "BIKINI BOTTOM IS SAVED!!!",
            "SAVED!", JOptionPane.INFORMATION_MESSAGE);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //AudioInputStream audioIn = (AudioInputStream) classLoader.getResourceAsStream("theme.wav");
        //;
        try
        {
          AudioInputStream audioIn = AudioSystem.getAudioInputStream(classLoader.getResourceAsStream("theme.wav"));
          Clip clip = AudioSystem.getClip();
          clip.open(audioIn);
          clip.start();
          viewGruman.updateView();
          viewHuman.updateView();
          Controller.this.viewImage.updateView();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      else
      {
        JOptionPane.showMessageDialog(frame, "We need to save Bikini Bottom!",
            "Inane warning", JOptionPane.WARNING_MESSAGE);
      }
    }
    else
    {
      int hS = 10 - game.getHumanSacks();
      JOptionPane.showMessageDialog(frame,
          "GO BRING ME 10 SACKS!!! \nYou need " + hS + " more!",
          "Inane warning", JOptionPane.WARNING_MESSAGE);
    }
  }
  
  public void changeName()
  {
    String str = JOptionPane.showInputDialog(frame, "Enter a new name for our hero: ", 
        "Change Name!", 1);
    if(str != null)
    {
      game.setHumanName(str);
      if(cheatList.contains(str))
      {
        cheat.setEnabled(true);
      }
    }
  }
  
  public void cheat()
  {
    System.out.println("CHEATING");
    int cheatListCount = cheatList.size();
    if(game.getHumanName().equals(cheatList.get(0)))
    {
      game.setHumanToMax();
    }
    else if(game.getHumanName().equals(cheatList.get(1)))
    {
      game.setHumanToMax();
    }
    else if(game.getHumanName().equals(cheatList.get(2)))
    {
      game.lifeOnEdge();
    }
  }
  
  public void changeDirection()
  {
    if(north.isEnabled())
    {
      north.setEnabled(false);
      south.setEnabled(false);
      east.setEnabled(false);
      west.setEnabled(false);
      runAway.setEnabled(true);
    }
    else if(!game.hHasHealth())
    {
      north.setEnabled(false);
      south.setEnabled(false);
      east.setEnabled(false);
      west.setEnabled(false);
      runAway.setEnabled(false);
      cheat.setEnabled(false);
      pokeGruman.setEnabled(false);
    }
    else
    {
      north.setEnabled(true);
      south.setEnabled(true);
      east.setEnabled(true);
      west.setEnabled(true);
      runAway.setEnabled(false);
    }
  }
  
  public void runAway()
  {
    if(game.canRunAway() || !game.gHasHealth() || !game.grumanHasSacks())
    {
      JOptionPane.showMessageDialog(frame,
          "You can run away!", "RUN!",
          JOptionPane.INFORMATION_MESSAGE);
      changeDirection();
    }
    else
    {
      JOptionPane.showMessageDialog(frame,
          "The Robot isn't letting you run!", "CAUGHT!",
          JOptionPane.ERROR_MESSAGE);
      if(game.gHasHealth())
      {
        takeTurn();
      }
    }
  }
}
