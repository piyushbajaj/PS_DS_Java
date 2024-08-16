package LinkedList;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 28/12/17.
 */
public class ACMTeam {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named LinkedList.Solution. */
        //int x=0b101;
        //int y=0b110;
        //int z=x|y;

        //int num = Integer.valueOf("1101") | Integer.valueOf("0010");

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            //arr[i] = "0b" + s.nextInt();
            arr[i] = s.next();
        }

        check_apc(arr, N, M);

    }

    public static long string_OR(String str1, String str2) {
        long val = Integer.valueOf(str1) | Integer.valueOf(str2);

        return val;
    }

    public static void check_apc(String[] arr, int N, int M) {
        //long str =0;
        //arr.le
        int count = 0, max = 0;
        for (int i = 0; i < N; i++) {

            for (int j = i + 1; j < N; j++) {
                // str+= Long.valueOf( arr[i] | arr[i]);
                //str = string_OR(arr[i], arr[j]);
                count = 0;
                for (int k = 0; k < M; k++) {
                    if (arr[i].charAt(k) == '1' || arr[j].charAt(k) == '1') {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                }
            }
        }
        int max_count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // str+= Long.valueOf( arr[i] | arr[i]);
                //str = string_OR(arr[i], arr[j]);
                count = 0;
                for (int k = 0; k < M; k++) {
                    if (arr[i].charAt(k) == '1' || arr[j].charAt(k) == '1') {
                        count++;
                    }
                }
                if (count == max) {
                    max_count++;
                }
            }
        }

        System.out.println(max);
        System.out.println(max_count);
    }
}
