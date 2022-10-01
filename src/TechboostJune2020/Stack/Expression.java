package TechboostJune2020.Stack;

import java.util.Stack;

public class Expression {

    public static int precedence(char oprt) {
        switch (oprt)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public String infixToPostFix(String exp) {
        boolean isOperator = true;

        String output = new String("");

        Stack<Character> stack = new Stack<>();

        for( char ch: exp.toCharArray()){
            if(Character.isLetterOrDigit(ch)) {
                output += ch;
            }

            else if (ch == '('){
                stack.push(ch);
            }

            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output += stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid";
                }
                else {
                    stack.pop();
                }
            }

            //In case of Operator
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())){
                    output += stack.pop();
                }
                stack.push(ch);
            }

        }

        while (!stack.isEmpty()) {
            if(stack.peek() == '(')
                return "Invalid";
            output += stack.pop();
        }

        return output;
    }

    public static void main(String[] args) {
        Expression exp = new Expression();
        String str = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println(exp.infixToPostFix(str));

    }
}
