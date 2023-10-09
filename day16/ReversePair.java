import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class ReversePair {
    public static Node BuildSingleLinkedList() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ente the size:");
        int size = scan.nextInt();
        int i = 0;
        Node head = null;
        Node tem = null;
        while (i < size) {
            i++;
            if (head == null) {
                head = tem = new Node(scan.nextInt());
                head.next = null;
                continue;
            }
            tem.next = new Node(scan.nextInt());
            tem = tem.next;
            tem.next = null;
        }
        return head;
    }

    public static void displayLinkedList(Node head) {
        Node tem = head;

    }

    public static void main(String[] args) {
        Node head = BuildSingleLinkedList();
        // displayLinkedList(head);
        pairwiseSwap(head);
    }

    public static Node pairwiseSwap(Node head) {
        if (head.next == null) {
            return head;
        }
        Node previous = head;
        Node current;
        Node nextNode;
        while (previous != null && previous.next != null) {
            current = previous.next;
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
