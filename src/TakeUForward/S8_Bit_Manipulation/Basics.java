package TakeUForward.S8_Bit_Manipulation;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S8_Bit_Manipulation
 * <p>
 * User: piyushbajaj
 * Date: 14/10/22
 * Time: 9:24 am
 * <p>
 * Link: <a href="https://www.techiedelight.com/bit-hacks-part-1-basic/">...</a>
 */
public class Basics {
    // Problem 1. Check if an integer is even or odd
    public static String evenOdd(int n) {
        return (n & 1) == 0 ? "even" : "odd";
    }


    public static void main(String[] args) {
        System.out.println(evenOdd(10));
        System.out.println(evenOdd(11));
    }
}
