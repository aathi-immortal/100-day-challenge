public class WaveArray {

    public static void convertToWave(int n, int[] a) {
        int index = 0;
        while (index < n && index + 1 < n) {
            int currentValue = a[index];
            int nextValue = a[index + 1];
            a[index + 1] = currentValue;
            a[index] = nextValue;
            index += 2;
        }
        
    }

}
