public class Solution {
    public static int minJumps(int []jump, int n) {
        int index = 0;
        int reachable = 0;
        int jumps = 0;
        while((index < n)  && !((reachable) >= n - 1))
        {
            
             if(reachable < index)
             {
                 return -1;
             }
            else if(reachable < (index + jump[index]))
            {
                reachable = index + jump[index];
                jumps++;
            }
            
            index++;
        }
        return jumps;
    }
}
