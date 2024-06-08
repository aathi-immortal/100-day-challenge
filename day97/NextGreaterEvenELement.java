import java.util.ArrayList;
import java.util.Arrays;

import utility.*;

public class NextGreaterEvenELement {

    public static void main(String[] args) {

        long number = getNextGreaterEvenNumber(111);
        System.out.println();
        System.out.println("answeris :" + number);

    }

    private static long getNextGreaterEvenNumber(long number) {

        long nextPermutationNumber = 0;
        while (nextPermutationNumber != -1) {
            nextPermutationNumber = getNextPermutation(number);
            if (nextPermutationNumber % 2 == 0)
                return nextPermutationNumber;
            number = nextPermutationNumber;
        }

        return -1;

    }

    private static long getNextPermutation(long number) {
        // convert the number to array
        // traverse from the last
        // find the break point
        // get the maximum minimum value
        // swap it
        // reverse the right side of break point
        ArrayList<Long> numberInArray = Arrayconvertor.longToArray(number);
        int index = numberInArray.size() - 1;

        for (; index > 0; index--) {
            long currentValue = numberInArray.get(index);
            long nextValue = numberInArray.get(index - 1);
            if (currentValue > nextValue) {
                // break point
                // swap it
                swapWithMinMax(index - 1, numberInArray);

                reverseArray(index, numberInArray);
                return Arrayconvertor.arrayToLong(numberInArray);
            }
        }
        return -1;

    }

    private static void swapWithMinMax(int nextValueIndex, ArrayList<Long> numberInArray) {
        long nextValue = numberInArray.get(nextValueIndex);
        int index = numberInArray.size() - 1;
        for (; index > -1; index--) {
            long currentValue = numberInArray.get(index);
            if (currentValue > nextValue) {
                numberInArray.set(index, nextValue);
                numberInArray.set(nextValueIndex, currentValue);
                break;
            }
        }

    }

    private static void reverseArray(int index, ArrayList<Long> numberInArray) {
        int last = numberInArray.size() - 1;
        while (index < last) {
            long currentValue = numberInArray.get(index);
            long lastValue = numberInArray.get(last);
            numberInArray.set(index, lastValue);
            numberInArray.set(last, currentValue);
            index++;
            last--;
        }
    }

    public static <T> void printArrayOfArray(ArrayList<T> array) {

        System.out.println();
        for (T data : array) {

            System.out.println(data);

        }
    }

}
