package Blind75.S1_Array;

/**
 * Project: DS_Algo
 * Package: Blind75.S1_Array
 * <p>
 * User: piyushbajaj
 * Date: 19/11/22
 * Time: 5:57 pm
 */
public class P2_BestTimeStock {
    public static void main(String[] args) {
        P2_BestTimeStock p2_bestTimeStock = new P2_BestTimeStock();
        int[] arr = {7, 1, 5, 3, 6, 4};

        System.out.println(p2_bestTimeStock.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int max = 0, n = prices.length;

        int i = 0, j = i + 1;

        while (i < n) {
            if (j < n && prices[i] < prices[j]) {
                max = Math.max(max, prices[j] - prices[i]);
                j++;
            } else {
                i++;
                j = i + 1;
            }
        }

        return max;
    }
}
