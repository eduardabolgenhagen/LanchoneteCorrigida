package br.senai.sc.lanchonete.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {
    private String url = "jdbc:mysql://localhost:3306/lanchonetecorrigida";
    private String username = "root";
    private String password = "root";

    public Connection connectDB() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            throw new RuntimeException("Erro na conexão.");
        }
    }
}
