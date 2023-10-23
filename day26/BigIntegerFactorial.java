import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();
        System.out.println(computeFactorial(value));
    }

    public static BigInteger computeFactorial(int limit) {
        BigInteger ans = new BigInteger("1");
        for (int i = 1; i <= limit; i++) {
            ans = ans.multiply(new BigInteger(i + ""));

        }
        return ans;

    }
}
