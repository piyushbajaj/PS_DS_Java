package Session.May2024.Grind75;

import java.util.Stack;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.Grind75
 * <p>
 * User: piyushbajaj
 * Date: 12/11/24
 * Time: 10:56 pm
 */
public class P2_ValidParenthesis {
    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
