package Array.ideserve;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 13/05/17.
 */
public class elementAppearOnce {

    public static void elementAppearOne(int[] arr){
        ArrayList<String> al = new ArrayList<>();
        int num = 0;
        for(int i= 0; i < arr.length; i++ ){
            al.add(Integer.toBinaryString(arr[i]));
            num += Integer.parseInt(Integer.toBinaryString(arr[i]));
        }

        String str = Integer.toString(num);
        String newStr = "";
        for(int i = 0 ; i < str.length(); i++){
            if((int)str.charAt(i)%3==0){
                newStr += "0";
            }
            else newStr += str.charAt(i)%3;
        }

        System.out.println(Integer.parseInt(newStr, 2));

    }

    public static void main(String[] args) {
        int[] arr = { 5, 5, 4, 8, 4, 5, 8, 9, 4, 8};
        elementAppearOne(arr);
    }
}
