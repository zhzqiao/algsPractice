package ch1.bags_queues_stacks;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by zzq on 2016/11/30.
 * <p>
 * Copy a stack. Create a new constructor for the linked-list implementation of Exer42.java so
 * that Exer42 t = new Exer42(s) makes t reference a new and independent copy of the stack s.
 */
public class Exer42<Item> {
    private Exer42.Node<Item> firstNode;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Exer42.Node<Item> next;
        Node(){}
        Node(Node<Item> n){
            if(n!=null){
                this.item = n.item;
                this.next = new Node<Item>(n.next);
            }
        }
    }

    public Exer42() {
        this.firstNode = null;
        n = 0;
    }

    public Exer42(Exer42<Item> old){
        firstNode = new Node<Item>(old.firstNode);
        this.n = old.n;
    }

    public int size(){
        return this.n;
    }

    public boolean isEmpty(){
        return firstNode == null;
    }

    public void push(Item item){
        Exer42.Node nextNode = this.firstNode;
        this.firstNode = new Node<Item>();
        this.firstNode.item = item;
        this.firstNode.next = nextNode;
        this.n++;
    }

    public Item pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = this.firstNode.item;
        this.firstNode = this.firstNode.next;
        this.n--;
        return item;
    }


    /**
     * Unit tests the {@code Exer42} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        Exer42<String> exer42 = new Exer42<String>();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            exer42.push(scan.next());
        }
        Exer42<String> exer42Copy = new Exer42<String>(exer42);
        System.out.println(exer42.n);
        while(!exer42.isEmpty()){
            System.out.println("1: "+exer42.pop());
        }
        //TODO 为何会多输出一个null
        System.out.println(exer42Copy.n);
        while(!exer42Copy.isEmpty()){
            System.out.println("2: "+exer42Copy.pop());
        }
    }
}

