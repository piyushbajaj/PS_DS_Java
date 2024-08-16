package Testing;

import java.io.File;
import java.time.LocalDate;

/**
 * Created by bajajp on 10 Aug, 2022
 */
public class testStrings {

    public static void main(String[] args) {
        String s3Path = "BULLSEYE_S3_FOLDER" + File.separator + 2022 +
            File.separator + 10 + File.separator + 1234556 +
            ".csv";

        System.out.println(s3Path);


        LocalDate today = LocalDate.now();
        System.out.println("First day: " + today.withDayOfMonth(1));
    }
}
