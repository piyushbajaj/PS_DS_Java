package DynamicProgramming;

/**
 * Created by piyush.bajaj on 23/01/17.
 *
 * LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}

 Longest Increasing Sub-sequence is a 3 step algorithm:
 1. if a[i] is the smallest among all the active elements, we will start new active list of length 1.
 2. if a[i] is the largest among all the active elements, we will clone and extend it by a[i].
 3. if a[i] is in between the elements, then will find a list with largest end element which is smaller than a[i].
    Clone and extend this list by a[i]. And also keep discarding the lists with same length.

 Algorithm:
 Create two arrays:
 1. T is going to store temporary intermediate results (stores the minimum index of final value of particular length) ,
 R is going to store Final results(means where the value is coming from, just previous node).
 2. Variable len, which will tell the length of subsequence till now.
 3. Initialize R array with -1, len = 0.
 4. First will put T[0] = 0;
 5. for(int i = 1; i <n; i++){
 6. if(arr[i] > arr[T[len]])
 {
 T[len] = i;
 R[T[len]] = T[len-1];
 len++;
 }
 else if(arr[i] < arr[T[0]]) {
 T[0] = i;
 }

 //Now it means that the value (for e.g. 2 here lies between the sorted array -1 to 8, so we need to find the ceilValue
 of arr[i] in this array arr[T[0]] to arr[T[len]])
else{
 int index = ceilIndex(input, T, len,input[i]);
 T[index] = i;
 R[T[index]] = T[index-1];
 }

 }

 1. Initialize temp array, int[] temp = new int[n]
 2. j = 1, temp[0] = arr[0];
 3. for(int i = 0; i < n; i++), temp[i] = -1;
 4. for(int i = 1; i < n; i++){
        if(arr[i] < temp[0])
            arr[i] = temp[0];// CASE 1
        else if(arr[i] > temp[j-1])
            temp[j++] = arr[i]; // CASE 2
        else{
        temp[ceilValue(temp, -1, j-1, arr[i])] = arr[i]; // CASE 3
        }
    }
 5. Create ceilValue function: ceilValue(int[] temp, int l, int r, int key){
    while(l-r >1){
        int m = l + (l-r)/2;
        if(temp[m] >= key)
            r =m;
        else
            l = m;
        }
 return r;
    }
 6. return j++;

 Time Complexity: O(n*log(n))
 */
public class LongestIncreasingSubsequence {

    //This takes time complexity: O(n*n)
    public void longestSub(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];

        for(int i =0; i < n; i++){
            temp[i] = 1;
        }

        int k = 1;
        for(int i =k; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i])
                    temp[i] = Math.max(temp[i], temp[j]+1);
                if(j==i)
                    break;
            }
        }

        System.out.println(temp[n-1]);
    }


    public int longestSub_improved(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        int j = 1;

        for(int i = 0; i < n; i++)
            temp[i] = -1;

        temp[0] = arr[0];
        for(int i = 1; i < n; i++){
           if(arr[i] < temp[0])
               arr[i] = temp[0];

           else if(arr[i] > temp[j-1])
                temp[j++] = arr[i];

            else {

               temp[ceilValue(temp, -1, j-1, arr[i])] = arr[i];

//               if (arr[i] > temp[j - 2] && arr[i] < temp[j - 1])
//                   temp[j - 1] = arr[i];
           }
        }
    return j++;
    }


    public int longestSubs_easy(int[] arr){
        int[] temp = new int[arr.length];

        int n = arr.length -1;
        for(int i = 0; i < n; i++)
            temp[i] = 1;

        int j = 0, i = 1;
        while (i <= n){
            if(arr[j] < arr[i] && j < i){
                temp[i] = Math.max(temp[i], temp[j]+1);
            }
            j++;
            if( j == i) {
                j = 0;
                i++;
            }
        }

        int max = -1;
        for(int k = 0; k < temp.length; k++){
            if(temp[k] > max)
                max = temp[k];
        }

        return max;

    }




    public int LIS_g4g_easiest(int[] arr){
        int n = arr.length;
        int[] lis = new int[n];

        for(int i = 0; i < n; i++)
            lis[i] = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if( arr[j] < arr[i]  && lis[i] < lis[j] + 1){
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = -1;
        for(int k = 0; k < lis.length; k++){
            if(lis[k] > max)
                max = lis[k];
        }

        return max;
    }

    public int longestSubs_tushar(int[] arr){
        int n = arr.length;

        //T is going to store temporary intermediate results (stores the minimum index of final value of particular length)
        int[] T = new int[n];

        //R is going to store Final results(means where the value is coming from, just previous node).
        int[] R = new int[n];

        for(int i = 0; i < n; i++ )
            R[i] = -1;

        int j = 0;
        T[0] = 0;
        int index = -1;

        for(int i = 1; i < n; i++){
            if(arr[T[j]] < arr[i]){
                j++;
                T[j] = i;
                R[T[j]] = T[j-1];

            }
            else if(arr[i] < arr[T[0]])
                T[0] = i;
            else {
                index = ceilValue_custom(T, arr, 0, T.length-1, arr[i]);
                T[index] = i;
                R[i] = T[index-1];
            }
        }

        return j;

    }

    public int ceilValue_custom(int[] T,int[] arr, int l, int h, int key){

        while(h - l > 1){
            int m = (l + h)/2;
            if(arr[T[m]] < key)
                l = m;
            else if(arr[T[m]] > key)
                h = m;
        }
        return h;
    }

    //Using the logic from Binary search
    public int ceilValue(int[] temp, int l, int r, int key){
        while (r-l>1) {
            int m = l + (r-l)/2;
            if(temp[m] >= key)
                r = m;
            else
                l = m;
        }
        return r;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence LI = new LongestIncreasingSubsequence();
        //int m = -1+ 1/2;

        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};

        int[] arr2 = {3, 4, -1, 0, 6, 2, 3};

        int[] arr1 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3,11, 7, 15};
                //{50, 3, 10, 7, 40, 80};

        //LI.longestSub(arr);
        //Output: Len= 4; 3, 10, 40, 80


       // System.out.println(LI.longestSub_improved(arr));

        //System.out.println(LI.longestSubs_easy(arr));

//        System.out.println(LI.longestSubs_tushar(arr));

        System.out.println(LI.LIS_g4g_easiest(arr));
    }
}
