package TakeUForward.S3_Arrays.S3_1_Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bajajp on 18 Sep, 2022
 */
public class P9_IntersectionOfTwoSorted {

    static List<Integer> getIntersection(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0;

        List<Integer> result = new ArrayList<>();

        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                result.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getIntersection(new int[]{1, 2, 3, 3, 4, 5, 6, 7}, new int[]{3, 3, 4, 4, 5, 8}));
    }
}
