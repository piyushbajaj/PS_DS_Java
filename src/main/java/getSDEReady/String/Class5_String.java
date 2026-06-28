package getSDEReady.String;

/**
 * Project: DSAlgo
 * Package: getSDEReady.String
 * <p>
 * User: piyushbajaj
 * Date: 17/05/26
 * Time: 12:25 pm
 */
public class Class5_String {

    /**
     * 1. Reverse the array
     * 2. Concat 2 char arrays
     * 3. Remove the last element
     * 4. Add element in the last
     * 5. Find the length of the array
     *
     * @param args
     */

    public char[] reverseArray(char[] arr) {
        int start = 0;
        int end = getArrLen(arr) - 1;

        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }

        return arr;
    }

    public char[] concat(char[] arr1, char[] arr2) {
        int len1 = getArrLen(arr1);
        int len2 = getArrLen(arr2);

        char[] array = new char[len1 + len2];

        int index = 0;
        int i = 0;
        while (i < len1) {
            array[index] = arr1[i];
            index++;
            i++;
        }

        int j = 0;
        while (j < len2) {
            array[index] = arr2[j];
            index++;
            j++;
        }

        return array;
    }

    public char[] removeLastElement(char[] arr) {
        int len = getArrLen(arr);
        char[] arr1 = new char[len - 1];
        for (int i = 0; i < len - 1; i++) {
            arr1[i] = arr[i];
        }

        return arr1;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int getArrLen(char[] arr) {
        int count = 0;

        for (int val : arr) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Class5_String class5String = new Class5_String();

        char[] arr = {'a', 'b', 'c'};
        char[] arr1 = {'a', 'b', 'c'};
        System.out.println(class5String.getArrLen(arr));
        System.out.println(class5String.reverseArray(arr));
        System.out.println(class5String.concat(arr, arr1));
    }
}
