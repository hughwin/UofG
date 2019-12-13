import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFunctionality {

    private  GameLogic gameLogic;
    private  UserInterfaceFrame userInterfaceFrame;

    public ButtonFunctionality(UserInterfaceFrame userInterfaceFrame, GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        this.userInterfaceFrame = userInterfaceFrame;
        userInterfaceFrame.getSpinButton().addActionListener(new ActionListener() { // creates a new ActionListner and adds it to the spin button
            @Override
            public void actionPerformed(ActionEvent e) { // anonymous function for event handling
                gameLogic.spin();
                gameLogic.getBalance();
                gameLogic.setCardsLabels();
                gameLogic.checkWinLoss();
                }
        });
        userInterfaceFrame.getResetButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameLogic.reset();
            }
        });
    }



    }


