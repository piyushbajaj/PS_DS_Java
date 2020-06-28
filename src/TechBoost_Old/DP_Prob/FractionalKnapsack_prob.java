package TechBoost_Old.DP_Prob;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by piyush.bajaj on 19/04/18.
 * Time Complexity: O(nlogN)
 */
public class FractionalKnapsack_prob {


    public static void main(String[] args) {
        FractionalKnapsack_prob fp = new FractionalKnapsack_prob();
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};
        int maxWeight = 50;



        System.out.println(fp.calculate(weight, value, maxWeight));
    }

    public int calculate(int[] weight, int[] value, int maxWt){
        int n = weight.length;
        ArrayList<Items> arr = new ArrayList<>();

        for(int i = 0; i < n; i++){
            arr.add(new Items(weight[i], value[i]));
        }

        arr.sort(new MyComparator());

        int sum = 0;
        for(int i = 0; i < n; i++){
            if(arr.get(i).weight <= maxWt){
                sum += arr.get(i).profit;
                maxWt -= arr.get(i).weight;
            }
            else {
                sum+= (arr.get(i).profit/arr.get(i).weight)*maxWt;
            }
        }

        return sum;
    }


    class Items{
        int weight;
        int profit;

        Items(int weight, int profit){
            this.weight = weight;
            this.profit = profit;
        }
    }

    class MyComparator implements Comparator<Items> {

        @Override
        public int compare(Items o1, Items o2) {
            int p1 = o1.profit/o1.weight;
            int p2 = o2.profit/o2.weight;

            return p2 - p1;
        }
    }
}
