package io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayIo {
    public static int[] buildArray() {
        Scanner scan = new Scanner(System.in);

        System.out.println("enter the size of the array:");
        int size = scan.nextInt();
        int arr[] = new int[size];
        System.out.println("enter the array values:");
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        return arr;
    }

    public static ArrayList<Integer> buildArrayList() {
        Scanner scan = new Scanner(System.in);

        System.out.println("enter the size of the array:");
        int size = scan.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("enter the array values:");
        for (int i = 0; i < size; i++) {
            arr.add(scan.nextInt());
        }
        scan.close();
        return arr;
    }
}
