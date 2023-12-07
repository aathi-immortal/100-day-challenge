
/*********************************************************

 Following is the TreeNode structure:

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
 ********************************************************/

import java.util.ArrayList;
import java.util.List;

public class TraversalInTree {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> allOrders = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();

        // main functions
        inOrderTraversal(root, inOrder);
        preOrderTraversal(root, preOrder);
        postOrderTraversal(root, postOrder);

        // adding
        allOrders.add(inOrder);
        allOrders.add(preOrder);
        allOrders.add(postOrder);

        return allOrders;
    }

    static void inOrderTraversal(TreeNode root, List<Integer> array) {
        if (root == null)
            return;
        inOrderTraversal(root.left, array);
        array.add(root.data);
        inOrderTraversal(root.right, array);
    }

    static void preOrderTraversal(TreeNode root, List<Integer> array) {
        if (root == null)
            return;
        array.add(root.data);
        preOrderTraversal(root.left, array);
        preOrderTraversal(root.right, array);
    }

    static void postOrderTraversal(TreeNode root, List<Integer> array) {
        if (root == null)
            return;
        postOrderTraversal(root.left, array);

        postOrderTraversal(root.right, array);
        array.add(root.data);
    }
}