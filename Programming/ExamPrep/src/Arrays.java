import java.util.OptionalDouble;
import java.util.Random;

public class Arrays {

    public static OptionalDouble arrayOfOneHundredPrimitives(){
        Random random = new Random();
        double[] doubleArray = new double[100];

        for (int i = 0 ; i < doubleArray.length ; i++ ){
            doubleArray[i] = random.nextDouble();
        }
        return java.util.Arrays.stream(doubleArray).average();
    }


    public static void main(String[] args) {
        System.out.println(arrayOfOneHundredPrimitives().getAsDouble());
    }
}
