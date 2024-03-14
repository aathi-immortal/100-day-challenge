
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] ans = approachOne(nums1, nums2, m, n);
        int index = 0;
        for (int data : ans) {
            nums1[index++] = data;
        }

    }

    private int[] approachOne(int[] nums1, int[] nums2, int m, int n) {

        int ans[] = new int[m + n];
        int index = 0;
        int num1Index = 0;
        int num2Index = 0;
        while (num1Index < m && num2Index < n) {

            // if left is small take it and move the pointer
            if (nums1[num1Index] < nums2[num2Index]) {
                ans[index] = nums1[num1Index++];
            } else {
                ans[index] = nums2[num2Index++];
            }
            index++;

        }
        while (num1Index < m) {
            ans[index++] = nums1[num1Index++];
        }
        while (num2Index < n) {
            ans[index++] = nums2[num2Index++];
        }
        return ans;
    }

}
