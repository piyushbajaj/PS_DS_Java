package Array.Practice_2022.SlidingWindow;

import BinaryTree.Practice_2022.CommonUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by bajajp on 12 Jun, 2022
 */
public class SW_1_SubstringWithConcatenation extends CommonUtils {
    public List<Integer> findSubstring(String s, String[] words) {
        int l = 0, r = 0;
        int n = s.length();
        Map<String, Integer> result = new HashMap<>();
        Set<String> hashSet = new HashSet<>(Arrays.asList(words));
        int wordLen = words[0].length();
//        r = wordLen;
        while (r < n) {
            String str = s.substring(r, r + wordLen); //
            if (hashSet.contains(str)) {
                if (result.containsKey(str)) {

                } else {

                }
                result.put(str, r);
                r += wordLen;
            } else {
                result.clear();
                l = r + wordLen;
            }
            r += wordLen;


        }

        return null;
    }

    public static void main(String[] args) {

    }
}
