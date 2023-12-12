import java.util.List;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BoundryTraversal {
    public static List<Integer> traverseBoundary(TreeNode root) {

        List<Integer> boundryNodes = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> leafNode = new ArrayList<>();
        List<Integer> rightBoundryNode = new ArrayList<>();

        // left node
        boundryNodes = leaftBoundryTreeTraversal(root.left);
        boundryNodes.add(0, root.data);

        // indorder traversal
        indorderTraversal(root, nodes);
        // filter the leaf nodes from it

        leafNode = filterLeafNode(nodes);

        load(boundryNodes, leafNode);
        // right boundry nodes

        rightBoundryNode = rightTreeTraversal(root.right);
        load(boundryNodes, rightBoundryNode);
        return boundryNodes;
    }

    private static List<Integer> rightTreeTraversal(TreeNode node) {
        List<Integer> rightBoundryNode = new ArrayList<>();
        if (node == null) {
            return rightBoundryNode;
        }
        while (node.left != null || node.right != null) {
            rightBoundryNode.add(0, node.data);
            // check for left
            if (node.right != null) {
                node = node.right;
            } else if (node.left != null) {
                node = node.left;
            } else {
                break;
            }
        }
        return rightBoundryNode;
    }

    private static List<Integer> leaftBoundryTreeTraversal(TreeNode node) {

        List<Integer> BoundryNodes = new ArrayList<>();
        if (node == null)
            return BoundryNodes;
        while (node.left != null || node.right != null) {
            BoundryNodes.add(node.data);
            // check for left
            if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                break;
            }
        }
        return BoundryNodes;
    }

    private static void load(List<Integer> boundryNodes, List<Integer> leafNode) {
        for (int data : leafNode) {
            boundryNodes.add(data);
        }
    }

    private static List<Integer> filterLeafNode(List<TreeNode> nodes) {
        List<Integer> leafNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left == null && node.right == null)
                leafNodes.add(node.data);

        }
        return leafNodes;
    }

    private static void indorderTraversal(TreeNode root, List<TreeNode> nodes) {
        if (root == null)
            return;
        indorderTraversal(root.left, nodes);
        nodes.add(root);
        indorderTraversal(root.right, nodes);

    }
}
