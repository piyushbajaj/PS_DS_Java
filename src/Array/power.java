package Array;

/**
 * Created by piyush.bajaj on 06/04/17.
 */
public class power {
    public static void main(String[] args) {
        power pw = new power();
        System.out.println(pw.powerRaise(2, 3, 3));
        System.out.println(pw.power_improved(2, 3, 3));
    }

    public int powerRaise(int x, int n, int d) {
        int temp = 1;
        long res = 1L;

        for (int i = 0; i < n; i++) {
            temp = x * temp;
        }

        return temp % d;
    }

    public int power_improved(int x, int n, int d) {
        long a = x;
        long res = 1L;

        while (n > 0) {

            if (n % 2 == 1) {
                res *= a;
                res %= d;
            }

            a *= a;
            a %= d;
            n = n >> 1;

        }

        res = (res + d) % d;

        return (int) res;

    }
}
