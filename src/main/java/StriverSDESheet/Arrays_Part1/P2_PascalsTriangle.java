package StriverSDESheet.Arrays_Part1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bajajp on 30 Jul, 2022
 */
public class P2_PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        /**
         * Steps:
         * 1. Create an array of numsRows
         */
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currRow, previousRow = null;
        for (int i = 0; i < numRows; i++) {
            currRow = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currRow.add(1);
                } else {
                    if (previousRow != null) {
                        currRow.add(previousRow.get(j - 1) + previousRow.get(j));
                    }
                }
            }
            previousRow = currRow;
            result.add(currRow);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
