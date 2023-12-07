import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

//   Following is the class structure of the Node class:

class Node {
    public int data;
    public Node left;
    public Node right;

    Node() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeBuild {
    public static Node createTree(int[] arr) {
        // base condition

        Node root = new Node(arr[0]);

        if (arr.length == 1)
            return root;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int index = 1;
        while (index < arr.length) {
            Node current = queue.pop();
            // last node
            if (index == arr.length - 1) {
                current.left = new Node(arr[index]);
                break;
            } else {
                current.left = new Node(arr[index++]);
                queue.add(current.left);
                current.right = new Node(arr[index++]);
                queue.add(current.right);
            }
        }
        return root;
    }
}
