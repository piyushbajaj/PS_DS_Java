package OnlineTest;

/**
 * Created by piyush.bajaj on 21/03/17.
 */
public class Grab_Test {

    public int solution(int[] A) {


        int len = A.length;

        int sum = 0;
        for (int i = 1; i < len; i++){
            //int first = 0, second = 0, third = 0;
            for(int j = i+2; j < len; j++){
                int first = 0, second = 0, third = 0;
                for(int k = 0; k <= i-1; k++){
                    first+= A[k];
                }
                for(int k = i+1; k <= j-1; k++){
                    second+= A[k];
                }
                for(int k = j+1; k <= len-1; k++){
                    third+= A[k];
                }

                if(first == second){
                    if(first == third)
                        return 1;
                }
            }
        }

        return -1;


    }


    public static void main(String[] args) {
        Grab_Test GT = new Grab_Test();

//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//
//        if(n < 5 || n > 100000) {
//            System.out.println("Invalid Range");
//            return;
//        }

//        int[] arr = new int[n];
//
//        for(int i = 5; i < n; i++){
//            arr[i] = s.nextInt();
//            if(arr[i] < 1 && arr[i] > 10000){
//                System.out.println("Invalid Input");
//                break;
//            }
//        }

        int[] arr= {4, 5, 1, 1, 1, 1, 4, 3, 1};

        System.out.println(GT.solution(arr));




    }
}
