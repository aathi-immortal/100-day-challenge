import org.w3c.dom.Node;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class ReversePair {
    public static void main(String[] args) {

    }

    public Node pairwiseSwap(Node head) {
        if (head.next == null) {
            return head;
        }
        Node previous = head;
        Node current = head.next;
        Node nextNode;
        while (previous != null && previous.next != null) {
            if (previous == head) {
                head = current;

            }
            // swap
            nextNode = current.next;
            current.next = previous;
            previous.next = nextNode;

            // iteration
            previous = nextNode;
        }
        return head;
    }
}
