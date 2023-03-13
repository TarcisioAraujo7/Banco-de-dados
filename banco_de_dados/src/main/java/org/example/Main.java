package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String instrucaoSQL = "SELECT * FROM universidade.usuario";
        try {
            Class.forName("org.postgresql.Driver");

            // Estabelecendo conexão
            Connection conexao = DriverManager.getConnection("url","user","password");

            Statement st = conexao.createStatement();
            ResultSet result = st.executeQuery(instrucaoSQL);

            // Printando a tabela de uma vez
            while (result.next()) {
                String tabela = result.getString(1) + " " + result.getString(2) + " " + result.getString(3 ) +
                        " " + result.getString(4) + " " + result.getString(5) + " " + result.getString(6);
                System.out.println(tabela);

            }

            // Printando a tabela usuario por usuario (precisa comentar a de cima e tirar a de baixo do comentario para funcionar)
            /*
            while (result.next()) {
                System.out.println("-------------------------------");
                System.out.println(result.getString(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getString(4));
                System.out.println(result.getString(5));
                System.out.println(result.getString(6));

            }*/

            result.close();
            st.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}