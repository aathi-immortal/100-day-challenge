/**
 * TwistedPrime
 */
public class TwistedPrime {
    int isTwistedPrime(int N) {
        // reverse the number
        // isPrime

        int reversedNumber = reverseNumber(N);
        System.out.println();
        System.out.println("value" + reversedNumber);
        return isPrime(reversedNumber);

    }

    private int isPrime(int reversedNumber) {
        for (int divisor = 2; divisor < Math.sqrt(reversedNumber) + 1; divisor++) {
            if (reversedNumber % divisor == 0)
                return 0;
        }
        return 1;
    }

    private int reverseNumber(int n) {

        int reverseNumber = 0;
        int place = 10;
        while (n != 0) {
            reverseNumber = (reverseNumber * place) + (n % 10);

            n = n / 10;
        }
        return reverseNumber;
    }

    public static void main(String[] args) {
        TwistedPrime prime = new TwistedPrime();
        prime.isTwistedPrime(125);
    }
}