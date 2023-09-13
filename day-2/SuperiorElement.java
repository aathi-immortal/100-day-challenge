import java.util.*;

public class SuperiorElement {
    public static List<Integer> superiorElements(int[] a) {
        List<Integer> ans = new ArrayList<>();
        int i = a.length - 1;
        int max = 0;
        while (i > -1) {
            if (a[i] > max) {
                max = a[i];
                ans.add(max);
            }
            i--;
        }
        return ans;
    }
}