
import java.util.*;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
};

public class RootToLeaf {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // traverse to the leaf node using traversal algorithm
        // use stringBuilder to track the visited nodes
        // if we found the node which is leaf node add the give stringbuilder in to the
        // ans list
        // and pop out the current node from the stringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        List<String> listOfPath = new ArrayList<>();
        rootToLeaf(root, stringBuilder, listOfPath);
        return listOfPath;

    }

    private static void rootToLeaf(BinaryTreeNode root, StringBuilder trackedNode, List<String> listOfPath) {
        if (root == null)
            return;

        trackedNode.append(root.data);
        trackedNode.append(" ");
        // display(trackedNode);
        rootToLeaf(root.left, trackedNode, listOfPath);

        rootToLeaf(root.right, trackedNode, listOfPath);

        // we found the leaf node
        if (root.left == null && root.right == null) {
            // System.out.println("ji");
            // display(trackedNode);

            listOfPath.add(trackedNode.toString().trim());
        }
        // System.out.println(root.data + "vana\n");
        trackedNode.deleteCharAt(trackedNode.length() - 1);
        String data = (root.data) + "";
        trackedNode.delete(trackedNode.length() - 1 * data.length(), trackedNode.length());

    }

    static void display(StringBuilder stringBuilder) {
        System.out.println("ki");
        for (int i = 0; i < stringBuilder.length(); i++)
            System.out.print(stringBuilder.charAt(i) + " ");
        System.out.println();
    }

}