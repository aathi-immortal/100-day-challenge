package day9;

public class SquareRoot {
    public static Long binarySearch(Long N) {

        Long start = 0l;
        Long end = (N / 2) + 1;

        while (start <= end) {
            Long mid = (start + end) / 2;

            if (mid * mid == N) {
                return mid;
            } else if (mid * mid > N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static int sqrtN(long N) {
        return (int) (Math.pow(N, 0.5));

    }
}
