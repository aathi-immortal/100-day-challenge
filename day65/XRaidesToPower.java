public class XRaidesToPower {

    public static double myPow(double x, int n) {
        return recursion(x, n);
    }

    private static double recursion(double x, int n) {

        if (n == 1) {
            return x;
        }
        // case 1 if the n is even
        if (n % 2 == 0) {
            // left side
            return recursion(x, n / 2) * recursion(x, n / 2);
        }
        // cases 2 if the n is odd
        else
            return recursion(x, n / 2) * recursion(x, n / 2) * x;

    }

    public static void main(String[] args) {
        double value = myPow(5, 5);
        System.out.println(value);
    }

}
