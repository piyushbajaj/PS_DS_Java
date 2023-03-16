package TakeUForward.CompleteCourse_456.S16_DP.S16_DP_Squares;

import java.util.Stack;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue
 * <p>
 * User: piyushbajaj
 * Date: 11/01/23
 * Time: 11:53 pm
 */
public class P1_Max_Rectangle_Area_With_1s {

    /**
     * TC: O(N* (M+N))
     * SC: O(M)
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] hist = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    hist[j]++;
                } else {
                    hist[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, getMaxArea_better(hist));
        }

        return maxArea;
    }

    /**
     * Got this function from P11
     *
     * @param hist
     * @return
     */
    public int getMaxArea_better(int[] hist) {
        int n = hist.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || hist[stack.peek()] >= hist[i])) {
                int height = hist[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        P1_Max_Rectangle_Area_With_1s p1_max_rectangle_area_with_1S = new P1_Max_Rectangle_Area_With_1s();
        char[][] matrix =
            {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        System.out.println(p1_max_rectangle_area_with_1S.maximalRectangle(matrix));
    }
}
