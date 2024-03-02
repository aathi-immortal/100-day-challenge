/**
 * BestTimeToSell
 */
public class BestTimeToSell {

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit2(int[] prices) {
        int minValue = prices[0];
        int maxProfit = -1;
        int profit = 0;
        for (int price : prices) {
            profit = price - minValue;
            if (maxProfit < profit)
                maxProfit = profit;
            if (minValue > price)
                minValue = price;
        }
        return maxProfit;
    }

    // wrong approch
    public static int maxProfit(int[] prices) {

        // choose the buy day
        int buy = prices[0];
        int sell = -1;
        int profit = 0;
        for (int index = 1; index < prices.length; index++) {
            while (buy > prices[index]) {
                buy = prices[index];
                index++;
                if (index == prices.length)
                    return profit;
            }
            while (sell == -1 || sell < prices[index]) {
                sell = prices[index];
                index++;
                if (index == prices.length)
                    break;
            }
            profit += sell - buy;
            buy = prices[index];
            sell = -1;

        }
        return profit;
    }

}