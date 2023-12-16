
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {
    public static boolean isSymmetric(TreeNode root) {
        return checkIsSymmetric(root, root);
    }

    public static boolean checkIsSymmetric(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;
        else if (root1 == null || root2 == null)
            return false;

        return (root1.val == root2.val) && checkIsSymmetric(root1.left, root2.right)
                && checkIsSymmetric(root1.right, root2.left);
    }
}
