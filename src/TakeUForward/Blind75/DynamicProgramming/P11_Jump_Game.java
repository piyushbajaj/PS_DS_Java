package TakeUForward.Blind75.DynamicProgramming;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.DynamicProgramming
 * <p>
 * User: piyushbajaj
 * Date: 02/02/23
 * Time: 5:04 pm
 */
public class P11_Jump_Game {
    public boolean canJump_recur(int[] nums) {
        int n = nums.length;
        return canJump_recur_util(nums, 0);
    }

    public boolean canJump_recur_util(int[] nums, int index) {
        if (index == nums.length - 1) {
            return true;
        }

        if (nums[index] == 0) {
            return false;
        }

        for (int jump = 1; jump <= nums[index]; jump++) {
            if (canJump_recur_util(nums, index + jump)) {
                return true;
            }
        }

        return false;

    }

    /**
     * Memoization
     * <p>
     * TC: O(N*jump)
     * SC: O(N) + O(N)
     *
     * @param nums
     * @return
     */
    public boolean canJump_mem(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];

        return canJump_mem_util(dp, nums, 0);
    }

    public boolean canJump_mem_util(boolean[] dp, int[] nums, int index) {
        if (index == nums.length - 1) {
            return true;
        }

        if (nums[index] == 0) {
            return false;
        }

        if (dp[index]) {
            return dp[index];
        }

        for (int jump = 1; jump <= nums[index]; jump++) {
            if (canJump_mem_util(dp, nums, index + jump)) {
                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }

    public boolean canJump_tab(int[] nums) {
        int n = nums.length;

        if (n <= 1) {
            return true;
        }

        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int index = n - 2; index >= 0; index--) {
            for (int jump = 1; jump <= nums[index]; jump++) {
                if (index + jump < n && dp[index + jump]) {
                    dp[index] = true;
                    break;
                }
            }
        }

        return dp[0];

    }

    public static void main(String[] args) {
        P11_Jump_Game p11_jump_game = new P11_Jump_Game();
        System.out.println(p11_jump_game.canJump_recur(new int[] {2, 3, 1, 1, 4}));
        System.out.println(p11_jump_game.canJump_recur(new int[] {3, 2, 1, 0, 4}));
        System.out.println(p11_jump_game.canJump_mem(new int[] {2, 3, 1, 1, 4}));
        System.out.println(p11_jump_game.canJump_mem(new int[] {3, 2, 1, 0, 4}));
        System.out.println(p11_jump_game.canJump_tab(new int[] {2, 3, 1, 1, 4}));
        System.out.println(p11_jump_game.canJump_tab(new int[] {3, 2, 1, 0, 4}));
    }
}
