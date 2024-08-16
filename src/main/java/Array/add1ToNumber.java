package Array;

/**
 * Created by piyush.bajaj on 12/05/17.
 */
public class add1ToNumber {
    public static void main(String[] args) {
        add1ToNumber an = new add1ToNumber();

        String myName = "domanokz";
        String newName = myName.substring(0, 4) + 'x' + myName.substring(5);

        System.out.print(an.addNumber(4));
    }

    public int addNumber(int val) {
        String bin = Integer.toBinaryString(val);
        int len = bin.length();
        int count = 0;
        String str = " ";

        //Integer.Mi
        int i = 0;
        for (i = len - 1; i >= 0; i--) {
            if (bin.charAt(i) == '0') {

                str = bin.substring(0, i) + '1';
                //+ bin.substring(i+1);
                //bin.replace(bin.charAt(i), '1');

                break;
            } else {
                count++;
            }
            if (count == len) {
                str = "1";
            }

        }

        for (int j = i + 1; j < len; j++) {
            if (count == 0) {
                break;
            } else {
                str += '0';
                count--;
            }
        }
        return Integer.parseInt(str, 2);
    }
}
