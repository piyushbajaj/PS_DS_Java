package Practice2025.Neetcode.ArraysHashing;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 10/06/25
 * Time: 12:22 pm
 */
public class P7_ProductOfArrayExceptSelf {

    /**
     * Whole idea of Prefix-Suffix approach is the get the value on the left of the element and get the value on the
     * right side of the element, and multiply both to get the right answer.
     * <p>
     * 1. Create output array of same size as nums
     * 2. First get the prefix by of each element
     * 2.1. You can assume prefix of first element is 1, as there is no element before that
     * 2.2. Get the result array of prefix, by multiplying previous element in the nums array with result array of
     * previous
     * 3. Now initialize suffix as 1, as there are no last element present, and result[n-1] = suffix * result[n-1]
     * 4. Start the loop backwards from n-2 to 0
     * 4.1. At every step recalculate the suffix = suffix * nums[index + 1]
     * 4.2. Update result[index] = result[index] * suffix
     * 5. Return the output
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int prefix = 1;
        int suffix = 1;
        int[] result = new int[len];

        // calculating prefix
        result[0] = prefix;
        for (int index = 1; index < len; index++) {
            result[index] = result[index - 1] * nums[index - 1];
        }

        // calculating suffix and also multiplying with prefix to get the desired output
        result[len - 1] = suffix * result[len - 1];
        for (int index = len - 2; index >= 0; index--) {
            suffix = suffix * nums[index + 1];
            result[index] = suffix * result[index];
        }

        return result;
    }

    public static void main(String[] args) {
        P7_ProductOfArrayExceptSelf p7ProductOfArrayExceptSelf = new P7_ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(p7ProductOfArrayExceptSelf.productExceptSelf(new int[] {1, 2, 4, 6})));
    }
}
