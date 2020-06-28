package LinkedList;

/**
 * Created by piyush.bajaj on 07/03/18.
 */
public class makingAnagram_Prob {
    static int makingAnagrams(String s1, String s2){
        // Complete this function
        int len1 = s1.length();
        int len2 = s2.length();

//        if(len1 != len2)
//            return -1;

        int[] chars = new int[26];
        for(int i = 0; i < len1; i++){
            chars[s1.charAt(i)-97]++;
        }

        int count = 0;
        for(int i = 0; i < len2; i++){
            chars[s2.charAt(i)-97]--;

        }

        for(int i = 0; i < 26; i++){
            if(Math.abs(chars[i]) > 0)
                count += Math.abs(chars[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "dge";

        System.out.println(makingAnagrams(s1, s2));
    }
}
