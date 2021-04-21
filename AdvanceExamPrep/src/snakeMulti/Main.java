package snakeMulti;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int snakeRow = 0;
    public static int snakeCol = 0;
    public static int food = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrices = createMatrices(scanner);
        String input = scanner.nextLine();
        while (food<10) {
            matrices[snakeRow][snakeCol] = '.';
            switch (input) {
                case "up":
                    snakeRow -= 1;
                    break;
                case "down":
                    snakeRow += 1;
                    break;
                case "left":
                    snakeCol -= 1;
                    break;
                case "right":
                    snakeCol += 1;
                    break;
            }

            if (snakeCol > matrices.length-1 || snakeCol < 0 || snakeRow > matrices.length-1 || snakeRow < 0) {
                System.out.println("Game over!");
                break;
            }

            char var = matrices[snakeRow][snakeCol];
            if(var=='*'){
                food++;
                if(food==10){
                    matrices[snakeRow][snakeCol] = 'S';
                    break;
                }
            }
            if(var=='B') {
                matrices[snakeRow][snakeCol] = '.';
                int[] indexes = new int[2];
                for (int i = 0; i < matrices.length; i++) {
                    for (int j = 0; j < matrices[0].length; j++) {
                        if (matrices[i][j] == 'B') {
                            indexes[0] = i;
                            indexes[1] = j;
                        }
                    }
                }
                snakeRow = indexes[0];
                snakeCol = indexes[1];

            }
                matrices[snakeRow][snakeCol]='S';
                input = scanner.nextLine();


        }
        if(food<10){
            System.out.printf("Food eaten: %d%n",food);

        }else{
            System.out.printf("You won! You fed the snake.%nFood eaten: %d%n",food);
        }
        printMatrix(matrices);

    }
    private static char[][] createMatrices(Scanner scanner) {

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrices = new char[n][];
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.contains("S")) {
                snakeRow = i;
                snakeCol = input.indexOf("S");
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
