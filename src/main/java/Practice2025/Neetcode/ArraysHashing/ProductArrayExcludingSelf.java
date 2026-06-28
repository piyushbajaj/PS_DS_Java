package Practice2025.Neetcode.ArraysHashing;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 11/04/25
 * Time: 9:55 am
 */
public class ProductArrayExcludingSelf {

    /**
     * Approach: Prefix and Suffix Approach
     * 1. Prefix will store all multiplications from left, prefix[0] = 1
     * 2. Suffix will store all multiplications from right, suffix[n] = 1
     * 3. Create fresh array with multiplication of Prefix and Suffix exluding Self
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];

        // prefix
        prefix[0] = 1;
        for (int front = 1; front < n + 1; front++) {
            prefix[front] = prefix[front - 1] * nums[front - 1];
        }

        // prefix
        suffix[n] = 1;
        for (int rear = n - 1; rear >= 0; rear--) {
            suffix[rear] = suffix[rear + 1] * nums[rear];
        }

        // result array
        for (int index = 0; index < n; index++) {
            nums[index] = prefix[index] * suffix[index + 1];
        }

        return nums;
    }

    public static void main(String[] args) {
        ProductArrayExcludingSelf productArrayExcludingSelf = new ProductArrayExcludingSelf();
        System.out.println(Arrays.toString(productArrayExcludingSelf.productExceptSelf(new int[] {1, 2, 4, 6})));
    }
}
