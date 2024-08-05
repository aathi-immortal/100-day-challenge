import java.util.HashMap;

class SingleElement {
    static HashMap<Integer, Integer> map;

    public int singleNonDuplicate(int[] nums) {

        return binarySearch(nums);
    }

    // private int binarySearch(int[] nums, int start, int end) {
    // if (start > end)
    // return -1;

    // int size = nums.length;

    // int mid = (start + end) / 2;
    // int midValue = nums[mid];
    // if ((mid == 0 || midValue != nums[mid - 1]) && (mid == size - 1 || midValue
    // != nums[mid + 1]))
    // return midValue;

    // int left = binarySearch(nums, start, mid - 1);

    // int right = binarySearch(nums, mid + 1, end);
    // return left == -1 ? right : left;

    // }

    private int binarySearch(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int midIndex = (start + end) / 2;
            int midValue = nums[midIndex];
            if (midIndex != 0 && midValue == nums[midIndex - 1]) {
                if (midIndex % 2 == 0) {
                    // we are in the right side move to right
                    end = midIndex - 1;
                } else {
                    // we are in left side
                    start = midIndex + 1;
                }
            } else if (midIndex != nums.length - 1 && midValue == nums[midIndex + 1]) {
                if (midIndex % 2 == 0) {
                    // we are in left side
                    start = midIndex + 1;
                } else {
                    end = midIndex - 1;
                }
            } else {
                return midValue;
            }
        }
        return -1;
    }

    public int OnceInArray(int[] nums) {
        map = new HashMap<>();
        loadHashMap(nums);
        for (int index = 0; index < nums.length; index++) {
            int currentValue = nums[index];
            if (map.get(currentValue) == 1)
                return currentValue;
        }
        return -1;
    }

    private void loadHashMap(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(nums[index])) {
                map.put(nums[index], map.get(nums[index]) + 1);
            }
            map.put(nums[index], 1);

        }
    }

    public static void main(String[] args) {
        SingleElement singleElement = new SingleElement();
        int[] arr = { 3, 3, 7, 7, 10, 11, 11 };
        int value = singleElement.singleNonDuplicate(arr);
        System.out.println(value);
    }
}