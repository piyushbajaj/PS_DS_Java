package Array;

/**
 * Created by piyush.bajaj on 16/03/17.
 */
public class maxMoney {
    static int maxMoney(int n, long k) {
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            if ((sum + i) != k) {
                sum += i;
            }
        }
        return sum;

    }

    public static void main(String[] args) {

        maxMoney(3, 3);
    }
}
