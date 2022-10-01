package CrackingCoding.Array.Jan_2018;

/**
 * Created by piyush.bajaj on 25/01/18.
 */
public class permutation_prob {
    public static void main(String[] args) {
        String str1 = "piyush";
        String str2 = "pipusy";

        System.out.println(permutation(str1, str2));
    }

    /*
    Considering its a ASCII value and not Unicode Characters
    Time Complexity: O(N)
    Space Complexity: O(256)
     */
    public static boolean permutation(String str1, String str2){
        int n1 = str1.length();
        int n2 = str2.length();

        if(n1!= n2) return false;

        int[] arr = new int[256];

        for(int i = 0; i < n1; i++){
            arr[str1.charAt(i)]++;
        }

        for(int i = 0; i < n1; i++){
            arr[str2.charAt(i)]--;
            if(arr[str2.charAt(i)] < 0)
                return false;
        }

        return true;
    }
}
