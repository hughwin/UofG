/* 
    Instructions - Assessed Exercise 1
    - This exercise tests the things you've learnt in week 1.
    - Add your code to this file, leaving the main method unchanged.
    - Each of the tasks involves writing a single method.
    - Total number of marks is 22.
    - Read the instructions for each task *carefully*.
    - Submit a single .java file on moodle by the deadline (details on moodle).
    - Do not change the name of the Java file, but ensure you add your name and 
        matric as requested below...
    - Add all of your methods *below* the main method, in question order.
    - You do not need to add any additional import lines.
    - Everything you need to do these tasks is covered in the week 1 slides.
*/

/*
    Non task-specific marks:
     - Add a comment with your name and matric here Hugh Winchester 2494047W [1 mark]
     - Clear code commenting [1 mark]
     - Use of correct Java variable naming conventions [1 mark]
*/
import java.util.Scanner;

public class AssEx1 {
	public static void main(String[] args) {
		String name = "Hugh";
//
//		/*
//		 * Task 1 [2 marks] Create a method called welcome that prints the word "Hello"
//		 * followed by whatever is stored in the variable 'name'. It will be called by
//		 * the line below.
//		 */
		welcome(name);
//
//		/*
//		 * Task 2 [3 marks] Write a method called multiples that prints out all
//		 * multiples of some integer m between m and another intger max in individual
//		 * lines. For example multiples(3,11) should print: 3 6 9 Your method *must* use
//		 * a loop
//		 */
		int m = 7;
		int max = 100;
		multiples(m, max);
//
//		/*
//		 * Task 3 [3 marks] Write a method called check that takes an integer as an
//		 * argument and returns a boolean value that is true if the integer is greater
//		 * than 5 and less than 10. Call the method three times with the integers 1, 6
//		 * and 12 respectively, printing the output each time on a new line.
//		 */
//		// Call the method and print the output three times below...
//
		System.out.println(check(1)); // false
		System.out.println(check(6)); // true
		System.out.println(check(12)); // false
//
//		/*
//		 * Task 4 [6 marks] Write a method called calculator that prompts the user to
//		 * input an integer, an operator ('+' or '-') and finally another integer. The
//		 * method should then perform the calculation and print the answer using
//		 * String.format. The result of the claculation should be padded with zeros to
//		 * make it length 4. E.g. if the user enters: 4 - 3 The program should output:
//		 * "Calculation: 4 - 3 = 0001" The inputs should be on separate lines. You don't
//		 * need to do any error checking on the user input.
//		 */
		calculator();

		/*
		 * Task 5 [5 marks] Write a method called table that takes two integers as
		 * arguments that correspond to a number of rows and a number of columns
		 * respectively. If either integer is <0 or >= 10, the program should print:
		 * "Error, rows and columns must be >0 and <10" and return. If the number of
		 * rows and columns is between >=0 and <=9 the method should print a table with
		 * the table co-ordinates in each position. For example, if the number of rows
		 * is 2 and the number of columns 4: (0,0) (0,1) (0,2) (0,3) (1,0) (1,1) (1,2)
		 * (1,3) Important: - You *must* only use System.out.print and *not*
		 * System.out.println... - Separate each co-ordinate pair with a tab ('\t') -
		 * You may *not* use for loops! I.e. you *must* use a do or a while loop.
		 */
		table(13, 5);
		table(-2, 7);
		table(3, 6);
	}

	public static void welcome(String name) {

		System.out.println("Hello " + name);

	}

	public static void multiples(int m, int max) {
		int currentMultiple = 0;								 // ""It is apparently good practice to initialise variables, so even though "n" doesn't require intialising 
		for (int i = 1; currentMultiple < max; i++) {          // I interpreted this question
			currentMultiple = m * i;
			if (currentMultiple <= max) {
				System.out.println(currentMultiple); // prints out "currentMultiple" if it is less than or equal to max. 
			}
		}

	}

	public static boolean check(int num) { // The method "check" is passed an integer "num"

		if (num > 5 && num < 10) { // This if statement evaluates if the integer "num" passed to the method is greater than 5 and less than 10.
			return true; 		   // If it is, the method returns "true"; if it isn't, false. 
		} else {			       // I considered not including the else statement as it's redundant, however I think it is good practice to include it should I (or anyone else) want to edit the code in the future.
			return false;  
		}
	}

	public static void calculator() {

		int calculation = 0;      //  Initalises the int variable calculation with 0. This is the variable to store the result of the calculation.

		Scanner reader = new Scanner(System.in); // Creates a Scanner object with the reference reader. Takes input from "System.in" (input from keyboard). 

		System.out.println("Welcome to the calculator program!"); // Welcomes the user to the calculator program. 
		System.out.println("Please enter your first integer");    
		int firstNumber = reader.nextInt(); // Allows the user to input a integer which is assigned to the variable "firstNumber".

		reader.nextLine(); // This is necessary to remove the "\n" character which is still referenced to reader.

		System.out.println("Please enter your operator (\'+\' or \'-\')"); // Asks the user to enter an operator. 
		String operator = reader.nextLine(); // The operator the user chooses is assigned to the variable operator as a String object. 

		System.out.println("Please enter your second integer");
		int secondNumber = reader.nextInt(); // Allows the user to input the second integer which is assigned to the variable "secondNumber".
		
		
		/* <If statement block>
		 *  
		 * I chose not to use an if / else statement as although this would have worked, 
		 * it would have possibly been confusing for people viewing my code later and making
		 * changes at a later date. The String object contained in the variable operator 
		 * is checked for equality with the appropriate symbols. The appropriate calculation
		 * is then carried out within the if statement and assigned to the variable calculation.
		 */

		if (operator.equals("+")) {
			calculation = firstNumber + secondNumber;
		}
		if (operator.equals("-")) {
			calculation = firstNumber - secondNumber;
		}
		
		/* <leadingZeros>
		 * As the calculation variable was the only variable which needed formatting, I chose 
		 * to keep this separate from the final System.out print as it makes the code easier to 
		 * understand, and more readable. 
		 * 
		 * The String.format first argument is set to "%04d", which essentially asks it to add 
		 * (where possible) 4 leading digits before the digits from "calculation". 
		 */

		String leadingZeros = String.format("%04d", calculation);

		System.out.println("Calculation: " + firstNumber + " " + operator + " " + secondNumber + " = " + leadingZeros); // Prints out the calculation. 

		reader.close(); // Closes the reader (as is good practice) to conserve resources. 

	}

	public static void table(int rows, int columns) {
		
		/*<if statement block>
		 * Ensures the person using the method enters an appropriate number of rows and columns.
		 * If either "rows" or "columns" is less than 0 or greater than 10 it will give the user 
		 * and error and the program will return.  
		 */

		if (rows < 0 || rows >= 10 || columns < 0 || columns >= 10) {
			System.out.println("Error, rows and columns must be >0 and <10");
			return;
		}

		int i = 0; // initialises i to 0
		int k = 0; // initialises k to 0

		while (i < rows) {
			while (k < columns) {
				System.out.print("(" + i + "," + k + ")\t"); // Prints out the table coordinates at each position. Contains the formatting for the cells and the tab character that creates distance between them. 
				k++; // Increments k so the inside while loop will terminate once the appropriate number of rows have been printed off. 
			}
			System.out.print("\n");
			i++;	   // Increments i so the outside while loop will terminate at the appropriate point.
			k = 0;     // The value for k is reset to 0. This ensures that the rows are printed off properly. 
		}

	}

}
