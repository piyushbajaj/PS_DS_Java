package Stack;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 19/09/16.
 */
public class StockSpan {
    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        System.out.println("Original Array according to stocks: ");
        displayarray(price);
        System.out.println("Sorted Array according to stocks: ");
        displayarray(calculateSpan(price));
        System.out.println("Sorted Array according to stocks using Stacks: ");
        displayarray(calculateSpanStack(price));
    }

    public static void displayarray(int a[]){
        for(int i =0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    //This takes O(n^2) time
    public static int[] calculateSpan(int[] prc){
        int size = prc.length;
        int s[] = new int[size];
        //s[0] = 1;


        for(int i =0; i < size; i++){
            int count = 1;
            for(int j = i-1; j >= 0; j--){
                if(prc[j] <= prc[i])
                    count++;
                else
                    break;
            }
            s[i] = count;
        }
        return s;

    }

    //This takes O(n) time using Stack
    public static int[] calculateSpanStack(int[] prc){
        int size = prc.length;
        int S[] = new int[size];

        Stack<Integer> st = new Stack<>();

        //Intialize array & stack
        S[0] = 1;
        st.push(0);

        for(int i =1; i < size; i++){
            while(!st.isEmpty() && prc[st.peek()] <= prc[i])
                st.pop();

            if(st.isEmpty())
                S[i] = i+1; // This means every element on the left is smaller than the prc[i]
            else
                S[i] = i - st.peek();

            st.push(i);
        }
        return S;
    }
}
