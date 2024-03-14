
import java.io.*;
import java.util.ArrayDeque;

class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

public class Solution {

    public static int countNodesModified(BinaryTreeNode<Integer> root) {
        // two base condition
        if (root == null)
            return 0;
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight)
            return (int) Math.pow(2, rightHeight) - 1;
        // if height is not equal
        return countNodesModified(root.left) + countNodesModified(root.right) + 1;
    }

    private static int getRightHeight(BinaryTreeNode<Integer> root) {
        
        if (root.right == null)
            return 1;
        return getRightHeight(root.right) + 1;

    }

    private static int getLeftHeight(BinaryTreeNode<Integer> root) {
        if (root.left == null)
            return 1;
        return getRightHeight(root.left) + 1;

    }

    public static int countNodes(BinaryTreeNode<Integer> root) {
        return countNodesModified(root);
    }
}