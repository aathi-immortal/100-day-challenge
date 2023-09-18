package day5;

// Test Case 1:

// Input: ‘N’ = 4, ‘arr’ = [3, 1, 2, 4], 'K' = 6

// Output: 2

// Explanation: The subarrays that sum up to '6' are: [3, 1, 2], and [2, 4].

// Test Case 2:

// Input: ‘N’ = 3, ‘arr’ = [1, 2, 3], 'K' = 3

// Output: 2

// Explanation: The subarrays that sum up to '7' are: [1, 2], and [3].

public class CountAllSubArray {
    public static void main(String[] args) {
        int array[] = { 81, 40, 37, 50, 67, 63, 59, 59, 11, 44, 11, 44,
                2, 8 };

        System.out.println(findAllSubarraysWithGivenSum(array, 47));
    }

    public static int moveEndPointer(int end, int[] arr) {
        int sum = 0;
        if (arr.length - 1 != end) {

            sum += arr[++end];

        }
        return sum;

    }

    public static int moveStartPointer(int start, int[] arr) {
        return arr[start];
    }

    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        // tow pointers
        int start = 0;
        int end = 0;
        // tem sum variable keep track of the tem sum in the array
        int sum = arr[0];
        int count = 0;
        while (end < arr.length) {
            if (sum == s) {
                System.out.println(start + " " + end);
                // removin the previous value

                sum -= moveStartPointer(start, arr);

                // add the next value
                sum += moveEndPointer(end, arr);

                start++;
                end++;

                // keep track of number of subArrayObtain
                count++;

            } else if (sum > s) {
                if (start == end) {

                    // removin the previous value
                    sum -= moveStartPointer(start, arr);
                    // add the next value
                    sum += moveEndPointer(end, arr);
                    start++;
                    end++;
                    continue;
                }
                sum -= moveStartPointer(start, arr);
                start++;
            } else {

                sum += moveEndPointer(end, arr);

                end++;
            }
        }

        return count;
    }
}
