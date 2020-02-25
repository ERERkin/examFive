package kg.exam.dao;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String user = "postgres";
    private static final String password = "postgres";

    @SneakyThrows
    public static Connection connect() {
        Class.forName("org.postgresql.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
