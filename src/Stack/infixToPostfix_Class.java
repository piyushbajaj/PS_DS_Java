package Stack;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 09/12/16.
 *
 Algorithm for converting Infix to PostFix:
 1. Define a method which checks whether a character is an Operand or not, i.e., char will be between a & z
 2. Define a method Precedence with priority: + - as 1; * / as 2; ^ as 3
 3. Please find the steps to convert Infix to PostFix:
    a. Will define Stack<Integer>()
    b. initialise k = 0; Define charArray[] = s.toCharArray()
    c. Now start loop from 1st character till the end.
    d. if the ch is operand, then charArray[k++] = ch;
    e. if ch is '(', then push into Stack.
    f. if ch is ')', then:
        i. while (stk.peek()!='('){
                charArray[k++] = stk.pop();
            }
            stk.pop();
    g. else{
        while(!stk.isEmpty() && Precedence(ch) <= Precedence(stk.peek()))
            charArray[k++] = stk.pop();
        }
        stk.push(ch)


 Time Complexity: O(n)
 Space Complexity: O(n)
 */
public class infixToPostfix_Class {
    public boolean isOperand(char ch){
        return ((ch>= 'a' && ch <= 'z')|| (ch>='A' && ch <= 'Z'));
    }

    public int Precedence(char ch){
        switch (ch){
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

    public String infixToPostfix(String s){
        Stack<Character> ST = new Stack<>();
        int k =-1;

        char[] chArr = s.toCharArray();

        for(char ch: chArr)
        {

            if(isOperand(ch))
                chArr[++k] = ch;
            else if(ch == '(')
                ST.push(ch);
            else if(ch == ')'){
                while (ST.peek()!= '('){
                    chArr[++k] = ST.pop();
                }
                ST.pop();
            }
            else {
                while (!ST.isEmpty() && Precedence(ch) <= Precedence(ST.peek())){
                    chArr[++k] = ST.pop();
                }
                ST.push(ch);
            }
        }

        while (!ST.isEmpty())
            chArr[++k] = ST.pop();

        char[] new_char = new char[k+1];

        for(int i=0; i < new_char.length; i++)
            new_char[i] = chArr[i];

        return String.valueOf(new_char);
    }

    public static void main(String[] args) {
        infixToPostfix_Class PC = new infixToPostfix_Class();
        String s = "A*B-(C+D)+E";
        System.out.println(PC.infixToPostfix(s));

    }
}
