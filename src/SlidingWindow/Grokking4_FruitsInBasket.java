package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 23 Sep, 2022
 */
public class Grokking4_FruitsInBasket {

    /**
     * TC: O(N)
     * SC: O(3)
     *
     * @param arr
     * @return
     */
    static int maximumFruitsInBasket(char[] arr) {
        int l = 0, r = 0, n = arr.length;
        int maxFruit = 0;
        int maxTypeOfFruit = 2;

        // Fruits with their counts
        Map<Character, Integer> hashMap = new HashMap<>();
        while (r < n) {
            if (hashMap.size() <= maxTypeOfFruit) {
                hashMap.put(arr[r], hashMap.getOrDefault(arr[r], 0) + 1);
                r++;
                if (hashMap.size() == maxTypeOfFruit) {
                    maxFruit = Math.max(maxFruit, r - l);
                }
            }

            while (hashMap.size() > maxTypeOfFruit) {
                hashMap.put(arr[l], hashMap.getOrDefault(arr[l], 0) - 1);
                if (hashMap.getOrDefault(arr[l], 0) == 0) {
                    hashMap.remove(arr[l]);
                }
                l++;
            }
        }

        return maxFruit == 0 ? Math.max(maxFruit, r - l) : maxFruit;
    }

    public static void main(String[] args) {
        System.out.println(maximumFruitsInBasket(new char[] {'A', 'B', 'C', 'A', 'C'}));
        System.out.println(maximumFruitsInBasket(new char[] {'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
