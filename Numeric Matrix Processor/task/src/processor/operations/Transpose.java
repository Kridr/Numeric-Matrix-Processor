package processor.operations;

import processor.operations.MatrixOperation;

public class Transpose implements MatrixOperation {
    final static String options =
            "\n1. Main diagonal\n" +
            "2. Side diagonal\n" +
            "3. Vertical line\n" +
            "4. Horizontal line";

    @Override
    public void execute() {
        System.out.println(options);
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        double[][] matrix = inputMatrix();

        double[][] result;

        switch (choice) {
            case 1:
                result = mainDiagonal(matrix);
                break;
            case 2:
                result = sideDiagonal(matrix);
                break;
            case 3:
                result = verticalLine(matrix);
                break;
            case 4:
                result = horizontalLine(matrix);
                break;
            default:
                result = new double[0][0];
        }

        outputMatrix(result);
    }

    static double[][] mainDiagonal(double[][] matrix) {
        double[][] result = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }

        return result;
    }

    static double[][] sideDiagonal(double[][] matrix) {
        double[][] result = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[matrix[0].length - 1 - j][matrix.length - 1 - i];
            }
        }

        return result;
    }

    static double[][] verticalLine(double[][] matrix) {
        double[][] result = new double[matrix.length][matrix[0].length];


        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[i][matrix[0].length - 1 - j];
            }
        }

        return result;
    }

    static double[][] horizontalLine(double[][] matrix) {
        double[][] result = new double[matrix.length][matrix[0].length];


        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[matrix.length - 1 - i][j];
            }
        }

        return result;
    }
}
