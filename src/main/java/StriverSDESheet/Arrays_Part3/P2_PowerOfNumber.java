package StriverSDESheet.Arrays_Part3;

/**
 * Created by bajajp on 08 Sep, 2022
 */
public class P2_PowerOfNumber {

    public static void main(String[] args) {
        P2_PowerOfNumber p2_powerOfNumber = new P2_PowerOfNumber();
        System.out.println(p2_powerOfNumber.power(2, 6));
        System.out.println(p2_powerOfNumber.power_better(2, 6));
    }

    /**
     * O(n)
     *
     * @param n
     * @param k
     * @return
     */
    public int power(int n, int k) {
        int pow = 1;

        for (int i = 0; i < k; i++) {
            pow *= n;
        }

        return pow;
    }

    /**
     * O(logN)
     * When k is even -> n^k -> (n*n)^k/2
     * When k is odd -> n^k -> n*(n)^k-1
     *
     * @param n
     * @param k
     * @return
     */
    public int power_better(int n, int k) {
        int pow = 1;

        while (k != 0) {
            if (k % 2 == 0) {
                n = n * n;
                k = k / 2;
            } else {
                pow = pow * n;
                k--;
            }
        }
        return pow;
    }
}
