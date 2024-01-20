public class MinimumElement {

    static int map[][];

    public static int minimumElements(int num[], int x) {

        int n = num.length - 1;
        map = new int[n + 1][x + 1];
        // return topDown(num, x, n);
        return bottomUp(num,x,n + 1);
    }

    private static int bottomUp(int[] num, int x, int n) {
        int[][] map = new int[n][x + 1];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<=x;j++)
            {
                map[i][j] = -1;
            }
        }
        for(int i = 0;i<n;i++)
        {
            map[i][0] = 0;
        }
        for(int index = 1;index <= n;index++)
        {
            for(int target = 0;target <= x;target++)
            {
                int pick = -1;
                if (num[index] <= target)
                    pick = map[index][target - num[index]];
                int notPick = map[index - 1][target];
                int result;
                if (pick == -1 && notPick == -1)
                    result = -1;
                else if (pick == -1)
                    result = notPick;
                else if (notPick == -1)
                    result = pick + 1;
                else
                    result = Math.min(pick + 1, notPick);
        
                map[index][target] = result;        
            }
        }
        return map[n][x];

    }

    private static int topDown(int[] num, int x, int n) {
        if (x == 0)
            return 0;
        else if (n < 0 || x < 0) {
            return -1;
        } else if (map[n][x] != 0)
            return map[n][x];

        int pick = -1;
        if (num[n] <= x)
            pick = topDown(num, x - num[n], n);
        int notPick = topDown(num, x, n - 1);
        int result;
        if (pick == -1 && notPick == -1)
            result = -1;
        else if (pick == -1)
            result = notPick;
        else if (notPick == -1)
            result = pick + 1;
        else
            result = Math.min(pick + 1, notPick);

        map[n][x] = result;
        return result;
    }
}
