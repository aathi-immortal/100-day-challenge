import java.util.*;

public class NextGreaterPermutation {
    public static List<Integer> nextGreaterPermutation(List<Integer> A) {
        return optimal(A);
    }

    private static List<Integer> optimal(List<Integer> a) {
        ArrayList<Integer> temArray = new ArrayList<>();
        // find the peak point
        int i;
        for (i = a.size() - 1; i >= 0; i--) {

            // if we found the peak stop the loop
            if (a.get(i) > a.get(i - 1)) {
                // swap the place
                temArray.add(a.get(i - 1));
                int tem = a.get(i);
                a.set(i, a.get(-1));
                a.set(i - 1, tem);
                break;
            }
            temArray.add(a.get(i));
        }
        Collections.sort(temArray);
        int j = 0;
        for (int index = i + 1; i < a.size(); i++) {
            a.set(index, temArray.get(j++));
        }
        return temArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(3);
        array.add(1);
        array.add(2);
        nextGreaterPermutation(array);
    }
}