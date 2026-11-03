package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresSQLDBConnection {
        private static String url = "jdbc:postgresql://134.117.134.15:5432/A3(1)";
        private static String user = "student@localhost.localdomain";
        private static String password = "A4s6s4u7";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, user, password);
        }

}