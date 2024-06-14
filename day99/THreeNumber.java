import java.util.Arrays;

public class THreeNumber {
    public int maximumProduct(int[] nums) {
        // sort the array
        Arrays.sort(nums);
        int result = 0;
        int n = nums.length;
        // check is it complete positive Or // check is it negative array
        if ((nums[0] > -1 && nums[nums.length - 1] > -1) || (nums[0] < 0 && nums[nums.length - 1] < 0)) {
            result = nums[n - 1] * nums[n - 2] * nums[n - 3];
        }

        // both positive negative
        else {
            // check for 2 negative
            if (nums[1] < 0) {
                result = nums[0] * nums[1] * nums[n - 1];
            }
            int lastThree = nums[n - 1] * nums[n - 2] * nums[n - 3];
            if (result < lastThree) {
                result = lastThree;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        THreeNumber tHreeNumber = new THreeNumber();
        int[] num = { 0, -1, 2, 3 };
        tHreeNumber.maximumProduct(num);
    }
}
