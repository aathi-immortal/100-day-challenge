public class RemoveUnbalanced {

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
                "((abc)((de))", // balanced after removal
                "(((ab)", // unbalanced, should become "(ab)"
                "a(b)c)d", // unbalanced, should become "a(b)c"
                "(a(b)c", // unbalanced, should become "a(b)c"
                "((a)((b)c)", // unbalanced, should become "(a)((b)c)"
                "((a((b)c)d)", // balanced, should remain the same
                "abc", // no parentheses, should remain the same
                "()", // balanced, should remain the same
                ")(", // unbalanced, should become ""
                "(((", // unbalanced, should become ""
                ")))", // unbalanced, should become ""
                "((abc)((de)))", // balanced, should remain the same
        };

        for (String exp : testCases) {
            String result = removeUnbalanced(exp);
            System.out.println("Input: " + exp + " => Output: " + result);
        }
    }

    private static String removeUnbalanced(String exp) {
        StringBuilder builder = new StringBuilder(exp);
        int open = 0;

        // left to right
        for (int index = 0; index < exp.length(); index++) {
            char character = exp.charAt(index);

            if (character == '(') {
                open++;
            } else if (character == ')') {
                open--;
            }
            if (open == -1) {
                open = 0;
                builder.setCharAt(index, '-');
            }
        }

        int close = 0;
        // right to left
        for (int index = exp.length() - 1; index > -1; index--) {
            char character = exp.charAt(index);

            if (character == ')') {
                close++;
            } else if (character == '(') {
                close--;
            }
            if (close == -1) {
                close = 0;
                builder.setCharAt(index, '-');
            }
        }

        removeExtra(builder);
        return builder.toString();
    }

    private static void removeExtra(StringBuilder builder) {
        int index = 0;
        while (index < builder.length()) {
            if (builder.charAt(index) == '-') {
                builder.deleteCharAt(index);
            } else {
                index++;
            }
        }
    }
}
