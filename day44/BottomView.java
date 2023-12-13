import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

public class BottomView {

    public static List<Integer> getTopView(TreeNode root) {

        // traverse the given tree note and store it in the array
        List<NodeContainer> listOfNodesContainers = new ArrayList<>();
        List<Integer> topViewDatas = new ArrayList<>();
        // create Node container object
        createNodeContainer(root, listOfNodesContainers, 0, 0);

        // sorting based on the col
        Collections.sort(listOfNodesContainers);

        // traverse the array ang get the min row data in the array
        topViewDatas = getBottomViewData(listOfNodesContainers);
        return topViewDatas;

    }

    private static List<Integer> getBottomViewData(List<NodeContainer> listOfNodesContainers) {
        List<Integer> data = new ArrayList<>();
        int index = 0;

        int maxRowIndex = 0;

        int colTracker = listOfNodesContainers.get(maxRowIndex).col;
        while (index < listOfNodesContainers.size()) {
            NodeContainer node = listOfNodesContainers.get(index);
            // check for the min untill difference col value is meet
            if (colTracker == node.col) {
                // if minrow is greater than current row change it
                if (listOfNodesContainers.get(maxRowIndex).row < node.row)
                    maxRowIndex = index;
            } else {

                // get the data of it and add it into the list
                // initialize maxRowIndex as current Index
                // change colTracker to current new col
                data.add(listOfNodesContainers.get(maxRowIndex).data);
                maxRowIndex = index;
                colTracker = node.col;

            }
            data.add(listOfNodesContainers.get(maxRowIndex).data);
            index++;

        }
                    data.add(listOfNodesContainers.get(maxRowIndex).data);
        return data;
    }

    private static void createNodeContainer(TreeNode root, List<NodeContainer> listOfNodesContainers, int i, int j) {

        if (root == null)
            return;
        createNodeContainer(root.left, listOfNodesContainers, i + 1, j - 1);
        listOfNodesContainers.add(new NodeContainer(i, j, root.data));
        createNodeContainer(root.right, listOfNodesContainers, i + 1, j + 1);

    }

}
