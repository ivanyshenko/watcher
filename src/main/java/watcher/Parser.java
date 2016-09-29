package watcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alex on 14.09.2016.
 */
public class Parser {
    private static Parser ourInstance = new Parser();

    private Parser() {
        System.out.println("watcher.Parser is created");
    }

    public static Parser getInstance() {
        return ourInstance;
    }

    public Vacation parseHTML(String html, int hhId) {
        String name = catchFromTag("title b-vacancy-title", html);
        String company = catchFromTag("hiringOrganization", html);
        String date = catchFromTag("vacancy-sidebar__publication-date", html);

        String importantVacancyInfo[] = catchFromTable("l-content-3colums", html);
        String experience = importantVacancyInfo[5];
        String location = importantVacancyInfo[4];

        return new Vacation(hhId, name, company, location, date, experience);
    }

    private String catchFromTag(String string, String html) {
        String result = null;
        Pattern pattern = Pattern.compile("<[^<]*" + string + "[^<]*");
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            result = matcher.group(0);
            result = result.replaceAll("<[^>]*>", "");
            result = result.replaceAll("^ *", "");
        } else System.out.println("name is not found");
        return result;
    }

    private String[] catchFromTable(String string, String html) {
        Pattern pattern = Pattern.compile("<table.*" + string + ".*</table>");
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            String tableString = matcher.group(0);
            String[] resultArray = new String[6];
            int j = 0;
            for (String i : tableString.split("<[^>]*>")) {
                if (i.length() != 0) {
                    resultArray[j] = i;
                    j++;
                }
            }
            return resultArray;
        } else { return null; }
    }
}
