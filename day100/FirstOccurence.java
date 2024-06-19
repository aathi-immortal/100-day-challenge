import java.util.Scanner;

public class FirstOccurence {

    // I/P: ZOHOCORPORATION PORT
    // O/P: OHOCORPORAT

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter :");
        String sentence = scan.nextLine();
        String key = scan.nextLine();
        String newString = firstOccurenceLogic(sentence, key);
        System.out.println(newString);
    }

    private static String firstOccurenceLogic(String sentence, String key) {

        // if no match found it will return empty string
        // traverse the key string
        // find the first index
        // track min and max of it

        int minIndex = sentence.length() + 1;
        int maxIndex = -1;

        for (int index = 0; index < key.length(); index++) {
            Character character = key.charAt(index);
            int firstOccurenceIndex = sentence.indexOf(character);

            if (firstOccurenceIndex > maxIndex) {
                maxIndex = firstOccurenceIndex;
            }
            if (firstOccurenceIndex < minIndex) {
                minIndex = firstOccurenceIndex;
            }

        }

        return maxIndex == -1 ? "" : sentence.substring(minIndex, maxIndex + 1);
    }
}
