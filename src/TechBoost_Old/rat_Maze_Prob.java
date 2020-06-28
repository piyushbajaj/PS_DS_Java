package TechBoost_Old;

/**
 * Created by piyush.bajaj on 31/03/18.
 */
public class rat_Maze_Prob {
    class Position{
        int row, col;

        Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }


//    public Position[] rat_Maze(int n){
//        Position[] positions = new Position[n];
//        int[][]
//        boolean isSolved = is_rat_Maze_solved(n, 0, positions);
//        if(isSolved)
//            return positions;
//        else
//            return new Position[0];
//    }

//    public boolean is_rat_Maze_solved(int n, int row, Position[] positions){
//        if(n==row) return true;
//
//        for(int col = 0; col < n; col++){
//            boolean foundSafe = true;
//            for(int j = 0; j < row; j++){
//                if(positions[j].){
//
//                }
//            }
//
//            if(foundSafe){
//                Po
//            }
//        }
//    }

    public void rat_Maze(int[][] mat){
        int[][] solution = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };
        if(is_rat_Maze_solved(solution.length, 0, 0, mat, solution)) {
            for (int i = 0; i < solution.length; i++) {
                for (int j = 0; j < solution[0].length; j++) {
                    System.out.print(solution[i][j] + " ");
                }
                System.out.println();
            }
        }
        else
            System.out.println("Rat cannot reach destination: ");
    }

    public boolean isValid(int[][] mat, int i, int j, int n){
        if(i >=0 && i < n && j >=0 && j <n && mat[i][j] != 0){
            return true;
        }
        else
            return false;
    }

    public boolean is_rat_Maze_solved(int n, int row, int col, int[][] mat, int[][] solution){
        if(row == n-1 && col == n-1) {
            solution[row][col] = 1;
            return true;
        }

        if(isValid(mat, row, col, n)){
            solution[row][col] = 1;
            int max = mat[row][col];

            for(int i = 1; i <= max && i < n; i++){
                //Move down
                if(is_rat_Maze_solved(n, row+i, col, mat, solution)){
                    return true;
                }

                if(is_rat_Maze_solved(n, row, col+i, mat, solution)){
                    return true;
                }
            }
            solution[row][col] = 0;
            return false;
        }

            return false;



    }

    /*
    Time Complexity: O(N^N)
    Space Complexity: O(N*N)
     */

    public static void main(String[] args) {
        rat_Maze_Prob rp = new rat_Maze_Prob();
        int[][] mat = { {2, 1, 0, 0},
                {3, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1} };

        rp.rat_Maze(mat);


    }

}
