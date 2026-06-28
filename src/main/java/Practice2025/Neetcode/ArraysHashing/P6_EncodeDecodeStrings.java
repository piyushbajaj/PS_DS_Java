package Practice2025.Neetcode.ArraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 10/06/25
 * Time: 10:44 am
 */
public class P6_EncodeDecodeStrings {

    /**
     * 1. Create empty String Builder
     * 2. Append String length and also append delimeter # to the String Builder
     * <p>
     * TC: O(N)
     * SC: O(N+M)
     * N: Number of Strings
     * M: Sum of lengths of all the Strings
     *
     * @param strs
     * @return
     */
    public String encode(List<String> strs) {
        StringBuilder encodeStr = new StringBuilder();
        for (String str : strs) {
            encodeStr.append(str.length()).append("#").append(str);
        }
        return encodeStr.toString();
    }

    /**
     * Decode
     * 1. Create empty String Builder and empty list
     * 2. Loop that will end only when first < len
     * 2.1. Increment the second ptr till it reaches #
     * 2.2. Extract the length using substring into temp -> currLen
     * 2.3. Increment first ptr -> second + 1, and second ptr -> first + currLen
     * 2.4. Extract the substring from first to second into the list
     * 2.5. first -> second
     * <p>
     * TC: O(N)
     * SC: O(N + M)
     *
     * @param str
     * @return
     */
    public List<String> decode(String str) {
        List<String> decodedStr = new ArrayList<>();
        int len = str.length();

        int first = 0;
        while (first < len) {
            int second = first;

            while (str.charAt(second) != '#') {
                second++;
            }
            int currStrLen = Integer.parseInt(str.substring(first, second));
            first = second + 1;
            second = first + currStrLen;
            decodedStr.add(str.substring(first, second));
            first = second;
        }
        return decodedStr;
    }

    public static void main(String[] args) {
        P6_EncodeDecodeStrings encodeDecodeStrings = new P6_EncodeDecodeStrings();
        String encodedStr = encodeDecodeStrings.encode(Arrays.asList("Piyush", "Bajaj", "How", "Are", "You?"));
        System.out.println(encodedStr);
        System.out.println(encodeDecodeStrings.decode(encodedStr));
    }
}
