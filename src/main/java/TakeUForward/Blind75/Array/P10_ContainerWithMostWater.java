package TakeUForward.Blind75.Array;

/**
 * Project: DSAlgo
 * Package: TakeUForward.Blind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 03/04/23
 * Time: 2:01 pm
 */
public class P10_ContainerWithMostWater {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxSum = Integer.MIN_VALUE;

        while (start < end) {
            int product = Math.min(height[start], height[end]) * (end - start);
            maxSum = Math.max(maxSum, product);

            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        P10_ContainerWithMostWater containerWithMostWater = new P10_ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
