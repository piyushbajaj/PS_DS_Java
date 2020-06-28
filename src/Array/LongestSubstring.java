package Array;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 09/02/17.
 */
public class LongestSubstring {

    public String longestSubstringWithoutRepeating(char[] arr){
        int n = arr.length;
        int count =0;
        int max = 0;

        HashMap<Character, Boolean> hash = new HashMap<>();

//arr[i] != arr[i+1] &&
        for(int i = 0; i < n; i++){
            if(!hash.containsKey(arr[i])) {
                hash.put(arr[i], true);
                count++;
            }
            else if(count > max) {
                max = count;
                count = 0;
                hash.clear();
                hash.put(arr[i], true);
                count++;
            }
            else {
                count = 0;
                hash.clear();
            }
        }
        if(count > max) {
            max = count;
        }

        char[] temp = new char[max];
        int j = 0;
        count =0;

        int tot = 0;

        hash.clear();
        for(int i = 0; i < n; i++){
            if(!hash.containsKey(arr[i]) && count!=max) {
                temp[j++] = arr[i];
                hash.put(arr[i], true);
                count++;
            }
            else if(count == max)
                break;
            else if(count > tot) {
                tot = count;
                count = 0;
                j = 0;
                hash.clear();
                temp = new char[max];
            }
        }

        System.out.println("Longest Substring Without Repeatition is: " + max);

        return String.valueOf(temp);

    }

    public void longestSubstringWithoutRepeating_iterative(char[] arr){
        int[] count = new int[256];
        int start =0;
        int end = 0;
        int len = 0;
        int max = 0;
        int diff = 0;

        for(int i = 0; i < arr.length; i++){
            ++count[arr[i]];
            //++len;
            end = i;
            diff = end - start;
            if(count[arr[i]] > 1){
                start = i;
                //len = 0;

            }
            if(diff > max)
                max = diff;

        }
        System.out.println("Longest Substring Without Repetition is: " + max);

    }

    public static void main(String[] args) {
        LongestSubstring LS = new LongestSubstring();
        String str = "GEEEKSFORGEEKS";

        //System.out.println(LS.longestSubstringWithoutRepeating(str.toCharArray()));
        LS.longestSubstringWithoutRepeating_iterative(str.toCharArray());
    }
}
