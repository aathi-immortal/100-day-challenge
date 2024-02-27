public class Meadian {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Size = nums1.length;
        int nums2Size = nums2.length;
        int tem[] = new int[nums1Size + nums2Size];
        int leftindex = 0;
        int rightindex = 0;
        int index = 0;
        while (leftindex < nums1Size || rightindex < nums2Size) {
            if (nums1[leftindex] < nums2[rightindex]) {
                tem[index++] = nums1[leftindex++];
            } else {
                tem[index++] = nums2[rightindex++];
            }
        }
        while (leftindex < nums1Size) {
            tem[index++] = nums1[leftindex++];
        }
        while (rightindex < nums2Size) {
            tem[index++] = nums2[rightindex++];
        }
        // array is merged let find the median
        if (tem.length % 2 == 0) {
            return (tem[tem.length / 2] + tem[(tem.length / 2) - 1] / 2);
        } else {
            return tem[tem.length / 2];
        }
    }
}
