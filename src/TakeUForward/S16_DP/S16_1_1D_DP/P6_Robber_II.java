package TakeUForward.S16_DP.S16_1_1D_DP;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP
 * <p>
 * User: piyushbajaj
 * Date: 12/11/22
 * Time: 4:53 pm
 * <p>
 * Link: <a href="https://www.codingninjas.com/codestudio/problems/house-robber_839733">...</a>
 */
public class P6_Robber_II {
    public int findMaxSum_tab_improve(int[] arr, int n) {
        int prevFirst = arr[0];
        int prevSecond = 0;

        for (int i = 1; i < n; i++) {

            int pick = arr[i];
            if (i > 1) {
                pick += prevSecond;
            }
            int nonPick = prevFirst;

            int curr = Math.max(pick, nonPick);
            prevSecond = prevFirst;
            prevFirst = curr;
        }

        return prevFirst;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param valueInHouse
     * @return
     */
    public long houseRobber(int[] valueInHouse) {
        int[] temp1 = new int[valueInHouse.length - 1];
        int[] temp2 = new int[valueInHouse.length - 1];

        if (valueInHouse.length == 1) {
            return valueInHouse[0];
        }

        // Include first, except last
        System.arraycopy(valueInHouse, 0, temp1, 0, valueInHouse.length - 1);

        // Exclude first, include last
        System.arraycopy(valueInHouse, 1, temp2, 0, valueInHouse.length - 1);

        return Math.max(findMaxSum_tab_improve(temp1, temp1.length), findMaxSum_tab_improve(temp2, temp2.length));
    }

    public static void main(String[] args) {
        P6_Robber_II p6_robber_ii = new P6_Robber_II();

        int[] arr = {5, 5, 10, 100, 10, 5};

        System.out.println(p6_robber_ii.houseRobber(arr));
    }
}
