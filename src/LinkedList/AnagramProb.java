package LinkedList;

/**
 * Created by piyush.bajaj on 07/01/18.
 */
public class AnagramProb {
    public static int anagram(String s){
        // Complete this function
        int len = s.length();
        if(len%2!=0) return -1;

        int[] charArr = new int[26];

        String s1 = "", s2 = "";

        s1 = s.substring(0, len/2);
        s2 = s.substring(len/2, len);

        int count = 0;
        int j = 0;
        for(int i = 0; i < len/2; i++){
            charArr[Integer.valueOf(s1.charAt(i))-97]++;

        }

        for(int i = 0; i < len/2; i++){
            if(charArr[Integer.valueOf(s2.charAt(i))-97] == 0)
                count++;
            else
                charArr[Integer.valueOf(s2.charAt(i))-97]--;
        }

        return count;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int q = in.nextInt();
//        for(int a0 = 0; a0 < q; a0++){
//            String s = in.next();
//            int result = anagram(s);
//            System.out.println(result);
//        }

        String s = "xyyx";
        int result = anagram(s);
    }
}
