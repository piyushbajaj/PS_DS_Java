package OnlineTest;

/**
 * Created by piyush.bajaj on 14/02/17.
 */
public class Tracxn_Test {
    public static void main(String[] args) {
        Tracxn_Test TT = new Tracxn_Test();

        String str = "aabcccbd";
        int n = str.length();
        char[] charArr = TT.bomberAlgo(str.toCharArray(), n);
        //char[] charArr = TT.removeAdj(str.toCharArray(), n);

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '\0') {
                break;
            } else {
                System.out.print(charArr[i] + " ");
            }
        }

    }

    public char[] bomberAlgo(char[] arr, int n) {
        //int n = arr.length;
        int i;
        int k = 0;
        //char[] temp = {'\0'};
        //char ch = ' ';

        for (i = 1; i < n; i++) {
            if (arr[i - 1] != arr[i]) {
                arr[k++] = arr[i - 1];
            } else {
                while (arr[i - 1] == arr[i]) {
                    i++;
                }
            }
        }
        arr[k++] = arr[i - 1];
        arr[k] = '\0';
        if (k != n) {
            bomberAlgo(arr, k);
        }
//        else {
//            temp = new char[k];
//            for (int j = 0; j < k; j++)
//                temp[j] = arr[j];
//
//            return temp;
//        }

        return arr;

    }

    public char[] removeAdj(char[] arr, int len) {
        int j = 0;
        for (int i = 1; i <= len; i++) {
            while ((arr[i] == arr[j]) && (j >= 0)) {
                i++;
                j--;
            }
            arr[++j] = arr[i];
        }
        return arr;
    }
}
