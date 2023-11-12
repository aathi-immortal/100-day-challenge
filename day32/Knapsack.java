import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/


public class Solution {
	static HashMap<Integer,Double> map;
	public static void costPerWeight(Pair[] arr,int n)
	{
		for(int i=0;i<n;i++)
		{
			map.put(i, (double)arr[i].value/arr[i].weight);
		}

	}
	public static HashMap<Integer, Double> sortByValue(HashMap<Integer, Double> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Double>> list = new LinkedList<Map.Entry<Integer, Double>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            public int compare(Map.Entry<Integer,Double> o1,
                    Map.Entry<Integer, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
	public static double  assignWeightInBag(Pair[] items,int bag)
	{
		double cost = 0;
		map.forEach((index, value)->
		{
			Pair pair = items[index];
			if(bag >= pair.weight)
			{
				bag-=pair.weight;
				cost+=  pair.value;
				
			}
			else{
				cost += (bag * ((double)pair.value/pair.weight));
				bag = 0;
			}
				
		});
		return cost;
	}
    public static double maximumValue(Pair[] items, int n, int w) {
		map = new HashMap<>();
            // find cost per weight
			costPerWeight(items,n);
			map = sortByValue(map);
			return assignWeightInBag(items,w);

    }
}
