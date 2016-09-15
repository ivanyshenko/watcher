import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alex on 14.09.2016.
 */
public class Parser {
    public Parser() {
        System.out.println("Parser is created");
    }

    public Vacation parseHTML(String html) {
        Vacation vacation = null;
        String name = catchFromTag("vacancy__name", html);
        String company = catchFromTag("vacancy-employer", html);
        company = company.replaceAll(" ","");
        String location = catchFromTag("vacancy-region", html);
        String date = catchFromTag("vacancy-date", html);
        String experience = catchFromTag("vacancy__experience", html);
        experience = new String(experience.replaceFirst(".*: ",""));

        vacation = new Vacation(name, company, location, date, experience);
        return vacation;
    }

    private String catchFromTag(String string, String html) {
        String result = null;
        Pattern pattern = Pattern.compile("<[^<]*"+ string +"[^\\/]*\\/.*>");
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            result = matcher.group(0);
            result = result.replaceAll("<[^>]*>", "");
            System.out.println(string + " is " + result);
        } else System.out.println("name is not found");

        return result;
    }
}
