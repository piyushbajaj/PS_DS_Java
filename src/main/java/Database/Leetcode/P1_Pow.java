package Database.Leetcode;

/**
 * Project: DSAlgo
 * Package: Database.Leetcode
 * <p>
 * User: piyushbajaj
 * Date: 24/07/23
 * Time: 11:28 am
 */
public class P1_Pow {

    public double myPow(double x, int n) {
        double res = 1;

        if (n < 0) {
            for (int i = -1; i >= n; i--) {
                res *= 1 / x;
            }
        } else if (n > 0) {
            for (int i = 1; i <= n; i++) {
                res *= x;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        P1_Pow p1Pow = new P1_Pow();
        System.out.println(p1Pow.myPow(2, -2));
    }
}
