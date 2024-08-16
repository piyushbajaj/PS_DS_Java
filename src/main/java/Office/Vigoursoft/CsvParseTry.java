package Office.Vigoursoft;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Project: DSAlgo
 * Package: Office.Vigoursoft
 * <p>
 * User: piyushbajaj
 * Date: 18/01/24
 * Time: 1:50 pm
 */
public class CsvParseTry {

    public static final String LANDED_REPORT_URI_WEEKLY_PAGE = String.join("/",
        "web_property_group_id=".concat(String.valueOf(10)),
        "integration_id=".concat(String.valueOf(UUID.fromString("c38df6a2-9d9f-4ebd-a78a-a1c8131e1f9c"))),
        "report_type=".concat("WEEKLY_PAGE"),
        "report_period=".concat("2017-06-10"),
        "report_channel=".concat("ALL"),
        "Report.csv".concat(".gz"));

    static String sanitizedFileName = LANDED_REPORT_URI_WEEKLY_PAGE.replaceAll("^/+", "");
    static String test;

    static {
        try {
            test =
                URLEncoder.encode(sanitizedFileName, "UTF-8").replace("%3A", ":").replace("%2F", "/")
                    .replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    static String test1;

    static {
        try {
            test1 =
                URLDecoder.decode(test, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        System.out.println(LANDED_REPORT_URI_WEEKLY_PAGE);
        System.out.println(sanitizedFileName);
        System.out.println(test);
        System.out.println(test1);
    }
}
