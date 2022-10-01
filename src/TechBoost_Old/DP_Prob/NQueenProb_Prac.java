package TechBoost_Old.DP_Prob;

import java.util.Arrays;

/**
 * Created by piyush.bajaj on 31/03/18.
 */
public class NQueenProb_Prac {
    class Position{
        int row, col;

        Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public Position[] solve_N_Queen(int n){
        Position[] positions = new Position[n];
        boolean hasSolution = solve_N_Queen_util(n, 0, positions );
        if(hasSolution){
            return positions;
        }
        else
            return new Position[0];
    }

    public boolean solve_N_Queen_util(int n, int row, Position[] position){
        if(n == row) return true;

        for(int col = 0; col < n; col++){
            boolean foundSafe = true;
            for(int queen = 0; queen < row; queen++){
                if(position[queen].row == row ||position[queen].col ==col ||
                        position[queen].row - position[queen].col == row-col ||
                        position[queen].row + position[queen].col == row+col){
                    foundSafe = false;
                    break;
                }
            }
            if(foundSafe){
                position[row] = new Position(row, col);
                if(solve_N_Queen_util(n, row+1, position))
                    return true;
            }
        }

        return false;
    }


    /*
    Time Complexity: O(n^n)
    Space Complexity: O(n)
     */
    public static void main(String[] args) {
        NQueenProb_Prac np = new NQueenProb_Prac();
        Position[] positions = np.solve_N_Queen(6);
        Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
    }
}
