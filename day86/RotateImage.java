/**
 * RotateImage
 */
public class RotateImage {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int row = 0;
        int col = 0;

        for (int i = n - 1; i <= 2; i = i - 2) {

            for (int index = 0; index < i; index++) {
                minorRotate(row + index, col, matrix);
            }

            row += 1;
            col += 1;
        }

    }

    private void minorRotate(int row, int col, int[][] matrix) {

        int increment = (matrix.length - 1) - (col * 2);
        int leftTop = matrix[row][col];
        int rightTop = matrix[row][col + increment];
        int leftBottom = matrix[row + increment][col];
        int rightBottom = matrix[row + increment][col + increment];

        matrix[row][col] = leftBottom;
        matrix[row][col + increment] = leftTop;
        matrix[row + increment][col + increment] = rightTop;
        matrix[row + increment][col] = rightBottom;

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
    }

}
