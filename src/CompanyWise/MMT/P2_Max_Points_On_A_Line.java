package CompanyWise.MMT;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: DS_Algo
 * Package: CompanyWise.MMT
 * <p>
 * User: piyushbajaj
 * Date: 01/03/23
 * Time: 12:43 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/max-points-on-a-line/">...</a>
 */
public class P2_Max_Points_On_A_Line {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < n && i!= j; j++) {
                double slope = getSlope(points[i], points[j]);

                hashMap.put(slope, hashMap.getOrDefault(slope, 0) + 1);
                max = Math.max(max, hashMap.get(slope));
            }
        }

        return max + 1;
    }

    public double getSlope(int[] pointA, int[] pointB) {
        int xVal = (pointB[0] - pointA[0]);
        int yVal = (pointB[1] - pointA[1]);

        if (xVal == 0) {
            return Double.MAX_VALUE;
        }

        return (double) yVal / (double) xVal;
    }

    public static void main(String[] args) {
        P2_Max_Points_On_A_Line p2_max_points_on_a_line = new P2_Max_Points_On_A_Line();
        System.out.println(p2_max_points_on_a_line.maxPoints(new int[][] {{1, 1}, {2, 2}, {3, 3}}));
    }
}
