package utility;

import java.util.ArrayList;

public class Arrayconvertor {

    // public static <T extends Number> ArrayList<T> numerToArray(T num) {
    // ArrayList<Long> arrayList = new ArrayList<>();

    // Number number = num;
    // while (number != (T) 0) {
    // arrayList.add(0, number % 10);
    // number /= 10;

    // }
    // return arrayList;

    // }

    public static ArrayList<Long> longToArray(long number) {
        ArrayList<Long> arrayList = new ArrayList<>();

        while (number != 0) {
            arrayList.add(0, number % 10);
            number /= 10;

        }
        return arrayList;

    }

    public static long arrayToLong(ArrayList<Long> arrayList) {
        long base = 10;
        long number = 0;
        for (long data : arrayList) {
            number = (number * base) + data;
        }
        return number;

    }

    // public static void main(String[] args) {
    // ArrayList<Long> arrayList = new ArrayList<>();
    // arrayList.add(3l);
    // arrayList.add(4l);
    // arrayList.add(5l);
    // long num = arrayToLong(arrayList);
    // System.out.println(num);

    // }

    public static int arrayToInteger(ArrayList<Integer> arrayList) {
        int base = 10;
        int number = 0;
        for (int data : arrayList) {
            number += (number * base) + data;
        }
        return number;

    }

}
