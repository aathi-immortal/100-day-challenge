import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

import io.ArrayIo;

public class MaximumOfSubArrayK {
    static Deque<Integer> deque;
    static ArrayList<Integer> ans;

    static void pushTheMaxIntoAns(int arr[]) {
        ans.add(arr[deque.getFirst()]);
    }

    static void decreaseWindow(int start) {

        if (start == deque.getFirst()) {
            deque.removeFirst();
        }

    }

    static void increaseWindow(int[] arr, int end) {
        // enqueue
        // if dequeu is empty or last value in dequeue is greater than end value
        if (deque.isEmpty() || arr[deque.getLast()] > arr[end]) {
            deque.addLast(end);
        } else {
            deque.removeLast();
            increaseWindow(arr, end);
        }

    }

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        deque = new ArrayDeque<>();
        ans = new ArrayList<>();
        // initial process
        int end = 0;
        int start = 0;
        int maxIndex = -1;
        int max = -1;
        while (end < k) {
            if (max < arr[end]) {
                max = arr[end];
                maxIndex = end;
            }
            end++;
        }
        end--;
        deque.addLast(maxIndex);
        pushTheMaxIntoAns(arr);
        while (end < n - 1) {
            // decrease window from left
            decreaseWindow(start++);

            increaseWindow(arr, ++end);
            pushTheMaxIntoAns(arr);
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            int[] array = ArrayIo.buildArray();
            System.out.println("k value:");
            int k = scan.nextInt();
            ArrayList<Integer> ans = max_of_subarrays(array, array.length, k);
            ArrayIo.printArrayList(ans);
        }

    }
}
