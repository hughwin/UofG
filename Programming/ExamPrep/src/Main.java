public class Main {

    public static void main(String[] args) {
        System.out.println(calculateLCM(4, 6));
        System.out.println(calculateGCD(4, 6));
        int k = 2, m = 12, n = 5;

        System.out.println(String.format("The value of %d/%d is %d", n, k, k / n));

        System.out.println(String.format("Value one is %03d%nValue two is %03d", k, m));

        System.out.println(writeNums(5));

    }

    public static int calculateLCM(int a, int b) {
        int i = a;
        while (true) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
            i++;
        }
    }

    public static int calculateGCD(int a, int b) {

        for (int i = a; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String writeNums(int x) {
        if (x == 1) {
            return "1, ";
        } else {
            return writeNums(x - 1) + (x) + ", ";
        }

    }
}

