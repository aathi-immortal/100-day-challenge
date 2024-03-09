import java.util.*;
import java.io.*;

class TreeNode<T> {
    public T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

public class CeilInBst {

    public static int findCeil(TreeNode<Integer> root, int x) {
        int ceilValue = -1;
        while (root != null) {

            int data = root.data;
            if (data == x) {
                return data;
            } else if (data > x) {
                // go to left subtree
                ceilValue = root.data;
                root = root.left;

            } else {
                root = root.right;
            }
        }
        return ceilValue;
    }
}
