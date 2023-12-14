
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

public class LeftView {
    public static void printLeftView(TreeNode<Integer> root) {
        // traverse the left boundry
        leftView(root);

    }

    private static void leftView(TreeNode<Integer> root) {

        ArrayDeque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int numberNodeLevel = queue.size();
            // array to store the nodes in the given level
            ArrayList<Integer> array = new ArrayList<>();
            for (int i = 0; i < numberNodeLevel; i++) {
                array.add(queue.peek().data);
                if (queue.peek().left != null)
                    queue.add(queue.peek().left);
                if (queue.peek().right != null)
                    queue.add(queue.peek().right);
                queue.poll();

            }
            System.out.print(array.get(0) + " ");
        }
    }
}
