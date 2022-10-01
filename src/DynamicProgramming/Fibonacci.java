package DynamicProgramming;


/**
 * Created by piyush.bajaj on 30/07/17.
 */
public class Fibonacci {
    //Time Complexity is 2^n
    public int fib(int key){
        if(key == 0)
            return 0;
        else if(key == 1)
            return 1;
        else return fib(key-1) + fib(key-2);
    }


    //Saving memory now
    public int fib_better(int[] arr, int key){
        if(arr[key] == -1){
            if(key == 0)
                return 0;
            else if(key == 1)
                return 1;
            else {
                arr[key] = fib(key-1) + fib(key-2);
                return arr[key];
            }
        }
        else return arr[key];
    }

    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();
        int key = 5;


        int[] arr = new int[1000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = -1;
        }

        System.out.println(fb.fib(key));

        System.out.println("Using less memory " + fb.fib_better(arr, key));


    }
}
