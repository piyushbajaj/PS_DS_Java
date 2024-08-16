package DynamicProgramming;

import java.util.HashSet;

/**
 * Created by piyush.bajaj on 12/08/17.
 */
public class sourceWord_to_Destination {
    public int trials(String[] arr, String source, String destination){
        HashSet<String> hashSet = new HashSet<>();
        int count = 0;
        for(int i = 0; i < arr.length; i++)
            hashSet.add(arr[i]);


        if(hashSet.contains(source) && hashSet.contains(destination)){
            if(source.length() == destination.length()){

            }
            return 0;
        }
        else
            return -1;
    }

    public static void main(String[] args) {
        sourceWord_to_Destination sd = new sourceWord_to_Destination();
        String[] strArr = {"BCCI","AICC","ICC","CCI","MCC","MCA", "ACC"};
        String source = "AICC";
        String destination = "ICC";
        sd.trials(strArr, source, destination);
    }
}
