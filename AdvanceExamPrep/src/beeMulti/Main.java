package beeMulti;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int flower = 0;
    public static int beeRow = 0;
    public static int beeCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrices = createMatrices(scanner);
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            matrices[beeRow][beeCol] = '.';
            switch (input) {
                case "up":
                    beeRow -= 1;
                    break;
                case "down":
                    beeRow += 1;
                    break;
                case "left":
                    beeCol -= 1;
                    break;
                case "right":
                    beeCol += 1;
                    break;
            }

            if (beeCol > matrices.length-1 || beeCol < 0 || beeRow > matrices.length-1 || beeRow < 0) {
                System.out.println("The bee got lost!");
                break;
            }

            char var = matrices[beeRow][beeCol];
            if(var=='f'){
                flower++;
            }
            if(var=='O'){
                input=input;
            }else {
                matrices[beeRow][beeCol]='B';
                input = scanner.nextLine();
            }

        }

        if(flower<5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",(5-flower));

        }else{
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",flower);
        }
        printMatrix(matrices);
    }

    private static char[][] createMatrices(Scanner scanner) {

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrices = new char[n][];
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.contains("B")) {
                beeRow = i;
                beeCol = input.indexOf("B");
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
