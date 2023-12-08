/************************************************************
 * 
 * Following is the BinaryTreeNode class structure
 * class BinaryTreeNode<T>
 * {
 * public:
 * T data;
 * BinaryTreeNode<T> left;
 * BinaryTreeNode<T> right;
 * 
 * BinaryTreeNode(T data)
 * {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * };
 ************************************************************/
public class MaximumSumPath {
    static int maximumSumPath;

    public static int maxPathSum(BinaryTreeNode<Integer> root) {
        maximumSumPath = Integer.MIN_VALUE;
        getMaximumSumPath(root);
        // System.out.println(maximumSumPath);
        return maximumSumPath;
    }

    static int getMaximumSumPath(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        int leftNodesSum = getMaximumSumPath(root.left);
        // System.out.println(leftNodesSum);

        int rightNodeSum = getMaximumSumPath(root.right);
        // System.out.println(rightNodeSum);
        int currentNodesSum = root.data;
        if (leftNodesSum > 0)
            currentNodesSum += leftNodesSum;
        if (rightNodeSum > 0)
            currentNodesSum += rightNodeSum;
        // System.out.println(currentNodesSum);
        if (currentNodesSum > maximumSumPath)
            maximumSumPath = currentNodesSum;

        int maxChild = Math.max(leftNodesSum, rightNodeSum);
        return root.data + (maxChild > 0 ? maxChild : 0);
    }
}
