public class IsSquare {
    static String isSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // code here
        // load all into array
        int x[] = { x1, x2, x3, x4 };
        int y[] = { y1, y2, y3, y4 };

        // check pair are there
        if (isPaired(x) && isPaired(y))
            return "Yes";
        return "No";

    }

    private static boolean isPaired(int[] x) {
        int result = 0;
        for (int data : x) {
            result ^= data;
        }
        return result == 0 ? !isAllSame(x) : false;
    }

    private static boolean isAllSame(int[] x) {

        return (x[0] == x[1] && x[1] == x[2]) ? true : false;
    }

}
