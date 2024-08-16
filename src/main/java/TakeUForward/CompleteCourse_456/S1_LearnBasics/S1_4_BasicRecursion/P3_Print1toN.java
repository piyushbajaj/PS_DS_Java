package TakeUForward.CompleteCourse_456.S1_LearnBasics.S1_4_BasicRecursion;

/**
 * Created by bajajp on 17 Sep, 2022
 */
public class P3_Print1toN {
    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param n
     */
    static void print1toN(int n) {
        if (n == 0) {
            return;
        }

        print1toN(n - 1);
        System.out.print(n + " ");
    }

    static void printNto1(int n) {
        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        printNto1(n - 1);
    }

    public static void main(String[] args) {
        print1toN(10);
        System.out.println();
        printNto1(10);
    }
}
