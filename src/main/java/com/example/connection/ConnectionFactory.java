package com.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String USERNAME = "";                                      //Usuario do Banco de Dados
    private static final String PASSWORD = "";                                      //Senha do Banco de Dados
    private static final String DATABASE_URL = "jdbc:sqlite:" 
        + System.getProperty("user.dir").replace("\\", "/") 
        + "/CRUD-Java/DB/crud.db";                                                  //URL pro Banco de Dados

    public static Connection connectDB() {

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DATABASE_URL);

            return connection;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados: 001\n" + e);

            return null;
        }
    }
}

