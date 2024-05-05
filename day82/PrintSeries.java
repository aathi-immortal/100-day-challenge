import java.util.*;

public class PrintSeries {
    public static List<Integer> printSeries(int n, int k) {
        List<Integer> array = new ArrayList<>();

        rec(n, k, array);
        return array;
    }

    public static void rec(int n, int k, List<Integer> array) {
        if (n <= 0) {
            array.add(n);

            return;
        }

        array.add(n);

        rec(n - k, k, array);
        array.add(n);

    }
}