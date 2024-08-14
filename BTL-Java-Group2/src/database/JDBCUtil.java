package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-JJ7V7BR\\MAY1:1433;database=QL_Phong;trustServerCertificate=true";
            String user = "DESKTOP-JJ7V7BR\\Admin";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
