package day8;

import java.util.ArrayList;

public class FindPeakElement {
    public static int findPeakElement(ArrayList<Integer> arr) {
        if (arr.size() == 1)
            return 0;
        int i = 0;

        while (arr.size() > i) {
            if ((i != 0 && arr.get(i - 1) > arr.get(i)) || (i != arr.size() - 1 && arr.get(i + 1) > arr.get(i))) {
                i++;
                continue;

            } else
                return i;

        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
