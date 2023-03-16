package OnlineTest.Egnyte;

/**
 * Project: DS_Algo
 * Package: OnlineTest.Egnyte
 * <p>
 * User: piyushbajaj
 * Date: 23/01/23
 * Time: 9:15 am
 */
public class Problem2 {
    public int solution(String S) {
        int n = S.length();
        String str = "";
        String chStr = "";
        int diff = 0;
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            str = S.substring(i, i + 2);

            for (j = n - 1; j >= i + 1; j--) {
                chStr = S.substring(j - 1, j + 1);

                if (chStr.equals(str)) {
                    diff = Math.max(diff, j - i - 1);
                }
            }


        }

        return diff == 0 ? -1 : diff;

    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.solution("aaa"));
    }

}
