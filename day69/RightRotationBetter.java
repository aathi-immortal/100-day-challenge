public class RightRotationBetter {

    public static void main(String[] args) {
        int[] num = { 1, 2, 3, 4, 5, 6, 7 };
        Rightrotate(num, 3);
        display(num);

    }

    public static void Rightrotate(int[] nums, int k) {
        rotate(nums, nums.length - k, nums.length - 1);
        rotate(nums, 0, nums.length - k - 1);
        rotate(nums, 0, nums.length - 1);
    }

    private static void display(int[] nums) {
        for (int data : nums) {
            System.out.println(data);
        }
    }

    private static void rotate(int[] nums, int start, int end) {

        while (start < end) {
            int tem = nums[end];
            nums[end] = nums[start];
            nums[start] = tem;
            start++;
            end--;
        }
    }
}
