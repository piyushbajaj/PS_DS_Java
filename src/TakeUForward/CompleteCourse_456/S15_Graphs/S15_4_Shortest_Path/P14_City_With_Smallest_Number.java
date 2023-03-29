package TakeUForward.CompleteCourse_456.S15_Graphs.S15_4_Shortest_Path;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 04/11/22
 * Time: 6:02 pm
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/0">...</a>
 */
public class P14_City_With_Smallest_Number {
    public static void main(String[] args) {
        P14_City_With_Smallest_Number p14_city_with_smallest_number = new P14_City_With_Smallest_Number();

        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};

        System.out.println(p14_city_with_smallest_number.findCity(4, 4, edges, 4));
    }

    public int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) 1e9;
            }
        }

        for (int i = 0; i < m; i++) {
            matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            matrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] == 1e9 || matrix[k][j] == 1e9) {
                        continue;
                    }

                    matrix[i][j] = Math.min(matrix[i][k] + matrix[k][j], matrix[i][j]);
                }
            }
        }

        int maxCount = n;
        int city = -1;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }

            if (cnt <= maxCount) {
                maxCount = cnt;
                city = i;
            }
        }

        return city;
    }
}
