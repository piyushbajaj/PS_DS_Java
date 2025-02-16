package Session.Nov2024.S1_SlowFastPointer;

/**
 * Project: DSAlgo
 * Package: Session.Nov2024.S1_SlowFastPointer
 * <p>
 * User: piyushbajaj
 * Date: 22/12/24
 * Time: 5:52 pm
 * <p>
 * Link: <a href="https://leetcode.com/problems/find-the-duplicate-number/">...</a>
 */
public class P3_DuplicateNumber {

    /**
     * Variation of Linked List Cycle II
     * <p>
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];

        // getting the intersection point
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // now understanding where the cycle starts
        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

    public static void main(String[] args) {
        P3_DuplicateNumber p3DuplicateNumber = new P3_DuplicateNumber();
        int[] numArr = {1, 3, 4, 2, 2};
        System.out.println(p3DuplicateNumber.findDuplicate(numArr));
    }
}
