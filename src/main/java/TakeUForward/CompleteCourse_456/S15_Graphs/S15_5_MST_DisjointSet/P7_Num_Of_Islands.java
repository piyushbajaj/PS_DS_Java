package TakeUForward.CompleteCourse_456.S15_Graphs.S15_5_MST_DisjointSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_5_MST_DisjointSet
 * <p>
 * User: piyushbajaj
 * Date: 10/11/22
 * Time: 10:03 am
 */

class Disjoint_Set {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    /**
     * TC: O(4*alpha): O(1)
     *
     * @param n
     */
    public Disjoint_Set(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int ultParent = findUParent(parent.get(node));
        parent.set(node, ultParent);
        return parent.get(node);
    }

    public void unionBySize(int x, int y) {
        int ultParentX = findUParent(x);
        int ultParentY = findUParent(y);

        if (ultParentX == ultParentY) {
            return;
        }

        if (size.get(ultParentX) < size.get(ultParentY)) {
            parent.set(ultParentX, ultParentY);
            size.set(ultParentY, size.get(ultParentY) + size.get(ultParentX));
        } else {
            parent.set(ultParentY, ultParentX);
            size.set(ultParentX, size.get(ultParentX) + size.get(ultParentY));
        }
    }
}

public class P7_Num_Of_Islands {

    private boolean isValid(int adjRow, int adjCol, int n, int m) {
        return adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m;
    }

    /**
     * TC: O(m*n + l)
     * For T operations, the amortized time complexity of the union-find algorithm (using path compression with union by rank)
     * is O(alpha(T)). Here, α(T) is the inverse Ackermann function that grows so slowly, that it doesn't exceed 4
     * for all reasonable T (approximately T<10^600). You can read more about the complexity of union-find here.
     * Because the function grows so slowly, we consider it to be O(1).
     *
     * Initializing UnionFind takes O(m⋅n) time because we are initializing the parent and rank arrays of size m*n each.
     *
     * For each position in positions, we perform addLand which takes O(1) time.
     * Furthermore, we check all four neighbors of every position and if there is land at any neighbor, we perform union of position and the neighbor. Because there can only be four union operations at a time, each union operation would take O(4)=O(1) time.
     * It would take O(l) time for l positions.
     *
     * Obtaining the number of islands for each position and pushing it to answer takes O(1) per position.
     * For l positions, it would take O(l) time.
     *
     * As a result, the total time required is O(m*n+l).
     * <p>
     * SC: O(m*n)
     *
     * @param rowLen
     * @param colLen
     * @param operators
     * @return
     */
    public List<Integer> numIslands2(int rowLen, int colLen, int[][] operators) {
        Disjoint_Set disjointSet = new Disjoint_Set(rowLen * colLen);
        int[][] visited = new int[rowLen][colLen];
        int countIsland = 0;
        List<Integer> countIslandsAtEachPosition = new ArrayList<>();

        // Go through one by one operator and check and add
        for (int[] operator : operators) {
            int rowIndex = operator[0];
            int colIndex = operator[1];

            if (visited[rowIndex][colIndex] == 1) {
                countIslandsAtEachPosition.add(countIsland);
                continue;
            }
            visited[rowIndex][colIndex] = 1;
            countIsland++;
            // row - 1, col -> UP
            // row , col + 1 -> RIGHT
            // row + 1, col -> BOTTOM
            // row, col - 1 -> LEFT
            int[] deltaRow = {-1, 0, 1, 0};
            int[] deltaCol = {0, 1, 0, -1};
            for (int k = 0; k < 4; k++) {
                int adjRow = deltaRow[k] + rowIndex;
                int adjCol = deltaCol[k] + colIndex;
                if (isValid(adjRow, adjCol, rowLen, colLen)) {
                    if (visited[adjRow][adjCol] == 1) {
                        int currNodeNumber = rowIndex * colLen + colIndex;
                        int adjNodeNumber = adjRow * colLen + adjCol;
                        if (disjointSet.findUParent(currNodeNumber) != disjointSet.findUParent(adjNodeNumber)) {
                            countIsland--;
                            disjointSet.unionBySize(currNodeNumber, adjNodeNumber);
                        }
                    }
                }
            }
            countIslandsAtEachPosition.add(countIsland);
        }
        return countIslandsAtEachPosition;
    }

    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {
            {0, 0},
            {0, 0},
            {1, 1},
            {1, 0},
            {0, 1},
            {0, 3},
            {1, 3},
            {0, 4},
            {3, 2},
            {2, 2},
            {1, 2},
            {0, 2}
        };

        P7_Num_Of_Islands obj = new P7_Num_Of_Islands();
        List<Integer> ans = obj.numIslands2(n, m, operators);

        for (Integer an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();
    }
}
