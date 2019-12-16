/*
Hugh Winchester
2494047W
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFunctionality {

    /*
    ButtonFunctionality class controls what the buttons do when they are clicked. The button functionality class does this
    by adding addActionListener to buttons in the view (UserInterFaceFrame). When the buttons are clicked the model is updated, which
    in turn, updates the view.
     */


    private GameLogic gameLogic;
    private UserInterfaceFrame userInterfaceFrame;

    public ButtonFunctionality(UserInterfaceFrame userInterfaceFrame, GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        this.userInterfaceFrame = userInterfaceFrame;
        userInterfaceFrame.getSpinButton().addActionListener(new ActionListener() { // creates a new ActionListner and adds it to the spin button
            // passed by the getSpinButton method
            public void actionPerformed(ActionEvent e) { // anonymous function for event handling
                gameLogic.spin();
                gameLogic.setBalanceLabel();
                gameLogic.setCardsLabels();
                gameLogic.checkWinLoss();
            }
        });
        userInterfaceFrame.getResetButton().addActionListener(new ActionListener() { // creates a new ActionListner and adds it to the reset button
            public void actionPerformed(ActionEvent e) { // anonymous function for event handling
                gameLogic.reset();
            }
        });
    }


}


