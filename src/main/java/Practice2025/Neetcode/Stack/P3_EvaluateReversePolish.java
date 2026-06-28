package Practice2025.Neetcode.Stack;

import java.util.Stack;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.Stack
 * <p>
 * User: piyushbajaj
 * Date: 01/05/25
 * Time: 1:34 pm
 */
public class P3_EvaluateReversePolish {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                if (operands.size() < 2) {
                    return -1;
                }
                int op2 = operands.pop();
                int op1 = operands.pop();
                operands.push(op1 + op2);
            } else if (token.equals("-")) {
                if (operands.size() < 2) {
                    return -1;
                }
                int op2 = operands.pop();
                int op1 = operands.pop();
                operands.push(op1 - op2);
            } else if (token.equals("/")) {
                if (operands.size() < 2) {
                    return -1;
                }
                int op2 = operands.pop();
                int op1 = operands.pop();
                operands.push(op1 / op2);
            } else if (token.equals("*")) {
                if (operands.size() < 2) {
                    return -1;
                }
                int op2 = operands.pop();
                int op1 = operands.pop();
                operands.push(op1 * op2);
            } else {
                operands.push(Integer.parseInt(token));
            }
        }

        return operands.size() == 1 ? operands.pop() : -1;
    }

    public static void main(String[] args) {
        P3_EvaluateReversePolish evaluateReversePolish = new P3_EvaluateReversePolish();
        String[] token = {"2", "1", "+", "3", "*"};
        System.out.println(evaluateReversePolish.evalRPN(token));
    }
}
