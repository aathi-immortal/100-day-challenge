import java.util.Stack;

public class nextGreaterElement {

    static Stack<Long> stack;

    public static long[] nextLargerElement(long[] arr, int n) {

        long[] resultArray = new long[n];
        stack = new Stack<>();
        // traverse the array from the last
        int index = n - 1;
        for (; index > -1; index--) {
            long data = arr[index];
            // get the value from the stack
            resultArray[index] = getStackedValue(data);
            // insert the current value into the stack
            stack.push(data);
        }
        return resultArray;
    }

    private static long getStackedValue(long data) {
        while (!stack.empty()) {
            long topValue = stack.peek();
            // data is less than topValue push it into the stack and return the topValue
            if (data < topValue) {

                return topValue;
            }
            stack.pop();
        }
        return -1;
    }

    public static void main(String[] args) {
        long[] arr = { 1, 3, 2, 4 };
        nextLargerElement(arr, 4);
    }
}
