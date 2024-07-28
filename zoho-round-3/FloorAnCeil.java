import java.util.Scanner;

public class FloorAnCeil {

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
            findFloorAndCeil(x, array);
        }

    }

    private static int[] findFloorAndCeil(int x, int[] array) {

        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        for (int data : array) {
            if (data < x && data > floor) {
                floor = data;
            }
            if (data > x && data < ceil)
                ceil = data;
        }
        floor = floor == Integer.MIN_VALUE ? -1 : floor;
        ceil = ceil == Integer.MAX_VALUE ? -1 : ceil;
        int[] arr = { floor, ceil };
        return arr;

    }

}
