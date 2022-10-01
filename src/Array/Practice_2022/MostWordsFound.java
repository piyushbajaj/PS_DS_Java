package Array.Practice_2022;

/**
 * Created by bajajp on 16 Jul, 2022
 */
public class MostWordsFound {
    public int mostWordsFound(String[] sentences) {
        int maxCount = 0;
        for (String sentence : sentences) {
            int count = 1;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ')
                    count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
