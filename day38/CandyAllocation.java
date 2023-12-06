public class CandyAllocation {
    public static int requiredCandies(int[] students) {
        // traver the students grade
        // compare the left(previous ) student grade with current grade
        // if grade is greater than previous

        // set currenct candy as previous candy  + 1

        // base case
        if(students.length == 1)
            return 1;

        

        int[] candyArray  = new int[students.length];

        // initial candies
        for(int i = 0;i<students.length;i++)
        {
            candyArray[i] = 1;
        }
        
        for(int i = 1;i<students.length;i++)
        {
            // previous grade is less than current grade
            if(students[i] > students[i - 1])
            {
                    candyArray[i] = candyArray[i - 1] + 1;
            }
        }
        for(int i = students.length -2;i>-1;i--)
        {
            // previous grade is less than current grade
            if(students[i] > students[i + 1])
            {
                    candyArray[i] = candyArray[i + 1] + 1;
            }
        }
        return sum(candyArray);
    }
    static int sum(int[] candyArray)
    {
        int total = 0;
        for(int data : candyArray)
            total += data;
        return total;
    }
}
