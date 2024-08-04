
import java.util.Scanner;

public class PartioningNumberToBD {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("enter the value :");
        int value = scan.nextInt();
        int[] array = convertToBD(value);
        for (int data : array) {
            if (data == 0)
                break;
            System.out.print(data + " ");
        }
        System.out.println();
    }

    private static int[] convertToBD(int value) {
        // create the empty array
        int binaryArray[] = new int[9];
        int base = 1;
        while (value != 0) {
            int lastDigit = value % 10;
            value = value / 10;
            insertToBinaryArray(binaryArray, lastDigit, base);
            base = base * 10;
        }
        return binaryArray;
    }

    private static void insertToBinaryArray(int[] binaryArray, int lastDigit, int base) {
        for (int i = 0; i < lastDigit; i++) {
            binaryArray[i] += 1 * base;
        }
    }

}