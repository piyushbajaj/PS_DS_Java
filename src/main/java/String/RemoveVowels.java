package String;

/**
 * Created by bajajp on 18 Jul, 2022
 */
public class RemoveVowels {
    public static String removeVowels(String s) {
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' ||
                s.charAt(i) == 'u') {
                s = s.substring(0, i).concat(s.substring(i + 1, n));
            }
        }

        return s;
    }

    public static String removeVowels_better(String s) {
        return s.replaceAll("[aeiou]", "");
    }

    public static String defanged_IP_Address(String s) {
        return s.replaceAll("[.]", "[.]");
    }

    public static void main(String[] args) {
        System.out.println(removeVowels_better("leetcodeisacommunityforcoders"));

        System.out.println(defanged_IP_Address("1.1.1.1"));
    }
}
