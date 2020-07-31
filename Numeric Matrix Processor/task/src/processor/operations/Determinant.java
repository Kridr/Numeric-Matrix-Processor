package processor.operations;

import processor.operations.MatrixOperation;

public class Determinant implements MatrixOperation {
    @Override
    public void execute() {
        double[][] matrix = inputMatrix();

        if (matrix.length == matrix[0].length) {
            double det = det(matrix);

            System.out.println("The result is:");
            System.out.println(det + "\n");
        } else {
            System.out.println("ERROR");
        }
    }

    //only for square matrix
    static double det(double[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        } else if (matrix.length == 1) {
            return matrix[0][0];
        } else if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        } else {
            double res = 0;

            for (int i = 0; i < matrix.length; i++) {
                res += matrix[0][i] * (i % 2 == 0 ? 1 : -1) * det(excludeRowAndCol(matrix, 0, i));
            }

            return res;
        }
    }

    //only for square matrix
    static double[][] excludeRowAndCol(double[][] matrix, int row, int col) {
        double[][] result = new double[matrix.length - 1][matrix.length - 1];

        boolean wasRow = false;
        for (int i = 0; i < matrix.length; i++) {
            if (i == row) {
                wasRow = true;
            } else {
                boolean wasCol = false;
                for (int j = 0; j < matrix.length; j++) {
                    if (j == col) {
                        wasCol = true;
                    } else {
                        result[wasRow ? i - 1 : i][wasCol ? j - 1 : j] = matrix[i][j];
                    }
                }
            }
        }

        return result;
    }
}
