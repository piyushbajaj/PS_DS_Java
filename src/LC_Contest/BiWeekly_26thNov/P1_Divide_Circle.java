package LC_Contest.BiWeekly_26thNov;

/**
 * Project: DS_Algo
 * Package: LC_Contest.Weekly_26thNov
 * <p>
 * User: piyushbajaj
 * Date: 26/11/22
 * Time: 8:37 pm
 */
public class P1_Divide_Circle {

    public static void main(String[] args) {
        P1_Divide_Circle p1_divide_circle = new P1_Divide_Circle();
        System.out.println(p1_divide_circle.numberOfCuts(10));
    }

    public int numberOfCuts(int n) {
        // base case
        if (n == 1) {
            return 0;
        }

        return n % 2 == 0 ? n / 2 : n;
    }
}
