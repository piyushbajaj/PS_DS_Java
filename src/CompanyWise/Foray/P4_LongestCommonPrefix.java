package CompanyWise.Foray;

/**
 * Created by bajajp on 28 Sep, 2022
 * <p>
 * Link: <a href="https://leetcode.com/problems/longest-common-prefix/discuss/1405155/Java-or-Detailed-solution-or-0-ms-or-Faster-than-100">...</a>
 */
public class P4_LongestCommonPrefix {

    /**
     * PLEASE UPVOTE IF IT HELPS YOU! THANK YOU!
     * Recommend to dry run along with the example.
     * <p>
     * Working:
     * 1)Take the first(index=0) string in the array as prefix.
     * 2)Iterate from second(index=1) string till the end.
     * 3)Use the indexOf() function to check if the prefix is there in the strs[i] or not.
     * If the prefix is there the function returns 0 else -1.
     * 4)Use the substring function to chop the last letter from prefix each time the function return -1.
     * <p>
     * eg:
     * strs=["flower", "flow", "flight"]
     * prefix=flower
     * index=1
     * while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flower")!=0)
     * Since flower as a whole is not in flow, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flowe"
     * Again while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flowe")!=0)
     * Since flowe as a whole is not in flow, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flow"
     * Again while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flow")!=0)
     * Since flow as a whole is in flow, it returns 0 so now prefix=flow
     * index=2
     * while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("flow")!=0)
     * Since flow as a whole is not in flight, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flo"
     * Again while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("flo")!=0)
     * Since flo as a whole is not in flight, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "fl"
     * Again while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("fl")!=0)
     * Since fl as a whole is in flight, it returns 0 so now prefix=fl
     * index=3, for loop terminates and we return prefix which is equal to fl
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            System.out.println(strs[i].indexOf(prefix));
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
    }
}
