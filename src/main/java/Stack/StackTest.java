package Stack;

//import java.util.Stack;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 13/09/16.
 */
public class StackTest {

    // A utility function to check if the given character is operand
    public static boolean isOperand(char ch) {
        return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
    }

    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence

    public static int Prec(char ch) {
        switch (ch) {
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

    // The main function that converts given infix expression to postfix expression.

    public static int infixToPostfix(char c[]) {
        Stack<Character> s = new Stack<>();

        //int n[] = new

        //int i = c.length;
        int k = -1;

        if (c == null || c.length == 0) {
            return -1;
        }

        // for(char ch:c)
        for (char ch : c) {
            if (isOperand(ch)) {
                c[++k] = ch;
            } else if (ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    c[++k] = s.pop();
                }
                if (!s.isEmpty() && s.peek() != '(') {
                    return -1;
                } else {
                    s.pop();

                }

            } else {
                while (!s.isEmpty() && Prec(ch) <= Prec(s.peek())) {
                    c[++k] = s.pop();
                }
                s.push(ch);
            }
        }
        // pop all the operators from the stack
        while (!s.isEmpty()) {
            c[++k] = s.pop();
        }

        char char_new[] = new char[k + 1];
        //cha = c;

        for (int i = 0; i < char_new.length; i++) {
            char_new[i] = c[i];
        }

        //c[++k] = '\0';
        System.out.println(char_new);
        return 1;
    }


    public static int PostfixEvaluation(char char_exp[]) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        int i1 = 0;
        int i2 = 0;

        //Character.g('1');

        int len = char_exp.length;

        int[] int_arr = new int[len];


        for (int a = 0; a < len; a++) {
            if ((char_exp[a] == '+') || (char_exp[a] == '-') || (char_exp[a] == '*') || (char_exp[a] == '/')) {
                int_arr[a] = Character.getDirectionality(char_exp[a]);
            } else {
                int_arr[a] = Character.getNumericValue(char_exp[a]);
            }
        }

        for (int num : char_exp) {
            if (Character.getNumericValue(num) >= 0 && Character.getNumericValue(num) <= 9) {
                s.push(Character.getNumericValue(num));
            } else if (num == '+') {
                i1 = s.pop();
                i2 = s.pop();
                i = i2 + i1;
                s.push(i);
            } else if (num == '-') {
                i1 = s.pop();
                i2 = s.pop();
                i = i2 - i1;
                //i = s.pop() - s.pop();
                s.push(i);
            } else if (num == '*') {
                i1 = s.pop();
                i2 = s.pop();
                i = i2 * i1;
                //i = s.pop() * s.pop();
                s.push(i);
            } else if (num == '/') {
                i1 = s.pop();
                i2 = s.pop();
                i = i2 / i1;
                //i = s.pop() / s.pop();
                s.push(i);
            } else {
                return -1;
            }
        }
        return (s.pop());
    }

    public static void reverseString(char exp[]) {
        Stack<Character> s = new Stack<>();
        int i = 0;

        for (char ch : exp) {
            s.push(ch);
        }

        while (!s.isEmpty() && i < exp.length) {
            exp[i] = s.pop();
            i++;
        }

        System.out.println(exp);

    }


    /*
    public static void balParen(){

    }
    */

    public static void main(String[] args) {
        /*
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);

        System.out.println(s.peek());

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }

        */
        //char c[] = {'a', '+', 'b', '*', '(', 'c', '^', 'd', '-', 'e', ')', '^', '(', 'f', '+', 'g', '*', 'h', ')', '-', 'i'};

        String str = "a+b*(c^d-e)^(f+g*h)-i";
        char[] c = str.toCharArray();

        infixToPostfix(c);

        String s = "231*+9-";
        char[] i = s.toCharArray();
        //int exp = Integer.parseInt(new String.valueOf(i));
        //System.out.println(exp);


//        int[] a = {2, 3, 1, *, +, 9, -};
        //;

        System.out.println(PostfixEvaluation(i));

        String name = "Piyush";
        char[] ch = name.toCharArray();
        reverseString(ch);


    }

}
