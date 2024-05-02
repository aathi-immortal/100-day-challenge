
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

public class LcaOfBtree {
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {

        // do inorder traversal return status of search
        return inorder(root, x, y);
    }

    private static int inorder(TreeNode<Integer> root, int x, int y) {

        if (root == null)
            return -1;
        else if (root.data == x)
            return x;
        else if (root.data == y)
            return y;
        int firstData = inorder(root.left, x, y);
        int secondData = inorder(root.right, x, y);
        if(firstData  == -1 && secondData == -1)
            return -1;
        else if (firstData > -1 && secondData > -1)
            return root.data;
        return firstData > -1 ? firstData : secondData;
    }
}
