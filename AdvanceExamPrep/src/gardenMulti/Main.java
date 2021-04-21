package gardenMulti;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrices = createMatrices(scanner);
        String input = scanner.nextLine();
        while (!"Bloom Bloom Plow".equals(input)) {
            String[] tokens = input.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);

            for (int rows = 0; rows <= matrices.length - 1; rows++) {
                for (int cols = col; cols <= col; cols++) {
                    matrices[rows][cols] += 1;

                }
            }
            for (int cols = 0; cols <= matrices.length - 1; cols++) {
                for (int rows = col; rows <= row; rows++) {
                    matrices[rows][cols] += 1;
                }
            }
            matrices[row][col] -= 1;

            input = scanner.nextLine();
        }
        for (int row = 0; row <matrices.length ; row++) {
            for (int col = 0; col < matrices[row].length ; col++) {
                System.out.print(matrices[row][col]+" ");

            }
            System.out.println("");
        }
    }


    private static int[][] createMatrices(Scanner scanner) {
        String[] data = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        return new int[rows][cols];
    }
}
