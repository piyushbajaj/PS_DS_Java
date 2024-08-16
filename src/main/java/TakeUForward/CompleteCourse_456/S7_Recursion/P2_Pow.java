package TakeUForward.CompleteCourse_456.S7_Recursion;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 16/10/22
 * Time: 11:13 am
 * <p>
 */
public class P2_Pow {
    public static void main(String[] args) {
        P2_Pow p2_pow = new P2_Pow();
        System.out.println(p2_pow.myPow(0.00001, 2147483647));
    }

    public double myPow(double x, int n) {
        if ((long) n >= 0) {
            return myPow_util(x, 1, n, n);
        } else {
            return myPow_neg_util(x, 1, n, n);
        }
    }

    public double myPow_util(double x, double pow, long n, long i) {
        if (i == 0) {
            return pow;
        }
        return myPow_util(x, x * pow, n, i - 1);
    }

    public double myPow_neg_util(double x, double pow, long n, long i) {
        if (i == 0) {
            return pow;
        }
        return myPow_neg_util(x, (1 / x) * (pow), n, i + 1);
    }
}
