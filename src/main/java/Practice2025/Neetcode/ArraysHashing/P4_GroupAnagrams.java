package Practice2025.Neetcode.ArraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 03/04/25
 * Time: 10:47 am
 */
public class P4_GroupAnagrams {

    /**
     * Approach 1: Sorting the key in the HashMap
     * 1. Create HashMap<String, List<String>
     * 2. Loop through each String from the input Array
     * 2.1. Convert the current string to character Array, then sort the array and store back into the temp String.
     * 2.2. Now store back the temp String to hashMap along-with the current string as list.
     * 3. Out the map.values()
     * <p>
     * TC: O(N*MLog(M))
     * SC: O(N*M)
     * N: Number of String
     * M: Length of longest String
     *
     * @param strs: List of Strings
     * @return: List of String Values
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> mapResult = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = Arrays.toString(charArray);
            mapResult.putIfAbsent(sortedKey, new ArrayList<>());
            mapResult.get(sortedKey).add(str);
        }

        return new ArrayList<>(mapResult.values());
    }


    /**
     * Approach 2: Convert the String to Ascii form and store as key in HashMap
     * <p>
     * 1. Create HashMap<String, List<String>>
     * 2. Loop through each string
     * 2.1.
     * TC: O(N*M)
     * SC: O(N*M)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            int[] countAlphabet = new int[26];
            for (char ch : str.toCharArray()) {
                countAlphabet[ch - 'a']++;
            }

            String cntAlphabet = Arrays.toString(countAlphabet);
            System.out.println(cntAlphabet);

            anagrams.putIfAbsent(cntAlphabet, new ArrayList<>());
            anagrams.get(cntAlphabet).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        P4_GroupAnagrams groupAnagrams = new P4_GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[] {"act", "pots", "tops", "cat", "stop", "hat"}));
    }
}
