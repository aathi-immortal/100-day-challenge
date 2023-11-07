
public class minToMaxHeap {
   
    public static void displayArray(int arr[])
    {
        for(int i = 0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
        }
    }
    public static int maxChild(int arr[] ,int left,int right)
    {
        return (arr[left] > arr[right]) ? left:right;
    }
    public static void checker(int lastIndex,int arr[])
    {
        if(lastIndex < (int)Math.ceil((double)(arr.length - 1)/2))
        {
            heapBuilder(lastIndex, arr,arr.length);
        }
    }
    public static int[] MinToMaxHeap(int n, int[] arr){
        for(int lastIndex = (int)Math.ceil((double)(n - 1)/2) - 1;lastIndex >=0 ;lastIndex--)
        {
           heapBuilder(lastIndex,arr,n);
        }
        return arr;
    }
    public static void heapBuilder(int lastIndex,int arr[],int n)
    {
         int leftChild = 2 * lastIndex + 1;
            int rightChild = 2 * lastIndex + 2;
            int parentValue = arr[lastIndex];
            if(rightChild < n)
            {
                // it has both child
                // find the max child value
                int maxChildIndex = maxChild(arr,leftChild,rightChild);
                // we got the max child index
                if(arr[maxChildIndex] > parentValue)
                {
                    // swap the value 
                    arr[lastIndex] = arr[maxChildIndex];
                    arr[maxChildIndex] = parentValue;
                    checker(maxChildIndex,arr);
                }
            }
            else
            {
                if(arr[lastIndex] < arr[leftChild])
                {
                    arr[lastIndex] = arr[leftChild];
                    arr[leftChild] = parentValue;
                    // swap it 

                }
            }
    }
}