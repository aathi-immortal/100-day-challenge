
public class FamilTree {
    public static String kthChildNthGeneration(int n, long k) {

        if (rec(n, k))
            return "male";
        return "female";

    }

    private static boolean

            rec(int n, long k) {
        if (n == 1)
            return true;
        if (k % 2 == 0) {
            // second child
            return !rec(n - 1, k / 2);

        }
        return rec(n - 1, (k + 1) / 2);

    }

    public static void main(String[] args) {
        System.out.println(kthChildNthGeneration(3, 02));
    }

}