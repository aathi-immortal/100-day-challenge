import java.util.* ;
import java.io.*; 
public class Sort012 {
    public static void swap(ArrayList<Integer> arr,int i,int j)
    {
        int tem = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,tem); 
    }
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int lastZero = 0;
        int firstTwo = n -1;
        int i = 0;
        while(i <= firstTwo)
        {
            if(arr.get(i) == 0 && i >= lastZero)
            {
                swap(arr,i,lastZero++);
                
            }
            else if(arr.get(i) == 2 && i <= firstTwo)
            {
                swap(arr,i,firstTwo--);
            }
            else
            {
                i++;
            }

        }
    }
}
