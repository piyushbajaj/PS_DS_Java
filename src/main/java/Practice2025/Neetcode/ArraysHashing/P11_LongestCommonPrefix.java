package Practice2025.Neetcode.ArraysHashing;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 05/04/25
 * Time: 12:15 pm
 */
public class P11_LongestCommonPrefix {

    /**
     * Approach 1: Two Inner Loops
     * TC: O(N*M)
     * SC: O(1)
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String output = "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;


            for (j = 0; j < strs[i].length(); j++) {
                if (prefix.length() != strs[i].length() || strs[i].charAt(j) != prefix.charAt(j)) {
                    return output;
                }
                strs[i].indexOf(prefix);
            }
//            output +=
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("flow".indexOf("flower"));
    }
}
