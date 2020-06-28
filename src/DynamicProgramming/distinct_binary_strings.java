package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by piyush.bajaj on 16/08/17.
 * Algorithm:
 * 1. If the B.S. ends with 0, we have to append both 0 and 1 one by one.
 * 2. But if the B.S. ends only with 1, we have to append only 0.
 */
public class distinct_binary_strings {

    private HashSet<String> hashSets[];

    public int distinct_BS(int n){
        HashMap<Integer, HashSet<String>> hashMap = new HashMap<>();
        //HashSet<String> hashSet = new HashSet<>();

        hashSets = new HashSet[n];

        for(int i = 0; i < n; i++)
            hashSets[i] = new HashSet<>();

        hashSets[0].add("0");
        hashSets[0].add("1");
        hashMap.put(0,hashSets[0]);

        int max = hashSets[0].size();

        for(int i =1; i < n; i++){
            //String str = hashMap.get(i-1);
            // {

                for(String key: hashSets[i-1]){
                    if(key.substring(i - 1, i).equals("0")){
                        String str = key.concat("0");
                        hashSets[i].add(str);
                        str = key.concat("1");
                        hashSets[i].add(str);
                        hashMap.put(i, hashSets[i]);
                    }
                    else if (key.substring(i - 1, i).equals("1")){
                        String str = key.concat("0");
                        hashSets[i].add(str);
                        hashMap.put(i, hashSets[i]);
                    }
                    if(hashSets[i].size() > max)
                        max = hashSets[i].size();
                }

            //}
        }
        return max;


    }

    //Its just like a fibonacci series 0, 2, 3, 5, 8, 13
    public int count_distinct(int n){
        if(n < 1)
            return 0;

        int temp1 = 1;
        int temp2 = 1;

//        if(n == 1)
//            return temp1 + temp2;
        int c = 0;
        for(int i =1; i <= n; i++){
            c = temp1 + temp2;
            temp1 = temp2;
            temp2 = c;
        }
        return c;


    }

    public static void main(String[] args) {
        distinct_binary_strings ds = new distinct_binary_strings();
        System.out.println(ds.distinct_BS(5));

        System.out.println(ds.count_distinct(5));
    }
}
