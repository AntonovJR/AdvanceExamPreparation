package cookingArrayDeque;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();//queue
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();//stack

        String[] liquidsAsText = scanner.nextLine().split("\\s+");
        for (String s : liquidsAsText) {
            liquids.offer(Integer.parseInt(s));

        }

        String[] ingredientsAsText = scanner.nextLine().split("\\s+");
        for (String s : ingredientsAsText) {
            ingredients.push(Integer.parseInt(s));

        }
        int breadCount = 0;
        int cakeCount = 0;
        int pastryCount = 0;
        int pieCount = 0;
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int liq = liquids.pop();
            int ind = ingredients.pop();
            if (liq + ind == 100) {
                pieCount++;
            } else if (liq + ind == 75) {
                pastryCount++;

            } else if (liq + ind == 50) {
                cakeCount++;
            } else if (liq + ind == 25) {
                breadCount++;
            } else {
                ingredients.push(ind + 3);
            }

        }
        if (breadCount > 0 && cakeCount > 0 && pastryCount > 0 && pieCount > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        if (!liquids.isEmpty()) {
            System.out.println("Liquids left: " + liquids.toString().replaceAll("\\[","").replaceAll("\\]", ""));

        }else{
            System.out.println("Liquids left: none");
        }

        if (!ingredients.isEmpty()) {
            System.out.println("Ingredients left: " + ingredients.toString().replaceAll("\\[","").replaceAll("\\]", ""));

        }else{
            System.out.println("Ingredients left: none");
        }

        System.out.printf("Bread: %d%n",breadCount);
        System.out.printf("Cake: %d%n",cakeCount);
        System.out.printf("Fruit Pie: %d%n",pieCount);
        System.out.printf("Pastry: %d",pastryCount);

    }

}
