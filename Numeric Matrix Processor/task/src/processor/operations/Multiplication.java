package processor.operations;

import processor.operations.MatrixOperation;

public class Multiplication implements MatrixOperation {
    @Override
    public void execute() {
        double[][] matrix1 = inputMatrix("first ");
        double[][] matrix2 = inputMatrix("second ");

        if (matrix1[0].length == matrix2.length) {
            double[][] result = multiplication(matrix1, matrix2);

            outputMatrix(result, "multiplication ");
        } else {
            System.out.println("ERROR");
        }
    }

    static double[][] multiplication(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix2[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {

                double cellValue = 0;
                for (int k = 0; k < matrix1[i].length; k++) {
                    cellValue += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = cellValue;
            }
        }

        return result;
    }
}
