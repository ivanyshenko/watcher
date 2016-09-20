import java.sql.*;

/**
 * Created by alex on 20.09.2016.
 */
public class DatabaseManager {
    private Connection dbConnection = null;

    public DatabaseManager() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/watcher_database","root","111");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void append(Vacation vacation) throws SQLException {
        Statement stmt = null;
        String sql = null;
        stmt = dbConnection.createStatement();
        sql = "INSERT INTO vacations (id_vacation, vacation_name, company_name, location, date, experience) VALUES " + vacation.toString();
        stmt.execute(sql);
    }


}
