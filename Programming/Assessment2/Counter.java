/*
Hugh Winchester 2494047W
 */


public class Counter {

    private Player player;
    
    public Counter(Player player){
        this.player = player; // Constructor for the Counter class. Is passed a reference to a Player object as an argument which it assigns to Counter's class variable player.
    }


    public Player getPlayer() {
        return player; // returns the referenced Player object held in the class' player class variable. 
    }
    
    @Override
    public String toString(){
        return player.getPlayerSymbol() + "" ; // Calls the getPlayerSymbol() method in Player which returns a char. The char is then cast into a String object by concatenation of "". The String is then returned. 
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Counter){ // Compares the passed referenced object and assesses whether it is an instance of Counter
            Counter counter = (Counter) o; // Casts the object reference o into the Counter type.  
            if(counter.getPlayer() == player){ //Compares the passed Counter object reference Player to see whether it is the same as the class variable Player
                return true; // If they are the same the method returns true.
            }
        }
        return false; // if not, returns false. 
    }
    
}
