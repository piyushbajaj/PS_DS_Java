package String;

/**
 * Created by bajajp on 18 Jul, 2022
 */
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int cnt = 0;
        for(int i = 0; i < stones.length(); i++) {
            if (jewels.contains(stones)) {
                cnt++;
            }
        }
        return cnt;
    }
}
