package Sorting;

/**
 * Created by piyush.bajaj on 15/01/17.
 * Here i suppose the number of candidates are less than the number of people who are voting
 */
public class whoWins {
    public static void main(String[] args) {
        whoWins WS = new whoWins();
        int[] arr = {10, 11, 14, 9, 10, 10, 11, 14, 9};
        WS.whoWins(arr, arr.length);
    }

    //returns max Index
    public int getMax(int[] arr, int n) {
        int i = 0;
        int max = arr[i];
        for (i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public void whoWins(int[] arr, int n) {
        int[] vote = new int[1000];

        for (int i = 0; i < n; i++) {
            vote[arr[i]]++;
        }

        int max = getMax(vote, vote.length);
        int i;
        for (i = 0; i < vote.length; i++) {
            if (vote[i] == max) {
                break;
            }
        }

        System.out.println("The candidate who won the election is: " + i);
    }
}
