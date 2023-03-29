package OnlineTest;

/**
 * Created by piyush.bajaj on 20/05/18.
 */
public class rangeBooking_Prob {
    public static void main(String[] args) {
        int[] A = {76, 22, 81, 77, 95, 23, 27, 35, 24, 38, 15, 90, 19, 46, 53, 6, 77, 96, 100, 85, 43,
            16, 73, 18, 7, 66};

        System.out.println("Answer is: " + numOptions(A, 98, 290));

    }

    public static int numOptions(int[] A, int B, int C) {
        int n = A.length;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] < 0 || A[i] > C) {
                continue;
            }
            sum = A[i];
//            System.out.print(A[i] + " ");
            for (int j = i + 1; j < n; j++) {
                if (A[j] < 0 || A[j] > C) {
                    break;
                }
                sum += A[j];
                if (sum >= B && sum <= C) {
                    count++;

                    System.out.println(A[i] + " " + A[j]);
                    //System.out.print(A[j] + " ");
                    //sum = 0;
                }


            }
            if (A[i] >= B && A[i] <= C) {
                count++;
            }
            //System.out.println();
        }
        return count;
    }
}
