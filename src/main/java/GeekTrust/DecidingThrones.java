package GeekTrust;

import java.util.HashSet;
import java.util.Map;

/**
 * Created by piyush.bajaj on 11/04/18.
 */
public class DecidingThrones implements DeciderThrones {

    public static final int min_allies = 3;
    public static final int uniq_char_size = 26;
    HashSet<String> allies = new HashSet<>();

    @Override
    public void whoIsRuler() {
        if (allies.size() >= min_allies) {
            System.out.println("King Shan");
        } else {
            System.out.println("None");
        }
    }

    @Override
    public void allies() {
        if (allies.size() >= min_allies) {
            System.out.println(allies.toString());
            allies.clear();
        } else {
            System.out.println("None");
        }
    }

    @Override
    public void encrypt(String name, String text, Map<String, String> hashMap) {
        text = text.toLowerCase();
        char[] charArr = new char[uniq_char_size];
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) - 97 >= 0 && text.charAt(i) - 97 <= uniq_char_size) {
                charArr[text.charAt(i) - 97]++;
            }
        }

        boolean flag = true;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(name)) {
                String str = entry.getValue();
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    if (charArr[ch - 97] > 0) {
                        charArr[ch - 97]--;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                } else {
                    allies.add(entry.getKey());
                }
            }
        }
    }
}
