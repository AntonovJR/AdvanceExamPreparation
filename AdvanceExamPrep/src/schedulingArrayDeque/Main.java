package schedulingArrayDeque;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();//last
        ArrayDeque<Integer> threads = new ArrayDeque<>();//first/peek

        String[] tasksAsText = scanner.nextLine().split(", ");
        for (String s : tasksAsText) {
            tasks.push(Integer.parseInt(s));

        }

        String[] threadsAsText = scanner.nextLine().split("\\s+");
        for (String s : threadsAsText) {
            threads.offer(Integer.parseInt(s));

        }

        int killValue = Integer.parseInt(scanner.nextLine());
        while (!threads.isEmpty()) {
            if( tasks.peek()==killValue){
                System.out.printf("Thread with value %d killed task %d%n", threads.peek(),killValue);
                for (Integer thread : threads) {
                    System.out.print(thread+" ");

                }
                return;
            }
            if (threads.peek() >= tasks.peek()) {
        threads.pop();
        tasks.poll();
            }else if(threads.peek()< tasks.peek()){
                threads.pop();
            }

        }


    }
}
