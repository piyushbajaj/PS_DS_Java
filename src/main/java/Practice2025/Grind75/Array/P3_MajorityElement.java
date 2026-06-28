package Practice2025.Grind75.Array;

/**
 * Project: DSAlgo
 * Package: Practice2025.Grind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 31/03/25
 * Time: 10:08 am
 */
public class P3_MajorityElement {

    /**
     * Approach: Boyer-Moore Voting Algorithm
     * If we had some way of counting instances of the majority element as +1
     * and instances of any other element as −1, summing them would make it
     * obvious that the majority element is indeed the majority element.
     * <p>
     * <p>
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Integer element = null;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                count = 1;
                element = num;
            }

            if (element == num) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }

    public static void main(String[] args) {

    }
}
