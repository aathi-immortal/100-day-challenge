public class MergeSort {

    public static void mergeSort(int[] arr, int l, int r) {

        mergeLogic(arr, l, r);
    }

    public static void mergeLogic(int[] arr, int l, int r) {
        if (r - l == 0 || r - l == -1)
            return;
        int mid = ((l + r) / 2);
        mergeLogic(arr, l, mid);
        mergeLogic(arr, mid, r);
        int leftIndex = l;
        int rightIndex = mid;
        while (leftIndex < mid && rightIndex < r) {
            if (arr[leftIndex] > arr[rightIndex]) {
                int tem = arr[rightIndex];
                arr[rightIndex] = arr[leftIndex];
                arr[leftIndex] = tem;
                rightIndex++;
            } else {
                leftIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 5 };
        mergeLogic(arr, 0, 4);
        displayArray(arr);
    }

    private static void displayArray(int[] arr) {
        for (int data : arr) {
            System.out.println(data);
        }
    }
}
