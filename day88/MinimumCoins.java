import java.util.ArrayList;
import java.util.List;

public class MinimumCoins {
    public static List<Integer> minimumCoins(int n) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        List<Integer> minimumCoins = new ArrayList<>();
        int currentCoinIndex = coins.length - 1;

        while (n != 0 && currentCoinIndex > -1) {
            int coin = coins[currentCoinIndex];
            if (n >= coin) {
                int numberOfTimes = n / coin;
                n = n % coin;
                insertCoins(minimumCoins, numberOfTimes, coin);

            }

            currentCoinIndex--;

        }
        return minimumCoins;
    }

    private static void insertCoins(List<Integer> minimumCoins, int numberOfTimes, int coin) {
        for (int time = 0; time < numberOfTimes; time++) {
            minimumCoins.add(coin);
        }
    }
}
