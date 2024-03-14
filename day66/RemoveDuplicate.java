class Solution {
    public int removeDuplicates(int[] nums) {
        int ans[] = new int[nums.length];
        int hashMap[] = new int[101];
        int index = 0;
        int count = 0;
        for (int data : nums) {
            hashMap[data] += 1;

        }
        for (int data : nums) {
            if (hashMap[data] == 1) {
                count++;
                ans[index++] = data;
            }
        }
        index = 0;
        for (int data : ans) {
            nums[index++] = data;
        }
        return count;
    }
}