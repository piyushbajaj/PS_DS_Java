package StringAlgorithm;

/**
 * Created by piyush.bajaj on 18/01/17.
 * Here are the four steps for this:
 * 1. create createHash function
 * 2. create checkEqual function to check whether both strings are matching or not
 * 3. recalculateHash when hash doesn't match
 * 4. apply all these functions in patternSearch()
 */
public class RobinKarp {

    //we can consider here any prime number
    private int prime = 3;

    public int patternSearch(char[] text, char[] pattern){
        int n = text.length;
        int m = pattern.length;
        long patternHash = createHash(pattern, m-1);
        long textHash = createHash(text, m-1);

        for(int i = 1; i <= n-m+1; i++){
            if(textHash == patternHash && checkEqual(text, i-1, i+m-2, pattern, 0, m-1))
                return i-1;
            else
                textHash = recalculateHash(text, i-1, i+m-1, textHash, m-1);
        }
        return -1;
    }

    public long recalculateHash(char[] str, int oldIndex, int newIndex, long oldHash, int patternLen){
        long newHash = (oldHash - str[oldIndex])/prime;
        newHash += str[newIndex]*Math.pow(prime, patternLen);
        return newHash;

    }

    public boolean checkEqual(char[] str1, int s1, int e1, char[] str2, int s2, int e2){
        if(e1-s1 != e2-s2)
            return false;
        while (s1 <= e1 && s2 <= e2){
            if(str1[s1] != str2[s2])
                return false;
            s1++;
            s2++;
        }
        return true;
    }

    public long createHash(char[] str, int len){
        long hash = 0;
        for(int i = 0; i <= len; i++){
            hash += str[i]*Math.pow(prime, i);
        }
        return hash;
    }

    public static void main(String[] args) {
        RobinKarp RK = new RobinKarp();
        String t1 = "Piyushus";
        String p1 = "us";

        System.out.println(RK.patternSearch(t1.toCharArray(), p1.toCharArray()));
    }
}
