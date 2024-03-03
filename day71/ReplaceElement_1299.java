import java.util.Stack;

public class ReplaceElement_1299 {

    public static void main(String[] args) {

    }

    public int[] replaceElements(int[] arr) {
        // create a max stack
        replaceElementsOptimal(arr);
        return arr;

    }

    public void replaceElementsOptimal(int arr[]) {

        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int index = arr.length - 2; index > -1; index--) {
            int tem = max;
            if (max < arr[index]) {
                max = arr[index];
            }
            arr[index] = tem;
        }
        // garbage collector
        // System.gc();

    }

    public void bruteForce(int[] arr) {
        Stack<Integer> stack;
        stack = loadStack(arr);
        for (int index = 0; index < arr.length; index++) {
            int data = arr[index];
            if (data == stack.peek()) {
                stack.pop();
            }
            if (stack.empty()) {
                arr[index] = -1;
            }
            arr[index] = stack.peek();
        }

    }

    private Stack<Integer> loadStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length - 1]);
        for (int index = arr.length - 2; index > -1; index--) {
            if (stack.peek() <= arr[index]) {
                stack.push(arr[index]);
            }
        }
        return stack;
    }
}
