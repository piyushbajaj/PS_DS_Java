package OnlineTest;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by piyush.bajaj on 11/07/17.
 */
public class longestChain_prob {

    static int longestChain(String[] words) {
        if(words.length <= 0 || words.length > 50000)
            return -1;

        int max = 1;

        HashMap<String, Integer> hashStore = new HashMap<String, Integer>();

        int n = 0;

        for(String str: words){
            if(str.length() <= 0 || str.length() > 60)
                return -1;

            char ch = ' ';
            if(str.length() == 1) {
                ch = str.charAt(0);
                if((int)ch < 97 || (int)ch > 122)
                    return -1;
                hashStore.put(str, 1);
            }
            else{
                n = str.length();
                String s = "";
                for(int i = 0; i < n; i++){
                    ch = str.charAt(i);
                    if((int)ch < 97 || (int)ch > 122)
                        return -1;
                    s = (str.substring(0, i).concat(str.substring(i+1, n)));
                    if(hashStore.containsKey(s)) {
                        hashStore.put(str, hashStore.get(s) + 1);
                        if((hashStore.get(s) + 1)> max)
                            max = (hashStore.get(s) + 1);
                        break;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        //String[] arr = {"a", "b", "ba", "bca", "bda", "bdca" };
        String[] arr = {"bdca", "bca", "bda", "ba",  "a", "b"  };
        System.out.println(longestChain(arr));

        //String str = arr[3].substring(-1, 0);

        //int ass = (int) 'a';
    }
}
