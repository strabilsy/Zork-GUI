package gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import game.Game;

/**
 * This class creates and delivers the controller and view panels for the 
 *   NewZorkGUI, and creates and delivers the model to the controller, which
 *   passes it on to the view
 * @author Rose Williams
 *
 */
public class PanelCreator
{
  // Instance Variables --------------------------------------------------------
  
  /**
   * This game is the MODEL that will be controlled by the controller, and 
   *   displayed by the view
   */
  private Game game; 
  
  /**
   * This controller is the CONTROLLER that the user will use to interact with
   *   the MODEL
   */
  private JPanel topPanel; 
  
  /**
   * This view is the VIEW that the user will use to view aspects about the 
   *   MODEL
   */
  private JPanel viewImage; 

  // Constructors --------------------------------------------------------------
  
  /**
   * Create a new game, create a new controller and send the game to it
   * Get the view back from the controller
   */
  public PanelCreator()
  {
    game = new Game();
    JPanel viewInfo = new ViewInfo(game);
    viewImage = new ViewImage(game);
    JPanel controller = new Controller(game, viewInfo, viewImage);
    topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
    topPanel.add(controller);
    topPanel.add(viewInfo);
  }
  
  /**
   * Returns the top panel
   * @return the top
   */
  public JPanel getTopPanel()
  {    
    return topPanel;
  }
  
  /**
   * Returns the viewImage panel
   * 
   * @return the viewImage
   */
  public JPanel getViewImagePanel()
  {
    return viewImage;
  }
}