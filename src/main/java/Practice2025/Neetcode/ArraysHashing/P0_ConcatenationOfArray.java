package Practice2025.Neetcode.ArraysHashing;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 05/04/25
 * Time: 12:06 pm
 */
public class P0_ConcatenationOfArray {

    /**
     * TC: O(N)
     * SC: O(2N)
     *
     * @param nums
     * @return
     */
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + n] = nums[i];
        }

        return result;
    }
}
