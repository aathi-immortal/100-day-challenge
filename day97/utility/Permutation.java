package utility;

import java.util.ArrayList;

/**
 * Permutation
 */
public class Permutation {

    static ArrayList<Long> permutationarray;

    public static ArrayList<Long> getPermutation(ArrayList<Long> arrayList) {
        permutationarray = new ArrayList<>();
        permutation(arrayList, 0);
        return permutationarray;
    }

    private static void permutation(ArrayList<Long> array, int currentIndex) {

        if (currentIndex >= array.size()) {
            permutationarray.add(Arrayconvertor.arrayToLong(array));
            return;
        }

        // traverse form current index to end of the index
        int pointerTwo = currentIndex;
        while (pointerTwo < array.size()) {

            ArrayList<Long> temArrayList = new ArrayList<>(array);
            // swap it
            long currenValue = temArrayList.get(currentIndex);
            long pointerTwoValue = temArrayList.get(pointerTwo);

            temArrayList.set(currentIndex, pointerTwoValue);
            temArrayList.set(pointerTwo, currenValue);
            pointerTwo++;

            // call the function
            permutation(temArrayList, currentIndex + 1);

        }
    }

}