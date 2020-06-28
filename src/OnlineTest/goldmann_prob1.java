package OnlineTest;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 25/03/18.
 */
public class goldmann_prob1 {

    static int closingBracePosition(String inputSentence, int openingBraceNum) {
        int len = inputSentence.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            if(inputSentence.charAt(i) == '(')
                stack.push(inputSentence.charAt(i));
            else if(inputSentence.charAt(i) == ')') {
                if(stack.isEmpty()) return -1;
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return -1;

        if(!inputSentence.contains("("))
            return -1;
        if(!inputSentence.contains(")"))
            return -1;
        int n = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < len; i++){
            if(inputSentence.charAt(i) == '(')
            {
                n++;
//                if(n == openingBraceNum){
//                    start = i;
//                }
            }
            else if(inputSentence.charAt(i) == ')') {
                if(n == openingBraceNum) {
                    end = i;
                    break;
                }
                n--;
            }
        }
        return end+1;


    }

    public static void main(String[] args) {
        String str = "(I want (to write a language parser), would (you) help me)";
        int input = 1;

        System.out.println(closingBracePosition(str, input));
    }
}
