import java.util.ArrayList;

public class UniquePath2 {
    static int map[][];

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        map = new int[n][m];
        return bottomUp(n, m, mat);
    }

    static int topToBottom(int n, int m, int row, int col, ArrayList<ArrayList<Integer>> mat) {
        if (row == n - 1 || col == m - 1) {
            return 1;
        } else if (row >= n || col >= m || mat.get(row).get(col) == -1) {
            return 0;
        }
        // bottom
        int value = topToBottom(n, m, row + 1, col, mat);
        value += topToBottom(n, m, row, col + 1, mat);
        return value;
        // right
    }

    static int bottomUp(int row, int col, ArrayList<ArrayList<Integer>> mat) {
        map[0][0] = 1;
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                // beyond the cell
                int value = 0;
                if (mat.get(i).get(j) != -1) {
                    if (i - 1 >= 0)
                        value = map[i - 1][j];
                    if (j - 1 >= 0)
                        value += map[i][j - 1];

                    if (i == 0 && j == 0) {
                        value = 1;
                    }
                }

                map[i][j] = value;
            }
        }
        return map[row - 1][col - 1];
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        ArrayList<Integer> arraytem = new ArrayList<>();
        arraytem.add(0);
        arraytem.add(0);
        array.add(arraytem);
        arraytem = new ArrayList<>();
        arraytem.add(0);
        arraytem.add(0);
        array.add(arraytem);
        int value = mazeObstacles(2, 2, array);
        System.out.println(value);
    }
}
