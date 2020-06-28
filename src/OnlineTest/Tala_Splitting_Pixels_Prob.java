package OnlineTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by piyush.bajaj on 11/06/18.
 */
public class Tala_Splitting_Pixels_Prob {
    public static void main(String[] args) throws IOException {
//        String[] str = {"101111010110011011100100",
//                        "110000010101011111101111",
//                        "100110101100111111101101",
//                        "010111011010010110000011",
//                        "000000001111111111111111"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //String line = br.readLine();
        //int N = Integer.parseInt(line);
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        calculate(arr);
    }

    public static void calculate(String[] arr){

        String red = "", green = "", blue = "";
        int redBin=0, greenBin=0, blueBin=0;
        double disPureBlack = 0, disPureWhite = 0, disPureRed = 0, disPureGreen = 0, disPureBlue = 0;
        for(int i = 0; i < arr.length; i++){
            red = arr[i].substring(0, 8);
            green = arr[i].substring(8, 16);
            blue = arr[i].substring(16, 24);

            redBin = Integer.parseInt(red, 2);
            greenBin = Integer.parseInt(green, 2);
            blueBin = Integer.parseInt(blue, 2);

            disPureBlack = Math.sqrt(Math.pow((redBin-0),2) + Math.pow((greenBin-0),2) +
                    Math.pow((blueBin-0),2));
            disPureWhite = Math.sqrt(Math.pow((redBin-255),2) + Math.pow((greenBin-255),2) +
                    Math.pow((blueBin-255),2));

            disPureRed = Math.sqrt(Math.pow((redBin-255),2) + Math.pow((greenBin-0),2) +
                    Math.pow((blueBin-0),2));

            disPureGreen = Math.sqrt(Math.pow((redBin-0),2) + Math.pow((greenBin-255),2) +
                    Math.pow((blueBin-0),2));
            disPureBlue = Math.sqrt(Math.pow((redBin-0),2) + Math.pow((greenBin-0),2) +
                    Math.pow((blueBin-255),2));

            double[] doubles = {disPureBlack, disPureWhite, disPureRed, disPureGreen, disPureBlue};

            double min = Integer.MAX_VALUE;
            int index = 0;
            for(int k = 0; k < 5; k++){
                if(doubles[k] < min) {
                    min = doubles[k];
                    index = k;
                }
            }

            int count = 0;
            for(int k = 0; k < 5; k++){
                if( min == doubles[k]) {
                    count++;
                }
            }

            if(count==1) {
                String result = "";
                switch (index) {
                    case 0:
                        result = "Black";
                        break;
                    case 1:
                        result = "White";
                        break;
                    case 2:
                        result = "Red";
                        break;
                    case 3:
                        result = "Green";
                        break;
                    case 4:
                        result = "Blue";
                        break;
                }
                System.out.println(result);
            }
            else
                System.out.println("Ambiguous");
        }
    }
}
