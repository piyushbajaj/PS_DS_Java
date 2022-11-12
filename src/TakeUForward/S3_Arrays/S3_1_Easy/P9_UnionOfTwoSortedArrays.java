package TakeUForward.S3_Arrays.S3_1_Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bajajp on 18 Sep, 2022
 */
public class P9_UnionOfTwoSortedArrays {
    static List<Integer> findUnion(int[] arr1, int[] arr2) {
        Set<Integer> hashSet = new HashSet<>();

        for (int i : arr1) {
            hashSet.add(i);
        }

        for (int i : arr2) {
            hashSet.add(i);
        }

        return new ArrayList<>(hashSet);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};

        System.out.println(findUnion(arr1, arr2));
    }
}
