import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.util.*;

/*************************************************************
 * GUI for an Adventure Game
 * 
 * @author Scott Grissom
 * @version October 7, 2011
 ************************************************************/
public class GUI extends JPanel{

    /** define an instance of type Game */
    private Game myGame;
    /** define buttons for each direction */
    private JButton b;

    /** define buttons for each action */
    private JButton look, help, pouch, speak, take, searchPouch, drop;
    private JButton north, south, east, west, up, down, retreat;

    /** GUI frame */
    JFrame theGUI;
    JTextArea results;

    /** menu items */
    // if attempting the challenge activity
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem, newItem;

    /*****************************************************************
     * Main Method
     ****************************************************************/ 
    public static void main(String args[]){
        // the traditional five lines of code from the book are
        // provided in the GUI constructor
        new GUI();
    }

    /*****************************************************************
     * constructor installs all of the GUI components
     ****************************************************************/    
    public GUI(){

        // establish the frame
        theGUI = new JFrame();
        theGUI.setSize(600,300);
        theGUI.setTitle("Killian's Antipodes Adventure Game");    

        // create display area
        results = new JTextArea(30,60);
        JScrollPane scrollPane = new JScrollPane(results);
        theGUI.add(BorderLayout.CENTER, scrollPane);

        // allows auto scrolling within the JTextArea
        DefaultCaret caret = (DefaultCaret)results.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        // instantiate each of the buttons
        help = new JButton("Help");
        look = new JButton("Look");
        pouch = new JButton("Pouch");
        speak = new JButton("Speak");
        take = new JButton("Take");
        searchPouch = new JButton("Invantory");
        drop = new JButton("Drop Items");

        // add action buttons here
        JPanel actionPanel = new JPanel();
        theGUI.add(BorderLayout.SOUTH, actionPanel);
        actionPanel.add(new JLabel("Actions: "));
        actionPanel.add(help);
        actionPanel.add(look);
        actionPanel.add(pouch);
        actionPanel.add(speak);
        actionPanel.add(take);
        actionPanel.add(searchPouch);
        actionPanel.add(drop);

        // create Directions panel
        JPanel directionPanel = new JPanel();
        directionPanel.setLayout(new BoxLayout(directionPanel, BoxLayout.Y_AXIS));
        theGUI.add(BorderLayout.EAST, directionPanel);
        directionPanel.add(new JLabel("Directions"));

        // instantiate Direction Buttons
        north = new JButton("North");
        south = new JButton("South");
        east = new JButton("East");
        west = new JButton("West");
        up = new JButton("Up");
        down = new JButton("Down");
        retreat = new JButton("Retreat");

        // add buttons to Direction panel
        directionPanel.add(north);
        directionPanel.add(south);
        directionPanel.add(east);
        directionPanel.add(west);
        directionPanel.add(up);
        directionPanel.add(down);
        directionPanel.add(retreat);

        // register the listeners
        ButtonListener listener = new ButtonListener();
        help.addActionListener(listener);
        look.addActionListener(listener);
        pouch.addActionListener(listener);
        speak.addActionListener(listener);
        take.addActionListener(listener);
        searchPouch.addActionListener(listener);
        drop.addActionListener(listener);
        north.addActionListener(listener);
        south.addActionListener(listener);
        east.addActionListener(listener);
        west.addActionListener(listener);
        up.addActionListener(listener);
        down.addActionListener(listener);
        retreat.addActionListener(listener);

        // set up File menu
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        newItem = new JMenuItem("New Game");
        fileMenu.add(newItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        theGUI.setJMenuBar(menus);
        menus.add(fileMenu);

        // register the menu items with the action listener
        quitItem.addActionListener(listener);
        newItem.addActionListener(listener);

        theGUI.setVisible(true);
        theGUI.pack();

        newGame();
    }

    private void gameOver(){
        help.setEnabled(false);
        look.setEnabled(false);              
        pouch.setEnabled(false);
        speak.setEnabled(false);
        take.setEnabled(false);
        searchPouch.setEnabled(false);
        drop.setEnabled(false);
        north.setEnabled(false);
        south.setEnabled(false);
        east.setEnabled(false);
        west.setEnabled(false);
        up.setEnabled(false);
        down.setEnabled(false);
        retreat.setEnabled(false);
    }

    private void newGame(){
        // instantiate a new game
        Game myGame = new Game();
        // enable all of the buttons
        help.setEnabled(true);
        look.setEnabled(true);  
        pouch.setEnabled(true);
        speak.setEnabled(true);
        take.setEnabled(true);
        searchPouch.setEnabled(true);
        drop.setEnabled(true);
        north.setEnabled(true);
        south.setEnabled(true);
        east.setEnabled(true);
        west.setEnabled(true);
        up.setEnabled(true);
        down.setEnabled(true);
        retreat.setEnabled(true);
    }

    /*****************************************************************
     * This method is called when any button is clicked.  The proper
     * internal method is called as needed.
     * 
     * @param e the event that was fired
     ****************************************************************/       
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            JComponent buttonPressed = (JComponent) e.getSource();

            if (buttonPressed == newItem){
                newGame();
                return;
            }

            if (buttonPressed == look){
                myGame.look();
            }

            if (buttonPressed == pouch){
                 myGame.pouch();
            }

            if (buttonPressed == speak){
                 myGame.speak();
            }

            if (buttonPressed == take){
                myGame.take();   
            }

            if (buttonPressed == searchPouch){
                myGame.searchPouch(String);
            }

            if (buttonPressed == drop){
                String currentMessage = "What do you want to drop?";
                String toDrop = JOptionPane.showInputDialog(null, message);
                myGame.drop(toDrop);    
            }

            if (buttonPressed == north){
                myGame.go();
            }

            if (buttonPressed == south){
                myGame.go();
            }

            if (buttonPressed == east){
                myGame.go();
            }

            if (buttonPressed == west){
                myGame.go();
            }

            if (buttonPressed == up){
                myGame.go();
            }

            if (buttonPressed == down){
                myGame.go();
            }

            if (buttonPressed == retreat){
                myGame.go();
            }

            // display a pop up message if the game is over
            //if (myGame.gameOver()){
            //    results.append("\n\n" + myGame.getMessage());
            //    gameOver();
            //}

        }
    }

}