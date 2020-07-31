package processor.operations;

public class Inverse implements MatrixOperation {
    @Override
    public void execute() {
        double[][] matrix = inputMatrix();

        if (Determinant.det(matrix) != 0 && matrix.length == matrix[0].length) {

            double[][] result = inverse(matrix);

            outputMatrix(result);
        } else {
            System.out.println("ERROR");
        }
    }

    double[][] inverse(double[][] matrix) {
        double[][] c = new double[matrix.length][matrix.length];

        double detMatrix = Determinant.det(matrix);

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                c[i][j] = Math.pow(-1, i + j) *
                        Determinant.det(Determinant.excludeRowAndCol(matrix, i, j));
            }
        }

        return MultiplicationByNumber.multiplicationByNumber(1 / detMatrix,
                Transpose.mainDiagonal(c));

    }
}
