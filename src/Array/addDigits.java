package Array;

/**
 * Created by piyush.bajaj on 16/11/17.
 */
public class addDigits {
    public static int addDigits(int num) {
        int n = 0;
        n = 1 + ((num-1)%9);
        return n;



    }

    public static void main(String[] args) {
        System.out.println(addDigits(11));
    }
}
