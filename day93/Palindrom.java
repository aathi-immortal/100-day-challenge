class Palindrom {
    public String is_palindrome(int n) {

        int reversedNumber = reverse(n);
        if (n == reversedNumber)
            return "Yes";
        return "No";

    }

    private int reverse(int n) {
        int reversedNumber = 0;

        while (n != 0) {
            reversedNumber += (reversedNumber * 10) + (n % 10);
            n = n / 10;

        }
        return reversedNumber;
    }
}