import java.util.Scanner;

public class NumberToString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int number = scan.nextInt();
            String numberInString = numberToStringConvertor(number);
            System.out.println(numberInString);
        }

    }

    private static String numberToStringConvertor(long n) {
        int number = (int) n;
        StringBuilder stringBuilder = new StringBuilder();
        String[] zeroToNineTeen = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] towentyToNinety = { "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
                "ninety" };
        while (true) {

            if (number <= 19) {
                if (n > 100 && number != 0)
                    stringBuilder.append("and ");
                stringBuilder.append(zeroToNineTeen[number]);
                break;
            } else if (number <= 99) {
                if (n > 100 && number != 0)
                    stringBuilder.append("and ");
                stringBuilder.append(towentyToNinety[number / 10 - 1] + " " + zeroToNineTeen[number % 10]);
                break;
            }

            else if (number <= 999) {
                stringBuilder.append(zeroToNineTeen[number / 100] + " hundred ");

                number = number % 100;

            } else if (number <= 19999) // 19 thousand
            {
                stringBuilder.append(zeroToNineTeen[number / 1000] + " thousand ");
                number = number % 1000;

            } else if (number <= 99999) {// upt to 99 thousand
                // 33000
                stringBuilder
                        .append(towentyToNinety[number / 10000 - 1] + " ");
                number = number % 10000;
                stringBuilder.append(zeroToNineTeen[number / 1000] + " thousand ");
                number = number % 1000;
            } else if (number <= 1999999)// 1L -> upto 19 L
            {
                stringBuilder.append(zeroToNineTeen[number / 100000] + " lakh ");
                number = number % 100000;
            } else if (number <= 9999999) // 99 L
            {
                stringBuilder.append(towentyToNinety[number / 1000000 - 1] + " ");
                number = number % 1000000;
                stringBuilder.append(zeroToNineTeen[number / 100000] + " lakh ");
                number = number % 100000;

            } else if (number <= 199999999) // upto 19 C
            {
                stringBuilder.append(zeroToNineTeen[number / 10000000] + " core ");
                number = number % 10000000;
            } else if (number <= 999999999) { // 99 c
                stringBuilder.append(towentyToNinety[number / 100000000 - 1] + " ");
                number = number % 100000000;
                stringBuilder.append(zeroToNineTeen[number / 10000000] + " core ");
                number = number % 10000000;

            }
        }
        return stringBuilder.toString();
    }
}
