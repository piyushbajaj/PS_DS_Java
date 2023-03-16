package TakeUForward.Blind75.DynamicProgramming;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.DynamicProgramming
 * <p>
 * User: piyushbajaj
 * Date: 02/02/23
 * Time: 2:53 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/house-robber-ii/description/">...</a>
 */
public class P8_House_Robber_II {
    public int rob(int[] nums) {
        P7_House_Robber p7_house_robber = new P7_House_Robber();

        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] temp = new int[n - 1];

        // copy all elements from 1 to n-1
        System.arraycopy(nums, 1, temp, 0, n - 1);
        int t1 = p7_house_robber.rob_tab(temp);

        // copy all elements from 0 to n-2
        System.arraycopy(nums, 0, temp, 0, n - 1);
        int t2 = p7_house_robber.rob_tab(temp);

        return Math.max(t1, t2);
    }

    public static void main(String[] args) {
        P8_House_Robber_II p8_house_robber_ii = new P8_House_Robber_II();
        System.out.println(p8_house_robber_ii.rob(new int[] {1, 2, 3, 1}));
    }
}
