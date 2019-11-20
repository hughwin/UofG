/*
Hugh Winchester
2494047W
 */

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

public class UserInterfaceFrame extends JFrame implements ActionListener {

    private GameLogic gamelogic;

    ;

	public UserInterfaceFrame(String title) {
        super(title);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2, 0));

        this.gamelogic = new GameLogic();

        JPanel labelsBorder = new JPanel();
        labelsBorder.setBorder(BorderFactory.createLoweredBevelBorder());
        JPanel labels = new JPanel();
        labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));

        DataLabel balanceLabel = new DataLabel("Balance is " + gamelogic.getBalance());
        labels.add(balanceLabel);

        DataLabel cards = new DataLabel("Welcome");
        labels.add(cards);

        DataLabel winLose = new DataLabel("");
        labels.add(winLose);

        labelsBorder.add(labels);

        JPanel lowerFrame = new JPanel();
        lowerFrame.setLayout(new GridLayout(0, 2));

        JPanel lowerRightFrame = new JPanel();
        lowerRightFrame.setLayout(new GridLayout(2, 0));
        lowerRightFrame.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));

        JPanel lowerLeftFrame = new JPanel();
        lowerLeftFrame.setLayout(new GridLayout(0, 3, 30, 0));
        lowerLeftFrame.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        JPanel card1 = new CardPanel();
        JLabel card1Label = new JLabel("", SwingConstants.CENTER);
        card1.add(card1Label);

        JPanel card2 = new CardPanel();
        JLabel card2Label = new JLabel("", SwingConstants.CENTER);
        card2.add(card2Label);

        JPanel card3 = new CardPanel();
        JLabel card3Label = new JLabel("", SwingConstants.CENTER);
        card3.add(card3Label);

        lowerLeftFrame.add(card1);
        lowerLeftFrame.add(card2);
        lowerLeftFrame.add(card3);



        JButton spin = new JButton("Spin");
        spin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamelogic.spin();
                balanceLabel.setText("Balance is " + gamelogic.getBalance());
                card1Label.setText(gamelogic.getDrawnCardAtX(0));
                card2Label.setText(gamelogic.getDrawnCardAtX(1));
                card3Label.setText(gamelogic.getDrawnCardAtX(2));

            }
        });
        
                JButton reset = new JButton("New game");
        reset.setEnabled(true);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gamelogic.setBalance(100);
                reset.setEnabled(false);
                spin.setEnabled(true);
                winLose.setText("");
                balanceLabel.setText("Balance is: " + gamelogic.getBalance());

            }
        });

        balanceLabel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (gamelogic.getBalance() < 0) {
                    winLose.setText("You lose!");
                    reset.setEnabled(true);
                    spin.setEnabled(false);
                }
                if (gamelogic.getBalance() > 150) {
                    winLose.setText("You win!");
                    reset.setEnabled(true);
                    spin.setEnabled(false);
                }
            }
        });
        
        

        lowerRightFrame.add(spin);
        lowerRightFrame.add(reset);

        lowerFrame.add(lowerLeftFrame);
        lowerFrame.add(lowerRightFrame);

        add(labelsBorder);
        add(lowerFrame);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
