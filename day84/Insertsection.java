import java.util.HashMap;

public class Insertsection {

    public static void intersections(int arr1[], int arr2[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < arr2.length; index++) {
            if (map.containsKey(arr2[index])) {
                map.put(arr2[index], map.get(arr2[index]) + 1);
            } else {
                map.put(arr2[index], 1);
            }
        }

        for (int index = 0; index < arr1.length; index++) {
            if (map.containsKey(arr1[index])) {
                map.put(arr1[index], map.get(arr1[index]) - 1);
                if (map.get(arr1[index]) == 0) {
                    map.remove(arr1[index]);
                }
                System.out.print(arr1[index] + " ");
            }

        }

    }
}