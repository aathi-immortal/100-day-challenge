import java.util.ArrayList;
import java.util.Collections;
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

class NodeContainer implements Comparable<NodeContainer> {
    int row;
    int col;
    int data;

    NodeContainer(int row, int col, int data) {
        this.row = row;
        this.col = col;
        this.data = data;
    }

    @Override
    public int compareTo(NodeContainer that) {
        return this.col - that.col;

    }
}

public class VerticalOrderTraversal {
    public static List<Integer> verticalOrderTraversal(TreeNode root) {
        // convert all node into NodeContainer and assigin row and col

        List<NodeContainer> listOfNodeContainer = new ArrayList<>();
        NodeContainerGenerator(root, 0, 0, listOfNodeContainer);
        Collections.sort(listOfNodeContainer);
        displayCol(listOfNodeContainer);
        return groupByColoumn(listOfNodeContainer);

    }

    private static void displayCol(List<NodeContainer> listOfNodeContainer) {
        for (NodeContainer node : listOfNodeContainer) {
            System.out.println(node.data + " " + node.col);
        }
    }

    private static List<List<Integer>> groupByColoumn(List<NodeContainer> listOfNodeContainer) {
        List<List<Integer>> groups = new ArrayList<>();
        int id = listOfNodeContainer.get(0).col;
        List<Integer> tem = new ArrayList<>();
        tem.add(listOfNodeContainer.get(0).data);
        for (int i = 1; i < listOfNodeContainer.size(); i++) {
            NodeContainer nodeContainer = listOfNodeContainer.get(i);
            if (id == nodeContainer.col) {
                tem.add(nodeContainer.data);
            } else {
                // add the current tem to groups
                // create new tem
                // add current value to tem
                // change id to current col

                Collections.sort(tem);
                groups.add(tem);
                tem = new ArrayList<>();
                tem.add(nodeContainer.data);
                id = nodeContainer.col;
            }
        }

        return groups;
    }

    private static void NodeContainerGenerator(TreeNode root, int row, int col, List<NodeContainer> array) {

        if (root == null)
            return;
        // left
        NodeContainerGenerator(root, row + 1, col - 1, array);
        array.add(new NodeContainer(row, col, root.data));
        NodeContainerGenerator(root, row + 1, col - 1, array);

    }
}
