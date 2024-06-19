/**
 * BaseSeven
 */
public class BaseSeven {
    public String convertToBase7(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        // divide untill zero
        // use the remainer

        int tem = num;
        num = Math.abs(num);
        if (num == 0)
            return "0";
        while (num != 0) {
            stringBuilder.append(num % 7);

            num /= 7;
        }
        // negative
        if (tem < 0)
            stringBuilder.append('-');
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        BaseSeven baseSeven = new BaseSeven();
        Integer.toString(23, 1);
        // String ans = baseSeven.convertToBase7(-7);

        // System.out.println(ans);

    }

}