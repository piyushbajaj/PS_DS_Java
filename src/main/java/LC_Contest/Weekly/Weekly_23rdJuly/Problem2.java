package LC_Contest.Weekly.Weekly_23rdJuly;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DSAlgo
 * Package: LC_Contest.Weekly.Weekly_23rdJuly
 * <p>
 * User: piyushbajaj
 * Date: 23/07/23
 * Time: 9:06 am
 */
public class Problem2 {
    public long maxArrayValue(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;

        List<Integer> numList = new ArrayList<>();

        for (int num : nums) {
            numList.add(num);
        }

        while (i < n) {
            if (numList.get(j) <= numList.get(j + 1)) {
                numList.set(j + 1, numList.get(j) + numList.get(j + 1));
                numList.remove(j);
                j = j + 1;

                if (j == n) {
                    j = 0;
                }
            }
        }

        return -1;


    }

    public static void main(String[] args) {

    }
}
