package CrackingCoding.Array.Jan_2018;

/**
 * Created by piyush.bajaj on 25/01/18.
 */
public class compressed_prob {
    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(compress(str));
    }

    public static String compress(String str) {
        int n = str.length();

        int count = 1, max = 1;

        for (int i = 1; i < n; i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 1;
            }
        }
        if (max <= 2) {
            return str;
        }


        boolean flag = false;
        StringBuilder sb = new StringBuilder();

//        for(int i = 1; i < n; i++){
//            if(str.charAt(i) == str.charAt(i-1)) {
//                count++;
//                if(!flag )
//                {
//                    sb.append(str.charAt(i));
//                    sb.append(count);
//                    flag = true;
//                }
//            }
//            else {
//                count = 0;
//            }
//        }

        count = 1;
        for (int i = 1; i < n; i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                sb.append(str.charAt(i - 1));
                sb.append(count);
                count = 1;
            }
        }

        sb.append(str.charAt(n - 1));
        sb.append(count);

        return sb.toString();

    }
}
