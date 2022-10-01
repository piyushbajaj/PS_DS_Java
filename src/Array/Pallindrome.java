package Array;

/**
 * Created by piyush.bajaj on 10/12/16.
 */
public class Pallindrome {
    public static boolean isPallindrome(String s){
        int n = s.length();
        int i = 0;
        int j = n-1;
        while(i < j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        if(i<j){
            System.out.println("Not a Pallindrome");
            return false;
        }
        else {
            System.out.println("Pallindrome");
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "piytyip";
        System.out.println(isPallindrome(s));
    }
}
