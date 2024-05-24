import java.util.ArrayList;
import java.util.HashMap;

/**
 * InnerRatInMaze
 */
class Cell {
    int row;
    int col;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class RatStatus {

    int row;
    int col;
    ArrayList<String> paths;

    RatStatus() {
        paths = new ArrayList<>();
    }

}

class Trackers {
    int[][] map;
    ArrayList<Character> pathInString;

    Trackers(int n) {
        map = new int[n][n];
        pathInString = new ArrayList<>();
    }
}

public class RatInMaze {

    public static ArrayList<String> findPath(int[][] m, int n) {

        RatStatus rat = new RatStatus();

        Trackers trackers = new Trackers(n);
        travel(m, n, trackers, rat);
        trackers.pathInString.remove(trackers.pathInString.size() - 1);
        return rat.paths;
    }

    private static void travel(int[][] m, int n, Trackers trackers, RatStatus rat) {

        int row = rat.row;
        int col = rat.col;
        // base case

        // destination
        if (row == n - 1 && col == n - 1) {
            rat.paths.add(trackers.pathInString.toString());
            trackers.map[row][col] = 0;
            return;
        }

        // move down
        // if not a last row we can move down
        if (row != n - 1 && m[row + 1][col] == 1 && isNotVisited(trackers, row + 1, col)) {
            trackers.pathInString.add('D');
            trackers.map[row + 1][col] = 1;
            rat.row++;
            travel(m, n, trackers, rat);
        }
        // move left
        if (col != 0 && m[row][col - 1] == 1 && isNotVisited(trackers, row, col - 1)) {
            trackers.pathInString.add('L');
            trackers.map[row][col - 1] = 1;
            rat.col--;
            travel(m, n, trackers, rat);
        }
        // move right
        if (col != n - 1 && m[row][col + 1] == 1 && isNotVisited(trackers, row, col + 1)) {
            trackers.pathInString.add('R');
            trackers.map[row][col + 1] = 1;
            rat.col++;
            travel(m, n, trackers, rat);
        }
        // move up
        if (row != 0 && m[row - 1][col] == 1 && isNotVisited(trackers, row - 1, col)) {
            trackers.pathInString.add('U');
            trackers.map[row - 1][col] = 1;
            rat.row--;
            travel(m, n, trackers, rat);
        }

        // remove current cell
        trackers.map[row][col] = 0;
        if (trackers.pathInString.size() != 0)
            trackers.pathInString.remove(trackers.pathInString.size() - 1);

    }

    private static boolean isNotVisited(Trackers trackers, int row, int col) {
        return trackers.map[row][col] == 0;
    }

    public static void main(String[] args) {

        int[][] m = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
        ArrayList<String> ans = findPath(m, 4);
        System.out.println("paths");
        for (String path : ans) {
            System.out.println("path " + path);
        }
    }

}