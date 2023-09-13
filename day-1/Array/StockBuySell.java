import java.util.Stack;

public class StockBuySell {
    static Stack<Integer> stack;

    static void loadTheStack(int[] arr) {

        stack.push(arr[arr.length - 1]);

        for (int i = arr.length - 2; i > -1; i--) {
            
            if (stack.peek() <= arr[i]) {
                stack.push(arr[i]);
            }

        }
    }

    public static int bestTimeToBuyAndSellStock(int[] prices) {
        stack = new Stack<>();
        // load the stack based on max prize from last to start
        loadTheStack(prices);
        int max = 0;
        // main logic
        for (int i = 0; i < prices.length; i++) {
            int profit = stack.peek() - prices[i];
            if (stack.peek() == prices[i]) {
                stack.pop();
            }
            if (profit > max) {
                max = profit;
            }
        }
        return max;
    }
}
