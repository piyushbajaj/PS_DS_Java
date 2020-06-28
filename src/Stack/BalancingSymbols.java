package Stack;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 09/12/16.
 */
public class BalancingSymbols {

    public boolean isBalance(String s){
        Stack<Character> ST = new Stack<>();
        if(s==null || s.length() == 0){
            System.out.println("String is empty");
            return false;
        }
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(ST.isEmpty())
                    return false;
                if(ST.peek() == '(' && !ST.isEmpty())
                    ST.pop();
                else
                    return false;
            }
            else if(s.charAt(i) == ']'){
                if(ST.isEmpty())
                    return false;
                if(ST.peek() == '[' && !ST.isEmpty())
                    ST.pop();
                else
                    return false;
            }
            else if(s.charAt(i) == '}'){
                if(ST.isEmpty())
                    return false;
                if(ST.peek() == '{' && !ST.isEmpty())
                    ST.pop();
                else
                    return false;
            }
            else {
                if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                    ST.push(s.charAt(i));
            }
        }

        if(ST.isEmpty())
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        BalancingSymbols BS = new BalancingSymbols();
        String str = "((([((())))))";
        System.out.println(BS.isBalance(str));
        //BS.isBalance(str);
    }
}
