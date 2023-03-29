package LinkedList;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 22/01/18.
 */
public class Kaprekar_Prob {
    public static void main(String[] args) {
        int[] res = kaprekar(1, 99999);
        if (res.length == 0) {
            System.out.println("INVALID RANGE");
        }
    }

    public static int[] kaprekar(int p, int q) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        int count = 0, val = 0;
        long square = 0;
        for (int i = p; i <= q; i++) {
            square = (long) i * (long) i;
            String str = String.valueOf(square);
            int len = str.length();

            if (len == 1) {
                if (square == i) {
                    count++;
                    arrayList.add(i);
                }
            } else {
                if (len % 2 == 0) {
                    val = Integer.valueOf(str.substring(0, len / 2)) + Integer.valueOf(str.substring(len / 2, len));
                } else {
                    val = Integer.valueOf(str.substring(0, len / 2)) + Integer.valueOf(str.substring(len / 2, len));
                }
                if (val == i) {
                    count++;
                    arrayList.add(val);
                }
            }
        }

        int[] result = new int[count];

        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}
