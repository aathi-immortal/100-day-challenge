import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * LargestNumberformedfromanArray
 */

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String numberOne, String numberTwo) {

        Integer numberOneDigit = Integer.parseInt(String.valueOf(numberOne.charAt(0)));
        Integer numberTwoDigit = Integer.parseInt(String.valueOf(numberTwo.charAt(0)));

        if (numberOneDigit < numberTwoDigit)
            return 1;
        else if (numberOneDigit > numberTwoDigit)
            return -1;
        return equalComparator(numberOne, numberTwo);
        // return numberOneDigit.compareTo(numberTwoDigit);

    }

    private int equalComparator(String numberOne, String numberTwo) {
        Integer numberOneDigit;
        Integer numberTwoDigit;

        // 3 == 3
        if (numberOne.length() == numberTwo.length()) {
            numberOneDigit = Integer.parseInt(numberOne);
            numberTwoDigit = Integer.parseInt(numberTwo);
            return numberOneDigit == numberTwoDigit ? 0 : (numberOneDigit > numberTwoDigit) ? -1 : 1;
        }

        // 3 and 30
        if (numberOne.length() < numberTwo.length()) {
            int indexTwo = 0;
            int indexOne = 0;

            while (indexTwo < numberTwo.length()) {
                numberOneDigit = Integer.parseInt(String.valueOf(numberOne.charAt(indexOne)));
                numberTwoDigit = Integer.parseInt(String.valueOf(numberTwo.charAt(indexTwo)));
                if (numberOneDigit < numberTwoDigit) {
                    return 1;
                } else if (numberOneDigit > numberTwoDigit)
                    return -1;
                else {
                    indexOne++;
                    if (indexOne == numberOne.length())
                        indexOne--;
                }
                indexTwo++;
            }
            return 0;

        }
        // 30 , 3
        else {
            int indexOne = 0;
            int indexTwo = 0;

            while (indexOne < numberOne.length()) {
                numberTwoDigit = Integer.parseInt(String.valueOf(numberTwo.charAt(indexTwo)));
                numberOneDigit = Integer.parseInt(String.valueOf(numberOne.charAt(indexOne)));
                if (numberOneDigit < numberTwoDigit) {
                    return 1;
                } else if (numberOneDigit > numberTwoDigit)
                    return -1;
                else {
                    indexTwo++;
                    if (indexTwo == numberTwo.length())
                        indexTwo--;
                }
                indexOne++;
            }
            return 0;
        }

    }

}

public class LargestNumberformedfromanArray {

    String printLargest(int n, String[] arr) {
        Arrays.sort(arr, new StringComparator());
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : arr) {
            stringBuilder.append(string);
        }
        // System.out.println();
        // System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    // public static void main(String[] args) {
    //     LargestNumberformedfromanArray largestNumberformedfromanArray = new LargestNumberformedfromanArray();

    //     // String[] arr = { "54", "546", "548", "60" };
    //     String[] arr = { "3", "30", "34", "5", "9" };
    //     largestNumberformedfromanArray.printLargest(5, arr);

    // }

}

// 6054854654
// 6054854654