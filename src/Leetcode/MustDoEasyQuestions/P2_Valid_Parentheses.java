package Leetcode.MustDoEasyQuestions;

import java.util.Stack;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 30/12/22
 * Time: 11:45 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/valid-parentheses/description/">...</a>
 * <p>
 * Pattern: Stacks
 */
public class P2_Valid_Parentheses {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int n = s.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (s.charAt(i) == ')' && stack.peek() != '(') {
                    return false;
                } else if (s.charAt(i) == ']' && stack.peek() != '[') {
                    return false;
                } else if (s.charAt(i) == '}' && stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        P2_Valid_Parentheses p2_valid_parentheses = new P2_Valid_Parentheses();
        System.out.println(p2_valid_parentheses.isValid("]"));
    }

}
