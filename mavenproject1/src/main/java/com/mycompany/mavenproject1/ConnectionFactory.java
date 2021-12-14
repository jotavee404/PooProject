/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;
import java.sql.*;
/**
 *
 * @author Aruossav42
 */
public class ConnectionFactory {
    public static Connection createConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/cadastro"; 
		String user = "root"; 
		String password = "Renan-159"; 
		java.sql.Connection conexao = null;
		conexao = DriverManager.getConnection(url, user, password);
		return conexao;
	}
}
