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

    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
};

public class MergeBst {

    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> inorderOne = new ArrayList<>();
        List<Integer> inorderTwo = new ArrayList<>();

        getInorder(root1, inorderOne);
        getInorder(root2, inorderTwo);

        List<Integer> ans = new ArrayList<>();
        int indexOne = 0;
        int indexTwo = 0;
        while (indexOne < inorderOne.size() && indexTwo < inorderTwo.size()) {
            int leftTree = inorderOne.get(indexOne);
            int rightTree = inorderTwo.get(indexTwo);
            if (leftTree > rightTree) {
                ans.add(rightTree);
                indexTwo++;
            } else {
                ans.add(leftTree);
                indexOne++;
            }
        }
        while (indexOne < inorderOne.size()) {
            int leftTree = inorderOne.get(indexOne);
            ans.add(leftTree);
            indexOne++;

        }
        while (indexTwo < inorderTwo.size()) {
            int rightTree = inorderTwo.get(indexTwo);
            ans.add(rightTree);
            indexTwo++;
        }
        return ans;

    }

    private static void getInorder(TreeNode root, List<Integer> array) {
        if (root == null)
            return;

        getInorder(root.left, array);
        array.add(root.data);
        getInorder(root.right, array);

    }

}