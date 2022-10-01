package TakeUForward.S11_Heaps.S11_2_Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 28 Sep, 2022
 */
public class P4_ReplaceElementsByItsRank {

    /**
     * TC: O(nLogN)
     * SC: O(N)
     *
     * @param arr
     * @return
     */
    static int[] replaceElementsByItsRank(int[] arr) {
        int n = arr.length;

        int[] dummyArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(dummyArray);
        // to store the ranks
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.putIfAbsent(dummyArray[i], hashMap.size() + 1);
        }

        for (int i = 0; i < n; i++) {
            dummyArray[i] = hashMap.get(arr[i]);
        }

        return dummyArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceElementsByItsRank(new int[]{20, 15, 26, 2, 98, 6})));
    }
}
