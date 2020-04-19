import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsAndIO {


    public static void askForIntInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an int:");
        try {
            int input = scanner.nextInt();
        }catch (InputMismatchException inputMismatchException){
            System.err.println("You didn't enter a number!");
            askForIntInput();
        }
        System.out.println("Number entered successfully");
    }

    public static void main(String[] args) {
        askForIntInput();
    }
}
