package bombsArrayDeque;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> effects = new ArrayDeque<>();//first queue
        ArrayDeque<Integer> casing = new ArrayDeque<>();//last stack


        String[] effectsAsText = scanner.nextLine().split(", ");
        for (String s : effectsAsText) {
            effects.offer(Integer.parseInt(s));
        }
        // first queue
        String[] casingAsText = scanner.nextLine().split(", ");
        for (String x : casingAsText) {
            casing.push(Integer.parseInt(x));
        }
        //last stack
        int datura = 0;
        int cherry = 0;
        int smoke = 0;

        while (!effects.isEmpty() && !casing.isEmpty()) {

            int sum = effects.peek()+casing.peek();

            if (sum == 40) {
                datura++;
              effects.pop();
              casing.pop();
            } else if (sum == 60) {
                cherry++;
                effects.pop();
                casing.pop();

            } else if (sum == 120) {
                smoke++;
                effects.pop();
                casing.pop();
            } else {
                casing.push(casing.pop() - 5);
            }

            if (datura >= 3 && cherry >= 3 && smoke >= 3) {
                break;
            }
        }
        if (datura >= 3 && cherry >= 3 && smoke >= 3) {

            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.printf("Bomb Effects: %s%n",effects.toString().replaceAll("\\[","").replaceAll("\\]", ""));
        }
        if (casing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.printf("Bomb Casings: %s%n",casing.toString().replaceAll("\\[","").replaceAll("\\]", ""));
        }
        System.out.printf("Cherry Bombs: %d%n", cherry);
        System.out.printf("Datura Bombs: %d%n", datura);
        System.out.printf("Smoke Decoy Bombs: %d", smoke);

    }

}
