
/**
 * SortWeight
 */
import java.util.*;

class DataObj {
    int data;
    int weight;
}

public class SortWeight {
    public static void main(String[] args) {
        int arr[] = { 10, 36, 54, 89, 12 };
        printWeighted(arr);
    }

    private static void printWeighted(int[] arr) {
        List<DataObj> array = new ArrayList<>();
        for (int data : arr) {
            int weight = getWeight(data);

            DataObj obj = new DataObj();
            obj.data = data;
            obj.weight = weight;
            array.add(obj);
        }

        Collections.sort(array, (DataObj o1, DataObj o2) -> {
            if (o1.weight > o2.weight)
                return 1;
            else if (o1.weight < o2.weight)
                return -1;
            return 0;
        });
        display(array);
    }

    private static void display(List<DataObj> array) {
        for (DataObj dataObj : array) {
            System.out.println(dataObj.data + " " + dataObj.weight);
        }
    }

    private static int getWeight(int data) {
        int squreRoot = (int) Math.sqrt(data);
        int weight = 0;
        if (data == (squreRoot * squreRoot)) {
            weight += 5;
        }
        if (data % 4 == 0 && data % 6 == 0) {
            weight += 4;
        }
        if (data % 2 == 0) {
            weight += 3;
        }
        return weight;
    }

}