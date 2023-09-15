import java.util.ArrayList;
public class SingleElement
{
    static int advanceBinarySearch(ArrayList<Integer>arr,int start,int end)
    {
        while(start <= end)
        {
         int   mid = (start + end)/2;
            if(mid < 0  & arr.get(mid) != arr.get(mid + 1))
            {
                return arr.get(mid);
            }
            else if((mid > arr.size() - 1) & (arr.get(mid) != arr.get(mid - 1)))
            {
                    return arr.get(mid);
            }
            else if((arr.get(mid) != arr.get(mid - 1)) & (arr.get(mid + 1) != arr.get(mid)))
            {
                    return arr.get(mid);
            }
            advanceBinarySearch(arr,start,mid - 1);
            
            advanceBinarySearch(arr, mid + 1, end);
            
        }
        return -1;      

    }
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        if(arr.size() == 1)
            return arr.get(0);
        return advanceBinarySearch(arr,0,arr.size());
    }    
}