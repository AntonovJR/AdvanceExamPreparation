package revoltMulti;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int row = 0;
    public static int col = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrices = createMatrices(matrixSize, scanner);
        int[] previous;
        String input = scanner.nextLine();
        matrices[row][col] = '-';
        int counter = 0;
        while (!(counter == n)) {

            previous = new int[]{row, col};
            switch (input) {
                case "up":
                    row -= 1;
                    break;
                case "down":
                    row += 1;
                    break;
                case "left":
                    col -= 1;
                    break;
                case "right":
                    col += 1;
                    break;
            }

            if (col > matrices.length - 1 || col < 0) {
                if (col < 0) {
                    col = matrices.length - 1;
                } else {
                    col = 0;
                }
            }
            if (row > matrices.length - 1 || row < 0) {
                if (row < 0) {
                    row = matrices.length - 1;
                } else {
                    row = 0;
                }
            }

            char var = matrices[row][col];

            if (var == 'F') {
                matrices[row][col] = 'f';
                System.out.println("Player won!");
                printMatrix(matrices);
                return;
            }
            if (var == 'T') {
                row = previous[0];
                col = previous[1];
            }
            if (var != 'B') {
                counter++;
            }else{
                continue;
            }

            if (counter < n){
                input = scanner.nextLine();
            }

        }
        System.out.println("Player lost!");
        matrices[row][col] = 'f';
        printMatrix(matrices);

    }

    private static char[][] createMatrices(int matrixSize, Scanner scanner) {
        char[][] matrices = new char[matrixSize][];
        for (int i = 0; i < matrixSize; i++) {
            String input = scanner.nextLine();
            if (input.contains("f")) {
                row = i;
                col = input.indexOf("f");
            }
            matrices[i] = input.toCharArray();
        }
        return matrices;
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }
}