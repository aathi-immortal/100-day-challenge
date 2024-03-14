class Solution {
    public int removeElement(int[] nums, int val) {

        int ans[] = new int[nums.length];
        int count = 0;
        int index = 0;
        for (int data : nums) {

            if (data == val) {
                continue;

            }

            count++;
            ans[index++] = data;
        }
        index = 0;
        for (int data : ans) {
            nums[index++] = data;
        }
        return count;

    }
}