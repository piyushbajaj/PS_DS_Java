package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 04/05/17.
 */
public class Fibonacci {
    private static int count = 0;
    public int fib_cal(int index){
        int sum = 0;
        count++;

        if(index <= 0)
            return 0;
        if(index == 1)
            return 1;

        //int x =

        //sum = 1;
//        int count = 1;
//        int i1 = 0, i2 = 1;
//        for(int i = 2; i <= index; i++){
//            sum= i1 + i2;
//            i2 = sum;
//
//        }
        //int sum = 0;
            return fib_cal(index-1) + fib_cal(index-2);





    }

    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();
        System.out.println(fb.fib_cal(10));
        System.out.println(count);
    }

}
