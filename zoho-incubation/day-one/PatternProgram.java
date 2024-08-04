import java.util.*;

public class PatternProgram {
    public static void main(String[] args) {
        int row, col, size, head, value, prntvalue;
        Scanner input = new Scanner(System.in);

        size = input.nextInt();
        head = 1;
        for (row = 0; row < size; row++) {
            prntvalue = head;
            value = row + 1;
            for (col = 0; col < size; col++) {
                System.out.print((prntvalue) + " ");
                if (col < (size - row - 1)) {
                    value++;
                } else if (col > (size - row - 1)) {
                    value--;
                }
                prntvalue += value;
            }
            head += row + 1;
            System.out.println("");
        }
    }
}