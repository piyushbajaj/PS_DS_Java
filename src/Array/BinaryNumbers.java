package Array;

/**
 * Created by piyush.bajaj on 20/03/17.
 */
public class BinaryNumbers {
    public void convertDecToBinary(int val){
        System.out.println(Integer.toBinaryString(val));

        String str = String.valueOf(Integer.toBinaryString(val));

        int n = str.length();

        int count = 1, max = 0;

//        if(str.contains("1"))
//            count=1;
        for(int i = 0; i <n-1; i++){
            if((str.charAt(i) == str.charAt(i+1)) || (str.charAt(i) == 1))
                count++;
            else {
                count=1;
            }
            if(max< count){
                max = count;
            }

        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        BinaryNumbers BN = new BinaryNumbers();
        int dec = 439;
        BN.convertDecToBinary(dec);
    }
}
