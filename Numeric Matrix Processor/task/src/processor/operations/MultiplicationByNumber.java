package processor.operations;

import processor.operations.MatrixOperation;

public class MultiplicationByNumber implements MatrixOperation {
    @Override
    public void execute() {
        double[][] matrix = inputMatrix();
        double c = scanner.nextInt();

        double[][] result = multiplicationByNumber(c, matrix);

        outputMatrix(result, "multiplication by number");
    }

    static double[][] multiplicationByNumber(double c, double[][] matrix) {
        double[][] result = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = c * matrix[i][j];
            }
        }

        return result;
    }
}
