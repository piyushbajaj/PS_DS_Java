package DynamicProgramming;

import java.util.HashSet;

/**
 * Created by piyush.bajaj on 30/07/17.
 *
 * Here we are keeping two loops:
 * 1. First Loop: We are checking from 1st character to character + 1 to string array, and if matches then we make it true.
 * 2. Then will check if str[i] = true, then we will enter into second loop, where we are checking from j = i+1 to n,
 * with string array, if it matches then will make it True, and see for other matches.
 * 3. Like this will go on, if it reaches end, and len-1 is true then will return true, or false.
 */
public class wordBreak {
    public static void main(String[] args) {
        String[] arr  = {"arrays", "dynamic", "heaps", "IDeserve", "learn", "learning", "linked", "list", "platform",
                "programming", "stacks", "trees"};

        String str = "IDeservelearningplatform";


        System.out.println(checkWordsMatch(arr, str));
    }

    public static boolean checkWordsMatch(String[] arr, String str){
        HashSet<String> strMap = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            strMap.add(arr[i]);
        }

        int len = str.length();
        boolean[] booleans = new boolean[len];

        for(int i = 0; i < len; i++){
            if(strMap.contains(str.substring(0, i + 1))) {
                booleans[i] = true;
            }
            if(i+1 == len && booleans[i] == true)
                return true;
            if(booleans[i] == true){
                for(int j = i+1; j < len; j++){
                    if(strMap.contains(str.substring(i+1, j+1)))
                        booleans[j] = true;
                    if(j+1 == len && booleans[j] == true)
                        return true;
                }
            }
        }
        return false;
    }
}
