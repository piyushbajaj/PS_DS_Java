package DynamicProgramming;

/**
 * Created by piyush.bajaj on 17/08/17.
 * Algo:
 * 1. If the last number is greater than 0, then recur for n-1 digits and add the result to the total count.
 * 2. If the last 2 numbers is less than 27, then recur for n-2 digits and add the result to the total count.
 */
public class count_decodings {


    public static void main(String[] args) {
        count_decodings cd = new count_decodings();
        String str = "1234";

        int[] digits = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }

        System.out.println(cd.count_decoding(str.toCharArray(), str.length()));

        System.out.println(cd.count_decoding_improved(str.toCharArray(), str.length()));
    }

    public int count_decoding(char[] digits, int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int count = 0;

        if (digits[n - 1] > '0') {
            count += count_decoding(digits, n - 1);
        }

        if (digits[n - 2] == '1' || digits[n - 2] == '2' && digits[n - 1] < '7') {
            count += count_decoding(digits, n - 2);
        }

        return count;
    }

    //This can be optimized like Fibonacci
    public int count_decoding_improved(char[] digits, int n) {
//        if(n==0 || n==1)
//            return 1;

        int[] count = new int[n + 1];

        count[0] = 1;
        count[1] = 1;
        //int count = 0;

        for (int i = 2; i <= n; i++) {
            if (digits[i - 1] > '0') {
                count[i] = count[i - 1];
            }

            if (digits[i - 2] == '1' || digits[i - 2] == '2' && digits[i - 1] < '7') {
                count[i] += count[i - 2];
            }
        }


        return count[n];
    }
}
