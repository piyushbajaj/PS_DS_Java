package TakeUForward.S5_Strings.S5_1_Easy;

/**
 * Created by bajajp on 28 Sep, 2022
 */
public class P1_RemoveOutermostParenthesis {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param s
     * @return
     */
    static String removeOuterParentheses(String s) {
        StringBuilder output = new StringBuilder();
        int openCounter = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(' && openCounter++ > 0) {
                output.append(ch);
            } else if (ch == ')' && openCounter-- > 1) {
                output.append(ch);
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }
}
