package com.jhunsuvlets.toysuvlets2.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.*;



public class Commons {
    public Statement getStatement(){
        String url = "jdbc:mysql://localhost:3306/toys_JavaWithDB";
        String user = "root";
        String password = "*khacademy!";

        Statement statement = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public String getGeneratorID(){
        Date date = new Date(0, 0, 0);  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyyhh:mm:ss");  
        String strDate = formatter.format(date);
        return strDate;
    }
}
