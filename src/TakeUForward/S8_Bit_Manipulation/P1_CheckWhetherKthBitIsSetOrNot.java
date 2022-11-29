package TakeUForward.S8_Bit_Manipulation;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S8_Bit_Manipulation
 * <p>
 * User: piyushbajaj
 * Date: 21/11/22
 * Time: 7:25 pm
 */
public class P1_CheckWhetherKthBitIsSetOrNot {
    public boolean checkKthBit(int n, int k) {
        String binary = Integer.toBinaryString(n);

        return binary.charAt(binary.length() - 1 - k) == '1';
    }

    public static void main(String[] args) {
        P1_CheckWhetherKthBitIsSetOrNot p1_checkWhetherKthBitIsSetOrNot = new P1_CheckWhetherKthBitIsSetOrNot();
        System.out.println(p1_checkWhetherKthBitIsSetOrNot.checkKthBit(4, 2));
    }
}
