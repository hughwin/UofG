
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Hugh
 */
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

        JPanel labels = new JPanel();
        labels.setBorder(BorderFactory.createLoweredBevelBorder());
        labels.setLayout(new BoxLayout(labels, 3));

        JLabel balanceLabel = new JLabel("Balance is " + gamelogic.getBalance());
        labels.add(balanceLabel);

        JLabel cards = new JLabel("Welcome");
        labels.add(cards);

        JLabel winLose = new JLabel("");
        labels.add(winLose);

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
            public void actionPerformed(ActionEvent e) {
                gamelogic.spin();
                balanceLabel.setText("Balance is " + gamelogic.getBalance());
                card1Label.setText(gamelogic.getDrawnCardAtX(0));
                card2Label.setText(gamelogic.getDrawnCardAtX(1));
                card3Label.setText(gamelogic.getDrawnCardAtX(2));
                System.out.println("Spinning!");

            }
        });
        lowerRightFrame.add(spin);

        JButton reset = new JButton("Reset");
        reset.setEnabled(gamelogic.hasWon());
        reset.setEnabled(gamelogic.hasLost());
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gamelogic.setBalance(100);
                System.out.println("Reset!");
            }
        });
        lowerRightFrame.add(reset);

        lowerFrame.add(lowerLeftFrame);
        lowerFrame.add(lowerRightFrame);

        add(labels);
        add(lowerFrame);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
