package LinkedList;

/**
 * Created by piyush.bajaj on 04/03/18.
 */
public class gameOfThrone_Prob {

    static String gameOfThrones(String s){
        // Complete this function
        int[] charArr = new int[26];
        char ch = ' ';
        //if(s.length % 2== 0){
        for(int i = 0; i < s.length(); i++){
            if(charArr[s.charAt(i)-97] > 0)
                charArr[s.charAt(i)-97]--;
            else
                charArr[s.charAt(i)-97]++;
        }
        //}
        int count = 0;
        if(s.length() % 2== 0){
            for(int i = 0; i < s.length(); i++){
                if(charArr[s.charAt(i)-97] > 0)
                    return "NO";
            }
        }
        else{
            for(int i = 0; i < s.length(); i++){
                if(charArr[s.charAt(i)-97] > 1)
                    return "NO";
                else if(charArr[s.charAt(i)-97] == 1){
                    if(ch == ' ') {
                        ch = s.charAt(i);
                        count++;
                    }
                    else if(ch == s.charAt(i))
                        continue;
                    else {
                        return "NO";
                    }

                }

            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        String s = "cdcdcdcdeeeef";
        String result = gameOfThrones(s);
        System.out.println(result);
    }
}
