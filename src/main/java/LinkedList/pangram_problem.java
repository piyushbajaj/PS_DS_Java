package LinkedList;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by piyush.bajaj on 08/06/18.
 */
public class pangram_problem {
    private static final Scanner scanner = new Scanner(System.in);

    static String pangrams(String s) {
        int[] charArr = new int[26];

        String result = "";
        s = s.toLowerCase();

        int n = s.length();

        for (int i = 0; i < n; i++) {

            if ((s.charAt(i) - 97) >= 0 && (s.charAt(i) - 97) < 26) {
                System.out.println(s.charAt(i) - 97);
                charArr[s.charAt(i) - 97]++;
            }

            //System.out.println(charArr[s.charAt(i) - 97]);
            //System.out.println(charArr[s.charAt(i) - 97]);
        }


        for (int i = 0; i < 26; i++) {
            // if((s.charAt(i) - 97) == ' ')
            //     continue;
            if (charArr[i] == 0) {
                result = "not pangram";
                return result;
            }

        }

        result = "pangram";
        return result;

    }

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        String s = "We promptly judged antique ivory buckles for the next prize";

        String result = pangrams(s);

        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
