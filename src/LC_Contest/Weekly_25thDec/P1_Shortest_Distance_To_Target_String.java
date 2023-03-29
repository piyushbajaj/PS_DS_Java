package LC_Contest.Weekly_25thDec;

import java.util.Objects;

/**
 * Project: DS_Algo
 * Package: LC_Contest.Weekly_25thDec
 * <p>
 * User: piyushbajaj
 * Date: 25/12/22
 * Time: 8:27 am
 */
public class P1_Shortest_Distance_To_Target_String {
    public static void main(String[] args) {
        P1_Shortest_Distance_To_Target_String p1_shortest_distance_to_target_string =
            new P1_Shortest_Distance_To_Target_String();
        String[] words = {"i", "eat", "leetcode"};
        System.out.println(p1_shortest_distance_to_target_string.closetTarget(words, "ate", 0));
    }

    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;

        int left = startIndex, right = startIndex;
        int leftCount = 0, rightCount = 0, minCount = (int) 1e9;

        while (leftCount != n && rightCount != n) {
            if (left == -1) {
                left = n - 1;
            }
            if (right == n) {
                right = 0;
            }

            if (Objects.equals(words[left], target)) {
                minCount = Math.min(minCount, leftCount);
                leftCount = 0;
                break;
            } else {
                left--;
                leftCount++;
            }

            if (Objects.equals(words[right], target)) {
                minCount = Math.min(minCount, rightCount);
                rightCount = 0;
                break;
            } else {
                right++;
                rightCount++;
            }
        }

        return minCount == (int) 1e9 ? -1 : minCount;
    }
}
