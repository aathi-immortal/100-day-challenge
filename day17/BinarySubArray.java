package day17;

import java.util.Scanner;

import io.ArrayIo;

public class BinarySubArray {
    static int arr[];
    static int goal;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arr = ArrayIo.buildArray();
        goal = scan.nextInt();
        int solution = numSubarraysWithSum(arr, goal);
        System.out.println(solution);

    }

    //exactly(n) = atleast(n) - atleast(n - 1)
    public static int numSubarraysWithSum(int[] nums, int goal) {

        if (goal == 0) {
            return atmostGoal(goal);
        }
        return atmostGoal(goal) - atmostGoal(goal - 1);
    }

    private static int atmostGoal(int goal) {
        int head = 0;
        int end = 0;
        int sum = 0;
        int size = 0;
        while (head < arr.length) {
            sum += arr[head++];
            while (sum > goal) {
                sum -= arr[end];
                end++;
            }
            size += (head - end + 1);
        }
        return size;
    }
}
