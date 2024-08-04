import java.util.ArrayList;

class NumberWithFrequncy {
    int number;
    int count;
}

public class TopThree {

    public static void main(String[] args) {
        int[] arr = { 7, 6, 4, 4, 3, 1, 1 };
        printTopThreeFrequency(arr);
    }

    private static void printTopThreeFrequency(int[] arr) {

        // sort(arr);
        // get frequency array
        NumberWithFrequncy[] frequncies = getFrequncies(arr);
        System.out.println("size " + (getLength(frequncies)));
        sort(frequncies);
        getTopThree(frequncies);
        // printData(frequncies);
        // firstThree(frequncies);

    }

    private static void getTopThree(NumberWithFrequncy[] frequncies) {

    }

    private static int getLength(NumberWithFrequncy[] frequncies) {
        int count = 0;
        for (NumberWithFrequncy currentNumber : frequncies) {
            if (currentNumber == null) {
                return count;
            }
            count++;

        }
        return count;
    }

    private static void printData(NumberWithFrequncy[] frequncies) {
        System.out.println();
        for (int index = getLength(frequncies) - 1; index > -1; index--) {

            System.out.println(frequncies[index].number + " " + frequncies[index].count);
        }
    }

    private static void sort(NumberWithFrequncy[] arr) {
        int arrLength = getLength(arr);
        for (int i = 0; i < arrLength; i++) {

            for (int inner = 0; inner < (arrLength) - i - 1; inner++) {

                if (arr[inner].count > arr[inner + 1].count) {
                    // swap it
                    NumberWithFrequncy tem = arr[inner];
                    arr[inner] = arr[inner + 1];
                    arr[inner + 1] = tem;
                }
            }
        }
    }

    private static NumberWithFrequncy[] getFrequncies(int[] arr) {
        NumberWithFrequncy[] frequncies = new NumberWithFrequncy[arr.length];
        int frequnciesIndex = 0;
        int[] visited = new int[frequncies.length];
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            int count = 0;
            if (visited[i] == 0) {
                NumberWithFrequncy currentNumber = new NumberWithFrequncy();
                currentNumber.number = current;

                for (int innerArray = 0; innerArray < arr.length; innerArray++) {
                    if (current == arr[innerArray]) {
                        visited[innerArray] = 1;
                        count++;
                    }
                }
                currentNumber.count = count;
                frequncies[frequnciesIndex++] = currentNumber;
            }
        }
        return frequncies;
    }

}
