package TakeUForward.CompleteCourse_456.S12_Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S12_Greedy
 * <p>
 * User: piyushbajaj
 * Date: 18/10/22
 * Time: 8:35 pm
 * <p>
 */
public class P2_Fractional_Knapsack {

    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    // Decreasing order
    static class ItemComparator implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            double r1 = (double) (o1.value) / (double) (o1.weight);
            double r2 = (double) (o2.value) / (double) (o2.weight);

            if (r1 < r1) {
                return 1;
            } else if (r1 > r2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Approach:
     * 1. Sort the Value and weight based on fractional knapsack of values/weight
     * 2. As per the increasing order of values/weight
     * TC: O(NlogN) + O(N)
     *
     * @param W
     * @param arr
     * @param n
     * @return
     */
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
        Arrays.sort(arr, new ItemComparator());
        int sumWeight = 0;
        double maxValue = 0;

        for (int i = 0; i < n; i++) {
            if (sumWeight + arr[i].weight <= W) {
                sumWeight += arr[i].weight;
                maxValue += arr[i].value;
            } else {
                int remain = W - sumWeight;
                maxValue += remain * ((double) arr[i].value / (double) arr[i].weight);
                break;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        P2_Fractional_Knapsack p2_fractional_knapsack = new P2_Fractional_Knapsack();
        int n = 3, weight = 50;
        Item arr[] = {new Item(100, 20), new Item(60, 10), new Item(120, 30)};
        double ans = p2_fractional_knapsack.fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is " + ans);
    }
}
