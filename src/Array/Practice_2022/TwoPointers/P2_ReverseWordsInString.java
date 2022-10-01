package Array.Practice_2022.TwoPointers;

/**
 * Created by bajajp on 10 Sep, 2022
 */
public class P2_ReverseWordsInString {
    /**
     * TC: O(2N)
     * @param chars
     */
    public void reverseString(char[] chars) {
        // reverseString
        int n = chars.length;
        reverse(chars, 0, n - 1);

        // reverseEachWord
        reverseEachWord(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

    public void reverseEachWord(char[] chars) {
        int n = chars.length;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            } else if (j == n - 1) {
                reverse(chars, i, j);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        P2_ReverseWordsInString p2_reverseWordsInString = new P2_ReverseWordsInString();
        char[] chars = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        p2_reverseWordsInString.reverseString(chars);
        System.out.println(chars);
    }
}
