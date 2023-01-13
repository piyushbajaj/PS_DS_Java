package TakeUForward.S8_Bit_Manipulation.Techie_Delight_Bitwise;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S8_Bit_Manipulation.Techie_Delight_Bitwise
 * <p>
 * User: piyushbajaj
 * Date: 29/12/22
 * Time: 8:29 pm
 */
public class P1_Check_Even_Odd {
    public static void isEvenOdd(int n) {
        if ((n & 1) == 1) {
            System.out.println("Odd");
        } else if ((n & 1) == 0) {
            System.out.println("Even");
        }
    }

    public static void main(String[] args) {
        isEvenOdd(2);
        isEvenOdd(3);
    }
}
