package watcher;

import java.io.FileWriter;

/**
 * Created by alex on 28.09.2016.
 */
public class CSVManager implements Storage {
    private FileWriter fileWriter = null;

    public CSVManager(String filename) {
        try {
            fileWriter = new FileWriter(filename);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void append(Vacation vacation) throws Exception {
        fileWriter.write(vacation.toCSVString(","));
    }

    public void closeConnection() {
        try {
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("connection with csv file is closed");
    }
}
