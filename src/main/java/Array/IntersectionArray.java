package Array;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by piyush.bajaj on 17/11/17.
 */
public class IntersectionArray {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int j = 0;
        int k = 0;
//        if(n1 > n2)
//            k = n2;
//        else
//            k = n1;


        HashSet<Integer> hash1 = new HashSet<>();
        HashSet<Integer> hash2 = new HashSet<>();
        HashSet<Integer> hash3 = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            hash1.add(nums1[i]);
        }
        int count = 0;
        for (int i = 0; i < n2; i++) {
            hash2.add(nums2[i]);
        }

        Iterator<Integer> itr = hash2.iterator();
        while (itr.hasNext()) {
            int l = itr.next().intValue();
            if (hash1.contains(l)) {
                hash3.add(l);
            }

        }


        int[] result = new int[hash3.size()];

        Iterator<Integer> itr1 = hash3.iterator();
        while (itr1.hasNext()) {
            result[j] = itr1.next().intValue();
            j++;

        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        int[] b = {1, 1, 3, 4};
        int[] res = (intersection(a, b));

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }


    }
}
