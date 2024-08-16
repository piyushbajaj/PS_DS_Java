package PracticeSessionMay2024.TwoPointer;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TwoPointer
 * <p>
 * User: piyushbajaj
 * Date: 02/07/24
 * Time: 4:59 pm
 */

/**
 * Question: <a href="https://leetcode.com/problems/container-with-most-water/description/?envType=problem-list-v2&envId=e9snhf4h">...</a>
 */
public class P3_ContainerWithMostWater {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int f = 0;
        int r = n - 1;
        int max = Integer.MIN_VALUE;

        while (f < r) {
            int area;
            if (height[f] <= height[r]) {
                area = height[f] * (r - f);
                f++;
            } else {
                area = height[r] * (r - f);
                r--;
            }
            max = Math.max(max, area);
        }

        return max;
    }

    public static void main(String[] args) {
        P3_ContainerWithMostWater p3ContainerWithMostWater = new P3_ContainerWithMostWater();
        System.out.println(p3ContainerWithMostWater.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
