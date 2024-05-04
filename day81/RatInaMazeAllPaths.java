import java.util.ArrayList;

public class RatInaMazeAllPaths {
    static ArrayList<ArrayList<Integer>> ans;

    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tem = new ArrayList<>();
        findAllPath(n, maze, 0, 0, tem);
        return createPathMatrix(ans,n);
    }

    

    private static ArrayList<ArrayList<Integer>> createPathMatrix(ArrayList<ArrayList<Integer>> ans,int n) {
        ArrayList<ArrayList<Integer>> pathMatrix = new ArrayList<>();
        createEmptyMatrix(pathMatrix,n);
        for(ArrayList<Integer> cell : ans)
        {
            int row = cell.get(0);
            int col = cell.get(1);
            pathMatrix.get(row).set(col, 1);
        }
        return pathMatrix;
    }



    private static void createEmptyMatrix(ArrayList<ArrayList<Integer>> pathMatrix,int n) {
            for(int row = 0;row < n;row++)
            {
                ArrayList<Integer> tem = new ArrayList<>();
                for(int col = 0;col < n;col++)
                {
                        tem.add(0);
                    
                }
                pathMatrix.add(tem);
            }
    }   



    private static void findAllPath(int n, int[][] maze, int row, int col, ArrayList<ArrayList<Integer>> tem) {
        pushToTem(tem, row, col);
        if (maze[row][col] == 0)
            return;
        if (row == n - 1 && col == n - 1) {
            loadTemToAnsArray(ans,tem);
        }
        if(row < n)
        {
            findAllPath(n, maze, row + 1, col , tem);
        }
        if(col < n)
        {
            findAllPath(n, maze, row, col + 1, tem);
        }
        tem.remove(tem.size() - 1);
    }

    private static void loadTemToAnsArray(ArrayList<ArrayList<Integer>> ans, ArrayList<ArrayList<Integer>> tem) {
            for(ArrayList<Integer> cell : tem)
            {
                ans.add(cell);
            }
    }

    private static void pushToTem(ArrayList<ArrayList<Integer>> tem, int row, int col) {
        ArrayList<Integer> cell = new ArrayList<>();
        cell.add(row);
        cell.add(col);
        tem.add(cell);
    }
}
