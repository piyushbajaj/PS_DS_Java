package Neetcode150.ArraysNHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: DSAlgo
 * Package: Neetcode150.ArraysNHashing
 * <p>
 * User: piyushbajaj
 * Date: 27/05/26
 * Time: 4:57 pm
 */
public class P4_GroupAnagram {

    /**
     * TC: O(N*M)
     * SC: O(N*26)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsAscii = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            int[] ascii = new int[26];

            for (char ch : chars) {
                ascii[ch - 'a']++;
            }

            String key = Arrays.toString(ascii);
            anagramsAscii.putIfAbsent(key, new ArrayList<>());
            anagramsAscii.get(key).add(str);
        }

        return new ArrayList<>(anagramsAscii.values());
    }

    public static void main(String[] args) {
        P4_GroupAnagram groupAnagram = new P4_GroupAnagram();
        System.out.println(groupAnagram.groupAnagrams(new String[] {"act", "pots", "tops", "cat", "stop", "hat"}));
    }
}
