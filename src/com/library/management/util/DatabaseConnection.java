package com.library.management.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library",
                "root",
                "password"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
