//package TechBoost.DP_Prob;
//
///**
// * Created by piyush.bajaj on 24/04/18.
// */
//public class matrixMultiplication_prob {
//    public static void main(String[] args) {
//        int[][] mat = {{2, 3}, {3, 6}, {6, 4}, {4, 5}};
//        System.out.println(calculate(mat));
//    }
//
//    public static int calculate(int[][] mat){
//        int n = mat.length;
//        int[][] sol = new int[n][n];
//
//        int len = 1;
//
//        int j = 0;
//        while (len <= n){
//            j = len-1;
//            for(int i = 0; j-i < len; i++){
//                if(len == 1) {
//                    sol[i][j] = 0;
//                    j++;
//                }
//                else {
//                    sol[i][j] = mat[i][j-1]*mat[i][j]*mat[i+1][j];
//                    j++;
//                }
//
//            }
//            len++;
//        }
//
//
////        for(int i = 0; i < n; i++){
////            for(int j = 0; j <= i; j++){
////                if(i == j)
////                    sol[i][j] = 0;
////            }
////        }
//    }
//}
