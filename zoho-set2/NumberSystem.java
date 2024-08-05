import java.util.ArrayDeque;
import java.util.Deque;

public class NumberSystem {

    public static void main(String[] args) {
        for (int num = 1; num <= 29; num++) {
            int value = findNthNumber(num);
            System.out.println();
            System.out.println(num + " :" + value);
        }
    }

    private static int findNthNumber(int number) {
        number = number - 1;
        // use dequeue
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(3);
        deque.add(4);
        int base = 10;
        for (int index = 0; index < number; index++) {
            int firstValue = deque.pollFirst();

            deque.add(firstValue * base + 3);
            deque.add(firstValue * base + 4);

        }
        return deque.peekFirst();
    }

    // private static int findNthNumber(int number) {
    // // convert number to bin
    // number = number - 1;
    // String binNumber = numberTobin(number);
    // // binary to number
    // number = numberMapping(binNumber);
    // return number;
    // }

    // private static int numberMapping(String binNumber) {
    // int index = 0;
    // int number = 0;
    // int base = 1;
    // System.out.println(binNumber);
    // while (index < binNumber.length()) {
    // char character = binNumber.charAt(index);
    // number = number * base;
    // if (character == '0') // 3
    // {
    // number += 3;
    // } else {
    // number += 4;
    // }
    // base *= 10;
    // index++;
    // }
    // return number;
    // }

    // private static String numberTobin(int number) {
    // return Integer.toBinaryString(number);
    // }
}
