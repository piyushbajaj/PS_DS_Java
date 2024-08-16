package CrackingCoding.Array.Jan_2018;

/**
 * Created by piyush.bajaj on 25/01/18.
 */
public class ReplaceString_Prob {
    public static void main(String[] args) {
        String s = "piyush bajaj ";
        replaceString(s);
    }

    public static String replaceString(String str) {
        if (!str.contains(" ")) {
            return str;
        }

        int n = str.length();
        char[] arr = new char[n];

        arr = str.toCharArray();

        //Calculate the last character before BLANK comes
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                //index = i;
                //break;
                arr[i] = arr[i - 1];
                arr[i - 1] = ' ';
            }
        }


        //String s = str.trim();

        //StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            if (arr[i] == ' ') {
                arr = displaceChar(arr, i + 1, index);
            }
        }

        return str;
    }

    public static char[] displaceChar(char[] arr, int i, int j) {
        char temp = ' ';
        for (int k = i; k < j; k++) {
            temp = arr[k];
            //arr
        }

        return arr;
    }
}
