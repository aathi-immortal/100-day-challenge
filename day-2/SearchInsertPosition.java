public class  SearchInsertPosition {
    static int binarySearch(int[] arr,int m)
    {
        int left = 0;
        int right = arr.length - 1 ;
        while(left < right)
        {
            int mid = (left + right)/2;
            if(arr[mid] == m)
            {
                return mid;
            }
            else if(arr[mid] > m)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return left;
    }
    public static int searchInsert(int [] arr, int m){
            
            int index = binarySearch(arr, m);
            if(arr.length == 0 || arr[index] == m || arr[index] > m)
            {
                return index;
            }
            return index + 1;
    }
}