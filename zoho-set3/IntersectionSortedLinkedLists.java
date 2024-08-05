
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class IntersectionSortedLinkedLists {

    public static Node findIntersection(Node head1, Node head2) {
        Node answerHead = null;
        Node head3 = null;
        while (head1 != null && head2 != null) {
            int head1Data = head1.data;
            int head2Data = head2.data;
            if (head1Data < head2Data) {
                head1 = head1.next;
            } else if (head1Data > head2Data) {
                head2 = head2.next;
            } else {
                if (answerHead == null) {

                    answerHead = new Node(head1Data);
                    head3 = answerHead;
                } else {
                    answerHead.next = new Node(head1Data);
                    answerHead = answerHead.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return head3;
    }
}
