package TakeUForward.CompleteCourse_456.S12_Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S12_Greedy
 * <p>
 * User: piyushbajaj
 * Date: 18/10/22
 * Time: 11:46 pm
 * <p>
 * TC: O(N)
 * SC: O(1)
 */
public class P3_Min_Coins {
    public List<Integer> coinChange(int[] coins, int amount) {
//        int[] coins = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        List<Integer> res = new ArrayList<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                res.add(coins[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        P3_Min_Coins p3_min_coins = new P3_Min_Coins();
        System.out.println(p3_min_coins.coinChange(arr, 11));
    }
}
