import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SumInMatrix {
    public int matrixSum(int[][] nums) {

        sortMatrixRow(nums);
        int result = 0;
        // run the loop col time
        for (int index = 0; index < nums[0].length; index++) {
            int maxValue = -1;
            for (int row = 0; row < nums.length; row++) {
                int value = nums[row][index];
                if (maxValue < value)
                    maxValue = value;
            }
            result += maxValue;
        }
        return result;
    }

    private void sortMatrixRow(int[][] nums) {
        for (int[] innerArray : nums) {
            Arrays.sort(innerArray);
            
            
        }

    }

}
