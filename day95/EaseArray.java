/**
 * EaseArray
 */
public class EaseArray {

    void modifyAndRearrangeArr(int arr[], int n) {

        doubleValidNUmber(arr);
        bringZeroEnd(arr);
    }

    private void bringZeroEnd(int[] arr) {
        int zeroCount = 0;
        int index = 0;
        while (index < arr.length) {
            int currentValue = arr[index];
            if (currentValue == 0) {
                zeroCount++;
            } else if (zeroCount != 0)
                swap(arr, index, zeroCount);

            index++;
        }
    }

    private void swap(int[] arr, int index, int zeroCount) {
        arr[index - zeroCount] = arr[index];
        arr[index] = 0;
    }

    private void doubleValidNUmber(int[] arr) {

        int index = 0;

        while (index < arr.length - 1) {
            int currentValue = arr[index];
            int nextValue = arr[index + 1];
            if (currentValue != 0 && currentValue == nextValue) {
                arr[index] = arr[index] * 2;
                arr[index + 1] = 0;
            }
            index++;
        }

    }
}
