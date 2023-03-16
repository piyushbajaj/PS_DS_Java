package LC_Contest.Weekly_19th_Feb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: DS_Algo
 * Package: LC_Contest.Weekly_19th_Feb
 * <p>
 * User: piyushbajaj
 * Date: 19/02/23
 * Time: 8:57 am
 */
public class P1_Merge_2D_Arrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();

        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                int sum = nums1[i][1] + nums2[j][1];
                result.put(nums1[i][0], sum);
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result.put(nums1[i][0], nums1[i][1]);
                i++;
            } else {
                result.put(nums2[j][0], nums2[j][1]);
                j++;
            }
        }

        while (i < n) {
            result.put(nums1[i][0], nums1[i][1]);
            i++;
        }

        while (j < n) {
            result.put(nums2[j][0], nums2[j][1]);
            j++;
        }

        int[][] resArr = new int[result.size()][2];
        int k = 0;
        for (Map.Entry<Integer, Integer> map : result.entrySet()) {
            resArr[k][0] = map.getKey();
            resArr[k][1] = map.getValue();
            k++;
        }

        return resArr;
    }

    public static void main(String[] args) {
        P1_Merge_2D_Arrays p1_merge_2D_arrays = new P1_Merge_2D_Arrays();
        System.out.println(Arrays.deepToString(
            p1_merge_2D_arrays.mergeArrays(new int[][] {{1, 2}, {2, 3}, {4, 5}}, new int[][] {{1, 4},
                {3, 2}, {4, 1}})));
    }
}
