package Office.Vigoursoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Project: DSAlgo
 * Package: Office.Vigoursoft
 * <p>
 * User: piyushbajaj
 * Date: 20/03/24
 * Time: 12:24 pm
 */
public class test {

    public static void main(String[] args) {
        List<Integer> bigList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<List<Integer>> smallerLists = Lists.partition(bigList, 2);
        smallerLists.forEach(System.out::println);
    }
}
