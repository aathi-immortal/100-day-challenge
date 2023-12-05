import java.util.*;


public class JobSequencing {
    public static int[] jobScheduling(int [][]jobs) {
        // creating array to store the jobs
        
        //1. sort the jobs based on the profit in desc order
        //2. create  the job allocation array with the size of maximum allocation time in given jib array
        //3. allocate the job to the deadLine index 
        // if job is already allocated in that place move to left untill you reach the -1 index

        // sorting
        Arrays.sort(jobs, (a, b) -> 
        {
            if(a[2] > b[2])
                return -1;
            return 1;
        });
        // traverse the array
        // display(jobs);
        return traverTheArray(jobs);
        
    }
    public static int[] traverTheArray(int[][] jobs)
    {
        
        int[] scheduledJobs = new int[jobs.length];
        int count = 0;
            for(int i = 0;i<jobs.length;i++)
        {
            int jobDeadLine = jobs[i][1];
            int jobProfit = jobs[i][2];
            // check for the free space  allocation
            int start = jobDeadLine - 1;
            // checking for the space untill -1 
            for(;start > -1 ;start--)
            {
                if( scheduledJobs[start] == 0)
                {
                    scheduledJobs[start] = jobProfit;
                    count++;
                    break;
                }
            }

        }
        return sumOfProfit(scheduledJobs,count);

    }
    public static int[] sumOfProfit(int[] profits,int count)
    {
        int sum = 0;
        for(int i : profits)
        {
            sum += i;
        }
        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = sum;
        return ans;
    }

    // static void display(int[][] jobs)
    // {
    //     for(int i = 0;i<jobs.length;i++)
    //         System.out.println(jobs[i][2]);
    // }

}
