package Array;

/**
 * Created by piyush.bajaj on 16/02/17.
 * This is following PreOrder Traversal
 */
public class combination {
    public void combinationString(String str){
        combinationOne("", str);
    }

    public void combinationOne(String prefix, String str){
        if(str.length() > 0){
            System.out.println(prefix + str.charAt(0));
            combinationOne(prefix + str.charAt(0), str.substring(1));
            combinationOne(prefix, str.substring(1));
        }


    }

    public static void main(String[] args) {
        combination com = new combination();
        //com.combinationString("piy");

        com.combination_prac("", "piy");
        //String str = "piyush";
        //String a = str.substring(1);
    }

    public void combination_prac(String prefix, String str){
        if(str.length() > 0){
            System.out.print(prefix + str.charAt(0) + ", ");
            combination_prac(prefix + str.charAt(0), str.substring(1));
            combination_prac(prefix, str.substring(1));
        }
    }
}
