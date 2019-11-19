
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Hugh
 */
public class UserInterface extends JFrame implements ActionListener {
    
    private GameLogic gamelogic;;

	public UserInterface(String title) {
        super(title);
        setSize(600, 400);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible(true);
        setLayout(new GridLayout(2,0));
        

        this.gamelogic = new GameLogic();
        
        
        
        JPanel labels =  new JPanel();
        labels.setBorder(BorderFactory.createLoweredBevelBorder());
        labels.setLayout(new BoxLayout(labels,3));
        
        JLabel balanceLabel = new JLabel("Balance is " + gamelogic.getBalance());
        labels.add(balanceLabel);
        
        JLabel cards = new JLabel("Welcome");
        labels.add(cards);
        
        
        JLabel winLose = new JLabel("");
        labels.add(winLose);
        
        JPanel lowerFrame =  new JPanel();
        lowerFrame.setLayout(new GridLayout(0, 2));
        
        
        JPanel lowerRightFrame =  new JPanel();
        lowerRightFrame.setLayout(new GridLayout(2, 0));
        lowerRightFrame.setBorder(BorderFactory.createEmptyBorder(60,60,60,60));
        
        JButton spin = new JButton("Spin");
        spin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		gamelogic.spin();
        		balanceLabel.setText("Balance is " + gamelogic.getBalance());
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
        
        JPanel lowerLeftFrame =  new JPanel();
        lowerLeftFrame.setLayout(new GridLayout(0,3,30,0));
        lowerLeftFrame.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        JPanel card = new JPanel();
        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();
        
        card.setBorder(BorderFactory.createRaisedBevelBorder());
        card2.setBorder(BorderFactory.createRaisedBevelBorder());
        card3.setBorder(BorderFactory.createRaisedBevelBorder());
        
        lowerLeftFrame.add(card).setBackground(Color.yellow);
        lowerLeftFrame.add(card2).setBackground(Color.yellow);
        lowerLeftFrame.add(card3).setBackground(Color.yellow);

        
        lowerFrame.add(lowerLeftFrame);
        lowerFrame.add(lowerRightFrame);
        
        this.add(labels);
        this.add(lowerFrame);
        
        setVisible(true);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    
    
    
}
