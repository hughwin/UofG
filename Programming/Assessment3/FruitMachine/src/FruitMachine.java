/*
Hugh Winchester
2494047W
 */
public class FruitMachine {

    public static void main(String[] args) {

        /*

        I have tried to follow MVC design patterns as closely as possible. Below are my three classes comprising the MVC.
        Each is initialised in turn.
         */

        UserInterfaceFrame userInterfaceFrame = new UserInterfaceFrame("Fruitmachine"); // view
        GameLogic gameLogic = new GameLogic(userInterfaceFrame); // model
        ButtonFunctionality buttonFunctionality = new ButtonFunctionality(userInterfaceFrame, gameLogic); // controller
    }

}
