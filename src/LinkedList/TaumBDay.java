package LinkedList;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 15/01/18.
 */
public class TaumBDay {
    static long taumBday(int b, int w, int x, int y, int z) {
        // Complete this function

        long val = 0;

        if ((x == y) || (z >= x && z >= y)) {
            val = (long) x * b + (long) y * w;
            return val;
        } else if (y + z < x) {
            val = (long) w * y + (long) b * (y + z);
            return val;
        } else if (x + z < y) {
            val = (long) b * x + (long) w * (x + z);
            return val;
        } else {
            val = (long) x * b + (long) y * w;
            return val;
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int b = in.nextInt();
            int w = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            long result = taumBday(b, w, x, y, z);
            System.out.println(result);
        }
        in.close();
    }
}
