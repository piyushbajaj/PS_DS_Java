package TakeUForward.CompleteCourse_456.S5_1_Easy;

/**
 * Created by bajajp on 28 Sep, 2022
 */
public class P2_ReverseWordsInAString {
    static String reverseWordsInString(String str) {
        str = filterOut(str);
        int n = str.length();

        char[] chArray = str.toCharArray();

        reverse(chArray, 0, n - 1);

        int s = 0;
        // Reverse each words one by one
        for (int i = 0; i < n; i++) {
            if (chArray[i] == ' ') {
                reverse(chArray, s, i - 1);
                s = i + 1;
            } else if (i == n - 1) {
                reverse(chArray, s, n - 1);
            }
        }

        int l = 0, r = 0;
        int spaceCnt = 0;
        for (int i = 0; i < n; i++) {
            if (chArray[i] == ' ') {
                spaceCnt++;
            }
        }

        return new String(chArray);
    }

    static String filterOut(String str) {
        str = str.trim();

        StringBuilder sb = new StringBuilder();
        int start = 0, end = str.length() - 1;

        while (start <= end) {
            char ch = str.charAt(start);

            if (ch != ' ') {
                sb.append(ch);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(ch);
            }
            start++;
        }

        return sb.toString();
    }

    static char[] reverse(char[] chars, int start, int end) {
        while (start <= end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInString("this is an amazing program"));

        System.out.println(reverseWordsInString("a good   example"));
    }
}
