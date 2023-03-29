package TakeUForward.CompleteCourse_456.S3_Arrays.S3_3_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_3_Hard
 * <p>
 * User: piyushbajaj
 * Date: 27/12/22
 * Time: 5:49 pm
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/majority-vote/1">...</a>
 */
public class P2_Majority_Element_N_3 {

    public static void main(String[] args) {
        P2_Majority_Element_N_3 p2_majority_element_n_3 = new P2_Majority_Element_N_3();
        System.out.println(p2_majority_element_n_3.majorityElement(new int[] {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6}));
    }

    /**
     * Appear more than n/3 times
     * TC: O(NlogN)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int n = nums.length;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);

            if (isMajority(hashMap.get(num), n)) {
                if (!result.contains(num)) {
                    result.add(num);
                }
            }
        }
        if (result.isEmpty()) {
            result.add(-1);
        }

        return result;
    }

    public boolean isMajority(int val, int n) {
        return val > Math.floor((double) n / 3);
    }
}
