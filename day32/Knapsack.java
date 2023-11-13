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

public class Knapsack {
	static HashMap<Integer, Double> map;

	public static void costPerWeight(Pair[] arr, int n) {
		for (int i = 0; i < n; i++) {
			map.put(i, (double) arr[i].value / arr[i].weight);
			System.out.println(arr[i].value + " " + arr[i].weight);
		}

	}

	public static HashMap<Integer, Double> sortByValue(HashMap<Integer, Double> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<Integer, Double>> list = new LinkedList<Map.Entry<Integer, Double>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
			public int compare(Map.Entry<Integer, Double> o1,
					Map.Entry<Integer, Double> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<Integer, Double> temp = new LinkedHashMap<Integer, Double>();
		for (Map.Entry<Integer, Double> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public static double assignWeightInBag(Pair[] items, int bag) {
		double cost = 0;
		Set<Integer> set = map.keySet();
		for (int i : set) {
			Pair pair = items[i];
			System.out.println(i);
			if (bag >= pair.weight) {
				bag -= pair.weight;
				cost += pair.value;

			} else {
				cost += (bag * ((double) pair.value / pair.weight));
				bag = 0;
			}
		}
		return cost;
	}

	public static double maximumValue(Pair[] items, int n, int w) {
		map = new HashMap<>();
		// find cost per weight
		costPerWeight(items, n);
		map = sortByValue(map);
		
		return assignWeightInBag(items, w);

	}

	public static void displayHashMap() {
		map.forEach((index, value) -> {
			System.out.print(value + " ");
		});
		System.out.println();
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
			System.out.println(pairs[0].value);
			System.out.println(maximumValue(pairs, size, bag));
		}

	}
}
