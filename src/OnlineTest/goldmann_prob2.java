package OnlineTest;

/**
 * Created by piyush.bajaj on 25/03/18.
 */
public class goldmann_prob2 {
    static String collapseString(String input) {
        if (input == "") {
            return "";
        }

        int len = input.length();
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < len - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                stringBuilder.append(count);
                stringBuilder.append(input.charAt(i));
                count = 1;
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(input.charAt(len - 1));

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "GGGGGrrrrrrrrrrrrrrt";
        System.out.println(collapseString(str));
    }
}
