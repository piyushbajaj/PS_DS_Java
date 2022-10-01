package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by piyush.bajaj on 18/09/16.
 */
public class MoonFrogTest {
    public static void main(String args[] ) throws Exception {

        //* Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        if(N>16 || N < 1){
            System.out.println("Value of N is more than expected");
            System.exit(0);
        }
        int[] a1 = new int[N];
        int[] a2 = new int[N];
        for (int i = 0; i < N; i++) {

            line = br.readLine();
            String[] splitLine = line.split(" ");
            a1[i] = Integer.parseInt(splitLine[0]);
            a2[i] = Integer.parseInt(splitLine[1]);

            if((a1[i] > N || a1[i] < 1) || (a2[i] > N || a2[i] < 1)){
                System.out.println("Value of X, Y should be in the range 1 to N");
                System.exit(0);
            }
        }



        int temp1 =0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(a1[i] > a1[j]) {
                    a1[i] = a1[j];
                    temp1 = a1[i];
                }
            }
        }

        int temp2 =0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(a2[i] > a2[j]) {
                    a2[i] = a2[j];
                    temp2 = a2[i];
                }
            }
        }

        if(temp1 <= temp2)
        System.out.println("Smallest value is" + temp1);
        else
            System.out.println("Smallest value is" + temp2);

    }
}
