package lootboxArrayDeque;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstLoot = new ArrayDeque<>();//first queue
        ArrayDeque<Integer> secondLoot = new ArrayDeque<>();//last stack

        String[] lootAsText = scanner.nextLine().split(" ");
        for (String s : lootAsText) {
            firstLoot.offer(Integer.parseInt(s));
// first queue
        }
        lootAsText = scanner.nextLine().split(" ");
        for (String s : lootAsText) {
            secondLoot.push(Integer.parseInt(s));
//last stack
        }
        int value = 0;
        while(!firstLoot.isEmpty()&&!secondLoot.isEmpty()){
            int sum = firstLoot.peek()+secondLoot.peek();
            if(sum%2==0){
                value+=sum;
                firstLoot.pop();
                secondLoot.pop();
            }else{
                firstLoot.offer(secondLoot.pop());
            }
        }
        if(firstLoot.isEmpty()){
            System.out.println("First lootbox is empty");
        }else{
            System.out.println("Second lootbox is empty");
        }
        if(value>=100){
            System.out.printf("Your loot was epic! Value: %d",value);
        }else{
            System.out.printf("Your loot was poor... Value: %d",value);
        }
    }
}
