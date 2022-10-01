package Array.Practice_2022.TwoPointers;

/**
 * Created by bajajp on 10 Sep, 2022
 */
public class P5_ContainerMostWater {
    /**
     * TC: O(N^2)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int slow = 0;
        int fast = slow + 1;
        int maxSoFar = Integer.MIN_VALUE;
        while (fast < n) {
            int product = Math.min(height[slow], height[fast]) * (fast - slow);
            maxSoFar = Math.max(maxSoFar, product);
            fast++;
            if (fast == n) {
                slow++;
                fast = slow + 1;
            }
        }
        return maxSoFar;
    }

    public int maxArea_better(int[] height) {
        int n = height.length;
        int start = 0;
        int end = n - 1;
        int maxSoFar = Integer.MIN_VALUE;
        while (start < end) {
            int product = Math.min(height[start], height[end]) * (end - start);
            maxSoFar = Math.max(maxSoFar, product);

            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        P5_ContainerMostWater p5_containerMostWater = new P5_ContainerMostWater();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(p5_containerMostWater.maxArea_better(arr));
    }
}
