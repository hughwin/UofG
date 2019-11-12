/*
Hugh Winchester 2494047W
 */

public class Board {

    private Column[] arrayOfColumns;
    private int rows;

    public Board(int rows, int columns) { // Constructor for the Board class, is passed two ints rows and columns which
        // determine how many rows and columns are going to be on the game board.
        this.rows = rows; // assigns the int rows argument passed in the constructor to the class' row
        // class variable.

        arrayOfColumns = new Column[columns]; // creates the array object and assigns the reference arrayOfColumns. The
        // array is created to the length of columns. arrayOfColumns is a class
        // variable

        for (int i = 0; i < arrayOfColumns.length; i++) { // Iterates through the array arrayOfColumns and creates
            // Column objects of row length at each index.
            arrayOfColumns[i] = new Column(rows);
        }
    }

    /*
	 * I considered using Getters and Setters in both Board and Column, however I
	 * decided against it as these really served no purpose (or their purpose was
	 * replicated both other methods). Furthermore, I believe their inclusion could
	 * actually damage the functionality of the game, for instance, changing a a
	 * Column length whilst the game is in progress would effectively break it.
     */
    public boolean add(Counter counter, int columnNumber) { // Adds a Counter to a column specified by columnNumber. Returns true if a counter is added, false otherwise. 
        return arrayOfColumns[columnNumber].add(counter);
    }

    public boolean isFull() { // Tests to see whether all Column objects in arrayOfColumns are full.
        for (Column arrayOfColumn : arrayOfColumns) {
            // Iterates across the array arrayOfColumns entire length
            if (arrayOfColumn.displayRow(0).equals(" ")) {
                // Tests to see if index 0 (right at the top of the
                // board) has a blank space indicating no counter
                // present.
                return false; // Returns false if there is a " "
            }
        }
        return true; // Returns true if the board is full.
    }

    public boolean testWinConditions(Counter counter) { // Iterates through all possible start positions and detects
        // whether there is 4 of the same counter in a row.


        /*
		 * Testing to see whether a player has won the game or not. Essentially all the
		 * win-state tests work the same in principle; the tests iterate through all the
		 * valid positions a winning "frame" of 4 counters could be. If 4 valid counters
		 * are found in the positions, the code returns true.
		 * 
		 * I realise that there is unnecessary looping in the code, however, I feel that
		 * this code is easy to understand. If I were to refactor it I would consider
		 * using a recursive test.
         */

 /*
		 * ================= Vertical checks =================
         */
        for (int i = 0; i < arrayOfColumns.length; i++) {
            for (int k = rows - 1; k >= 3; k--) {

                Counter first = arrayOfColumns[i].getCounterAt(k);
                Counter second = arrayOfColumns[i].getCounterAt(k - 1);
                Counter third = arrayOfColumns[i].getCounterAt(k - 2);
                Counter forth = arrayOfColumns[i].getCounterAt(k - 3);

                if (counter.equals(first) && counter.equals(second) && counter.equals(third)
                        && counter.equals(forth)) {
                    return true;
                }

            }

        }

        /*
		 * ================= Horizontal checks =================
         */
        for (int i = rows - 1; i >= 0; i--) {
            for (int k = 0; k < arrayOfColumns.length - 3; k++) {

                Counter first = arrayOfColumns[k].getCounterAt(i);
                Counter second = arrayOfColumns[k + 1].getCounterAt(i);
                Counter third = arrayOfColumns[k + 2].getCounterAt(i);
                Counter forth = arrayOfColumns[k + 3].getCounterAt(i);

                if (counter.equals(first) && counter.equals(second) && counter.equals(third)
                        && counter.equals(forth)) {
                    return true;
                }

            }

        }

        /*
		 * ================= Negative diagonal checks =================
         */
        for (int i = 3; i < arrayOfColumns.length; i++) {
            for (int k = 0; k < rows - 3; k++) {

                Counter first = arrayOfColumns[i].getCounterAt(k);
                Counter second = arrayOfColumns[i - 1].getCounterAt(k + 1);
                Counter third = arrayOfColumns[i - 2].getCounterAt(k + 2);
                Counter forth = arrayOfColumns[i - 3].getCounterAt(k + 3);

                if (counter.equals(first) && counter.equals(second) && counter.equals(third)
                        && counter.equals(forth)) {
                    return true;
                }

            }

        }

        /*
		 * ================= Positive diagonal checks =================
         */
        for (int i = 0; i < arrayOfColumns.length - 3; i++) {
            for (int k = 0; k < rows - 3; k++) {

                Counter first = arrayOfColumns[i].getCounterAt(k);
                Counter second = arrayOfColumns[i + 1].getCounterAt(k + 1);
                Counter third = arrayOfColumns[i + 2].getCounterAt(k + 2);
                Counter forth = arrayOfColumns[i + 3].getCounterAt(k + 3);

                if (counter.equals(first) && counter.equals(second) && counter.equals(third)
                        && counter.equals(forth)) {
                    return true;
                }

            }

        }

        return false;

    }

    public String toString() { // prints out the board
        String toBeReturned = ""; // creates the string object to be returned as an empty string.
        for (int i = 0; i < arrayOfColumns.length; i++) { // for loop, prints the indexes of columns at the top of the
            // board
            if (i == 0) {
                toBeReturned += "|" + 0 + "|"; // the far left hand column has to be printed with "|" on both sides
            } else {
                toBeReturned += i + "|"; // prints i with a "|" to the right hand side.
            }
        }
        toBeReturned += "\n"; // creates a new line

        for (int i = 0; i < (arrayOfColumns.length * 2) + 1; i++) { // creates the dashed line under the indexes.
            toBeReturned += "-"; // adds dashes whilst i < arrayOfColumns.length * 2
        }
        toBeReturned += "\n"; // creates a new line
        for (int i = 0; i < rows; i++) { // iterates across all rows 
            for (int k = 0; k < arrayOfColumns.length; k++) { // iterates across all columns in array of columns

                if (k == 0) { // prints and extra "|" for the zero index
                    toBeReturned += "|" + (arrayOfColumns[k].displayRow(i)) + "|"; // displays the row at a particular index. 
                } else {
                    toBeReturned += (arrayOfColumns[k].displayRow(i)) + "|";
                }
            }
            toBeReturned += "\n"; // creates a new line
        }
        return toBeReturned; // returns the fully built string
    }

}
