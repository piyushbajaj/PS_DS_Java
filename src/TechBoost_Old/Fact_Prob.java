package TechBoost_Old;

/**
 * Created by piyush.bajaj on 10/03/18.
 */
public class Fact_Prob {
    static int fact(int n){
        if(n == 0 || n == 1)
            return 1;

        return n*fact(n-1);

        /*
        Time Complexity = O(N)
        Space Complexity = O(N)
         */
    }

    static int fact_iterative(int n){
        if(n == 0 || n == 1)
            return 1;

        int temp = 1;
        for(int i = 2; i <= n; i++){
             temp = i*temp;
        }

        return temp;
    }

    public static void main(String[] args) {
        System.out.println(fact(5));

        System.out.println(fact_iterative(5));
    }
}
