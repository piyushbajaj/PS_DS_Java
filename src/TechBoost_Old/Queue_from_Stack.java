package TechBoost_Old;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 26/03/18.
 */
public class Queue_from_Stack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        Queue_from_Stack queue_from_stack = new Queue_from_Stack();
        queue_from_stack.enqueue(1);
        queue_from_stack.enqueue(2);
        queue_from_stack.enqueue(3);
        queue_from_stack.enqueue(4);
        queue_from_stack.enqueue(5);

        System.out.println(queue_from_stack.dequeue());
        System.out.println(queue_from_stack.dequeue());
    }

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }

        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }


        return stack2.pop();
    }
}
