package InterviewBit;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 07/04/17.
 */
public class contigousArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int n = a.size();

        int sum=0, max =0, start =0, end = 0, diff = 0, negIndex = 0, count = 0;
        for(int k: a){
            if(k>=0){
                sum+=k;
                if(sum==max && (count - (negIndex+1)) > diff){
                    start = negIndex+1;
                    end = count + 1;
                }
            }
            //a.
            if(sum>= max && k >= 0){
                max =sum;
                end = count + 1;

            }

            if(k < 0) {
                sum = 0;
                negIndex = count;
                diff = end - start;
                if(diff == 0)
                    start = count+1;

            }
            count++;
        }

        a = new ArrayList<>(a.subList(start, start + diff));
        return a;
    }

    public static void main(String[] args) {
        contigousArray ca = new contigousArray();
        ArrayList<Integer> ar = new ArrayList<>();
//        ar.add(1);
//        ar.add(2);
//        ar.add(5);
//        ar.add(-7);
//        ar.add(2);
//        ar.add(3);
        ar.add(-1);
        ar.add(-1);
        ar.add(3342);
        ar.add(-1);
        System.out.println(ca.maxset(ar));
    }
}
