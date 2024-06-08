import java.util.ArrayList;
import java.util.Arrays;

import utility.*;

public class NextGreaterEvenELement {

    public static void main(String[] args) {

        long number = getNextGreaterEvenNumber(34722641);
        System.out.println();
        System.out.println("answeris :" + number);

    }

    private static long getNextGreaterEvenNumber(long number) {
        ArrayList<Long> permutationarray;

        // number to Array
        ArrayList<Long> array = Arrayconvertor.longToArray(number);
        // printArrayOfArray(array);
        // get the permutation
        permutationarray = Permutation.getPermutation(array);
        // printArrayOfArray(permutationarray);
        // getMinimumEventFrom it
        return getMinimumEven(permutationarray, number);

    }

    private static long getMinimumEven(ArrayList<Long> permutationarray, Long number) {

        long temMin = 1000000000 + 1;
        // first number is even
        // second number must be greater than number
        // third number should be less than temMinNumber;
        for (Long data : permutationarray) {
            if (data % 2 == 0 && data > number && data < temMin) {
                temMin = data;

            }
        }
        if (temMin == 1000000000 + 1)
            return -1;
        return temMin;

    }

    public static <T> void printArrayOfArray(ArrayList<T> array) {

        System.out.println();
        for (T data : array) {

            System.out.println(data);

        }
    }

}
