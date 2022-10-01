package Practice75Problems;

/**
 * Created by bajajp on 18 Jun, 2022
 */
public class P7_Anagram {
    public static boolean isAnagram(String s, String t) {
        int[] frequency = new int[26];

        int asciiA = 'a';
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - asciiA]++;
        }

        for (int i = 0; i < t.length(); i++) {
            frequency[t.charAt(i) - asciiA]--;
        }

        for (int i = 0; i < 26; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "cat"));
    }
}
