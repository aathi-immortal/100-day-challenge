
/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class Node {
 * public int data;
 * public Node next;
 * 
 * Node()
 * {
 * this.data = 0;
 * this.next = null;
 * }
 * 
 * Node(int data)
 * {
 * this.data = data;
 * this.next = null;
 * }
 * 
 * Node(int data, Node next)
 * {
 * this.data = data;
 * this.next = next;
 * }
 * };
 * 
 *****************************************************************/

public class ReverseListInKGroups {

    public static int getSize(Node head) {
        int i = 0;
        Node tem = head;
        while (tem != null) {
            i++;
            tem = tem.next;
        }
        return i;
    }

    public static Node kReverse(Node head, int k) {
        Node previous = null;
        Node current = head;
        Node nextNode = head.next;
        int i = 0;
        Boolean flag = false;
        Node tem = current;
        Node futureHead;
        int linkedListSize = getSize(head);
        int numberOfOperation = linkedListSize / k;
        int j = 0;

        while (j < numberOfOperation) {

            i = 0;
            // storing the current head (because after reversing the linked list head of the
            // linked list will be in the last of the linked list using that we need to
            // connect the next reversed linked list)
            futureHead = current;
            previous = null;
            while (i < k) {

                // reverse
                current.next = previous;

                previous = current;
                current = nextNode;
                if (nextNode == null) {
                    break;
                }
                nextNode = nextNode.next;

                i++;

            }
            if (!flag) {
                head = previous;
                flag = true;
            } else {
                tem.next = previous;
                tem = futureHead;

            }
            j++;

        }
        if (k % linkedListSize != 0) {
            tem.next = current;
        }
        return head;
    }

}
