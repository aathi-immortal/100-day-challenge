import java.util.ArrayList;
import java.util.Scanner;

public class ReturnSubsetSum {

    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tem = new ArrayList<>();
        subSetsUsingRec(arr, k, tem, 0, ans, 0);
        return ans;
    }

    private static void subSetsUsingRec(ArrayList<Integer> arr, int target, ArrayList<Integer> tem, int sum,
            ArrayList<ArrayList<Integer>> ans, int index) {

        if (index >= arr.size()) {
            if (sum == target)
                loadTemToArr(ans, tem);
            return;
        }

        // pick
        tem.add(arr.get(index));
        subSetsUsingRec(arr, target, tem, sum + arr.get(index), ans, index + 1);
        tem.remove(tem.size() - 1);
        // not pick
        subSetsUsingRec(arr, target, tem, sum, ans, index + 1);
    }

    private static void loadTemToArr(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> tem) {
        ArrayList<Integer> subset = new ArrayList<>();
        for (int data : tem) {
            subset.add(data);
        }
        ans.add(subset);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(-2);
        arr.add(0);
        arr.add(-5);
        arr.add(2);

        findSubsetsThatSumToK(arr, 5, 0);
    }
}
