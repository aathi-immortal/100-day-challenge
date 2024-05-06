import java.io.*;
import java.util.*;

public class ReverseLinkedList {

    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> previous = null;
        LinkedListNode<Integer> current = head;
        if (head == null)
            return head;
        LinkedListNode<Integer> next = head.next;
        while (true) {

            current.next = previous;
            previous = current;
            current = next;
            if(next == null)
                return previous;
                
            next = next.next;
        }
    }
}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}
