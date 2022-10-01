package javatpoint.Office;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class testHash {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("asd", "efg", "abc");
        List<String> list2 = Arrays.asList("sds", "zxz", "sdsd");
//        HashSet<String>set = new HashSet<>(list);
//        if(set.containsAll(Arrays.asList("asd", "efg", "xyz"))) {
//            System.out.println("true");
//        }

        System.out.println(LocalDateTime.now());

        System.out.println(!Collections.disjoint(list1, list2));


        String test = "bajajp@MIDWAY.AMAZON.COM";
        test = test.replaceFirst("@MIDWAY.AMAZON.COM$", "");
        System.out.println(test);


//        iamUser = iamUser.replaceFirst("(.*)@MIDWAY.AMAZON.COM(.*)", "");

//        if (Stream.of("val1", "val2", "val3").anyMatch(list::equalsIgnoreCase)) {
//            // ...
//        }
    }
}
