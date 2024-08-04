public class Day2Pattern {

    public static void main(String[] args) {
        System.out.println();
        printPattern(3);
    }

    private static void printPattern(int n) {
        int head = 1;
        int decrement = 0;
        for (int row = 0; row < n; row++) {
            printSpace(n - row - 1);
            int currentValue = head;
            decrement = n - row;
            for (int col = 0; col < (row + 1); col++) {
                System.out.print(currentValue + " ");
                currentValue -= decrement;
                decrement += 1;
            }
            System.out.println();
            head = head + n - row;
        }
    }

    private static void printSpace(int time) {
        for (int i = 0; i < time; i++) {
            System.out.print("  ");
        }
    }

}
