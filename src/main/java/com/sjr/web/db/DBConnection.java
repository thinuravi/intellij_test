package com.sjr.web.db;

import util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;


    public static Connection getConnection() throws Exception {
        ApplicationProperties propertes = ApplicationProperties.getInstance();
        Class.forName(propertes.get("sql.connection.driver"));
        connection = DriverManager.getConnection(propertes.get("sql.connection.url"), propertes.get("sql.connection.username"), propertes.get("sql.connection.password"));

        return connection;
    }

    public static void iud(String query){

        try {
            connection.prepareStatement(query).executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ResultSet search(String query) throws SQLException{

        return connection.prepareStatement(query).executeQuery();

    }


}
