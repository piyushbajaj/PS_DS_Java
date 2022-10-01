package SlidingWindow;

/**
 * Created by bajajp on 26 Sep, 2022
 */
public class P13_MaximumPoints {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param cardPoints
     * @param k
     * @return
     */
    static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int max = sum;

        for (int i = 0; i < k; i++) {
            sum = sum - cardPoints[k - i - 1] + cardPoints[n - i - 1];
            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        System.out.println(maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }
}
