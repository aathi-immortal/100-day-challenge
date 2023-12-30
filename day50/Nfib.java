import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Nfib {
    static Map<Integer, Integer> map;

    public static void main(String[] args) {

        /*
         * Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */
        map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int nthValue = scan.nextInt();
        int value = fibRecursion(nthValue);
        value = fibMemozization(nthValue);
        System.out.println(value);
    }

    private static int fibMemozization(int nthValue) {
        if (nthValue == 2 || nthValue == 1)
            return 1;

        int firstIndex = nthValue - 1;
        int secondIndex = nthValue - 2;
        int firstValue;
        int secondValue;

        if (!map.containsKey(firstIndex)) {
            firstValue= fibMemozization(firstIndex);
            map.put(firstIndex, firstValue);

        } else
            firstValue = map.get(firstIndex);
        if (!map.containsKey(secondIndex)) {

            secondValue = fibMemozization(secondIndex);
            map.put(secondIndex, secondValue);
        } else
            secondValue = map.get(secondIndex);

        return firstValue + secondValue;
    }

    private static int fibRecursion(int nthValue) {
        if (nthValue == 1 || nthValue == 0)
            return 1;
        return fibRecursion(nthValue - 1) + fibRecursion(nthValue - 2);
    }

}
