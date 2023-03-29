package OnlineTest.microsoft_online_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bajajp on 20 Sep, 2022
 */
public class P2 {
    public static int solution(String S) {
        int n = S.length();
        int res = 0;

        List<String> arrayStrFirst = new ArrayList<>();
        List<String> arrayStrSecond = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            arrayStrFirst.add(S.substring(0, i + 1));
            arrayStrSecond.add(S.substring(i + 1, n));
        }


        for (int i = 0; i < arrayStrFirst.size(); i++) {
            if ((getCountX(arrayStrFirst.get(i)) == getCountY(arrayStrFirst.get(i))) ||
                (getCountX(arrayStrSecond.get(i)) == getCountY(arrayStrSecond.get(i)))
            ) {
                res++;
            }
        }

        System.out.println(arrayStrFirst);
        System.out.println(arrayStrSecond);

        return res;
    }

    private static int getCountX(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'x') {
                count++;
            }
        }
        return count;
    }

    private static int getCountY(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'y') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("ayxbx"));
    }
}
