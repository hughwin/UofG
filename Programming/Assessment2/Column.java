/*
Hugh Winchester 2494047W
 */


public class Column {

    private Counter[] array;

    public Column(int numRows) { // Constructor for the Column class. Passed an integer determining how many rows there are. 
        array = new Counter[numRows]; //Creates an "empty" array of Column objects. Values are null by default. 
    }

    public boolean add(Counter counter) { // Adds a Counter to a Column. 

        for (int i = array.length - 1; i > -1; i--) { // Iterates the array from the last index to the first index. 
            if (array[i] == null) { // If a char in the array is equivalent to null, it has been unassigned, and therefore a Counter can take its place.
                array[i] = counter; // Assigns the first found null value to the Counter in the argument. 
                return true; // Returns true, as a Counter has been added. 
            }
        }
        return false; // If the for loop completes, there are no empty spaces in the Column and the method returns false. 
    }
    
    public String displayRow(int row) { // Returns a String object of the Player's Counter's Symbol at the particular index in the array specified by row. 
    	if (array[row] == null) {
    		return " "; // If the index of the Column (array) contains the null character a blank space (" ") is returned. 
    	}
    	return array[row].getPlayer().getPlayerSymbol() +""; // Else, the method returns the char (cast into a String object) at the specified index. 
    }
    
        public Counter getCounterAt(int row) { // Returns the referenced Counter object at a specified index (row). 
            return array[row];
    }
    
    public void display() { // Prints out the entire contents of a column from the "bottom" upwards. 
    	for (int i = array.length - 1; i > -1; i--) { // The for loop starts at the last value in the array and works up to the zero index.
    		System.out.println(displayRow(i)); // Calls the displayRow() method, and prints the contents of each index returned by that method
    	}
    }
}
