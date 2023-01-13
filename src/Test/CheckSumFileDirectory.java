package Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_2_2D_3D_Grids
 * <p>
 * User: piyushbajaj
 * Date: 09/01/23
 * Time: 12:54 pm
 */
public class CheckSumFileDirectory {
    public void foo(List<File> fileList) {
        // Key: CheckSum String
        // Value: Name of the file
        HashMap<String, String> hashMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (File file : fileList) {
            String checkSumStr = checkSum(file);
            synchronized (this) {
                if (hashMap.containsKey(checkSumStr)) {
                    result.add(file.getName());
                } else {
                    hashMap.put(checkSumStr, file.getName());
                }
            }
        }
    }

    public String checkSum(File file) {
        return "abc";
    }

    public static void main(String[] args) {

    }
}
