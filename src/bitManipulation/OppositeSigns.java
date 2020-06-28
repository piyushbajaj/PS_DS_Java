package bitManipulation;

/**
 * Created by piyush.bajaj on 23/05/17.
 */
public class OppositeSigns {

    public boolean checkSign(int a, int b){
        if(a * b < 0)
            return true;
        else
            return false;
    }


    //Signed bit for newgative number is 1 and for positive is 0
    public boolean checkSign_improve(int a, int b){
        return (a^b) < 0;
    }

    public static void main(String[] args) {
        OppositeSigns OS = new OppositeSigns();
        System.out.println(OS.checkSign_improve(-10, -12));
    }
}
