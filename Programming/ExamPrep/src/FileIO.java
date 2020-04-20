import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {

    public static void loadSumFile(){

        File sum = new File("Programming/ExamPrep/sum.txt");
        try {
            Scanner scanner = new Scanner(sum);
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] stringArray = line.split(" ");
                if(stringArray[1].equals("+")) {
                    System.out.println(Integer.parseInt(stringArray[0]) + Integer.parseInt(stringArray[2]));
                }
                else{System.out.println(Integer.parseInt(stringArray[0]) - Integer.parseInt(stringArray[2]));
                }
            }
        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }


    }

    public static void main(String[] args) {
      loadSumFile();
    }

}
