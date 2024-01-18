public class MinSubset {
    static int maxValue;
    static int[][] map;
    public static int minSubsetSumDifference(int[] arr, int n) {

        maxValue = 0;
        int sum = sumOfValues(arr);
        int target = sum / 2;
        map = new int[n][sum];
        for(int i = target;i>0;i--)
        {
            boolean flag = topToDownOptimal(n - 1, i, arr);
            if(flag)
                return Math.abs((sum - i) - i);
        }
        return sum;
        // topToBottom(arr, n - 1, 0, target);
        // return Math.abs((sum - maxValue) - maxValue);

    }

    private static boolean topToDownOptimal(int n, int k, int[] arr) {
          
        
         if (k < 0 | n < 0)
            return false;
        else if (k == 0 |(n == 0 && arr[n] == k))
            return true;
        
        boolean pick;
        boolean notPick;
        // 1 = > true
        // 2 = > false
        
        if(map[n][k] != 0)
        {
            return map[n][k] == 1 ? true:false;
        }
        pick = topToDownOptimal(n - 1, k - arr[n], arr);
        notPick = topToDownOptimal(n - 1, k, arr);
        map[n][k] = (pick|notPick)?1:2;
        return (pick|notPick);

    }

    private static int sumOfValues(int[] arr) {
        int sum = 0;
        for (int data : arr)
            sum += data;
        return sum;
    }
}
// link :
// https://www.codingninjas.com/studio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum._842494?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION