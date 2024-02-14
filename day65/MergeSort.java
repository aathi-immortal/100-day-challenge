/**
 * MergeSort
 */
public class MergeSort {
    static int count;

    static int[] mergeSort(int[] array) {
        // base case
        if (array.length == 1) {
            return array;
        }
        // find the mid value
        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        System.arraycopy(array, 0, leftArray, 0, mid);
        leftArray = mergeSort(leftArray);
        int[] rightArray = new int[array.length % 2 == 0 ? mid : mid + 1];
        System.arraycopy(array, mid, rightArray, 0, rightArray.length);
        rightArray = mergeSort(rightArray);

        // logic
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                array[index] = leftArray[leftIndex++];

            } else {
                array[index] = rightArray[rightIndex++];
                count += leftArray.length - leftIndex;
            }
            index++;
        }
        while (leftIndex < leftArray.length) {
            array[index++] = leftArray[leftIndex++];

        }
        while (rightIndex < rightArray.length) {
            array[index++] = rightArray[rightIndex++];
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {
                52244275, 123047899, 493394237, 922363607, 378906890, 188674257, 222477309, 902683641, 860884025,
                339100162
        };
        count = 0;
        mergeSort(array);
        System.out.println(count);
    }

    private static void display(int[] mergeSort) {
        for (int data : mergeSort) {
            System.out.print(data + " ");
        }
    }
}