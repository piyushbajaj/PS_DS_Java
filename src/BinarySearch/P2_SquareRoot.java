package BinarySearch;

/**
 * Created by bajajp on 20 Sep, 2022
 */
public class P2_SquareRoot {

    /**
     * TC: O(N)
     *
     * @param x
     * @return
     */
    static int squareRoot(int x) {
        int i = 1;

        if (x == 1 || x == 0) {
            return x;
        }

        for (; i < x; i++) {
            int square = i * i;
            int squareNext = (i + 1) * (i + 1);

            if (square == x) {
                return i;
            }

            if (x > square && x < squareNext) {
                return i;
            }
        }
        return -1;
    }

    static int squareRoot1(int x) {
        int low = 2, high = x / 2;

        if (x == 1 || x == 0) {
            return x;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        int num = 2147395599;
//        System.out.println(squareRoot(num));
        System.out.println(squareRoot1(num));
    }
}
