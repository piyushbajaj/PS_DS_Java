package Array;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 23/12/17.
 */
public class SherlockSquares {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named LinkedList.Solution. */
//        Scanner s= new Scanner(System.in);
//        int N = s.nextInt();
//        int[] arr = new int[N];
//
//
//        for(int i = 0; i < N; i++){
//            int a = s.nextInt();
//            int b = s.nextInt();
//            check(a, b);
//        }

        check(3, 9);
    }

    public static void check(int a, int b){
        int count = 0;
        double sq = 0;

         int a_val = (int)Math.ceil(Math.sqrt(a));

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.remove(1);


        for(int i = a; i <= b; i++){
            sq = Math.sqrt(i);
            if(sq%1 == 0)
            //if(((sq == Math.floor(sq)) && !Double.isInfinite(sq)))
                count++;
        }
        System.out.println(count);
    }
}
