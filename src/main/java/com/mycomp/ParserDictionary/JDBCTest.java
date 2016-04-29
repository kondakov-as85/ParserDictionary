package com.mycomp.ParserDictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kondakov on 20.04.2016.
 */
public class JDBCTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/portalsp_data";
        String name = "admin";
        String password = "admin";
        Connection connection = null;

        //Загружаем драйвер
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            //Создаём соединение
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Соединение установлено");
            connection.close();
            System.out.println("Соединение разорвано");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
