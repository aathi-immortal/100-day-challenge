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

public class PredecessorAndSuccessorInBST {
    static List<Integer> inorder;

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        inorder = new ArrayList<>();
        getListOfInorder(root);
        return getprecessorSuccessor(key);

    }

    private static List<Integer> getprecessorSuccessor(int key) {
        List<Integer> ans = new ArrayList<>();
        int index = getNodeIndex(key);

        if (index == 0)
            ans.add(-1);
        else
            ans.add(inorder.get(index - 1));
        if (index == inorder.size() - 1)
            ans.add(-1);
        else
            ans.add(inorder.get(index + 1));
        return ans;
    }

    private static int getNodeIndex(int key) {
        for (int index = 0; index < inorder.size(); index++) {
            if (inorder.get(index) == key) {
                return index;
            }
        }
        return -1;
    }

    private static void getListOfInorder(TreeNode root) {
        if (root == null)
            return;
        getListOfInorder(root.left);
        inorder.add(root.data);
        getListOfInorder(root.right);

    }
}