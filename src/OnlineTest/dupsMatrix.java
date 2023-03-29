package OnlineTest;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 02/04/17.
 */
public class dupsMatrix {

    public static int findDups(int[][] data, int operation, int numOfDups) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        if (operation == 1) {
            int count = 0, realCount = 0;
            int flagCount = 0;
            int cols = data[0].length;
            int rows = data.length;
            //int

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (hash.containsKey(data[i][j])) {
                        hash.put(data[i][j], hash.get(data[i][j]) + 1);
                        count++;
                        if (count >= numOfDups) {
                            realCount++;
                        }
                    } else {
                        hash.put(data[i][j], 1);
                    }
                }
                if (realCount >= 1) {
                    flagCount++;
                }
                realCount = 0;
                count = 0;
                hash.clear();

            }
            return flagCount;

        } else if (operation == 2) {
            int count = 0;
            int cols = data[0].length;
            int rows = data.length;
            int realCount = 0;
            int flagCount = 1;

            for (int j = 0; j < cols; j++) {
                for (int i = 0; i < rows; i++) {
                    if (hash.containsKey(data[i][j])) {
                        hash.put(data[i][j], hash.get(data[i][j]) + 1);
                        count++;
                        if (count >= numOfDups) {
                            realCount++;
                        }
                    } else {
                        hash.put(data[i][j], 1);
                    }
                }
                if (realCount >= flagCount) {
                    flagCount += realCount;
                }
                realCount = 0;
                count = 0;
                hash.clear();

            }
            return flagCount;
        } else {
            return -1;
        }

        //return -1;
    }

    public static void main(String[] args) {
        dupsMatrix DM = new dupsMatrix();
//        int[][] mat = {{1, 3, 5, 9},
//                {1, 2, 1, 2},
//                {1, 4, 7, 9},
//                {1, 5, 9, 11},
//                {20, 25, 20, 35}};

        int[][] mat = {{1, 1, 2},
            {1, 1, 1},
            {1, 2, 1}};

        int ops = 2;
        int dups = 2;

        findDups(mat, ops, dups);
    }
}
