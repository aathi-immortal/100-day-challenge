import java.util.Random;

public class SuffleArray {

    public static void main(String[] args) {
        // io as array
        int[] array = { 1, 2, 3, 4, 5, 6 };
        suffleArray(array);
        System.out.println();
        for (int data : array) {
            System.out.println(data);
        }
    }

    private static void suffleArray(int[] array) {
        Random random = new Random();
        int lastIndex = array.length - 1;
        while (lastIndex > 0) {
            int index = random.nextInt(lastIndex);
            int currentValue = array[lastIndex];
            int randomValue = array[index];


            //swap it 
            array[lastIndex] = randomValue;
            array[index] = currentValue;

            lastIndex--;
        }

    }
}
