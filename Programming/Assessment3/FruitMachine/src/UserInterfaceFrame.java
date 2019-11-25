/*
Hugh Winchester
2494047W
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/* 
Creation of the user interface 
 */
public class UserInterfaceFrame extends JFrame implements ActionListener {

    private GameLogic gameLogic;

    public UserInterfaceFrame(String title, GameLogic gameLogic) {
        super(title); // sets the title of the frame to title
        setSize(600, 400); // sets the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the default behaviour of the close operation to EXIT_ON_CLOSE
        setVisible(true); // sets the frame to visibble 
        setLayout(new GridLayout(2, 0)); // sets the layout of the frame to GridLayout with 2 rows. 
        this.gameLogic = gameLogic;

        JPanel labelsBorder = new JPanel(); // creats a new reference to a JPanel object
        labelsBorder.setBorder(BorderFactory.createLoweredBevelBorder()); // Creates a bevel border to seperate the data labesl from the rest of the UI. 
        JPanel labels = new JPanel(); // creates a new reference to a JPanel object
        labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS)); // sets the layout to BoxLayout, items are alligned down the Y axis. 

        JLabel balanceLabel = new JLabel("Balance is " + gameLogic.getBalance()); // gets the balance from gameLogic getBalance() method and sets the JLabel accordingly. 
        formatDataLabels(balanceLabel); // formats the styling of the label with help from the formatDataLabels helper method. 
        labels.add(balanceLabel); // adds balanceLabel to the labels Jpanel. 

        JLabel cardsLabel = new JLabel("Welcome"); // Creates the cards label message. First message is set to welcome
        formatDataLabels(cardsLabel);  // formats the styling of the label with help from the formatDataLabels helper method.
        labels.add(cardsLabel); // adds the cardsLabel to the labels JPanel

        JLabel winLoseLabel = new JLabel(""); // Win lose label is initallly set to "" 
        formatDataLabels(winLoseLabel); // formats the styling of the label with help from the formatDataLabels helper method.
        labels.add(winLoseLabel); // adds the winLoseLabel to the labels JPanel

        labelsBorder.add(labels); // adds the labels JPanel to the frame

        JPanel lowerFrame = new JPanel(); // creates a new JPanel object reference for the lower half of the frame
        lowerFrame.setLayout(new GridLayout(0, 2)); // sets the layout to GridLayout with 2 columns

        JPanel lowerRightFrame = new JPanel(); // creats a JPanel for the lower righthandside of the Frame. 
        lowerRightFrame.setLayout(new GridLayout(2, 0)); // sets GridLayout with two rows
        lowerRightFrame.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60)); // creates an empty border

        JPanel lowerLeftFrame = new JPanel(); // creates a JPanel 
        lowerLeftFrame.setLayout(new GridLayout(0, 3, 30, 0)); // creates a new GridLayout with 3 columns and 30 pixels of horizontal space between each column. 
        lowerLeftFrame.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // sets an empty border around the frame. 

        JPanel card1 = new JPanel(); // creates a new Jpanel for card1
        JLabel card1Label = setCardLayout(card1); // uses the helper method setCardLayout to format the layout of the card
        card1.add(card1Label); // adds the card1Label to card1 

        JPanel card2 = new JPanel(); // creates a new JPanel for card2
        JLabel card2Label = setCardLayout(card2); // uses the helper method setCardLayout to format the layout of the card
        card2.add(card2Label); // adds the card2Label to card2

        JPanel card3 = new JPanel(); // creates a new JPanel for card 3
        JLabel card3Label = setCardLayout(card3); // uses the helper method setCardLayout to format the layout of the card
        card3.add(card3Label); // adds the card3Label to card3

        lowerLeftFrame.add(card1);
        lowerLeftFrame.add(card2);
        lowerLeftFrame.add(card3);

        JButton spin = new JButton("Spin"); // creates a new JButton object referenced to spin
        spin.addActionListener(new ActionListener() { // creates a new ActionListner and adds it to the spin button
            @Override
            public void actionPerformed(ActionEvent e) { // anonymous function for event handling 
                cardsLabel.setText(gameLogic.spin());  // sets the label of cardsLabel to the result of the spin() method in gameLogic
                balanceLabel.setText("Balance is " + gameLogic.getBalance()); // sets the text of the balanceLabel to the result of the getBalance() method in gameLogic
                card1Label.setText(gameLogic.getDrawnCardAtX(0)); // sets the text to equal that of the card in gameLogic.getDrawnCardAtX(0)
                card2Label.setText(gameLogic.getDrawnCardAtX(1)); // sets the text to equal that of the card in gameLogic.getDrawnCardAtX(1)
                card3Label.setText(gameLogic.getDrawnCardAtX(2)); // sets the text to equal that of the card in gameLogic.getDrawnCardAtX(2)

            }
        });

        JButton reset = new JButton("New game");
        reset.setEnabled(false);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameLogic.setBalance(100);
                reset.setEnabled(false);
                spin.setEnabled(true);
                winLoseLabel.setText("");
                balanceLabel.setText("Balance is: " + gameLogic.getBalance());

            }
        });

        balanceLabel.addPropertyChangeListener(new PropertyChangeListener() { // listens to property change of balanceLabel
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (gameLogic.hasLost()) { // if hasLost() equals true, the game is over. 
                    winLoseLabel.setText("You lose!"); // sets the winLoseLabel accordingly
                    reset.setEnabled(true); // Enables the reset button
                    spin.setEnabled(false); // disables the spin button
                }
                if (gameLogic.hasWon()) {// if hasWon() equals true, the game is over.
                    winLoseLabel.setText("You win!");  // sets the winLoseLabel accordingly
                    reset.setEnabled(true); // Enables the reset button
                    spin.setEnabled(false); // disables the spin button
                }
            }
        });

        lowerRightFrame.add(spin); // adds the spin button to lowerRightFrame
        lowerRightFrame.add(reset); // adds the reset button to lowerRightFrame

        lowerFrame.add(lowerLeftFrame); // adds lowerLeftFrame to lowerFrame Jpanel
        lowerFrame.add(lowerRightFrame); // adds lowerRightFrame to lowerFrame Jpanel

        add(labelsBorder); // adds labelsBorder to frame
        add(lowerFrame); // adds lowerFrame to frame

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    private JLabel setCardLayout(JPanel toBeSet) { // Helper method for the creation of cards as this is done repetitively
        toBeSet.setBorder(BorderFactory.createRaisedBevelBorder()); // Creates a raised border around the edge of the cards to make them "pop".
        toBeSet.setBackground(Color.yellow); // Sets the colour of the cards to yellow
        toBeSet.setLayout(new GridBagLayout()); // Sets the Layout to GridBagLayout
        return new JLabel("", SwingConstants.CENTER); // Returns a new JLabel
    }

    private void formatDataLabels(JLabel toBeSet) { // Helper method for the formatting of data labels as this is done repetitively
        toBeSet.setAlignmentX(Component.CENTER_ALIGNMENT); // Centres the component along the Y-axis
        toBeSet.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Creates an empty border. 
    }

}
