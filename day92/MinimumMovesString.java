public class MinimumMovesString {

    public int minimumMoves(String s) {

        int moves = 0;
        for (int index = 0; index < s.length();) {
            char symbol = s.charAt(index);
            if (symbol == 'X') {
                moves += 1;
                index += 3;
            } else {
                index++;
            }

        }
        return moves;
    }

}
