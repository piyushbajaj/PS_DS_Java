package Practice2025.Neetcode.Stack;

import java.util.Stack;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.Stack
 * <p>
 * User: piyushbajaj
 * Date: 24/07/25
 * Time: 11:23 am
 */
public class P2_MinStack1 {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public P2_MinStack1() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        P2_MinStack1 minStack = new P2_MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
