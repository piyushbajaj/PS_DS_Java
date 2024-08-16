package PracticeSessionMay2024.StriversA2ZSheet.Step2_SortingTechniques;

/**
 * Project: DSAlgo
 * Package: StriversA2ZSheet.Step2_SortingTechniques
 * <p>
 * User: piyushbajaj
 * Date: 23/05/24
 * Time: 4:14 pm
 */
public class Utils {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
