package watcher;

import java.sql.*;

/**
 * Created by alex on 20.09.2016.
 */

public class DatabaseManager implements Storage {
    private Connection dbConnection = null;

    public DatabaseManager(String databasePath) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            dbConnection = DriverManager.getConnection(databasePath, "root", "111");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void append(Vacation vacation) throws Exception {
        Statement stmt = null;
        String sql = null;
        stmt = dbConnection.createStatement();
        sql = "INSERT INTO vacations (id_vacation, vacation_name, company_name, location, date, experience) VALUES " + vacation.toSQLString();
        stmt.execute(sql);
    }

    public void closeConnection() {
        try {
            dbConnection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("connection with mysql database is closed");
    }
}
