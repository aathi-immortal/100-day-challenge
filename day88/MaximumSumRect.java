import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class MaxSubArrayStatus {
    int start;
    int end;
    int maxValue;

    public MaxSubArrayStatus(int start, int end, int maxValue) {
        this.start = start;
        this.end = end;
        this.maxValue = maxValue;
    }

}

public class MaximumSumRect {
    public static void main(String[] args) {
        ArrayList<Integer> ans =new ArrayList<>();
        
        // Set<Integer> set = new HashSet<>();
        // set.add(20);
        int[] as = { 1, 2 };
        as[9] = 23;
        // for (int data : set) {

        // }
        // int[][] nums = { { 17 }, { -10 }, { 8 }, { -27 } };
        // int value = maxSumRectangle(nums, 4, 1);
        // System.out.println("");
        // System.err.println("ans " + value);

    }

    public static int maxSumRectangle(int[][] arr, int n, int m) {

        int left = 0;
        int right = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int maxTop = 0;
        int maxBottom = 0;
        int currentSum = 0;
        int maxSum = -1000000;
        int tem[];

        for (; left < m; left++) {
            tem = new int[n];
            for (right = left; right < m; right++) {
                addArray(tem, arr, right);
                MaxSubArrayStatus maxSubArrayStatus = maxSubArray(tem);
                if (maxSubArrayStatus.maxValue > maxSum) {
                    maxLeft = left;
                    maxRight = right;
                    maxTop = maxSubArrayStatus.start;
                    maxBottom = maxSubArrayStatus.end;
                    maxSum = maxSubArrayStatus.maxValue;
                }
            }
        }
        return maxSum;
    }

    private static void addArray(int[] tem, int[][] arr, int col) {
        for (int index = 0; index < tem.length; index++) {
            tem[index] += arr[index][col];
        }
    }

    public static MaxSubArrayStatus maxSubArray(int[] nums) {

        int start = 0;
        int current = 0;
        int maxSum = -1000000;
        int maxStart = 0;
        int maxEnd = 0;
        int currentSum = 0;
        while (current < nums.length) {
            currentSum += nums[current];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStart = start;
                maxEnd = current;

            }
            current++;
            if (currentSum < 0) {
                currentSum = 0;

                start = current;

            }

        }

        return new MaxSubArrayStatus(maxStart, maxEnd, maxSum);

    }

    public int[] common_digits(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int index = 0;

        for (int data : nums) {
            splitNumber(data, map);
        }
        int[] ans = new int[map.size()];
        for(int data :ans)
        {

        }
        for (int data : map.keySet()) {
            ans[index++] = data;
        }
        Arrays.sort(ans);
        return ans;
    }

    private void splitNumber(int data, HashMap<Integer, Integer> set) {
        while (data != 0) {
            int lastDigit = data % 10;
            if (!set.containsKey(lastDigit))
                set.put(lastDigit, 1);
            data = data / 10;
        }
    }
}

// 5
// 4 1

// 17
// -10
// 8
// -27

// 3 1
// 19
// -3
// 18
// 5 2
// -16 23
// -18 23
// -21 -24
// -20 -11
// -30 5
// 5 4
// -29 -10 -30 21
// -1 29 -5 6
// -29 9 1 29
// 22 7 -12 8
// -11 9 27 -12
// 1 2
// 10 21
