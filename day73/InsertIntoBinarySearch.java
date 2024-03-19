import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.text.html.HTMLDocument.Iterator;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
};

public class InsertIntoBinarySearch {

    public static TreeNode insertionInBST(TreeNode root, int val) {
        TreeNode head = root;

        if (root == null) {
            return new TreeNode(val);

        }
        TreeNode previousNode = null;
        while (root == null) {
            previousNode = root;
            if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (previousNode.left == null)
            previousNode.left = new TreeNode(val);
        else
            previousNode.right = new TreeNode(val);
        return head;
    }
}
