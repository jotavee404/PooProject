/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadastro;

import Objects.Alunos;
import com.mycompany.mavenproject1.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aruossav42
 */
public class CrudAlunos {
    
    public void InsertAlunos (Alunos alunos) throws SQLException {
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stm = null;
	
	try {
            stm = con.prepareStatement("INSERT INTO alunos (nome, idade, turma, nomeresponsavel) VALUES(?, ?, ?, ?)");
            stm.setString(1, alunos.getNome());
            stm.setInt(2, alunos.getIdade());
            stm.setString(3, alunos.getTurma());
            stm.setString(4, alunos.getNomeresponsavel());
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    public List<Alunos> SelectAlunos() throws SQLException {
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Alunos> alunos = new ArrayList<>();
        try {
            stm = con.prepareStatement ("SELECT * FROM alunos");
            rs = stm.executeQuery();
            while(rs.next()){
                Alunos a1 = new Alunos();
                a1.setId(rs.getInt("id"));
                a1.setNome(rs.getString("nome"));
                a1.setIdade(rs.getInt("idade"));
                a1.setTurma(rs.getString("turma"));
                a1.setNomeresponsavel(rs.getString("nomeresponsavel"));
                alunos.add(a1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return alunos;
    
         
         
    }
    
    public void  UpdateAlunos (Alunos alunos) throws SQLException {
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stm = null;
	try {
            stm = con.prepareStatement("UPDATE alunos SET nome = ?, idade = ?, turma = ?, nomeresponsavel = ? WHERE id = ?");
            stm.setString(1,alunos.getNome() );
            stm.setInt(2,alunos.getIdade() );
            stm.setString(3, alunos.getTurma());
            stm.setString(4, alunos.getNomeresponsavel());
            stm.setInt(5, alunos.getId());
            stm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void  DeleteAlunos(Alunos alunos) throws SQLException {
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stm = null;
	try {
            stm = con.prepareStatement("DELETE FROM alunos WHERE id = ?");
            stm.setInt(1, alunos.getId());
            stm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}

