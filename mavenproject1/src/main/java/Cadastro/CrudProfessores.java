/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadastro;

import Objects.Professores;
import com.mycompany.mavenproject1.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aruossav42
 */
public class CrudProfessores {
    
    public void InsertProfessor (Professores professor)throws SQLException{
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stm = null;
        try{
            stm= con.prepareStatement("INSERT INTO professor (cpf, nome, disciplina) VALUES (?,?,?)");
            stm.setString(1, professor.getCpf());
            stm.setString(2, professor.getNome());
            stm.setString(3, professor.getDisciplina());
            stm.executeUpdate();
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
    
    public List<Professores> SelectProfessores() throws SQLException {
    Connection con = ConnectionFactory.createConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List <Professores> professor =new ArrayList<>();
    try{
        stmt = con.prepareStatement("SELECT * FROM professor");
        rs = stmt.executeQuery();
        while(rs.next()){
            Professores p1 = new Professores();
            p1.setCpf(rs.getString("cpf"));
            p1.setNome(rs.getString("nome"));
            p1.setDisciplina(rs.getString("Disciplina"));
            professor.add(p1);
        }    
    }catch(Exception exc){
        exc.printStackTrace();
    }
    return professor;
    }
    
    public void UpdateProfessores(Professores professor)throws SQLException{
	Connection con = ConnectionFactory.createConnection();
        PreparedStatement stmt = null;
	try{
	    stmt = con.prepareStatement("UPDATE professor SET nome = ?, disciplina = ? WHERE cpf = ?");
	    stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getDisciplina());
            stmt.setString(3, professor.getCpf());
	    stmt.executeUpdate();
	}catch(SQLException exc){
	    exc.printStackTrace();
	}
    }
    
    public void DeleteProfessor (Professores professor)throws SQLException{
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stat = null;
        try{
            stat= con.prepareStatement("DELETE FROM professor where cpf = ?");
            stat.setString(1, professor.getCpf());
            stat.executeUpdate();
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
    
}
