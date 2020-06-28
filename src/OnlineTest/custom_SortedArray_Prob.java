package OnlineTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by piyush.bajaj on 12/06/18.
 */
public class custom_SortedArray_Prob {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        calculate(arr);
    }

    public static void calculate(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            if(arr[i]%2 != 0){

            }
        }

        int start = 0, end = n-1;
        int indexStart = -1, indexEnd = -1;
        int count = 0;
        while (start < end){
            if(arr[start]%2!=0){
                indexStart = start;
                start++;
            }
            else if(arr[start]%2==0)
                start++;

            if(arr[end]%2==0){
                indexEnd = end;
                end--;
            }
            else if(arr[end]%2!=0)
                end--;

            if(indexStart!= -1 && indexEnd!=-1){
                swap(arr, indexStart, indexEnd);
                count++;
                indexStart = -1;
                indexEnd = -1;
            }
        }

        System.out.println(count);

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
