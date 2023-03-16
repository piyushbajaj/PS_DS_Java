package TakeUForward.CompleteCourse_456.S3_Arrays.S3_3_Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_3_Hard
 * <p>
 * User: piyushbajaj
 * Date: 27/12/22
 * Time: 1:24 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/pascals-triangle/description/">...</a>
 */
public class P1_Pascals_Triangle {

    /**
     * TC: O(Rows * Cols)
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    curr.add(prev.get(j - 1) + prev.get(j));
                }
            }
            prev = curr;
            result.add(curr);
        }

        return result;
    }

    public static void main(String[] args) {
        P1_Pascals_Triangle p1_pascals_triangle = new P1_Pascals_Triangle();
        System.out.println(p1_pascals_triangle.generate(5));
    }
}
