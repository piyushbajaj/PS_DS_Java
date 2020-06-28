package CrackingCoding.Array.Jan_2018;

/**
 * Created by piyush.bajaj on 25/01/18.
 * Here we are making an assumption that all Strings are ASCII and not unicode
 */
public class uniqueCharacter_Prob {
    public static void main(String[] args) {
        String str = "piyushj  ";

        System.out.println(unique_Char(str));
    }


    /*
    Time Complexity: O(N)
    Space Complexity: O(256)
     */
    public static boolean unique_Char(String str){
        boolean[] flag = new boolean[256];

        int n = str.length();

        for(int i = 0; i < n; i++){
            int val = str.charAt(i);
            if(flag[val]){
                return false;
            }
            else {
                flag[val] = true;
            }
        }
        return true;
    }
}
