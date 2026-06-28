package Practice2025.Neetcode.ArraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 09/04/25
 * Time: 5:56 pm
 *
 * TC: O(N)
 */
public class EncodeDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str.length()).append("#").append(str);
        }

        return stringBuilder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int index = 0;
        int len = s.length();
        List<String> decodeList = new ArrayList<>();

        while (index < len) {
            int j = index;

            while (s.charAt(j) != '#') {
                j++;
            }

            int currStrLen = Integer.parseInt(s.substring(index, j));
            index = j + 1; // one for delimiter and j for string length
            String currStr = s.substring(index, currStrLen + index);
            index += currStrLen;
            decodeList.add(currStr);
        }

        return decodeList;
    }

    public static void main(String[] args) {
        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();
        String encode = encodeDecodeStrings.encode(Arrays.asList("How", "Are", "You"));
        System.out.println(encodeDecodeStrings.decode(encode));

    }
}
