import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by alex on 10.09.2016.
 */

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        DatabaseManager dbManager = new DatabaseManager();
        for (int i = from; i <= to; i++) {
            Searcher searcher = new Searcher("https://hh.ru/vacancy/", i);
            String content = searcher.getContent();
            if (content == null) {
                System.out.println("vacation with id " + i + "isn't exist or we don't have appropriate access");
                continue;
            }
            Parser parser = new Parser();
            Vacation vacation = parser.parseHTML(content, i);
            if (vacation != null) {
                try {
                    dbManager.append(vacation);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}


