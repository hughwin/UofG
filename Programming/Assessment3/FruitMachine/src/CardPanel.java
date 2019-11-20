
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hugh
 */
public class CardPanel extends JPanel{
    
    public CardPanel(){
    setBorder(BorderFactory.createRaisedBevelBorder()); // Creates a raised border around the edge of the cards to make them "pop".
    setBackground(Color.yellow); // Sets the colour of the cards to yellow
    setLayout(new GridBagLayout()); // GridBagLayout with out any constraints will always centre a JLabel.
    }
}
