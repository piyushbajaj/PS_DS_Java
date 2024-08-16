package Office.Vigoursoft.Regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Project: DSAlgo
 * Package: Office.Vigoursoft
 * <p>
 * User: piyushbajaj
 * Date: 29/03/24
 * Time: 6:57 pm
 */
public class RegexTry {

    private enum FileExtension {
        CSV, ZIP
    }

    private enum ReportAttachmentPatternGroupNames {
        PROFILE_TYPE, WEBPROPERTYGROUPID, INTEGRATIONID, REPORTFREQUENCY, REPORTDIMENSION,
        REPORTPERIOD, REPORTCHANNEL, FILE_NAME, FILEEXTENSION
    }

//    static final Pattern VALID_REPORT_KEY_PATTERN = Pattern.compile(
//        String.format(
//            "(.+)[/](?<%s>.+)[/](?<%s>%s)[_-](?<%s>%s)[/](?<%s>Report(?<%s>[0-9]{8})[-](?<%s>[0-9]{8}))\\." +
//                "(?<%s>%s)",
//            "(.+)[/](?<%s>web_property_group_id=)[/](?<%s>integration_id=[0-9][a-z][-])[/](?<%s>report_type=(?<%s>%s)" +
//                "[_-](?<%s>%s))[/]" +
//                "(?<%s>report_period=" +
//                "(?<%s>[0-9]{4})[-](?<%s>[0-9]{2})[-](?<%s>[0-9]{2}))[/](?<%s>report_channel=(?<%s>%s))\\.(?<%s>%s)",
//            ReportAttachmentPatternGroupNames.PROFILE_TYPE,
//            ReportAttachmentPatternGroupNames.WEB_PROPERTY_GROUP_ID,
//            ReportAttachmentPatternGroupNames.INTEGRATION_ID,
//            ReportAttachmentPatternGroupNames.REPORT_FREQUENCY,
//            Arrays.stream(ReportFrequency.values()).map(Enum::name).collect(Collectors.joining("|")),
//            ReportAttachmentPatternGroupNames.REPORT_DIMENSION,
//            Arrays.stream(ReportDimension.values()).map(Enum::name).collect(Collectors.joining("|")),
//            ReportAttachmentPatternGroupNames.REPORT_PERIOD,
//            ReportAttachmentPatternGroupNames.REPORT_CHANNEL,
//            ReportAttachmentPatternGroupNames.FILE_NAME,
//            ReportAttachmentPatternGroupNames.FILE_EXTENSION,
//            Arrays.stream(FileExtension.values()).map(Enum::name).collect(Collectors.joining("|"))

//    ReportAttachmentPatternGroupNames.PROFILEALIAS,
//    ReportAttachmentPatternGroupNames.REPORTFREQUENCY,
//        Arrays.stream(ReportFrequency.values()).map(Enum::name).collect(Collectors.joining("|")),
//    ReportAttachmentPatternGroupNames.REPORTDIMENSION,
//        Arrays.stream(ReportDimension.values()).map(Enum::name).collect(Collectors.joining("|")),
//    ReportAttachmentPatternGroupNames.REPORTNAME,
//    ReportAttachmentPatternGroupNames.PERIODSTARTDATE,
//    ReportAttachmentPatternGroupNames.PERIODENDDATE,
//    ReportAttachmentPatternGroupNames.FILEFORMAT,
//        Arrays.stream(FileExtension.values()).map(Enum::name).collect(Collectors.joining("|"))

//        ),
//        Pattern.CASE_INSENSITIVE);

    static final Pattern VALID_REPORT_KEY_PATTERN1 =
        Pattern.compile(
            String.format(
                "(.+)[/]web_property_group_id=(?<%s>\\d+)[/]integration_id=" +
                    "(?<%s>[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12})" +
                    "[/]report_type=(?<%s>%s)[_-](?<%s>%s)[/]report_period=" +
                    "(?<%s>[0-9]{4}[-][0-9]{2}[-][0-9]{2})" +
                    "[/]report_channel=(?<%s>.+)" +
                    "[/](.+)",
                ReportAttachmentPatternGroupNames.WEBPROPERTYGROUPID,
                ReportAttachmentPatternGroupNames.INTEGRATIONID,
                ReportAttachmentPatternGroupNames.REPORTFREQUENCY,
                Arrays.stream(ReportFrequency.values()).map(Enum::name).collect(Collectors.joining("|")),
                ReportAttachmentPatternGroupNames.REPORTDIMENSION,
                Arrays.stream(ReportDimension.values()).map(Enum::name).collect(Collectors.joining("|")),
                ReportAttachmentPatternGroupNames.REPORTPERIOD,
                ReportAttachmentPatternGroupNames.REPORTCHANNEL),
            Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {

        final Matcher matcher = VALID_REPORT_KEY_PATTERN1.matcher(
            "landed/analytics/v1/profile_type=google_analytics/web_property_group_id=10/integration_id=0fc72629-2ef3" +
                "-4a52-a3ef-da35f6605169/report_type=WEEKLY_PAGE/report_period=2017-06-03/report_channel=ORGANIC" +
                "/index.csv.gz");

        System.out.println(matcher.matches());
        System.out.println(matcher.group(ReportAttachmentPatternGroupNames.WEBPROPERTYGROUPID.name()));
        System.out.println(matcher.group(ReportAttachmentPatternGroupNames.INTEGRATIONID.name()));
        System.out.println(matcher.group(ReportAttachmentPatternGroupNames.REPORTFREQUENCY.name()));
        System.out.println(matcher.group(ReportAttachmentPatternGroupNames.REPORTDIMENSION.name()));
        System.out.println(matcher.group(ReportAttachmentPatternGroupNames.REPORTPERIOD.name()));
        System.out.println(matcher.group(ReportAttachmentPatternGroupNames.REPORTCHANNEL.name()));

    }
}
