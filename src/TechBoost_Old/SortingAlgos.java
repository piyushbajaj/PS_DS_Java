package TechBoost_Old;

/**
 * Created by piyush.bajaj on 22/03/18.
 */
public class SortingAlgos {

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public void selection_Sort(int[] arr){
        int len = arr.length;

        int min = 0;

        for(int i = 0; i < len; i++){
            min = i;
            for(int j = i+1; j < len; j++){
                if(arr[j] < arr[min])
                    min = j;
            }
            swap(arr, i, min);
        }
    }

    public void insertion_sort(int[] arr){
        int len = arr.length;

        for(int i = 1; i < len; i++){
            int V = arr[i];
            int j = i-1;

            while ( j >= 0 && arr[j] > V ){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = V;
        }
    }

    public void bubble_sort(int[] arr){
        int len = arr.length;

        for(int i = len-1 ; i >=0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }

    public void merge_sort(int[] arr, int start, int end){
        if(start < end)
        {
            int mid = (start + end)/2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid + 1, end);
            merge_sort_helper(arr, start, mid, end);
        }

    }

    public void merge_sort_helper(int[] arr, int start, int mid, int end){
        int N1 = mid - start + 1;
        int N2 = end - mid;

        int[] L = new int[N1];
        int[] R = new int[N2];

        for(int i = 0; i < N1; i++){
            L[i] = arr[start + i];
        }

        for(int j = 0; j < N2; j++){
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = start;
        while (i < N1 && j < N2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                k++;
                i++;
            }
            else {
                arr[k] = R [j];
                k++;
                j++;
            }
        }

        while (i < N1){
            arr[k] = L[i];
            k++;
            i++;
        }


        while (j < N2){
            arr[k] = R[j];
            k++;
            j++;
        }


    }

    public void quick_sort(int[] arr, int start, int end){
        if(start < end){
            int pivotIndex = partition(arr, start, end);

            quick_sort(arr, start, pivotIndex - 1);

            quick_sort(arr, pivotIndex + 1, end);
        }
    }

    public int partition(int[] arr , int start, int end){
        int pivot = arr[end];
        int i = start -1;

        for(int j = start; j < end; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, end);
        return i+1;
    }

    public void counting_Sort(int[] arr){
        int[] count = new int[10];
        int len = arr.length;
        int[] output = new int[len];

        for(int i = 0; i < len; i++){
            count[arr[i]]++;
        }

        for(int i = 1 ; i < 10; i++){
            count[i] += count[i-1];
        }

        for(int i = 0; i < len; i++ ){
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for(int i = 0; i < len; i++ ){
            arr[i] = output[i];
        }

    }


    public void radixSort(int[] arr){
        int len = arr.length;

        int max = 0;
        for(int i = 0; i < len; i++){
            if(arr[i] > max)
                max = arr[i];
        }

        for(int exp = 1; max/exp > 0; exp*=10){
            counting_Sort_radix(arr, exp, len);
        }
    }

    public void counting_Sort_radix(int[] arr, int exp, int n){
        int[] count = new int[10];
        int[] output = new int[n];

        for(int i = 0; i < n; i++ ){
            count[(arr[i]/exp)%10]++;
        }

        for(int i = 1; i < 10; i++ ){
            count[i] += count[i-1];
        }

        for(int i = 0; i < n; i++){
            output[count[(arr[i]/exp)%10] - 1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for(int i = 0; i < n; i++ ){
            arr[i] = output[i];
        }

    }


    public static void main(String[] args) {
        SortingAlgos sortingAlgos = new SortingAlgos();
        int[] A = {6, 4, 2, 1, 3, 5};
        sortingAlgos.selection_Sort(A);
        System.out.print("Selection Sort: ");
        sortingAlgos.printArray(A);

        int[] A1 = {6, 4, 2, 1, 3, 5};
        System.out.println();
        sortingAlgos.insertion_sort(A1);
        System.out.print("Insertion Sort: ");
        sortingAlgos.printArray(A1);

        int[] A2 = {6, 4, 2, 1, 3, 5};
        System.out.println();
        sortingAlgos.bubble_sort(A2);
        System.out.print("Bubble Sort: ");
        sortingAlgos.printArray(A2);

        int[] A3 = {8, 2, 4, 1, 3, 5, 6, 9};
        System.out.println();
        sortingAlgos.merge_sort(A3, 0, A3.length-1);
        System.out.print("Merge Sort: ");
        sortingAlgos.printArray(A3);

        int[] A4 = {8, 2, 4, 1, 3, 5, 6, 9};
        System.out.println();
        sortingAlgos.quick_sort(A4, 0, A4.length-1);
        System.out.print("Quick Sort: ");
        sortingAlgos.printArray(A4);


        int[] A5 = {8, 2, 4, 1, 3, 5, 6, 9};
        System.out.println();
        sortingAlgos.counting_Sort(A5);
        System.out.print("Counting Sort: ");
        sortingAlgos.printArray(A5);

        int[] A6 = {8, 2, 4, 1, 3, 5, 6, 9};
        System.out.println();
        sortingAlgos.radixSort(A6);
        System.out.print("Radix Sort: ");
        sortingAlgos.printArray(A6);
    }
}
