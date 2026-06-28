package Practice2025.Neetcode.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.Stack
 * <p>
 * User: piyushbajaj
 * Date: 27/04/25
 * Time: 7:06 pm
 * <p>
 * Approach 1:
 * 1. Create Stack of Character. Keep pushing elements for open brackets, and keep removing elements for closed brackets
 * 2. In case there is mismatch return False
 */
public class ValidParenthesis {


    /**
     * Conditional Check
     * TC: O(N)
     * SC: O(N)
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character currPeek = stack.peek();
                if (ch == ')' && currPeek.equals('(')) {
                    stack.pop();
                } else if (ch == '}' && currPeek.equals('{')) {
                    stack.pop();
                } else if (ch == ']' && currPeek.equals('[')) {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid_clean(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> validParenthesis = new HashMap<>();
        validParenthesis.put(')', '(');
        validParenthesis.put(']', '[');
        validParenthesis.put('}', '{');

        for (Character ch : s.toCharArray()) {
            if (validParenthesis.containsKey(ch)) {
                if (!stack.isEmpty() && stack.peek().equals(validParenthesis.get(ch))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("()[]{}"));
        System.out.println(validParenthesis.isValid_clean("()[]{}"));
    }
}
