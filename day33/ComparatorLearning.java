import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ComparatorLearning {
    public static void main(String[] args) {
        List<String> str = sortByStringLength(getTheStringArray());
        System.out.println("after soring ");
        displayStringArray(str);

    }

    public static List<String> getTheStringArray() {
        ArrayList<String> strs = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        scan.nextLine();
        for (int i = 0; i < size; i++) {
            strs.add(scan.nextLine());
        }
        return strs;
    }

    public static List<String> sortByStringLength(List<String> str) {
        Comparator<String> comparable = new Comparator<String>() {
            public int compare(String t1, String t2) {
                return (t1.length() > t2.length()) ? 1 : -1;
            };
        };
        Collections.sort(str, comparable);
        return str;
    }

    public static void displayStringArray(List<String> strs) {
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
