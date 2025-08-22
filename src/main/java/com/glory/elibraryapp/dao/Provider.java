package com.glory.elibraryapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Provider {

    public static Connection getPostgresConnection(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Elab",
                    "postgres", "Crunches02");

        } catch (Exception connect) {
            connect.printStackTrace();


        }
        return con;
    }
}
