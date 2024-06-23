package songutil;

import java.util.ArrayList;

public class Utility {

    public static <T> void printItems(ArrayList<T> array) {
        for (T item : array) {
            System.out.println(item.toString());

        }
    }
}
