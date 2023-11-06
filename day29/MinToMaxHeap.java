package day29;

public class MinToMaxHeap {
    static int[] maxheap;
    public static void heapify(int lastIndex)
    {
        while(lastIndex != 0)
        {
            int parentIndex = (int)Math.ceil((double)lastIndex/2) - 1;
            int parentValue = maxheap[parentIndex];
            int childValue = maxheap[lastIndex];
            if(parentValue < childValue)
            {
                // swap the child and parent value
                maxheap[parentIndex] = childValue;
                maxheap[lastIndex] = parentValue;
                lastIndex = parentIndex;
                continue;
            }
            
            return;
        }
    }
    public static void displayArray(int arr[])
    {
        for(int i = 0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
        }
    }
    public static int[] MinToMaxHeap(int n, int[] arr){
        maxheap = new int[n];
        // traver the array value
        for(int i = 0;i<n;i++)
        {
            // insert the value into at last in the maxheap array
            maxheap[i] = arr[i];
            // using this function we can maintain the max heap 
            heapify(i);
        }
        // displayArray(maxheap);
        return maxheap;
    }
}