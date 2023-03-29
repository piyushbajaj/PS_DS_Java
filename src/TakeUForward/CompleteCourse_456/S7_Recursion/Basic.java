package TakeUForward.CompleteCourse_456.S7_Recursion;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 14/10/22
 * Time: 4:38 pm
 * <p>
 */
public class Basic {

    /**
     * Recursion: When a function calls itself until a specified condition is met
     * Base Condition: Where we say recursion to stop or return
     */

    /**
     * This is infinite recursion below
     */
    static void fun() {
        System.out.println(1);
        fun();
    }

    public static void main(String[] args) {
        Basic basic = new Basic();
        basic.printNameNTimes(0, 5);

        basic.print1ToN(1, 4);

        basic.printNTo1(4, 4);

        basic.addingSum1toN(3, 0);

        System.out.println(basic.addingSum1toN(3));

        System.out.println(basic.fact(3));
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param i
     * @param n
     */
    public void printNameNTimes(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println("Piyush");
        printNameNTimes(i + 1, n);
    }

    /**
     * Print 1 to N
     *
     * @param i
     * @param n
     */
    public void print1ToN(int i, int n) {
        if (i > n) {
            return;
        }

        System.out.println(i);
        print1ToN(i + 1, n);
    }

    public void printNTo1(int i, int n) {
        if (i < 1) {
            return;
        }

        System.out.println(i);
        printNTo1(i - 1, n);
    }

    // Parameterized Recursion
    // TC: O(N)
    // SC: O(N)
    public void addingSum1toN(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }

        addingSum1toN(i - 1, sum + i);
    }

    /**
     * Functional Recursion
     *
     * @param i
     */
    public int addingSum1toN(int i) {
        if (i == 0) {
            return 0;
        }

        return i + addingSum1toN(i - 1);
    }

    public int fact(int i) {
        if (i == 0) {
            return 1;
        }

        return i * fact(i - 1);
    }
}
