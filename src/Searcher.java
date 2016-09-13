import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by alex on 10.09.2016.
 */
public class Searcher {
    public Searcher(String surl) {
        String content = null;
        URLConnection connection = null;
        try {
            connection =  new URL(surl).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        System.out.println(content);
    }
}
