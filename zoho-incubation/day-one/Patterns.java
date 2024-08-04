import java.util.Scanner;

/**
 * Patterns
 */
public class Patterns {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the matrix row");
        int size = scan.nextInt();

        printSnakePattern(size);
        // printLadderPattern2(size);
        printLadderPaternUpandDown(size);
    }

    private static void printLadderPaternUpandDown(int size) {

        int head = 1;
        for (int row = 0; row < size; row++) {
            int currentValue = head;
            int incrementer = 1;
            int difference = row + 2;
            for (int col = 0; col < size; col++) {
                if (col == size - row - 2) {
                    System.out.print(currentValue + " ");
                    incrementer = -1;
                } else {
                    System.out.print(currentValue + " ");

                }
                currentValue += difference;

                difference += incrementer;

            }

            System.out.println();
            head += (row + 1);
        }
    }

    private static void printLadderPattern(int size) {
        int head = 1;
        for (int row = 0; row < size; row++) {
            int currentValue = head;
            int incrementer = 1;

            for (int col = 0; col < size - row; col++) {

                System.out.print(currentValue + " ");
                currentValue += (row + col + 2);

            }

            System.out.println();
            head += (row + 1);
        }
    }

    private static void printLadderPattern2(int size) {
        int head = 1;
        for (int row = 0; row < size; row++) {
            int currentValue = head;

            int col;
            for (col = 0; col < size - row; col++) {

                System.out.print(currentValue + " ");
                currentValue += (row + col + 2);

            }

            currentValue--;
            int incrementer = row + col;
            for (int remCol = 0; remCol < row; remCol++) {
                incrementer--;
                System.out.print(currentValue);
                currentValue += incrementer;

            }

            System.out.println();
            head += (row + 1);
        }
    }

    private static void printSnakePattern(int size) {

        int head = 0;
        int switcher = 1;

        for (int row = 0; row < size; row++) {
            if (row % 2 == 0) {
                head++;
                switcher = 1;
            } else {
                head += (size * 2) - 1;
                switcher = -1;
            }
            int currentValue = head;
            for (int col = 0; col < size; col++) {
                System.out.print(currentValue + " ");
                currentValue += switcher;
            }
            System.out.println();

        }

    }

}