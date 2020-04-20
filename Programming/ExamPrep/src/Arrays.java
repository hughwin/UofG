import java.util.OptionalDouble;
import java.util.Random;

public class Arrays {

    public static double[] arrayOfOneHundredDoublePrimitives(){
        Random random = new Random();
        double[] doubleArray = new double[100];

        for (int i = 0 ; i < doubleArray.length ; i++ ){
            doubleArray[i] = random.nextDouble();
        }
        return doubleArray;
    }

    public static int[] arrayOfOneHundredIntPrimitives(){
        Random random = new Random();
        int[] intArray = new int[100];

        for (int i = 0 ; i < intArray.length ; i++){
            intArray[i] = random.nextInt(100);
        }
        return intArray;
    }

    public static int findFirstInt(int intToBeSearched, int[] intArray){
        for (int i = 0 ; i < intArray.length ; i++ ){
            if(intToBeSearched == intArray[i]){
                return i;
            }
        }
        return  -1;
    }

    public static int findLastInt(int intToBeSearched, int[] intArray) {
        for (int i = intArray.length - 1 ; i >= 0 ; i-- ){
            if(intToBeSearched == intArray[i]){
                return i;
            }
        }
        return  -1;
    }

    public static double averageDoubleArray(double[] doubleArray){
        return java.util.Arrays.stream(doubleArray).average().getAsDouble();
    }


    public static void main(String[] args) {
        int[] intArray = arrayOfOneHundredIntPrimitives();
        double[] doubleArray = arrayOfOneHundredDoublePrimitives();

        for (int i : intArray){
            System.out.println(i);
        }

        System.out.println(averageDoubleArray(doubleArray));
        System.out.println(findFirstInt(52, intArray));
        System.out.println(findLastInt(75, intArray));
    }
}
