package AthenaHealth;

/**
 * Created by piyush.bajaj on 21/01/18.
 */
public class Prob1 {
    public static void main(String[] args) {
        String[] a = {"a", "jk", "abb", "mn", "abc"};
        String[] b = {"bb", "kj", "bbc", "op", "def"};

        int[] result = getMinimumDifference(a, b);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] getMinimumDifference(String[] a, String[] b) {
        int len_a = a.length;
        int len_b = b.length;

        int len_res = (len_a > len_b) ? len_a : len_b;
        int[] result = new int[len_res];


        for (int i = 0; i < len_a; i++) {
            int count = 0;
            int count_a = 0;
            if (a[i].length() != b[i].length()) {
                result[i] = -1;
            } else {
                int[] charArr = new int[26];
                for (int j = 0; j < a[i].length(); j++) {
                    charArr[Integer.valueOf(a[i].charAt(j)) - 97]++;
                    count_a++;
                    //count++;
                }

                for (int j = 0; j < b[i].length(); j++) {
                    charArr[Integer.valueOf(b[i].charAt(j)) - 97]--;
                    if (charArr[Integer.valueOf(b[i].charAt(j)) - 97] >= 0) {
                        count_a--;
                    }
                }

//                for(int k = 0; k < 26; k++){
////                    if(charArr[k] != 0){
////                        result[i] = count;
////                    }
//
//                    count+= charArr[k];
//
//
//
//                }

                result[i] = count_a;


            }


        }
        return result;


    }

}
