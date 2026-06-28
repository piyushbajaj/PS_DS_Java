package DSA_Patterns.P1_PrefixSum;

/**
 * Project: DSAlgo
 * Package: DSA_Patterns.P1_PrefixSum
 * <p>
 * User: piyushbajaj
 * Date: 17/05/25
 * Time: 4:28 pm
 */
public class P1_RangeSumQuery {

    int[] prefixSum;

    public P1_RangeSumQuery(int[] nums) {
        prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        for (int index = 1; index < nums.length; index++) {
            prefixSum[index] = nums[index] + prefixSum[index - 1];
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? prefixSum[right] : prefixSum[right] - prefixSum[left - 1];
    }

    public static void main(String[] args) {

    }
}
