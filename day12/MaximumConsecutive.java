package day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import io.ArrayIo;

public class MaximumConsecutive {
    static Queue<Integer> queue = new LinkedList<>();
    static int start;
    static int end;
    static int portion;

    public static void incrementPortion(int k) {
        if (portion < k)
            portion++;
    }

    public static int findTheOne(ArrayList<Integer> arr) {
        int i = end;
        while (i < arr.size()) {
            if (arr.get(i) == 1) {
                start = i;
                end = i;
                return 1;
            }
            i++;
        }
        return -1;
    }

    public static int longestSubSeg(ArrayList<Integer> arr, int n, int k) {
        start = 0;
        end = 0;
        portion = k;
        int max = 0;

        while (end < n && start < n) {
            // we have a magic portion that will convert the zero to 1
            if (arr.get(end) == 0 && portion != 0) {
                queue.add(end);
                portion--;
            }
            // we have no more portion
            // change the start
            else if (arr.get(end) == 0) {
                if (queue.size() == 0) {
                    if (findTheOne(arr) == -1) {
                        break;
                    }
                } else {
                    start = queue.peek() + 1;
                    queue.remove();
                    incrementPortion(k);
                    continue;
                }

            }
            // calculating the max value
            if (max < (end - start + 1)) {
                max = end - start + 1;
            }
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("portion");
            int k = scan.nextInt();
            ArrayList<Integer> arr = ArrayIo.buildArrayList();

            int value = longestSubSeg(arr, arr.size(), k);
            System.out.println(value);

        }

    }
}
