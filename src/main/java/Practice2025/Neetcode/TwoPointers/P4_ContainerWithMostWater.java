package Practice2025.Neetcode.TwoPointers;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.TwoPointers
 * <p>
 * User: piyushbajaj
 * Date: 14/06/25
 * Time: 7:05 pm
 */
public class P4_ContainerWithMostWater {

    /**
     * Approach 1: Brute-force
     * <p>
     * 1. Initialize maxArea to Integer.MIN
     * 2. Outer loop from first 0 to n-1
     * 2.1. Inner loop from second: first+1 to n-1
     * 2.1.1. Calculate area at each index, area = min(height[first], height[second]) * (second - first)
     * 2.1.2. MaxArea = max(MaxArea, area)
     * <p>
     * TC: O(N^2)
     * SC: O(1)
     *
     * @param heights
     * @return
     */
    public int maxArea(int[] heights) {
        int heightsLen = heights.length;
        int largestContainerWithWater = Integer.MIN_VALUE;
        for (int first = 0; first < heightsLen; first++) {
            for (int second = first + 1; second < heightsLen; second++) {
                int currentContainerWithWater = Math.min(heights[first], heights[second]) * (second - first);
                largestContainerWithWater = Math.max(largestContainerWithWater, currentContainerWithWater);
            }
        }

        return largestContainerWithWater;
    }

    /**
     * Approach 2: Use 2-Pointer
     * 1. Start with start = 0, end = n-1
     * 2. Calculate area: minimum(height[start], height[end]) * (end - start)
     * 3. If height[start] < height[end] start++, else end--
     * <p>
     * TC: O(N)
     * SC: O(1)
     *
     * @param heights
     * @return
     */
    public int maxArea_better(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (start < end) {
            int area = Math.min(heights[start], heights[end]) * (end - start);
            maxArea = Math.max(maxArea, area);
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        P4_ContainerWithMostWater containerWithMostWater = new P4_ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[] {1, 7, 2, 5, 4, 7, 3, 6}));

        System.out.println(containerWithMostWater.maxArea_better(new int[] {1, 7, 2, 5, 4, 7, 3, 6}));
    }
}
