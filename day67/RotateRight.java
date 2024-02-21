public class RotateRight {
    public static void main(String[] args) {

    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        while (k != 0) {
            // shifting
            int index = nums.length - 2;
            int last = nums[index + 1];

            while (index > -1) {

                nums[index + 1] = nums[index];
                index--;
            }
            nums[0] = last;
            k--;
        }
    }

    public void betterRotate(int[] nums, int k) {

        k = k % nums.length;
        int tem[] = new int[k];
        int index = nums.length - 1;
        int count = 0;
        // load the k last datas

        while (count < k) {

            tem[count++] = nums[index];
            index--;
        }
        // shifting
        index = nums.length - k - 1;

        while (index > -1) {

            nums[index + k] = nums[index];
            index--;
        }

        index = 0;
        for (int i = k - 1; i > -1; i--) {
            nums[index++] = tem[i];
        }

    }

}
