package TechboostJune2020.CodingChallenge;

public class EqualStacksProblem {

    public static int maxHeight(int[] h1, int[] h2, int[] h3) {
        int l1 = h1.length;
        int l2 = h2.length;
        int l3 = h3.length;

        if(l1 > 100000 || l2 > 100000 || l3 > 100000)
            return 0;

        int c1=0, c2 = 0, c3 = 0;
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for(int i = 0; i < l1; i++) {
            if(h1[i] ==0 || h1[i] > 100)
                return 0;
            sum1+= h1[i];
        }

        for(int i = 0; i < l2; i++) {
            if(h2[i] ==0 || h2[i] > 100)
                return 0;
            sum2+= h2[i];
        }

        for(int i = 0; i < l3; i++) {
            if(h3[i] ==0 || h3[i] > 100)
                return 0;
            sum3+= h3[i];
        }

        while (c1 < l1 && c2 < l2 && c3 < l3) {
            if(sum1==sum2 && sum2==sum3)
                return sum1;
            if(sum1 > sum2 && sum1 > sum3) {
                sum1 = sum1 - h1[c1++];
            }
            else if (sum2 > sum1 && sum2 > sum3) {
                sum2 = sum2 - h2[c2++];
            }
            else if (sum3 > sum1 && sum3 > sum2) {
                sum3 = sum3 - h3[c3++];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] n1 = {3, 2, 1, 1, 1};
        int[] n2 = {4, 3, 2};
        int[] n3 = {1, 1, 4, 1};

        System.out.println(maxHeight(n1, n2, n3));
    }
}
