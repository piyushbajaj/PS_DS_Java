package getSDEReady.String;

/**
 * Project: DSAlgo
 * Package: getSDEReady.String
 * <p>
 * User: piyushbajaj
 * Date: 17/05/26
 * Time: 12:19 pm
 */
public class test {
    public static int getArrLen(int[] arr) {
        int count = 0;

        for (int i: arr) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(getArrLen(arr));
    }
}
