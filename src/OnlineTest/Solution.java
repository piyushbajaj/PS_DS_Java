package OnlineTest;

/**
 * Created by piyush.bajaj on 19/03/17.
 */
public class Solution {
    public int solution(int[] A) {
        int n = A.length;
        int sum = 0, i =0, j = 0;
        if(n < 0 || n > 100000)
            return -1;

//        for(i = 0; i < n; i++){
//            for(j = i+2; j < n; j++){
//                sum += A[j];
//                //A[i] =
//            }
//            if(A[i] == sum)
//                return i+1;
//        }

        for(i = 0; i < n; i++){
            for(j = i+2; j < n; j++){
                sum += A[j];
                //A[i] =
            }
            if(A[i] == sum)
                return i+1;
        }

        return -1;
        // write your code in Java SE 8
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s="Sachin";
        s.concat(" Tendulkar");//concat() method appends the string at the end
        System.out.println(s);

//        System.out.println("Enter the maximum number of integers");
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//
//
//        System.out.println("Enter the integers one by one: ");
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = s.nextInt();
//        }

        int arr[] = {-1, 3, -4, 5, 1, -6, 2, 1};

        System.out.println(sol.solution(arr));



    }
}
