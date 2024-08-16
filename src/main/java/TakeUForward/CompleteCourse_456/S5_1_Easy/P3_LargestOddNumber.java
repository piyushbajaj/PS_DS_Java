package TakeUForward.CompleteCourse_456.S5_1_Easy;

/**
 * Created by bajajp on 28 Sep, 2022
 */
public class P3_LargestOddNumber {
    /**
     * TC: O(N)
     *
     * @param num
     * @return
     */
    static String largestOddNumber(String num) {
        int n = num.length();

        if (n <= 0 || n > 100000) {
            return "";
        }

        for (int i = n; i > 0; i--) {
            int val = Integer.parseInt(num.substring(i - 1, i));
            if (val % 2 != 0) {
                return num.substring(0, i);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String num = "239537672423884969653287101";
        System.out.println(largestOddNumber(num));
    }
}
