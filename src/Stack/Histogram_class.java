package Stack;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 10/12/16.
 * Question Link: http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
 * Please find the algorithm below:
 * 1. Initialize maxArea = 0
 * 2. Loop form i = 0 to n-1
 * 3. In first condition, every time will check if stack id empty or value which is there on the top of Stack is less than
 * or equal to arr[i]. And if it matches will push that value into stack, like s.push(i++)
 * 4. Now if the next element is bigger than the top of the current stack value, then pop the top most element from Stack,
 * and calculate the area.
 * top = s.pop()
 * maxArea = Max(maxArea, arr[top]* (s.empty()? i-1: (i-s.peek()-1) ) )
 * 5. Now repeat step 4 till the stack is empty.
 */
public class Histogram_class {
    public static int maxArea(int[] intArr) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        int maxArea = 0;
        int top = 0;
        while (i < intArr.length) {
            if (stk.isEmpty() || intArr[stk.peek()] <= intArr[i]) {
                stk.push(i++);
            } else {
                top = stk.pop();
                maxArea = Math.max(maxArea, intArr[top] * (stk.isEmpty() ? i - 1 : (i - stk.peek() - 1)));
            }
        }

        while (!stk.isEmpty()) {
            top = stk.pop();
            maxArea = Math.max(maxArea, intArr[top] * (stk.isEmpty() ? i - 1 : (i - stk.peek() - 1)));
        }

        return maxArea;

    }

    public static void main(String[] args) {
        int[] intArr = {6, 2, 5, 4, 5, 2, 6};
        System.out.println("Maximum area is: " + maxArea(intArr));
    }
}
