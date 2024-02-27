class RemoveDuplaicate {
    public int removeDuplicates(int[] nums) {

        int count = 0;
        int tracker = 1;
        for (int index = 1; index < nums.length - 1; index++) {
            if (nums[index] == nums[index - 1]) {
                continue;
            } else {
                nums[tracker++] = nums[index];
            }
            count++;
        }
        return count;
    }

}