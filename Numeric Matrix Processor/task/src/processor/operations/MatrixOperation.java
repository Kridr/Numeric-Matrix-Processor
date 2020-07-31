package processor.operations;

import java.util.Scanner;

public interface MatrixOperation {
    Scanner scanner = new Scanner(System.in);

    void execute();

    default double[][] inputMatrix(String additionalInfo) {
        System.out.print("Enter the size of " + additionalInfo + "matrix: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        double[][] matrix = new double[n][m];

        System.out.println("Enter " + additionalInfo + "matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        return matrix;
    }

    default double[][] inputMatrix() {
        System.out.print("Enter the size of matrix: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        double[][] matrix = new double[n][m];

        System.out.println("Enter matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        return matrix;
    }

    default void outputMatrix(double[][] matrix, String additionalInfo) {
        System.out.println("The " + additionalInfo + "result is:");
        for (double[] row : matrix) {
            for (double elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    default void outputMatrix(double[][] matrix) {
        System.out.println("The result is:");
        for (double[] row : matrix) {
            for (double elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
