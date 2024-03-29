package mx.ucol.helpers;

import org.sqlite.core.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    private DBConnection(){
        String url = "jdbc:sqlite:resources/todos.db";

        try{
            connection = DriverManager.getConnection(url);
        } catch (SQLException e){
            System.err.println("Error on DBConnection: " + e.getMessage());
        } catch (Exception e){
            System.err.println(e);
        }
    }

    public static Connection getInstance(){
        if (connection == null){
            new DBConnection();
        }
        return connection;
    }
}
