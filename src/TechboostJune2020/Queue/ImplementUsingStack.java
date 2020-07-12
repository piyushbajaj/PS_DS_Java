package TechboostJune2020.Queue;

import java.util.Stack;

public class ImplementUsingStack {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();


    // T.C: O(N)
    public void enqueue_better(int data) {
        // Pushing all existing elements from Stack1 to Stack2
        while(!s1.empty()) {
            s2.push(s1.pop());
        }

        //New element gets inserted to stack, so that it will remain in the bottom of stack1
        s1.push(data);

        //Pushing every element back to stack1
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }

    //T.C: O(1)
    public int dequeue_better() {
        if(s1.empty()){
            System.out.println("List is emppty, cant perform dequeue");
            return -1;
        }

        return s1.pop();
    }

    // T.C: O(N)
    public void enqueue(int data) {
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        s1.push(data);
    }

    // T.C: O(N)
    public int dequeue() {
        if(s1.empty()) {
            System.out.println("Queue is empty");
        }
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        return s1.pop();
    }

    public static void main(String[] args) {
        ImplementUsingStack implementUsingStack = new ImplementUsingStack();
        implementUsingStack.enqueue_better(10);
        implementUsingStack.enqueue_better(20);
        implementUsingStack.enqueue_better(30);
        System.out.println(implementUsingStack.dequeue_better());
        implementUsingStack.enqueue_better(40);
        implementUsingStack.enqueue_better(50);
        System.out.println(implementUsingStack.dequeue_better());
    }
}
