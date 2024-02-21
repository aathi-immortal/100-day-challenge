public class MooreAlgorithm {

    public static void main(String[] args) {

    }
}

class Solution {
    public int majorityElement(int[] nums) {

        int majority = nums[0];
        int pointer = 0;
        int count = 0;
        while (pointer < nums.length) {
            if (nums[pointer] == majority) {
                count++;
            } else {
                count--;
            }
            pointer++;
            if (count == 0) {
                majority = nums[pointer];
                count = 0;
            }
        }
        return majority;

    }
}