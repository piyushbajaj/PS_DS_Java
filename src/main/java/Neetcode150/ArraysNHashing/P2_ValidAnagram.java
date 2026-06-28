package Neetcode150.ArraysNHashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: DSAlgo
 * Package: Neetcode150.ArraysNHashing
 * <p>
 * User: piyushbajaj
 * Date: 26/05/26
 * Time: 9:27 am
 */
public class P2_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // base condition
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> hashAnagram = new HashMap<>();

        for (char ch : s.toCharArray()) {
            hashAnagram.put(ch, hashAnagram.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            hashAnagram.put(ch, hashAnagram.getOrDefault(ch, 0) - 1);
        }

        for (Map.Entry<Character, Integer> entry : hashAnagram.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        P2_ValidAnagram validAnagram = new P2_ValidAnagram();
        System.out.println(validAnagram.isAnagram("racecar", "carrace"));
        System.out.println(validAnagram.isAnagram("racecar", "carracb"));
    }
}
