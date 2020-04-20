public class Recursion {

    public static void printAsterisks(int limiter){
        if (limiter == 0){return;}
        else{
            System.out.print("*");
            printAsterisks(limiter - 1);
        }
    }

    public static void printStringVertically(String string){
        if(string.equals("")){return;}
        System.out.println(string.charAt(0));
        printStringVertically(string.substring(1));
    }

    public static int simplePowerFunction(int powerOf){

        if(powerOf == 1){return 1;}

        return powerOf * simplePowerFunction(powerOf-1);
    }

    public static int sumOfSquares(int limiter){

        if(limiter == 1){
            return 1;
        }
        return (limiter * limiter) + sumOfSquares(limiter - 1);

    }

    public static void main(String[] args) {
        printAsterisks(10);
        System.out.println();
        printStringVertically("Hello there!");
        System.out.println();
        System.out.println(simplePowerFunction(5));
        System.out.println();
        System.out.println(sumOfSquares(10));
    }

}
