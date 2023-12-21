
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BinaryTreeNode<T> {

    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class DistanceKFromNode {
    static Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> map;
    static List<BinaryTreeNode<Integer>> listOfNodes;

    public static List<BinaryTreeNode<Integer>> printNodesAtDistanceK(BinaryTreeNode<Integer> root,
            BinaryTreeNode<Integer> target, int K) {
        // create the children parent mapp ing using bfs
        map = new HashMap<>();
        int distance = 0;
        int limit = K;
        listOfNodes = new ArrayList<>();
        childParentMapping(root);

        modifiedDfs(target, distance, limit, null);

        BinaryTreeNode<Integer> child = target;
        int i = 1;

        while (map.containsKey(child) && i <= limit) {
            // it have parent
            BinaryTreeNode<Integer> parent = map.get(child);
            modifiedDfs(parent, 0, limit - i, child);
            child = parent;
            i++;
        }
        return listOfNodes;
    }

    private static void modifiedDfs(BinaryTreeNode<Integer> root, int distance, int limit,
            BinaryTreeNode<Integer> target) {
        // leaf node is reached
        if (root == null)
            return;
        // we visting already calculated subtree so ignore it
        if (root == target)
            return;
        // we found the distance so don't move further below stop it
        if (distance == limit) {
            listOfNodes.add(root);
        }

        modifiedDfs(root.left, distance + 1, limit, target);

        modifiedDfs(root.right, distance, limit, target);

    }

    private static void childParentMapping(BinaryTreeNode<Integer> root) {
        ArrayDeque<BinaryTreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodeInLevel = queue.size();
            for (int i = 0; i < nodeInLevel; i++) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                    // children as a key
                    // parent as a value
                    map.put(queue.peek().left, queue.peek());

                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                    // children as a key
                    // parent as a value
                    map.put(queue.peek().right, queue.peek());
                }
                queue.poll();
            }
        }

    }
}
