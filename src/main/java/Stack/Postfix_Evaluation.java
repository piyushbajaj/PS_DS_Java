package Stack;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 09/12/16.
 */
public class Postfix_Evaluation {
    public static void main(String[] args) {
        Postfix_Evaluation PE = new Postfix_Evaluation();
        String s[] = {"1", "2", "3", "*", "+", "5", "-"};
        System.out.println(PE.postfix_cal(s));
        //PE.postfix_cal(s);
    }

    public boolean isOperand(int val) {
        return (val >= 0 && val <= 9);
    }

    public int postfix_cal(String[] s) {
        //int[] i =(int) s.toCharArray();

        Stack<Integer> st = new Stack<>();
        for (String token : s) {
            if (token.equals("+")) {
                int op1 = st.pop();
                int op2 = st.pop();
                int res = op1 + op2;
                st.push(res);
            } else if (token.equals("-")) {
                int op1 = st.pop();
                int op2 = st.pop();
                int res = op2 - op1;
                st.push(res);
            } else if (token.equals("*")) {
                int op1 = st.pop();
                int op2 = st.pop();
                int res = op1 * op2;
                st.push(res);
            } else if (token.equals("/")) {
                int op1 = st.pop();
                int op2 = st.pop();
                int res = op1 / op2;
                st.push(res);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();


    }
}
