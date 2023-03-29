package Leetcode.MustDoEasyQuestions;

import java.util.Stack;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 30/12/22
 * Time: 5:09 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/min-stack/description/">...</a>
 * TC: O(1)
 * <p>
 * Pattern: Stack
 */
public class P7_Min_Stack {
    // Stack stores current value and minimum value
    Stack<int[]> stack;

    public P7_Min_Stack() {
        stack = new Stack<>();
    }

    public static void main(String[] args) {

        // Your MinStack object will be instantiated and called as such:
        P7_Min_Stack obj = new P7_Min_Stack();
        obj.push(-2);
        obj.push(-5);
        obj.push(0);
        obj.push(-3);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

        System.out.println("Top: " + param_3);
        System.out.println("Get Minimum: " + param_4);
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
            return;
        }

        int currMin = Math.min(val, stack.peek()[1]);
        stack.push(new int[] {val, currMin});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

//    public int getMin() {
//        return getMin_recur(new int[] {Integer.MAX_VALUE});
//    }
//
//    public int getMin_recur(int[] min) {
//        if (!stack.isEmpty()) {
//            int temp = stack.pop();
//            if (temp < min[0]) {
//                min[0] = temp;
//            }
//            getMin_recur(min);
//            stack.push(temp);
//        }
//
//        return min[0];
//    }

    public int getMin() {
        return stack.peek()[1];
    }
}
