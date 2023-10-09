package day17;

import java.util.Scanner;

import io.ArrayIo;

public class OddSubarray {
    static int arr[];
    static int goal;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arr = ArrayIo.buildArray();
        goal = scan.nextInt();
        int solution = numSubarraysWithSum(arr, goal);
        System.out.println(solution);

    }

    // exactly(n) = atleast(n) - atleast(n - 1)
    public static int numSubarraysWithSum(int[] nums, int goal) {

        if (goal == 0) {
            return atmostGoal(goal);
        }
        return atmostGoal(goal) - atmostGoal(goal - 1);
    }

    private static int atmostGoal(int goal) {
        int head = 0;
        int end = 0;
        int numberOfOdd = 0;
        int size = 0;
        while (head < arr.length) {
            if (arr[head] % 2 == 1) {
                numberOfOdd += 1;
            }

            head++;
            // if we have more odd than limit this loop will try to remove all odd value
            // from the end to head until
            // we reach the limit number of odd
            while (numberOfOdd > goal) {
                if (arr[end] % 2 == 1) {
                    numberOfOdd -= 1;

                }

                end++;

            }

            size += (head - end + 1);
        }
        return size;
    }
}
