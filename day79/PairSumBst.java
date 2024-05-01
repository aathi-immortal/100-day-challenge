import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

public class PairSumBst {
    public static boolean pairSumBst(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        return isPairExist(inorder,k);
    }

    private static boolean isPairExist(List<Integer> inorder, int k) {
        int start = 0;
        int end = inorder.size() - 1;
        while(start < end)
        {
            int sum = inorder.get(start) + inorder.get(end);
            if(sum == k)
                return true;
            else if(sum > k)
                end--;
            else
                start++;
        }
        return false;
    }

    private static void getInorder(TreeNode root, List<Integer> inorder) {
        if (root == null)
            return;
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);

    }

}