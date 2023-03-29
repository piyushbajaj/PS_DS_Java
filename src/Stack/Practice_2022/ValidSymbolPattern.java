package Stack.Practice_2022;

import java.util.Stack;

public class ValidSymbolPattern {
    public static void main(String[] args) {
        System.out.println(isValidSymbol("[{(a+b)}]"));
    }

    private static boolean isValidSymbol(String s) {
        Stack<Character> stack = new Stack<>();
        char[] stringToChar = s.toCharArray();
        for (Character ch : stringToChar) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if ((ch == '}' && stack.peek() == '{') || (ch == ']' && stack.peek() == '[') ||
                (ch == ')' && stack.peek() == '(')) {
                stack.pop();
            } else if ((ch == '}' && stack.peek() != '{') || (ch == ']' && stack.peek() != '[') ||
                (ch == ')' && stack.peek() != '(')) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
