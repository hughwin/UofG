/*
Hugh Winchester
2494047W
 */

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CardPanel extends JPanel {

    public CardPanel() {
        setBorder(BorderFactory.createRaisedBevelBorder()); // Creates a raised border around the edge of the cards to make them "pop".
        setBackground(Color.yellow); // Sets the colour of the cards to yellow
        setLayout(new GridBagLayout()); // GridBagLayout with out any constraints will always centre a JLabel.
    }
}
