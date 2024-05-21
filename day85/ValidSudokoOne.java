import java.util.HashMap;

public class ValidSudokoOne {
    public boolean isValidSudoku(char[][] board) {

        // row validation
        // col validation
        // sub matrix validation

        return rowValidation(board) && columnValidation(board) && matrixValidation(board);

    }

    private boolean matrixValidation(char board[][]) {

        HashMap<Character, Integer> map;
        int numberOfSubMatrix = board.length;
        int currentSubMatricx = 0;
        int row = 0;
        int col = 0;

        for (; currentSubMatricx < numberOfSubMatrix; currentSubMatricx++) {
            row = 3 * (currentSubMatricx / 3);

            map = new HashMap<>();
            for (int subrow = 0; subrow < 3; subrow++) {
                col = 3 * (currentSubMatricx % 3);
                for (int subcol = 0; subcol < 3; subcol++) {
                    char currentValue = board[row][col];
                    if (currentValue != '.' && map.containsKey(currentValue)) {
                        return false;
                    }
                    map.put(currentValue, 1);
                    col++;
                }
                row++;
            }

        }
        return true;

    }

    private boolean columnValidation(char board[][]) {

        HashMap<Character, Integer> map;

        int col = 0;
        for (; col < board.length; col++) {
            map = new HashMap<>();
            int row = 0;
            for (; row < board.length; row++) {
                char currentData = board[row][col];
                if (currentData != '.' && map.containsKey(currentData)) {
                    return false;
                }
                map.put(currentData, 1);
            }
        }
        return true;
    }

    private boolean rowValidation(char[][] board) {

        HashMap<Character, Integer> map;
        int row = 0;

        for (; row < board.length; row++) {
            map = new HashMap<>();
            int col = 0;
            for (; col < board.length; col++) {
                char currentData = board[row][col];
                if (currentData != '.' && map.containsKey(currentData)) {
                    return false;
                }
                map.put(currentData, 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char arr[][] = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };
        ValidSudokoOne validSudokoOne = new ValidSudokoOne();
        boolean status = validSudokoOne.isValidSudoku(arr);
        System.out.println(status);

    }

}
