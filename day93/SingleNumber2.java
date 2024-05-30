public class SingleNumber2 {

    public int singleNumber(int[] nums) {

        int ones = 0;
        int twos = 0;
        for (int index = 0; index < nums.length; index++) {
            int currentValue = nums[index];
            ones = xorLogic(ones, currentValue) & onesCompliment(twos);
            twos = xorLogic(twos, currentValue) & onesCompliment(ones);
        }
        return ones;
    }

    private int onesCompliment(int value) {
        return ~value;
    }

    private int xorLogic(int value, int currentValue) {
        return value ^ currentValue;
    }

    // private int getOnes(int currentValue, int ones) {
    // return currentValue ^ ones;
    // }

    // private int getwos(int ones, int twos) {
    // int oneComplimentedTwos = oneCompliment(twos);
    // return ones & oneComplimentedTwos;
    // }

}
