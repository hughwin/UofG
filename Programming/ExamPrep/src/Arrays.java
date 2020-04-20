import java.util.Random;

public class Arrays {

    public static void arrayOfOneHundredPrimitives(){
        Random random = new Random();
        double[] doubleArray = new double[100];

        for (int i = 0 ; i < doubleArray.length ; i++ ){
            doubleArray[i] = random.nextDouble();
        }
        for (Double d : doubleArray){
            System.out.println(d);
        }
    }
    

    public static void main(String[] args) {
        arrayOfOneHundredPrimitives();
    }
}
