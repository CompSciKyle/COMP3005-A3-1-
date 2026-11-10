package src.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class PostgresSQLDBConnection {

    public static Connection getConnection() throws SQLException {

        Properties env = new Properties();

        try (FileInputStream file = new FileInputStream(".env")) {
            env.load(file);
        } catch (IOException e) {
            throw new SQLException("Could not load .env file", e);
        }

        String url = env.getProperty("DB_URL");
        String user = env.getProperty("DB_USER");
        String password = env.getProperty("DB_PASSWORD");

        return DriverManager.getConnection(url, user, password);
    }
}