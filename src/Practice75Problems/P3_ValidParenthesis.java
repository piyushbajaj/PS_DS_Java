package Practice75Problems;

import java.util.Stack;

/**
 * Created by bajajp on 18 Jun, 2022
 */
public class P3_ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    if ((s.charAt(i) == ')' && stack.peek() != '(') ||
                            (s.charAt(i) == '}' && stack.peek() != '{') ||
                            (s.charAt(i) == ']' && stack.peek() != '[')) {
                        return false;
                    }
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        isValid("[");
    }
}
