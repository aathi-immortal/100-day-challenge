package io;

import java.util.LinkedList;
import java.util.Scanner;

public class SingleLinkedListiIo {
    public static LinkedList<Integer> BuildSingleLinkedList() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the size of linked list:");
        LinkedList<Integer> linkedList = new LinkedList<>();
        int size = scan.nextInt();
        for (int i = 0; i < size; i++) {
            linkedList.add(scan.nextInt());
        }
        return linkedList;
    }
}
