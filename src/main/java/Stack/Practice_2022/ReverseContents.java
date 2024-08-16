package Stack.Practice_2022;

import java.util.Arrays;
import java.util.Stack;

public class ReverseContents {
    public static void main(String[] args) {
        ReverseContents rc = new ReverseContents();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(Arrays.toString(stack.toArray()));
        rc.reverseStackElements(stack);
        System.out.println(Arrays.toString(stack.toArray()));
    }

    public void insertInBottom(Stack<Integer> stack, Integer value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int temp = stack.pop();
        insertInBottom(stack, value);


        stack.push(temp);
    }

    public void reverseStackElements(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();
        reverseStackElements(stack);
        insertInBottom(stack, temp);
    }
}
