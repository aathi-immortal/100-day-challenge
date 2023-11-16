import java.util.*;
import java.io.*;

class Pair {
    int weight;
    int value;

    Pair(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public Pair() {
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}

public class NewKnapsack {

    public static void sortByCostPerWeight(Pair[] items) {
        Comparator comparator = new Comparator<Pair>() {

            @Override
            public int compare(Pair o1, Pair o2) {
                return ((double) o1.value / o1.weight) < ((double) o2.value / o2.weight) ? 1 : -1;
            }

        };
        Arrays.sort(items, comparator);
    }

    public static void displayItems(Pair[] items) {
        for (Pair item : items) {
            System.out.println(item.weight + " " + item.value);
        }
    }

    public static double maximumValue(Pair[] items, int n, int w) {
        displayItems(items);
        sortByCostPerWeight(items);
        displayItems(items);
        return calculateCost(items, w);

    }

    private static double calculateCost(Pair[] items, int bag) {
        double cost = 0;

        for (Pair item : items) {

            if (bag >= item.weight) {
                bag -= item.weight;
                cost += item.value;

            } else {
                cost += (bag * ((double) item.value / item.weight));
                bag = 0;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int size = scan.nextInt();
            int bag = scan.nextInt();
            Pair[] pairs = new Pair[size];
            for (int i = 0; i < size; i++) {
                Pair pair = new Pair();
                pair.setWeight(scan.nextInt());

                pairs[i] = pair;
            }
            for (int i = 0; i < size; i++) {
                Pair pair = pairs[i];
                pair.setValue(scan.nextInt());

                pairs[i] = pair;
            }

            System.out.println(maximumValue(pairs, size, bag));
        }

    }
}
