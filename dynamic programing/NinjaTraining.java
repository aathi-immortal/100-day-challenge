public class NinjaTraining {

    static int arr[][];

    public static int ninjaTraining(int n, int points[][]) {
        arr = new int[n][3];
        return recSol(0, n, points, -1);
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
            running = points[currentDay][0] + recSol(currentDay + 1, totalDays, points, 0);
        }
        if (previous != 1) {
            fighting = points[currentDay][1] + recSol(currentDay + 1, totalDays, points, 1);
        }
        if (previous != 2) {
            moves = points[currentDay][2] + recSol(currentDay + 1, totalDays, points, 2);
        }
        int status = running > fighting && running > moves
                ? 0
                : fighting > moves
                        ? 1
                        : 2;
        arr[currentDay][status] = status == 0
                ? running
                : status == 1
                        ? fighting
                        : moves;
        return arr[currentDay][status];
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 5 },
                { 3, 1, 1 },
                { 3, 3, 3 } };
        int result = NinjaTraining.ninjaTraining(3, arr);
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
