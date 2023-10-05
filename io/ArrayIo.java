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

    // 1 d array
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

    // 2 d array
    public static ArrayList<ArrayList<Integer>> build2dArrayList() {
        Scanner scan = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        System.out.println("enter the row:");
        int row = scan.nextInt();
        System.out.println("enter the col:");
        int col = scan.nextInt();
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> temArray = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                temArray.add(scan.nextInt());
            }
            array.add(temArray);
        }
        return array;
    }

    public static void print2dArrayList(ArrayList<ArrayList<Integer>> array) {
        for (ArrayList<Integer> temArray : array) {
            for (Integer data : temArray) {
                System.out.println(data + " ");
            }
            System.out.println();
        }

    }

    public static void printArrayList(ArrayList<Integer> arrayList)

    {
        for (Integer data : arrayList) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void printIntArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
