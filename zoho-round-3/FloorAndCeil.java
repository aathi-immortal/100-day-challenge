import java.util.Scanner;

public class FloorAndCeil {

    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("enter the size of array");
            int size = scan.nextInt();
            int array[] = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = scan.nextInt();
            }
            System.out.println("enter the value :");
            int x = scan.nextInt();
            System.out.println("floor " + findFloor(x, array));
            System.out.println("ceil " + findCeil(x, array));
        }

    }

    private static int findCeil(int x, int[] array) {
        int start = 0;
        int end = array.length - 1;
        int ceil = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == x)
                return x;
            else if (array[mid] > x) {
                ceil = array[mid];
            } else
                start = mid + 1;
        }
        return ceil;
    }

    private static int findFloor(int x, int[] array) {
        int start = 0;
        int end = array.length - 1;
        int floor = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == x)
                return x;
            else if (array[mid] < x)
                floor = x;
            else
                end = mid + 1;

        }
        return floor;
    }

    // private static int[] findFloorAndCeil(int x, int[] array) {

    // int floor = Integer.MIN_VALUE;
    // int ceil = Integer.MAX_VALUE;

    // for (int data : array) {
    // if (data < x && data > floor) {
    // floor = data;
    // }
    // if (data > x && data < ceil)
    // ceil = data;
    // }
    // floor = floor == Integer.MIN_VALUE ? -1 : floor;
    // ceil = ceil == Integer.MAX_VALUE ? -1 : ceil;
    // int[] arr = { floor, ceil };
    // return arr;

    // }

}
