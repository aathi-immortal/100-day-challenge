
/*************************************************************
 * 
 * Following is the Binary Tree Node structure:
 * 
 * class TreeNode<T> {
 * public T data;
 * public BinaryTreeNode<T> left;
 * public BinaryTreeNode<T> right;
 * 
 * TreeNode(T data) {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * }
 * 
 *************************************************************/

public class DiameterOfTree {
    static int longestPath;

    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        longestPath = 0;
        getLongestPath(root);
        return longestPath;
    }

    public static int getLongestPath(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        int leftHeight = getLongestPath(root.left);
        int rightHeight = getLongestPath(root.right);
        int pathDistance = leftHeight + rightHeight;
        if (pathDistance > longestPath)
            longestPath = pathDistance;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
