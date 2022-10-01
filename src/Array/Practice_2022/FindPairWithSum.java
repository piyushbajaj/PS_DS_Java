package Array.Practice_2022;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*
https://www.techiedelight.com/find-pair-with-given-sum-array/
 */
public class FindPairWithSum {

    private static final String SEGMENT_ID = "673593702, 123456, 123";

    // TC: O(N)
    // SC: O(N)
    public static void findPair(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(target - num)) {
                System.out.printf("Pair found (%d, %d)", target - num, num);
                return;
            }
            hashMap.put(num, target - num);
        }
        System.out.println("Pair not found");
    }

    public static void cal() {
        final List<Long> longs = Arrays
                .stream(SEGMENT_ID.split(","))
                .map(String::trim)
                .map(Long::parseLong)
                .collect(Collectors.toList());

        System.out.println(longs);
        LocalDate todaydate = LocalDate.now();
        System.out.println("Months first date in yyyy-mm-dd: " + todaydate.withDayOfMonth(1));

    }

    public static void main(String[] args) {
        int[] nums = {8, 7, 2, 5, 3, 1};
        int target = 10;

//        findPair(nums, target);
        cal();


    }
}
