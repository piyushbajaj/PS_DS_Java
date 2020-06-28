package Array;

/**
 * Created by piyush.bajaj on 20/10/16.
 */
public class PairSum {

    //This is done with a time complexity of n^2
    public boolean checkPairSum(int[] a, int x){
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                if((a[i] + a[j])==x)
                    return true;
            }
        }
        return false;
    }

    ///Using merge sort, sort an array

    public boolean checkPairSum_Improved(int[] a, int x){
        int l =0;
        int r = a.length -1;

        while(l<r){
            if(a[l] + a[r] == x)
                return true;
            else if(a[l] + a[r] < x)
                l++;
            else
                r--;
        }
        return false;
    }

    public void checkPairSum_Improved_MuchMore(int[] a, int x) {

        int MAX = 100000; // Max size of Hashmap
        boolean[] binMap = new boolean[MAX];

        for (int i = 0; i < a.length; i++) {

            int temp = x - a[i];

            if (temp >= 0 && binMap[temp]) {
                System.out.println("Pairs " + temp + "+" + a[i]);
                return;
            }
            binMap[a[i]] = true;
        }
    }


    public static void main(String[] args) {
        PairSum pr = new PairSum();
        int a[] = {1, 2, 3};
        int x = 6;
        //System.out.println(pr.checkPairSum(a,x));
        //This is done with a time complexity of n^2

        //System.out.println(pr.checkPairSum_Improved(a,x));
        //Here the time complexity will be nlogn


        pr.checkPairSum_Improved_MuchMore(a,x);
        //Here the time complexity is O(n)


    }
}
