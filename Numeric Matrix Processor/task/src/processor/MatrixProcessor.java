package processor;

import processor.operations.*;

import java.util.Scanner;

public class MatrixProcessor {
    MatrixOperation matrixOperation;
    final static String menu =
            "1. Add matrices\n" +
            "2. Multiply matrix to a constant\n" +
            "3. Multiply matrices\n" +
            "4. Transpose matrix\n" +
            "5. Calculate a determinant\n" +
            "6. Inverse matrix\n" +
            "0. Exit";

    void methodChooser(int numberOfMethod) {
        switch (numberOfMethod) {
            case 1:
                matrixOperation = new Addition();
                break;
            case 2:
                matrixOperation = new MultiplicationByNumber();
                break;
            case 3:
                matrixOperation = new Multiplication();
                break;
            case 4:
                matrixOperation = new Transpose();
                break;
            case 5:
                matrixOperation = new Determinant();
                break;
            case 6:
                matrixOperation = new Inverse();
                break;
        }
    }

    void process() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(menu);
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        while (choice != 0) {
            methodChooser(choice);

            matrixOperation.execute();

            System.out.println(menu);
            System.out.print("Your choice: ");
            choice = MatrixOperation.scanner.nextInt();
        }
    }
}
