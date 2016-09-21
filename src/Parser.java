import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alex on 14.09.2016.
 */
public class Parser {
    public Parser() {
        System.out.println("Parser is created");
    }

    public Vacation parseHTML(String html, int hhId) {
        String name = catchFromTag("title b-vacancy-title", html);
        String company = catchFromTag("hiringOrganization", html);
        String date = catchFromTag("vacancy-sidebar__publication-date", html);

        String importantVacancyInfo[] = catchFromTable("l-content-3colums", html);
        String experience = new String(importantVacancyInfo[5]);
        String location = new String(importantVacancyInfo[4]);

        Vacation vacation = new Vacation(hhId, name, company, location, date, experience);
        return vacation;
    }

    private String catchFromTag(String string, String html) {
        String result = null;
        Pattern pattern = Pattern.compile("<[^<]*" + string + "[^<]*");
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            result = matcher.group(0);
            result = result.replaceAll("<[^>]*>", "");
            System.out.println(string + " is " + result);
        } else System.out.println("name is not found");
        return result;
    }

    private String[] catchFromTable(String string, String html) {
        Pattern pattern = Pattern.compile("<table.*" + string + ".*</table>");
        Matcher matcher = pattern.matcher(html);
        String result;
        if (matcher.find()) {
            result = matcher.group(0);
            System.out.println(string + " is " + result.replaceAll("<[^>]*>", " "));
            return result.split("<[^>]*>");
        } else {
            return null;
        }
    }
}
