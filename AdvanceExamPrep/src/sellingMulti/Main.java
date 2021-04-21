package sellingMulti;

import java.util.*;

public class Main {

    private static char[][] matrix;
    private static int[] indexes;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        readMatrix(scan, Integer.parseInt(scan.nextLine()));
        indexes = findIndexes('S');
        int money = 0;

        while (money < 50 && isInBounds()) {

            String input = scan.nextLine();
            setPosition('-');

            if ("up".equals(input)) {
                indexes[0]--;
            } else if ("down".equals(input)) {
                indexes[0]++;
            } else if ("left".equals(input)) {
                indexes[1]--;
            } else if ("right".equals(input)) {
                indexes[1]++;
            }
            if (isInBounds()) {
                if (matrix[indexes[0]][indexes[1]] == 'O') {

                    setPosition('-');
                    indexes = findIndexes('O');

                } else if (Character.isDigit(matrix[indexes[0]][indexes[1]])) {

                    money += Integer.parseInt(String.valueOf(matrix[indexes[0]][indexes[1]]));
                }
                setPosition('S');
            }
        }
        if (isInBounds()) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }

        System.out.println("Money: " + money);
        printMatrix();

    }

    private static void printMatrix() {
        Arrays.stream(matrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }

    private static void readMatrix(Scanner scan, int rows) {
        matrix = new char[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }

    private static boolean isInBounds() {
        return indexes[0] >= 0 && indexes[0] < matrix.length && indexes[1] >= 0 && indexes[1] < matrix[indexes[0]].length;
    }

    private static void setPosition(char toSet) {
        matrix[indexes[0]][indexes[1]] = toSet;
    }

    private static int[] findIndexes(char toFind) {
        int[] indexes = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == toFind) {
                    indexes[0] = i;
                    indexes[1] = j;
                }
            }
        }
        return indexes;
    }
}