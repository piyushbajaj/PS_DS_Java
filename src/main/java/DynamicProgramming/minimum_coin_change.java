package DynamicProgramming;

/**
 * Created by piyush.bajaj on 18/08/17.
 * Find minimum number of coins that make a given value
 Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm}
 valued coins, what is the minimum number of coins to make the change?

 Examples:

 Input: coins[] = {25, 10, 5}, V = 30
 Output: Minimum 2 coins required
 We can use one coin of 25 cents and one of 5 cents

 Input: coins[] = {9, 6, 5, 1}, V = 11
 Output: Minimum 2 coins required
 We can use one coin of 6 cents and 1 coin of 5 cents

 Algorithm:
 1. 'i' will vary from 0 to 13.
 2. Create two arrays: T[i]: For storing number of coins needed to make the sum.
    R[i]: For storing the immediate source of the coin came from.
 3. If i - coins[j] >= 0, then
    T[i] = min(T[i], 1+T[i-coins[j]])
 */
public class minimum_coin_change {
    public int min_coins(int[] coins, int sum){
        int n = coins.length;
        int[] T = new int[sum+1];
        int[] R = new int[sum+1];

        T[0] = 0;
        for(int i = 1; i < sum+1; i++)
            T[i] = Integer.MAX_VALUE;

        for(int i = 0; i < sum+1; i++)
            R[i] = -1;

        for(int j = 0; j < coins.length; j++) {
            for (int i = 1; i < sum + 1; i++) {
                if(i - coins[j] >= 0){
                    if(T[i - coins[j]] == Integer.MAX_VALUE)
                        T[i] = Math.min(T[i], Integer.MAX_VALUE);
                    else
                        T[i] = Math.min(T[i], 1 + T[i - coins[j]]);
                    if(T[i] > T[i - coins[j]])
                        R[i] = j;
                }
            }
        }
        //

        int[] result = new int[T[sum]];

        int j = 0;
        int i = sum;
        while (i > 0){
            if(R[i] >= 0){
                result[j] = coins[R[i]];
                j++;
                i = i - coins[R[i]];
            }
        }

        for(int k = 0; k < T[sum]; k++ )
            System.out.print(result[k] + " ");

        System.out.println();

        return T[sum];
    }

    public void coins_which_make_min_sum(int[] coins, int sum){
        int n = coins.length;
        int[] T = new int[sum+1];
        int[] R = new int[sum+1];

        T[0] = 0;
        for(int i = 1; i < sum+1; i++)
            T[i] = Integer.MAX_VALUE;

        for(int i = 0; i < sum+1; i++)
            R[i] = -1;

        for(int j = 0; j < coins.length; j++) {
            for (int i = 1; i < sum + 1; i++) {
                if(i - coins[j] >= 0){
                    if(T[i - coins[j]] == Integer.MAX_VALUE)
                        T[i] = Math.min(T[i], Integer.MAX_VALUE);
                    else
                        T[i] = Math.min(T[i], 1 + T[i - coins[j]]);
                    if(T[i] >= 0)
                        R[i] = j;
                }
            }
        }
        ///return T[sum];

        int[] result = new int[T[sum]];

        int j = 0;
        int i = sum;
        while (i > 0){
            if(R[i] >= 0){
               T[j] = coins[R[i]];
               j++;
                i = i - coins[R[i]];
            }
        }

        for(int k = 0; k < T[sum]; k++ )
            System.out.print(result[k] + " ");
    }

    public static void main(String[] args) {
        minimum_coin_change mc = new minimum_coin_change();
        int[] arr = {7, 2, 3, 6};
        int sum = 13;
        System.out.println(mc.min_coins(arr, sum));

        //mc.coins_which_make_min_sum(arr, sum);
    }

}
