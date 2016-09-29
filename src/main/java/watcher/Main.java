package watcher;

import java.sql.SQLException;

/**
 * Created by alex on 10.09.2016.
 */

public class Main {
    public static void main(String args[]) {
        int database = Integer.parseInt(args[0]);
        int from = Integer.parseInt(args[1]);
        int to = Integer.parseInt(args[2]);

        StorageFactory storageFactory = StorageFactory.getInstance();
        Storage storage = null;
        if (database == 0) {
            storage = storageFactory.getStorage(database, "jdbc:mysql://localhost/watcher_database");
        } else {
            storage = storageFactory.getStorage(database, "vacations.csv");
        }

        for (int i = from; i <= to; i++) {
            Searcher searcher = new Searcher("https://hh.ru/vacancy/", i);
            String content = searcher.getContent();
            if (content == null) {
                System.out.println("vacation with id " + i + "isn't exist or we don't have appropriate access");
                continue;
            }
            Parser parser = Parser.getInstance();
            Vacation vacation = parser.parseHTML(content, i);
            if (vacation != null) {
                try {
                    storage.append(vacation);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        storage.closeConnection();
    }
}


