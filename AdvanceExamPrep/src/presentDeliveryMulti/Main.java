package presentDeliveryMulti;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int row = 0;
    public static int col = 0;
    public static int givenPresents = 0;
    public static int goodKids = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int presentsCount = Integer.parseInt(scanner.nextLine());
        String[][] matrices = createMatrices(scanner);

        String input = scanner.nextLine();
        String var = "";
        while (!"Christmas morning".equals(input)) {
            matrices[row][col] = "-";
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
            if (col > matrices.length - 1 || col < 0 || row > matrices.length - 1 || row < 0) {

                break;
            }

            var = matrices[row][col];

            if (var.equals("V")) {
                givenPresents++;
                goodKids++;
            }
            if (var.equals("C")) {
                if (!(matrices[row][col + 1]).equals("-")) {
                    givenPresents++;
                    if ((matrices[row][col + 1]).equals("V")) {
                        goodKids++;
                    }
                    matrices[row][col + 1] = "-";
                }
                if (!(matrices[row][col - 1]).equals("-")) {
                    givenPresents++;
                    if ((matrices[row][col - 1]).equals("V")) {
                        goodKids++;
                    }
                    matrices[row][col - 1] = "-";
                }
                if (!(matrices[row + 1][col]).equals("-")) {
                    givenPresents++;
                    if ((matrices[row + 1][col]).equals("V")) {
                        goodKids++;
                    }
                    matrices[row + 1][col] = "-";
                }
                if (!(matrices[row - 1][col]).equals("-")) {
                    givenPresents++;
                    if ((matrices[row - 1][col]).equals("V")) {
                        goodKids++;
                    }
                    matrices[row - 1][col] = "-";
                }


            }
            matrices[row][col] = "S";

            if (givenPresents >= presentsCount) {
                break;
            }
            input = scanner.nextLine();


        }

        if (!(col > matrices.length - 1 || col < 0 || row > matrices.length - 1 || row < 0) && presentsCount <= givenPresents && !var.equals("C")) {
            System.out.println("Santa ran out of presents!");
        }


        printMatrix(matrices);
        if (thereAreStillGoodKids(matrices) != 0) {
            System.out.printf("No presents for %d nice kid/s.", thereAreStillGoodKids(matrices));

        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", goodKids);
        }

    }

    private static int thereAreStillGoodKids(String[][] matrices) {
        int n = 0;
        for (int i = 0; i < matrices.length; i++) {
            for (int j = 0; j < matrices.length; j++) {
                if (matrices[i][j].equals("V")) {
                    n++;
                }

            }
        }
        return n;
    }


    private static String[][] createMatrices(Scanner scanner) {
        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[][] matrices = new String[matrixSize][];
        for (int i = 0; i < matrixSize; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("S")) {
                    row = i;
                    col = j;
                }
            }
            matrices[i] = input;
        }
        return matrices;
    }

    private static void printMatrix(String[][] matrix) {
        Arrays.stream(matrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", " ")).forEach(System.out::println);
    }
}