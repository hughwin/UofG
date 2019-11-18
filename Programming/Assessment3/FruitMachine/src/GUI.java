
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hugh
 */
public class GUI extends JFrame{
    
    public GUI(String title, Balance balance) {
        super(title);
        setSize(600, 400);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible(true);
        setLayout(new GridLayout(2,0));
        
        
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
        JPanel labels =  new JPanel();
        labels.setBorder(loweredbevel);
        labels.setLayout(new BoxLayout(labels,3));
        
        JLabel balanceLabel = new JLabel("Balance is " + balance.getBalance());
        labels.add(balanceLabel);
        
        JLabel cards = new JLabel("Welcome");
        labels.add(cards);
        
        
        JLabel winLose = new JLabel("");
        labels.add(winLose);
        
        JPanel lowerFrame =  new JPanel();
        lowerFrame.setLayout(new GridLayout(0,2));
        JPanel lowerLeftFrame =  new JPanel();
        JPanel lowerRightFrame =  new JPanel();
        lowerRightFrame.setBorder(loweredbevel);
        lowerFrame.add(lowerLeftFrame);
        lowerFrame.add(lowerRightFrame);
        
        this.add(labels);
        this.add(lowerFrame);
        
        setVisible(true);
}
}
