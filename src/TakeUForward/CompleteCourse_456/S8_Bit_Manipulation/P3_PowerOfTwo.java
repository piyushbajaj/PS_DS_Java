package TakeUForward.CompleteCourse_456.S8_Bit_Manipulation;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S8_Bit_Manipulation
 * <p>
 * User: piyushbajaj
 * Date: 21/11/22
 * Time: 7:42 pm
 */
public class P3_PowerOfTwo {

    public static void main(String[] args) {
        P3_PowerOfTwo p3_powerOfTwo = new P3_PowerOfTwo();
        System.out.println(p3_powerOfTwo.isPowerOfTwo(256));
    }

    public boolean isPowerOfTwo(long n) {
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }
}
