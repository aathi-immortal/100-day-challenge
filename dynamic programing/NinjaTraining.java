public class NinjaTraining {

    static int arr[][];

    public static int ninjaTraining(int n, int points[][]) {
        arr = new int[n + 1][6];
        return recSol(0, n, points, 5);
    }

    private static int recSol(int currentDay, int totalDays, int[][] points, int previous) {

        int running = 0;
        int fighting = 0;
        int moves = 0;
        if (currentDay == totalDays) {
            return 0;
        }

        if (previous != 0) {
            // running
            int nextDay = 0;
            if (previous != -1 && arr[currentDay + 1][previous] != 0)
                nextDay = arr[currentDay + 1][previous];
            else {
                nextDay = recSol(currentDay + 1, totalDays, points, 0);
                arr[currentDay + 1][previous] = nextDay;
            }
            running = points[currentDay][0] + nextDay;
        }
        if (previous != 1) {
            int nextDay = 0;
            if (previous != -1 && arr[currentDay + 1][previous] != 0)
                nextDay = arr[currentDay + 1][previous];
            else {
                nextDay = recSol(currentDay + 1, totalDays, points, 1);
                arr[currentDay + 1][previous] = nextDay;
            }
            fighting = points[currentDay][1] + nextDay;
        }
        if (previous != 2) {
            int nextDay = 0;
            if (previous != -1 && arr[currentDay + 1][previous] != 0)
                nextDay = arr[currentDay + 1][previous];
            else {
                nextDay = recSol(currentDay + 1, totalDays, points, 2);
                arr[currentDay + 1][previous] = nextDay;
            }
            moves = points[currentDay][2] + nextDay;
        }
        return running > fighting && running > moves
                ? running
                : fighting > moves
                        ? fighting
                        : moves;

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 5 },
                { 3, 1, 1 },
                { 3, 3, 3 } };
        int result = NinjaTraining.ninjaTraining(3, arr);
        System.out.println();
        System.out.println("result");

        System.out.println(result);
    }
}

// 4

// 1 2 5 3 1 1 3 3 3
// 3
// 10 40 70
// 20 50 80
// 30 60 90

// 3
// 18 11 19
// 4 13 7
// 1 8 13
// 2
// 10 50 1
// 5 100 11
