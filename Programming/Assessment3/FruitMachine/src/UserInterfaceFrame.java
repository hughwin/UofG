/*
Hugh Winchester
2494047W
 */

import javax.swing.*;
import java.awt.*;

/* 
Creation of the user interface 
 */
public class UserInterfaceFrame extends JFrame {


    private JButton spin = new JButton("Spin"); // creates a new JButton object referenced to spin
    private JButton reset = new JButton("New game");

    private JLabel balanceLabel = new JLabel("Balance is 100");
    private JLabel cardsLabel = new JLabel("Welcome");
    private JLabel winLoseLabel = new JLabel("");

    private JLabel card1Label = new JLabel("", SwingConstants.CENTER); // Returns a new JLabel
    private JLabel card2Label = new JLabel("", SwingConstants.CENTER); // Returns a new JLabel
    private JLabel card3Label = new JLabel("", SwingConstants.CENTER); // Returns a new JLabel


    public UserInterfaceFrame(String title) {
        super(title); // sets the title of the frame to title
        setSize(650, 450); // sets the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the default behaviour of the close operation to EXIT_ON_CLOSE
        setLayout(new GridLayout(2, 0)); // sets the layout of the frame to GridLayout with 2 rows.

        JPanel labelsBorder = new JPanel(); // creats a new reference to a JPanel object
        labelsBorder.setBorder(BorderFactory.createLoweredBevelBorder()); // Creates a bevel border to seperate the data labesl from the rest of the UI. 
        JPanel labels = new JPanel(); // creates a new reference to a JPanel object
        labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS)); // sets the layout to BoxLayout, items are alligned down the Y axis. 

        formatDataLabels(balanceLabel); // formats the styling of the label with help from the formatDataLabels helper method.
        labels.add(balanceLabel); // adds balanceLabel to the labels JPanel.

        formatDataLabels(cardsLabel);  // formats the styling of the label with help from the formatDataLabels helper method.
        labels.add(cardsLabel); // adds the cardsLabel to the labels JPanel

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

        JPanel card1 = new JPanel(); // creates a new JPanel for card1
        setCardLayout(card1); // uses the helper method setCardLayout to format the layout of the card
        card1.add(card1Label); // adds the card1Label to card1


        JPanel card2 = new JPanel(); // creates a new JPanel for card2
        setCardLayout(card2); // uses the helper method setCardLayout to format the layout of the card
        card2.add(card2Label); // adds the card2Label to card2


        JPanel card3 = new JPanel(); // creates a new JPanel for card 3
        setCardLayout(card3); // uses the helper method setCardLayout to format the layout of the card
        card3.add(card3Label);

        lowerLeftFrame.add(card1);
        lowerLeftFrame.add(card2);
        lowerLeftFrame.add(card3);


        lowerRightFrame.add(spin); // adds the spin button to lowerRightFrame
        lowerRightFrame.add(reset); // adds the reset button to lowerRightFrame
        reset.setEnabled(false);

        lowerFrame.add(lowerLeftFrame); // adds lowerLeftFrame to lowerFrame Jpanel
        lowerFrame.add(lowerRightFrame); // adds lowerRightFrame to lowerFrame Jpanel

        add(labelsBorder); // adds labelsBorder to frame
        add(lowerFrame); // adds lowerFrame to frame

        setVisible(true); // sets the frame to visibble


    }

    private void setCardLayout(JPanel toBeSet) { // Helper method for the creation of cards as this is done repetitively
        toBeSet.setBorder(BorderFactory.createRaisedBevelBorder()); // Creates a raised border around the edge of the cards to make them "pop".
        toBeSet.setBackground(Color.yellow); // Sets the colour of the cards to yellow
        toBeSet.setLayout(new GridBagLayout()); // Sets the Layout to GridBagLayout
        new JLabel("", SwingConstants.CENTER); // Returns a new JLabel
    }

    private void formatDataLabels(JLabel toBeSet) { // Helper method for the formatting of data labels as this is done repetitively
        toBeSet.setAlignmentX(Component.CENTER_ALIGNMENT); // Centres the component along the Y-axis
        toBeSet.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Creates an empty border. 
    }

    /*
    Getters for the various buttons and JLabels
     */


    public JButton getSpinButton() {
        return spin;
    }

    public JButton getResetButton() {
        return reset;
    }

    public JLabel getBalanceLabel() {
        return balanceLabel;
    }

    public JLabel getWinLoseLabel() {
        return winLoseLabel;
    }

    public JLabel getCardsLabel() {
        return cardsLabel;
    }

    public JLabel getCard1Label() {
        return card1Label;
    }

    public JLabel getCard2Label() {
        return card2Label;
    }

    public JLabel getCard3Label() {
        return card3Label;
    }

}
