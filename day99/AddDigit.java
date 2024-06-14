public class AddDigit {

    public int addDigits(int num) {

        // while single digit
        while (num > 10) {
            num = getSumOfDigit(num);

        }
        return num;

    }

    private int getSumOfDigit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        AddDigit addDigit = new AddDigit();
        int result = addDigit.addDigits(38);
        System.out.println();
        System.out.println(result);
    }
}
