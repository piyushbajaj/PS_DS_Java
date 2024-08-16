package TakeUForward.CompleteCourse_456.S8_Bit_Manipulation.Techie_Delight_Bitwise;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S8_Bit_Manipulation.Techie_Delight_Bitwise
 * <p>
 * User: piyushbajaj
 * Date: 29/12/22
 * Time: 8:49 pm
 */
public class P2_Detect_Opposite_Sign {

    public static String isOppositeSign(int a, int b) {
        return (a ^ b) < 0 ? "Opposite" : "Same";
    }

    public static void main(String[] args) {
        System.out.println(isOppositeSign(4, -8));

        System.out.println(isOppositeSign(4, 8));
    }
}
