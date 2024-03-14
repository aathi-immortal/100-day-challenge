class MaxOne {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int maxValue = 0;

        int index = 0;
        while (index < nums.length) {
            // if current Value is one
            if (nums[index] == 1) {
                count++;
                if (maxValue < count) {
                    maxValue = count;
                }
            } else {
                count = 0;
            }
        }
        return maxValue;

    }
}