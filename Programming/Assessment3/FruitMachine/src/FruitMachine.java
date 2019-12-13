/*
Hugh Winchester
2494047W
 */
public class FruitMachine {

    public static void main(String[] args) {
        UserInterfaceFrame userInterfaceFrame = new UserInterfaceFrame("Fruitmachine"); // view
        GameLogic gameLogic = new GameLogic(userInterfaceFrame); // model
        ButtonFunctionality buttonFunctionality = new ButtonFunctionality(userInterfaceFrame, gameLogic); // controller
    }

}
