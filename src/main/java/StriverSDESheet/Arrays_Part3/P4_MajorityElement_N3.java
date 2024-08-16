package StriverSDESheet.Arrays_Part3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bajajp on 09 Sep, 2022
 */
public class P4_MajorityElement_N3 {
    public static void main(String[] args) {
        P4_MajorityElement_N3 p4_majorityElement_n3 = new P4_MajorityElement_N3();
        System.out.println(p4_majorityElement_n3.majorityElement_better(new int[] {11, 33, 33, 11, 33, 11}));
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param arr
     * @return
     */
    public int majorityElement(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i : arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        for (int item : hashMap.keySet()) {
            if (hashMap.get(item) > n / 3) {
                return item;
            }
        }
        return 0;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * Capturing most frequent occurring numbers
     *
     * @param arr
     * @return
     */
    public List<Integer> majorityElement_better(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;

        int num1 = -1, num2 = -1, c1 = 0, c2 = 0;

        for (int num : arr) {
            if (num == num1) {
                c1++;
            } else if (num == num2) {
                c2++;
            } else if (c1 == 0) {
                num1 = num;
                c1++;
            } else if (c2 == 0) {
                num2 = num;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for (int num : arr) {
            if (num == num1) {
                c1++;
            } else if (num == num2) {
                c2++;
            }
        }

        if (c1 > n / 3) {
            result.add(num1);
        }

        if (c2 > n / 3) {
            result.add(num2);
        }

        return result;
    }
}
