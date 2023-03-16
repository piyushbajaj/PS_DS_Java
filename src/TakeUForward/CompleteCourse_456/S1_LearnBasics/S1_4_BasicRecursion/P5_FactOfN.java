package TakeUForward.CompleteCourse_456.S1_LearnBasics.S1_4_BasicRecursion;

/**
 * Created by bajajp on 17 Sep, 2022
 */
public class P5_FactOfN {

    /**
     * TC: O(N)
     * SC: O(N)
     * @param n
     * @return
     */
    static int fact(int n) {
        if (n == 1) return 1;

        return n * fact(n - 1);
    }

    public static void main(String[] args) {

    }
}
