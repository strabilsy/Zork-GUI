package gui;

import game.Game;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * This class serves as the VIEW in the NewZorkGUI
 * It creates an area where aspects of the MODEL can be displayed
 * @author Rose Williams
 *
 */
public class ViewInfo extends JPanel
{
  // Instance Variables --------------------------------------------------------

  /**
   * MODEL
   * What this VIEW will show
   */
  private Game game;
  
  /**
   * SubPanel of this VIEW
   * Will show info about Human portion of MODEL
   */
  private ViewSubPanel viewHuman;
  
  /**
   * SubPanel of this VIEW
   * Will show info about Gruman portion of MODEL
   */
  private ViewSubPanel viewGruman;


  
  // Constructors --------------------------------------------------------------
  
  /**
   * Creates this JPanel as well as the subpanels that reside within it
   * @param game
   */
  public ViewInfo(Game game)
  {
    // Initialize MODEL
    this.game = game; 
    
    // Inner Classes -------------------------------------------------------------
    
    /**
     * Inner class that implements PlayerStatus interface
     * Will generate and return Human status
     */
    class HumanStatus implements PlayerStatus
    {
      /**
       * Returns String showing info about human portion of MODEL
       * Note that all information requests go through MODEL
       */
      public String getStatus()
      {
        String status = "No Human Defined";
        if (ViewInfo.this.game.hasHuman())
        {
          // Get human status from MODEL
          status = ViewInfo.this.game.aString();
        }
        return status;
      }    
    }

    /**
     * Inner class that implements PlayerStatus interface
     * Will generate and return Gruman status
     */
    class GrumanStatus implements PlayerStatus
    {
      /**
       * Returns String showing info about gruman portion of MODEL
       * Note that all information requests go through MODEL
       */
      public String getStatus()
      {
          String status = "No Robot in this Chamber! WHEW!";
          if (ViewInfo.this.game.grumanInChamber())
          {
            status = ViewInfo.this.game.mString();
          }
          return status;
      }     
    }  
    
    // Create subpanels
    // Note that each takes in an appropriate PlayerStatus object
    viewHuman = new ViewSubPanel(new HumanStatus());
    viewGruman = new ViewSubPanel(new GrumanStatus());
    
    // Set the layout manager of this JPanel to BorderLayout, and add the
    //   human subpanel to the top, and the gruman subpanel to the bottom
    this.setLayout(new BorderLayout());
    this.add(viewHuman, BorderLayout.NORTH);
    this.add(viewGruman, BorderLayout.SOUTH);
  }
  
  // Accessor Methods ----------------------------------------------------------
  
  /**
   * Return human subpanel
   * @return human subpanel
   */
  public ViewSubPanel getHuman()
  {
    return viewHuman;
  }
  
  /**
   * Return gruman subpanel
   * @return gruman subpanel
   */
  public ViewSubPanel getGruman()
  {
    return viewGruman;
  }  
  
  /**
   * New Game method
   * @param game
   */
  public void newGame(Game game)
  {
    this.game = game;
  }
}
