package OnlineTest;

/**
 * Created by piyush.bajaj on 15/07/17.
 */
public class moveRobot {
    static int numPaths = 0;
    static int n = 2, m = 2;

    public static void main(String[] args) {

        int field[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j] = 0;
            }
        }
        field[0][0] = 1;
        moveRobot(0, 0, field);
        System.out.println(numPaths);
    }

    public static void moveRobot(int row, int column, int[][] field) {
        moveRobotUp(row, column, field);
        moveRobotDown(row, column, field);
        moveRobotLeft(row, column, field);
        moveRobotRight(row, column, field);
    }

    public static void moveRobotUp(int row, int column, int[][] field) {
        if (row == 0) {
            return;
        } else {
            if (field[row - 1][column] == 1) {
                return;
            }
            field[row - 1][column] = 1;
            moveRobot(row - 1, column, field);
            field[row - 1][column] = 0;
        }
    }

    public static void moveRobotDown(int row, int column, int[][] field) {
        if (row == n - 1 && column == m - 1) {
            numPaths++;
            return;
        } else if (row == n - 1) {
            return;
        } else {
            if (field[row + 1][column] == 1) {
                return;
            }
            field[row + 1][column] = 1;
            moveRobot(row + 1, column, field);
            field[row + 1][column] = 0;
        }
    }

    public static void moveRobotLeft(int row, int column, int[][] field) {
        if (column == 0) {
            return;
        } else {
            if (field[row][column - 1] == 1) {
                return;
            }
            field[row][column - 1] = 1;
            moveRobot(row, column - 1, field);
            field[row][column - 1] = 0;
        }
    }

    public static void moveRobotRight(int row, int column, int[][] field) {
        if (column == m - 1 && row == n - 1) {
            numPaths++;
            return;
        } else if (column == m - 1) {
            return;
        } else {
            if (field[row][column + 1] == 1) {
                return;
            }
            field[row][column + 1] = 1;
            moveRobot(row, column + 1, field);
            field[row][column + 1] = 0;
        }
    }
}
