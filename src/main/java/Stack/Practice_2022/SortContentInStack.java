package Stack.Practice_2022;

import java.util.Arrays;
import java.util.Stack;

public class SortContentInStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(2);
        stack.push(30);
        stack.push(4);
        stack.push(5);

        System.out.println(Arrays.toString(stack.toArray()));
        System.out.println(sortStack(stack));
    }

    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();

        while (!stack.isEmpty()) {
            int top = stack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek() > top) {
                stack.push(sortedStack.pop());
            }

            sortedStack.push(top);
        }
        return sortedStack;
    }
}
