import java.util.ArrayList;

public class MoveZero {
    public static void pushZerosAtEnd(ArrayList<Integer> arr) {
        int zeroCount = 0;
        // traverse the array
        for (int index = 0; index < arr.size(); index++) {
            int currentValue = arr.get(index);
            if (currentValue == 0) {
                zeroCount++;
            } else {
                arr.set(index - zeroCount, currentValue);
            }

        }
        // set zeros
        for (int index = 0; index < zeroCount; index++) {
            int base = arr.size() - zeroCount;
            arr.set(base + index, 0);
        }
    }
}