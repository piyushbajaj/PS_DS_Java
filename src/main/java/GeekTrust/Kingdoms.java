package GeekTrust;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by piyush.bajaj on 11/04/18.
 */
public class Kingdoms {
    Map<String, String> hashMap = new HashMap<String, String>();

    public void addKingdom(String Name, String Emblem) {
        Name = Name.toLowerCase();
        Emblem = Emblem.toLowerCase();
        hashMap.put(Name, Emblem);
    }

    public Map<String, String> allKingdoms() {

        //Put all in lower case
        hashMap.put("land", "panda");
        hashMap.put("water", "octopus");
        hashMap.put("ice", "mammoth");
        hashMap.put("air", "owl");
        hashMap.put("fire", "dragon");

        return hashMap;
    }
}
