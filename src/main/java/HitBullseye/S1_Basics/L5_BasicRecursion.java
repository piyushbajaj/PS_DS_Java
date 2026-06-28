package HitBullseye.S1_Basics;

/**
 * Project: DSAlgo
 * Package: HitBullseye.S1_Basics
 * <p>
 * User: piyushbajaj
 * Date: 18/05/25
 * Time: 5:03 pm
 */
public class L5_BasicRecursion {

    static int cnt = 0;

    static void print() {

        // Base Condition.
        if (cnt == 3) {
            return;
        }
        System.out.println(cnt);

        // Count incremented.
        cnt = cnt + 1;
        print();

    }

    public static void main(String[] args) {
        print();
    }
}
