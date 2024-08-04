
class NumberWithFactor {

    int number;
    int factorCount;
}

public class FactorSorting {
    public static void main(String[] args) {
        int arr[] = { 10, 12, 13, 23, 45 };
        // find factor of all number and store it in the array
        // sort it
        NumberWithFactor numberArray[] = getNumberWithFactor(arr);
    }

    private static NumberWithFactor[] getNumberWithFactor(int[] arr) {
        NumberWithFactor[] numberWithFactor = new NumberWithFactor[arr.length];
        for (int data : arr) {
            NumberWithFactor currentNumber = new NumberWithFactor();
            currentNumber.number = data;
            currentNumber.factorCount = getFactor(data);
        }
        sortTheArray(numberWithFactor);
        return null;
    }

    private static void sortTheArray(NumberWithFactor[] numberWithFactor) {
        // buble sort
        // for(int i = )
    }

    private static int getFactor(int data) {
        int count = 2;
        int divisor = 2;
        while (divisor <= data / 2) {
            if (data % divisor == 0) {
                count++;
            }
            divisor++;
        }
        return count;
    }

}
