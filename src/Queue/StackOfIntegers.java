package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 12/12/16.
 */
public class StackOfIntegers {
    public boolean checkConsecutiveness(Stack<Integer> stk){
        Queue<Integer> queue = new LinkedList<>();
        boolean flag = true;

        while (!stk.empty()){
            queue.add(stk.pop());
        }
        while (!queue.isEmpty()){
            stk.push(queue.remove());
        }
        while (!stk.empty()){
            int n = stk.pop();
            queue.add(n);
            if(!stk.empty()){
                int m = stk.pop();
                queue.add(m);
                if(Math.abs(m-n)!=1)
                    flag = false;
            }
        }

        while (!queue.isEmpty())
            stk.push(queue.remove());

        return flag;
    }

    public static void main(String[] args) {
        StackOfIntegers SI = new StackOfIntegers();
        Stack<Integer> stack = new Stack<>();

        stack.push(4);
        stack.push(5);
        stack.push(-2);
        stack.push(-3);
        stack.push(11);
        stack.push(10);
        stack.push(5);


        System.out.println("Whether the stack of elements are consecutive pair or not? " + SI.checkConsecutiveness(stack));
    }
}
