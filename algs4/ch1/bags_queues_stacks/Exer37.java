package ch1.bags_queues_stacks;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by zzq on 2016/11/30.
 * <p>
 * Josephus problem. In the Josephus problem from antiquity, N people are in dire straits and
 * agree to the following strategy to reduce the population. They arrange themselves in a circle
 * (at positions numbered from 0 to N-1) and proceed around the circle, eliminating every Mth
 * person until only one person is left. Legend has it that Josephus figured out where to sit to
 * avoid being eliminated. Write a Queue client Josephus.java that takes M and N from the command
 * line and prints out the order in which people are eliminated (and thus would show Josephus
 * where to sit in the circle).
 * <p>
 * e.g.
 * Input: 2 7
 * Output: 1 3 5 0 4 2 6
 */
public class Exer37 {
    private int M;  //every M person
    private List<Integer> people ;

    public Exer37(int M, int N) {
        this.M = M;
        people = IntStream.range(0,N).boxed().collect(Collectors.toList());
    }

    public void print() {
        int i = 0;
        while(!people.isEmpty()){
            i=(i+M-1)%people.size();
            System.out.println(people.get(i));
            people.remove(i);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int N = scan.nextInt();
        Exer37 josephus = new Exer37(M, N);
        josephus.print();
    }
}
/*
//Standard Answer:
public class Josephus {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        // initialize the queue
        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < n; i++)
            queue.enqueue(i);

        while (!queue.isEmpty()) {
            for (int i = 0; i < m-1; i++)
                queue.enqueue(queue.dequeue()); //use this to resort
            StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
    }
}
*/
