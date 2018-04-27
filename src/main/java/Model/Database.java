package Model;

import java.sql.*;

public class Database {

    private static Database instance = new Database();
    private Connection connection;

    private Database() {
    }


    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

    public void connect() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }

    }


    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Can't close connection");
            }
        }
        connection = null;
    }
}
