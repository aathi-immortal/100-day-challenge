public class PartitionSubsetSum {
	static int[][] map;

	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.

		int sum = sumOfArray(arr);
		if (sum % 2 == 1)
			return false;
		map = new int[n][sum];
		return topToDownOptimal(n, sum / 2, arr);
	}

	private static int sumOfArray(int[] arr) {
		int sum = 0;
		for (int data : arr) {
			sum += data;
		}
		return sum;
	}

	private static boolean topToDownOptimal(int n, int k, int[] arr) {

		if (k < 0 | n < 0)
			return false;
		else if (k == 0 | (n == 0 && arr[n] == k))
			return true;

		boolean pick;
		boolean notPick;
		// 1 = > true
		// 2 = > false

		if (map[n][k] != 0) {
			return map[n][k] == 1 ? true : false;
		}
		pick = topToDownOptimal(n - 1, k - arr[n], arr);
		notPick = topToDownOptimal(n - 1, k, arr);
		map[n][k] = (pick | notPick) ? 1 : 2;
		return (pick | notPick);

	}
}