package Stack;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 09/12/16.
 */
public class BalancingSymbols {

    public static void main(String[] args) {
        BalancingSymbols BS = new BalancingSymbols();
        String str = "((([((())))))";
        System.out.println(BS.isBalance(str));
        //BS.isBalance(str);

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(
            "(",
            "0",
            "&&",
            "1",
            "&&",
            "2",
            ")"));
        String listString = String.join(" ", arrayList);

        Boolean a = null;
        Boolean b = null;
        if (a == b) {
            System.out.println(true);
        }

        System.out.println(listString);

        System.out.println(arrayList.toString().replaceAll("[,\\[\\]]", ""));
    }

//    public int openBracketCount(ArrayList<String> arrayList) {
////        Deque<String> stack = new ArrayDeque<>();
//////        int count = 0;
////        for(String str: arrayList) {
////            if (Objects.equals(str, "(")) {
////                stack.push(str);
//////                count++;
////                continue;
////            }
////            if (stack.isEmpty()){
////                return 0;
////            }
////            if (Objects.equals(str, ")")) {
////                stack.pop();
////            }
////        }
//
////        return count;
//    }

    public boolean isBalance(String s) {
        Stack<Character> ST = new Stack<>();
        if (s == null || s.length() == 0) {
            System.out.println("String is empty");
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (ST.isEmpty()) {
                    return false;
                }
                if (ST.peek() == '(' && !ST.isEmpty()) {
                    ST.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (ST.isEmpty()) {
                    return false;
                }
                if (ST.peek() == '[' && !ST.isEmpty()) {
                    ST.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (ST.isEmpty()) {
                    return false;
                }
                if (ST.peek() == '{' && !ST.isEmpty()) {
                    ST.pop();
                } else {
                    return false;
                }
            } else {
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    ST.push(s.charAt(i));
                }
            }
        }

        if (ST.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean utilFunc(ArrayList<String> arrayList) {
//        Deque<String> stack = new ArrayDeque<>();
////        int count = 0;
//        for(String str: arrayList) {
//            if (!Objects.equals(str, ")")) {
//                stack.push(str);
////                count++;
//                continue;
//            }
//            if (stack.isEmpty()){
//                return false;
//            }
//            if (Objects.equals(str, ")")) {
//                String sPeek = stack.peek();
//                while (!Objects.equals(sPeek, "(")) {
//                    if (Objects.equals(sPeek, "&&") || Objects.equals(sPeek, "||")) {
//                        return false;
//                    }
//                    int index = Integer.parseInt(sPeek);
//
//                }
//            }
//        }

        return true && Boolean.parseBoolean("&&") && true;
    }

    private boolean validateExpression(final List<String> expression) {
        Deque<String> expInStack = new ArrayDeque<>();

        for (String currStr : expression) {
            if (currStr.equals("&&") || currStr.equals("||")) {
                continue;
            }
            if (currStr.equals("(")) {
                expInStack.push(currStr);
            } else if (currStr.equals(")")) {
                if (expInStack.isEmpty()) {
                    return false;
                }
                expInStack.pop();
            } else {
                return false;
            }
        }
        return false;
    }
}
