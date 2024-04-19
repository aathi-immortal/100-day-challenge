import java.util.ArrayList;

/**
 * KthSmallestNode
 */
public class KthSmallestNode {
    public static int count;
    public static int minValue;

    public static int kthSmallest(TreeNode root, int k) {

        // do inorder traversal and then return the k index of it

        // brute force
        // ArrayList<Integer> inorder = new ArrayList<>();
        // getInorderTraversal(root, inorder);

        // return inorder.get(k);

        // optimal
        count = 1;
        getInorderTraversalOptimal(root, k);
        return minValue;

    }

    private static void getInorderTraversalOptimal(TreeNode root, int k) {

        if (root == null)
            return;
        getInorderTraversalOptimal(root.left, k);
        if (count == k) {
            minValue = root.data;

        }
        count++;
        getInorderTraversalOptimal(root.right, k);
    }

    private static void getInorderTraversal(TreeNode root, ArrayList<Integer> array) {
        if (root == null)
            return;
        // left
        getInorderTraversal(root.left, array);
        array.add(root.data);
        getInorderTraversal(root.right, array);

    }

}

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
