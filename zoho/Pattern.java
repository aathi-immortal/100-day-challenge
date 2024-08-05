import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            printStartPatter(scan.nextLine());
        }

    }

    private static void printStartPatter(String nextLine) {
        printUpper(nextLine);
        printMid(nextLine);
        printLower(nextLine);

    }

    private static void printLower(String nextLine) {
        int midIndex = nextLine.length() / 2;
        int leftSpace = midIndex - 1;
        int rightSpace = midIndex - 1;
        int midSpace = 1;
        int leftValue = midIndex - 1;
        int rightValue = midIndex + 1;
        while (leftValue > -1) {
            printSpace(leftSpace);
            System.out.print(nextLine.charAt(leftValue));
            printSpace(midSpace);
            System.out.print(nextLine.charAt(rightValue));
            printSpace(rightSpace);
            leftSpace--;
            rightSpace++;
            leftValue--;
            rightValue++;
            midSpace += 2;
            System.out.println();
        }
    }

    private static void printMid(String nextLine) {
        int midIndex = nextLine.length() / 2;
        printSpace(midIndex);
        System.out.print(nextLine.charAt(midIndex));
        printSpace(midIndex);
        System.out.println();
    }

    private static void printUpper(String nextLine) {

        int leftSpace = 0;
        int rightSpace = 0;
        int midSpace = nextLine.length() - 2;
        int leftValue = 0;
        int rightValue = nextLine.length() - 1;
        while (leftValue != rightValue) {
            printSpace(leftSpace);
            System.out.print(nextLine.charAt(leftValue));
            printSpace(midSpace);
            System.out.print(nextLine.charAt(rightValue));
            printSpace(rightSpace);
            leftSpace++;
            rightSpace++;
            leftValue++;
            rightValue--;
            midSpace -= 2;
            System.out.println();
        }
    }

    private static void printSpace(int rightSpace) {
        for (int index = 0; index < rightSpace; index++) {
            System.out.print(" ");
        }
    }

}

// int leftSpace = 0;
// int rightSpace = 0;
// int midSpace = nextLine.length() - 2;
// int leftValue = 0;
// int rightValue = nextLine.length() - 1;
// while (leftValue != rightValue) {
// printSpace(leftSpace);
// System.out.print(nextLine.charAt(leftValue));
// printSpace(midSpace);
// System.out.print(nextLine.charAt(rightValue));
// printSpace(rightSpace);
// leftSpace++;
// rightSpace++;
// leftValue++;
// rightValue--;
// midSpace -= 2;
// System.out.println();
// }
// System.out.println(nextLine.charAt(leftValue));
// midSpace = 1;
// leftValue--;
// rightValue++;
// leftSpace--;
// rightSpace--;
// while (leftValue > -1) {
// printSpace(leftSpace);
// System.out.print(nextLine.charAt(leftValue));
// printSpace(midSpace);
// System.out.print(nextLine.charAt(rightValue));
// printSpace(rightSpace);
// leftSpace--;
// rightSpace--;
// leftValue--;
// rightValue++;
// midSpace += 2;
// }