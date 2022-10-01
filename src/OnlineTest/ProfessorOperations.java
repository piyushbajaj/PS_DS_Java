package OnlineTest;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 26/03/17.
 */
public class ProfessorOperations {

    public int[] swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        return a;
    }

    public int[] work(int[] arr, int opVal){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == opVal){
                arr = swap(arr, i, n-1-i);
                break;
            }
        }
        return arr;
    }

    public void printlist(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        ProfessorOperations PO = new ProfessorOperations();

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        if(N <1 || N > 100000){
            return;
        }

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = s.nextInt();
            if(arr[i] <1 || arr[i] > N){
                return;
            }
        }

        int op = s.nextInt();

        if(op <1 || op > 100000){
           return;
        }

        //int[] arr = {1, 2, 3, 4, 5};

        for(int i = 0; i < op; i++){
            arr = PO.work(arr, s.nextInt());
            arr = PO.work(arr, s.nextInt());
        }


        PO.printlist(arr);

    }
}
