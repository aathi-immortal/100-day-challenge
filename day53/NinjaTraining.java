/**
 * NinjaTraining
 */

public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {

        // O(1) => space complexity
        // O(n*3) => O(n) => time complexity
        // return optimalSolution(points);
        return topToBottom(3, points, n - 1);

    }

    private static int optimalSolution(int[][] points) {
        int n = points.length;
        int[] temArray = { 0, 0, 0 };
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < 3; col++) {
                int maxValue = 0;
                for (int index = 0; index < 3; index++) {
                    int value = 0;
                    // don't pick it
                    if (col == index) {
                        value = temArray[index];
                    } else {
                        value = points[row][col] + temArray[index];
                    }
                    if (value > maxValue)
                        maxValue = value;
                }
                points[row][col] = maxValue;

            }
            load(points, temArray, row);
        }
        return (temArray[0] > temArray[1] && temArray[0] > temArray[2])
                ? temArray[0]
                : (temArray[1] > temArray[2])
                        ? temArray[1]
                        : temArray[2];
    }

    private static void load(int[][] points, int[] temArray, int row) {
        for (int i = 0; i < 3; i++)

        {
            temArray[i] = points[row][i];
        }
       }




    //    basic approch
    // recurson
    static int topToBottom(int last,int[][] points,int n)
    {

        //base condition when day 0 comes we have 2 choice because in the 1 day we choose one we can't choose it 
        // get max of that two event
        if(n == 0)    
        {
            int maxValue = 0;
            for(int i = 0;i<3;i++)
            {
                if(i != last)
                {   
                    maxValue = Math.max(maxValue, points[n ][i]);
                }
            }
            return maxValue;
        }
        int maxValue = 0;
        
        for(int i = 0;i<3;i++)
        {
            if(i != last)
            {
                Math.max(maxValue, points[n][i] + topToBottom(i, points, n - 1));
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[][] point = {

                { 1, 2, 5 },
                { 3, 1, 1 },
                { 3, 3, 3 }
        };
        System.out.println(ninjaTraining(3, point));
    }

}