import java.util.Scanner;

public class PatternNic {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the number");
        int n = scan.nextInt();
        patternMatrix(n);
    }

    private static void patternMatrix(int n) {
        int numberCount = 1;
        for (int row = 0; row < n; row++) {
            printSpace(n - row - 1);
            int start = row + 1;
            int incrementer = -1;
            for (int col = 0; col < numberCount; col++) {
                if (start == 1) {
                    System.out.print(start + " ");
                    incrementer = 1;
                } else {
                    System.out.print(start + " ");

                }
                start += incrementer;
            }
            numberCount += 2;
            System.out.println();
        }
    }

    private static void printSpace(int i) {
        for (int time = 0; time < i; time++) {
            System.out.print("  ");
        }
    }

}
