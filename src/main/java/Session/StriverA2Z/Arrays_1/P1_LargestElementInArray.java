package Session.StriverA2Z.Arrays_1;

/**
 * Project: DSAlgo
 * Package: Session.StriverA2Z.Arrays_1
 * <p>
 * User: piyushbajaj
 * Date: 22/03/25
 * Time: 5:02 pm
 * <p>
 * Link: <a href="https://takeuforward.org/data-structure/find-the-largest-element-in-an-array/">...</a>
 */
public class P1_LargestElementInArray {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    public static int largest(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }

        return max;
    }
}
