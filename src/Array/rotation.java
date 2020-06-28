package Array;

/**
 * Created by piyush.bajaj on 20/11/16.
 */
public class rotation {
    public static boolean isRotation(String str1, String str2){
        if(str1.length()==str2.length() && str1.length()>0){
            str1 = str1 + str1;
            return (isSubstring(str1, str2));
        }
        return false;
    }

    public static boolean isSubstring(String str1, String str2){
        return false;
    }
}
