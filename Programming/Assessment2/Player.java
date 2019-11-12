/*
Hugh Winchester 2494047W
 */




public class Player {

    private String name;
    private char playerSymbol;
    
    public Player(String name, char playerSymbol){
        this.name = name; // Sets the class variable of name to the String name passed in the constructor's argument. 
        this.playerSymbol = playerSymbol;// Sets the class variable of playerSymbol to the char name playerSymbol in the constructor's argument.
    }

    public String getName() {
        return name; // Returns the Player's name class variable as a String. 
    }

    public char getPlayerSymbol() {
        return playerSymbol; // Returns the Player's playerSymbol class variable as a String.
    }
    
    public String toString(){
        return name; // Returns the player's name only as a String
    }			     // Originally, I had this set to return the Player's playerSymbol as well, but this didn't make sense when completing question 1.C.


    
    
}
