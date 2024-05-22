class DiagonalSum {
    public int diagonalSum(int[][] mat) {

        int n = mat.length;
        if (n % 2 == 1) {
            int center = (n - 1) / 2;
            return matSum(mat) - mat[center][center];
        }
        return matSum(mat);

    }

    private int matSum(int[][] mat) {
        int sum = 0;
        int row = 0;
        int col = mat.length - 1;
        for (int index = 0; index < mat.length; index++) {
            sum += mat[index][index];
        }
        for (int index = 0; index < mat.length; index++) {
            sum += mat[row + index][col - index];
        }
        return sum;
    }

}