public class JumpGame {

    public static void main(String[] args) {
        int[] arr = { 2,0, 0 };
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {

        int max = nums[0];
        for (int index = 0; index < nums.length - 1; index++) {
            int current = nums[index];
            if (current == 0 && max == 0) {
                return false;
            } else {
                if (max < current)
                    max = current;k
            }

            max--;
        }
        return true;
    }
}
