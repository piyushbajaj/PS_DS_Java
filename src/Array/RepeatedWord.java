package Array;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 16/03/17.
 */
public class RepeatedWord {
    static String firstRepeatedWord(String s) {
        int n = s.length();
        int count= 1;
        //s = Str

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == ' ' || s.charAt(i) == '\t' || s.charAt(i) == ',' || s.charAt(i) == ':' ||
                    s.charAt(i) == ';' || s.charAt(i) == '-' || s.charAt(i) == '.'){
                count++;
            }
        }
        String[] str = new String[count + 1];
        int j = 0;
        int start = 0;
        for(int i = 0; i < n && j <= count; i++){
            if(s.charAt(i) == ' ' || s.charAt(i) == '\t' || s.charAt(i) == ',' || s.charAt(i) == ':' ||
                    s.charAt(i) == ';' || s.charAt(i) == '-' || s.charAt(i) == '.'){
                str[j++] = s.substring(start, i);
                start = i+1;
            }

            if(i == n-1){
                str[j] = s.substring(start, i+1);
            }

        }

        HashMap<String, Boolean> hash = new HashMap<String, Boolean>();
        for(int i = 0; i < count; i++){
            if(hash.containsKey(str[i])){
                return str[i];
            }
            else{
                hash.put(str[i], true);
            }
        }
        return "No match";

    }

    public static void main(String[] args) {
        String str = "he had had quite enough of nonsense";
        System.out.println(firstRepeatedWord(str));


    }


    /*
    Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        long _k;
        _k = Long.parseLong(in.nextLine().trim());

        res = maxMoney(_n, _k);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
     */
}
