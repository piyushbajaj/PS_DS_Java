package Array;

/**
 * Created by piyush.bajaj on 19/02/17.
 */
public class minWindow {
    public String minWindowLength(String input, String chars){
        int inputLen = input.length();
        int charLen = chars.length();

        int[] needToFind = new int[256];
        for(int i = 0; i < charLen; i++){
            needToFind[chars.charAt(i)]++;
        }

        int[] hasFound = new int[256];
        int minWinLength = Integer.MAX_VALUE;
        int minBegin = 0;
        int minEnd = 0;
        int end = 0;
        int begin = 0;
        int count = 0;

        for(begin = 0, end = 0; end < inputLen; end++) {
            if (needToFind[input.charAt(end)] == 0)
                continue;
            hasFound[input.charAt(end)]++;

            if (hasFound[input.charAt(end)] <= needToFind[input.charAt(end)])
                count++;

            if (count == charLen) {
                while (needToFind[input.charAt(begin)] == 0 || hasFound[input.charAt(begin)] > needToFind[input.charAt(begin)]) {
                    if (hasFound[input.charAt(begin)] > needToFind[input.charAt(begin)])
                        hasFound[input.charAt(begin)]--;
                    begin++;
                }

                int bin = 11 | 11;

                //Integer.bin
                //

                //Long.pa


                int winLen = end - begin + 1;

                if (winLen < minWinLength) {
                    minBegin = begin;
                    minEnd = end;
                    minWinLength = winLen;
                }
            }
        }

        return (count == charLen)?input.substring(minBegin, minEnd + 1):"";
    }

    public static void main(String[] args) {
        minWindow mw = new minWindow();
        System.out.println(mw.minWindowLength("ABBACBAA", "AAB"));

    }
}
