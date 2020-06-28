package TechBoost_Old;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by piyush.bajaj on 19/04/18.
 */
public class FractionalKnapsack {

    public static void main(String[] args) {
        int[] weight					= {10,20,30};
        int[] profit					= {60,100,120};
        ArrayList<Items> itemsArrayList	= new ArrayList<>();

        for (int i = 0; i < weight.length; i++) {
            itemsArrayList.add(new Items(weight[i], profit[i]));
        }

        itemsArrayList.sort(new MyComparator());
        int totalProfit	= 0;
        int weightLeft	= 50;
        for (int i = 0; i < itemsArrayList.size(); i++) {
            int p=itemsArrayList.get(i).profit;
            int w=itemsArrayList.get(i).weight;

            if(w<=weightLeft){
                totalProfit+=p;
                weightLeft-=w;
            }else{
                totalProfit+=(p/w)*weightLeft;
            }
        }
        System.out.println(totalProfit);
    }

}
class Items{
    int weight;
    int profit;
    public Items(int weight,int profit){
        this.weight=weight;
        this.profit=profit;
    }

}
class MyComparator implements Comparator<Items> {

    @Override
    public int compare(Items item1, Items item2) {
        Integer pwRation1=item1.profit/item1.weight;
        Integer pwRation2=item2.profit/item2.weight;

        return pwRation2 - pwRation1;
    }

}
