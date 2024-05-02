
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class LcaOfThreeNodeBTree {

    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2,
            int node3) {
        BinaryTreeNode<Integer> data = inorderTraversal(root, node1, node2);
        return inorderTraversal(root, data.data, node3);

    }

    private static BinaryTreeNode<Integer> inorderTraversal(BinaryTreeNode<Integer> root, int node1, int node2) {

        if (root == null)
            return null;
        else if (root.data == node1)
            return root;
        else if (root.data == node2)
            return root;
        BinaryTreeNode<Integer> first = inorderTraversal(root.left, node1, node2);
        BinaryTreeNode<Integer> second = inorderTraversal(root.right, node1, node2);

        if (first == null && second == null)
            return null;
        else if (first != null && second != null)
            return root;
        return first != null ? first : second;

    }

}
