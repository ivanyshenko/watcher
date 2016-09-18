import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by alex on 10.09.2016.
 */
public class Searcher {
    private int id;
    private String url;
    public Searcher(String string, int from) {
        id = from;
        url = string;
        System.out.println("Searcher is created with url " + url);
    }

    public String next(){
        this.id++;
        String content = null;
        HttpURLConnection connection = null;
        try {
//            connection =  new URL(url + id).openConnection();
//            Scanner scanner = new Scanner(connection.getInputStream());
//            scanner.useDelimiter("\\Z");
//            content = scanner.next();
            URL hhUrl = new URL(url + id);
            connection = (HttpURLConnection) hhUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Mozilla/5.0");
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }



        return content;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
