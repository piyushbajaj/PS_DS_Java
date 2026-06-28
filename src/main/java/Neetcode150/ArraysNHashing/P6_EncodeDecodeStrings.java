package Neetcode150.ArraysNHashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DSAlgo
 * Package: Neetcode150.ArraysNHashing
 * <p>
 * User: piyushbajaj
 * Date: 31/05/26
 * Time: 12:58 pm
 * Link: https://neetcode.io/problems/string-encode-and-decode/question?list=neetcode150
 */
public class P6_EncodeDecodeStrings {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            result.add(str.substring(start, start + length));
            i = start + length;
        }
        return result;
    }

    public static void main(String[] args) {
        P6_EncodeDecodeStrings solution = new P6_EncodeDecodeStrings();
        List<String> strs = List.of("neet", "code", "love", "you");
        String encoded = solution.encode(strs);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + solution.decode(encoded));
    }
}
