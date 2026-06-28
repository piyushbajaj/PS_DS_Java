package Practice2025.Neetcode.TwoPointers;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.TwoPointers
 * <p>
 * User: piyushbajaj
 * Date: 14/06/25
 * Time: 11:13 am
 */
public class P2_TwoIntegerSumII {

    /**
     * Approach:
     * 1. Start 2 pointers from the opposite end.
     * 2. If sum of both number is greater than the target, reduce from the right, or else reduce from the left
     * <p>
     * TC: O(N)
     * SC: O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return new int[] {start, end};
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {

    }
}
