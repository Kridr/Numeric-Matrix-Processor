package processor.operations;

import processor.operations.MatrixOperation;

public class Addition implements MatrixOperation {
    @Override
    public void execute() {
        double[][] matrix1 = inputMatrix("first ");
        double[][] matrix2 = inputMatrix("second ");

        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            double[][] result = add(matrix1, matrix2);

            outputMatrix(result, "addition ");
        } else {
            System.out.println("ERROR");
        }
    }

    static double[][] add(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }
}
