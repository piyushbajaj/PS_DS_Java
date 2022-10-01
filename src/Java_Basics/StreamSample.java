package Java_Basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSample {

    public static int switchTest(int a) {
        switch (a) {
            case 1:
            case 2:
                return 20;
        }
        return -1;
    }



    public static void main(String[] args) {
//        System.out.println(switchTest(1));
//
//        List<Integer> number = Arrays.asList(2,3,4,5);
//
//        // demonstration of map method
//        List<Integer> square = number.stream().map(x -> x*x).
//            collect(Collectors.toList());
//        System.out.println(square);


        String s = "quick;brown";
        int from = s.indexOf(';');
        int to = s.indexOf(';', from+1);
//        String brown = s.substring(from+1, to);

        System.out.println("from: " + from + " to: " + to);
    }
}
