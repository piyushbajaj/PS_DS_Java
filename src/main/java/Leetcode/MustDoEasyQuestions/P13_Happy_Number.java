package Leetcode.MustDoEasyQuestions;

import java.util.HashSet;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 31/12/22
 * Time: 6:31 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/happy-number/">...</a>
 * <p>
 * Pattern: Hash Table, LinkedList
 * link: <a href="https://leetcode.com/problems/happy-number/solutions/421162/happy-number/">...</a>
 */
public class P13_Happy_Number {

    public static void main(String[] args) {
        P13_Happy_Number p13_happy_number = new P13_Happy_Number();
        System.out.println(p13_happy_number.isHappy(19));
        System.out.println(p13_happy_number.isHappy_better(19));
    }

    /**
     * TC: O(logN)
     * SC: O(N)
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();

        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    /**
     * TC: O(logN)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public boolean isHappy_better(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    public int getNext(int n) {
        int sum = 0;

        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }

        return sum;
    }
}
