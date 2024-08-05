public class SecondMax {

    int print2largest(int arr[], int n) {
        Integer firstMax = Integer.MIN_VALUE;
        Integer secondMax = Integer.MIN_VALUE;
        for (int data : arr) {

            if (firstMax < data) {
                secondMax = firstMax;
                firstMax = data;
            } else if (secondMax < data) {
                secondMax = data;
            }
        }
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }
}
