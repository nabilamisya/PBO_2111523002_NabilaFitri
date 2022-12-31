package com.config;
import java.sql.DriverManager;
import java.sql.Connection;

public class cConfig {

    // mendefinisikan koneksi database
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/uaspbo";
    private static final String USER = "root";
    private static final String PASS = "";

    // instansi object dari class DriverManager dan Connection
    private static Connection connect;

    public static void connection() {
        // method koneksi database
        try {
            // registrasi driver yang dipakai
            Class.forName(JDBC_DRIVER);

            // koneksi database
            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Koneksi Berhasil");

        } catch (Exception e) {
            // kalau error saat koneksi
            e.printStackTrace();
        }
    }
}
