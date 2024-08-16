package DynamicProgramming;

/**
 * Created by piyush.bajaj on 11/08/17.
 * Given a string s, form a shortest palindrome by appending characters at the start of the string.
    Example: abab => babab
                abcd => dcbabcd
                ananab    => bananab

 Algorithm:
 1. Normal String + Reverse of String
 2. Find Suffix(reverse string) which is longest prefix of(string)
 3. Remove the longest suffix from reverse string
 4. After removal just add to the original string.

 */
public class shortest_palindrome {

    public String shortest_pal(String str){

        String rev = reverse(str);
        String comp = str + rev;
        String temp = "";
        //Now find suffix which is longest prefix
        //int ;
        int k = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(k) == rev.charAt(i)){
                temp += str.charAt(k);
                k++;
            }
            else
                k = 0;
        }

        int i = 0, j = 0;
        for( j = 0; j < rev.length(); j++){
            if(temp.charAt(i) == rev.charAt(j)){

                if(rev.substring(j, rev.length()).equals(temp))
                    break;
                i++;

            }


        }
        rev = rev.substring(i, j);

        String original = "";
        original = rev+str;




        return original;
    }

    public String reverse(String str){
        int n = str.length();
        char[] chArr = str.toCharArray();
        char ch;
        for(int i = 0; i < n/2; i++){
            ch = chArr[i];
            chArr[i] = chArr[n-i-1];
            chArr[n-i-1] = ch;
        }
        return String.valueOf(chArr);
    }

    public static void main(String[] args) {
        shortest_palindrome sp = new shortest_palindrome();
        String str = "abcd";
        System.out.println(sp.shortest_pal(str));
    }
}
