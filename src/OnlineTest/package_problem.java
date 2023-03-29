package OnlineTest;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by piyush.bajaj on 12/07/17.
 */
public class package_problem {

    public static void main(String[] args) throws IOException {
        package_problem kp = new package_problem();

        try {


            String csvFile = "/Users/piyush.bajaj/Documents/whatfix/package_prob_input.csv";
            String cvsSplitBy = ":";

            List<String> strings = Files.readAllLines(Paths.get(csvFile), Charset.forName("ISO-8859-1"));


            for (String line : strings) {
                List<Tuple> tuples = new ArrayList<>();
                String[] item = line.split(cvsSplitBy);
                int max_weight = Integer.valueOf(item[0].trim());
                if (max_weight < 0 || max_weight > 100) {
                    System.out.println("Maximum weight cannot be more than 100");
                    return;
                }
                String[] arr = item[1].split(" ");

                for (String s : arr) {
                    if (s == null || s.isEmpty() || s.length() == 0) {
                        continue;
                    }
                    String[] temp = s.trim().substring(1, s.trim().length() - 1).split(",");
                    if (Double.valueOf(temp[1]).doubleValue() < 0 || Double.valueOf(temp[1]).doubleValue() > 100) {
                        System.out.println("Individual Weight cannot be more than 100");
                        return;
                    }
                    if (Integer.valueOf(temp[2].substring(1, temp[2].length())) < 0 ||
                        Integer.valueOf(temp[2].substring(1, temp[2].length())) > 100) {
                        System.out.println("Individual Costs cannot be more than 100");
                        return;
                    }

                    tuples.add(new Tuple(Integer.valueOf(temp[0]),
                        Integer.valueOf((int) (Double.valueOf(temp[1]).doubleValue() * 100)),
                        Integer.valueOf(temp[2].substring(1, temp[2].length()))));
                }
                kp.package_cal(max_weight * 100, tuples);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void package_cal(int weight, List<Tuple> tuples) {
        int n = tuples.size();
        int[] wt = new int[n];
        int[] val = new int[n];


        for (int i = 0; i < n; i++) {
            wt[i] = tuples.get(i).getWeight();
            val[i] = tuples.get(i).getCost();
        }

        int row_len = wt.length;
        int[][] mat = new int[row_len][weight + 1];

        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j <= weight; j++) {
                if (j == 0) {
                    mat[i][j] = 0;
                } else if (j < wt[i]) {
                    if (i == 0) {
                        mat[i][j] = mat[i][j - 1];
                    } else {
                        mat[i][j] = mat[i - 1][j];
                    }
                } else {
                    if (i == 0) {
                        mat[i][j] = val[i];
                    } else {
                        mat[i][j] = Math.max((val[i] + mat[i - 1][j - wt[i]]), mat[i - 1][j]);
                    }
                }

            }
        }
        int result = mat[row_len - 1][weight];

        int j = weight, benefit = 0;
        if (benefit == result) {
            System.out.println("-");
            return;
        }
        for (int i = row_len - 1; i >= 0 & j >= 0; i--) {
            if (i == 0 && j == 0) {
                System.out.println("-");
                break;
            } else if (i >= 1 && (mat[i][j] == mat[i - 1][j])) {
                continue;
            } else if (i >= 1 && (mat[i][j] > mat[i - 1][j])) {
                System.out.print(i + 1);
                j = j - wt[i];
                benefit += val[i];

            }
            if (benefit == result) {
                System.out.println();
                break;
            } else {
                System.out.print(",");
            }

        }


        return;
    }
}
