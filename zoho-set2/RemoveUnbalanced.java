/**
 * RemoveUnbalanced
 */
public class RemoveUnbalanced {

    public static void main(String[] args) {
        String exp = "((abc)((de))";
        exp = removeUnbalanced(exp);
        System.out.println(exp);
    }

    private static String removeUnbalanced(String exp) {

        int open = 0;
        for (int index = 0; index < exp.length(); index++) {
            char character = exp.charAt(index);

            if (character == '(') {
                open++;
            } else if (character == ")") {
                open--;
            }
            if (open == -1) {

            }
        }
    }

}