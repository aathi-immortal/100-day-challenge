import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        printPrime(number);
    }

    private static void printPrime(int number) {

        boolean[] marker = new boolean[number + 1];
        System.out.println(marker[0]);
        for (int i = 2; i * i <= number; i++) // uptpo sqrt(number)
        {
            for (int j = i * i; j <= number; j += i) {
                marker[j] = true;
            }
        }
        for (int index = number; index > -1; index--) {
            if (marker[index] == false) {
                System.out.println(index);
                break;
            }
        }
    }

}
