package OnlineTest;

/**
 * Created by piyush.bajaj on 15/07/17.
 */
public class robot {
    static int path=0;
    static int n = 3, m = 3;
    public static void main(String[] args) {

        boolean mat [][]= new boolean[n][m];

        mat[0][0]= true;
        start(0, 1, mat);
        System.out.println(path);
    }

    private static void start(int x, int y,boolean [][]mat){
        mat[x][y]=true;
        moveUp(x,y,mat);
        moveDown(x,y,mat);
        moveLeft(x,y,mat);
        moveRight(x,y,mat);
    }

    private static void moveUp(int x, int y, boolean [][] mat){
        if(y==0) return;
        else{
            if (mat[x][y-1]) return;
            mat[x][y-1]=true;
            start(x,y-1,mat);
            mat[x][y-1]=false;
        }
    }
    private static void moveLeft(int x, int y, boolean [][] mat){
        if(x==0) return;
        else{
            if (mat[x-1][y]) return;
            mat[x-1][y]=true;
            start(x-1,y,mat);
            mat[x-1][y]=false;
        }
    }
    private static void moveDown(int x, int y, boolean [][] mat){
        if(x==n-1 && y==m-1){
            path++;
            mat[x][y]=true;
            return;
        }
        else if(y==m-1) return;
        else{
            if (mat[x][y+1]) return;
            mat[x][y+1]=true;
            start(x,y+1,mat);
            mat[x][y+1]=false;
        }
    }


    private static void moveRight(int x, int y, boolean [][] mat){
        if(x==n-1 && y==m-1){
            path++;
            mat[x][y]=true;
            return;
        }else if(x==n-1) return;
        else{
            if (mat[x+1][y]) return;
            mat[x+1][y]=true;
            start(x+1,y,mat);
            mat[x+1][y]=false;
        }
    }
}
