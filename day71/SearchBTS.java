
class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

public class SearchBTS {
    public static boolean searchInBST(BinaryTreeNode root, int x) {

        while (root != null) {

            int data = root.data;
            if (data == x) {
                return true;
            } else if (data > x) {
                // go to left subtree
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return false;

    }
}