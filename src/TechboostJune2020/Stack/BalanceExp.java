package TechboostJune2020.Stack;

import java.util.Stack;

public class BalanceExp {

    public boolean isBalance(String exp) {
        if( exp.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack();

        //Traversing all the elements
        for( char ch: exp.toCharArray()) {
            if( ch == '{' || ch == '[' || ch == '(' ) {
                stack.push(ch);
            }

            if ( ch == '}' || ch == ']' || ch == ')') {
                if(stack.isEmpty()){
                    return false;
                }

                Character topElement = stack.pop();

                if ((topElement == '(' && ch != ')') ||
                    (topElement == '{' && ch != '}') ||
                    (topElement == '[' && ch != ']') ) {
                    return false;
                }

            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        BalanceExp balanceExp = new BalanceExp();

        String exp = "{()}[{}]";
        System.out.println("Is Expression Balanced? " + balanceExp.isBalance(exp));
    }
}
