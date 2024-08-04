public class EvenOdd {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[][] evenOdd = getEvenOddArray(arr);
        System.out.println("even");
        printArray(evenOdd[0], evenOdd[2][0]);
        System.out.println("odd");
        printArray(evenOdd[1], evenOdd[2][1]);
    }

    private static void printArray(int[] arr, int size) {
        for (int data : arr) {

            System.out.print(data + " ");
        }
    }

    private static int[][] getEvenOddArray(int[] arr) {
        int[] evenArray = new int[arr.length];
        int[] oddArray = new int[arr.length];
        int evenIndex = 0;
        int oddIndex = 0;
        for (int data : arr) {

            if (data % 2 == 0) {
                evenArray[evenIndex++] = data;
            } else {
                oddArray[oddIndex++] = data;
            }
        }
        int[][] result = { evenArray, oddArray, { evenIndex, oddIndex } };
        return result;
    }
}
