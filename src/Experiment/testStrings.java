package Experiment;

import java.io.File;
import java.time.LocalDate;

/**
 * Created by bajajp on 10 Aug, 2022
 */
public class testStrings {

    public static void main(String[] args) {
        String s3Path = new StringBuilder("BULLSEYE_S3_FOLDER").append(File.separator).append(2022)
                .append(File.separator).append(10).append(File.separator).append(1234556)
                .append(".csv").toString();

        System.out.println(s3Path);


        LocalDate today = LocalDate.now();
        System.out.println("First day: " + today.withDayOfMonth(1));
    }
}
