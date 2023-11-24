public class Solution {
    public static boolean jump_search(int []jump, int n){
        int index = 0;
        int reachable = (index + jump[index++]);
        while(index < n)
        {
            if(index > reachable)
            {
                return false;
            }
            else if(reachable < (index + jump[index]))
            {
                reachable = index + jump[index];
            }
            
            index++;
        }
        return true;
    }
}
