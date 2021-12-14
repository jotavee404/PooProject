/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadastro;

import Objects.Responsaveis;
import com.mycompany.mavenproject1.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aruossav42
 */
public class CrudResponsaveis {
    
    public void InsertResponsaveis(Responsaveis resp)throws SQLException{
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement statement = null;
	try{
	    statement = con.prepareStatement("INSERT INTO responsaveis (cpf, nome, idade, parentesco) VALUES (?, ?, ?, ?)");
	    statement.setString(1, resp.getCpf());
	    statement.setString(2, resp.getNome());
	    statement.setInt(3, resp.getIdade());
	    statement.setString(4, resp.getParentesco());
	    statement.executeUpdate();
	    }catch(SQLException ex){
	    	ex.printStackTrace();
	    }
	}
    
    
    public List<Responsaveis> SelectResponsaveis()throws SQLException{
	Connection con = ConnectionFactory.createConnection();
        PreparedStatement statement = null;
	ResultSet rs = null;
    	List<Responsaveis> atributos = new ArrayList<>();
    	try{
            statement = con.prepareStatement("SELECT * FROM responsaveis");
            rs = statement.executeQuery();
            while(rs.next()){
    		Responsaveis r1 = new Responsaveis();
    		r1.setCpf(rs.getString("cpf"));
                r1.setNome(rs.getString("nome"));
    		r1.setIdade(rs.getInt("idade"));
    		r1.setParentesco(rs.getString("parentesco"));
    		atributos.add(r1);
            }
    	}catch(SQLException ex){
    		ex.printStackTrace();
    	}
    	return atributos;
    }
    
    public void UpdateResponsaveis(Responsaveis resp)throws SQLException{
	Connection con = ConnectionFactory.createConnection();
        PreparedStatement statement = null;
	try{
	    statement = con.prepareStatement("UPDATE responsaveis SET nome = ?, idade = ?, parentesco = ? WHERE cpf = ?");
	    statement.setString(1, resp.getNome());
            statement.setInt(2, resp.getIdade());
            statement.setString(3, resp.getParentesco());
	    statement.setString(4, resp.getCpf());
	    statement.executeUpdate();
	}catch(SQLException ex){
	    ex.printStackTrace();
	}
    }
    
    
    public void DeleteResponsaveis(Responsaveis resp)throws SQLException{
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement statement = null;
        try{
	    statement = con.prepareStatement("DELETE FROM responsaveis WHERE cpf = ?");
	    	statement.setString(1, resp.getCpf());
	    	statement.executeUpdate();
	    }catch(SQLException ex){
	    	ex.printStackTrace();
	    }
	}
    
    
}
