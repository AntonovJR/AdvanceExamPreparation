package flowerWreathsArrayDeque;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> roses = new ArrayDeque<>();//first queue
        ArrayDeque<Integer> lilies = new ArrayDeque<>();//last stack
        int wreaths = 0;
        String[] liliesAsText = scanner.nextLine().split(", ");
        for (String s : liliesAsText) {
            lilies.push(Integer.parseInt(s));
//last stack
        }

        String[] rosesAsText = scanner.nextLine().split(", ");
        for (String s : rosesAsText) {
            roses.offer(Integer.parseInt(s));
// first queue
        }
        int sum = 0;
        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int rose = roses.peek();
            int lili = lilies.peek();

            if (rose + lili == 15) {
                wreaths++;
                roses.pop();
                lilies.pop();
            } else if (rose + lili > 15) {
                lilies.pop();
                lilies.push(lili - 2);
            } else {
                sum += roses.peek() + lilies.peek();
                roses.pop();
                lilies.pop();
            }

        }
        wreaths += sum / 15;
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %s wreaths more!", 5 - wreaths);
        }


    }
}

