/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadastro;

import Objects.Funcionario;
import com.mycompany.mavenproject1.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aruossav42
 */
public class CrudFuncionario{
    
    public void InsertFuncionario(Funcionario func) throws SQLException {
	Connection con = ConnectionFactory.createConnection();
	PreparedStatement stm = null;
	try {
            stm = con.prepareStatement("INSERT INTO funcionario (cpf, funcao, turno, nome) VALUES(?,?,?,?)");
            stm.setString(1, func.getCpf());
            stm.setString(2, func.getFuncao());
            stm.setString(3, func.getTurno());
            stm.setString(4, func.getNome());
            stm.executeUpdate();
	}catch(SQLException e) {
            e.printStackTrace();
	}
    }
    public List<Funcionario> SelectFuncionario() throws SQLException{
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try{
            stm = con.prepareStatement("SELECT * FROM funcionario");
            rs = stm.executeQuery();
            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setCpf(rs.getString("cpf"));
                f.setFuncao(rs.getString("funcao"));
                f.setTurno(rs.getString("turno"));
                f.setNome(rs.getString("nome"));
                funcionarios.add(f);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return funcionarios;
    }
    
    public void UpdateFuncionario(Funcionario func) throws SQLException{
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stm = null;
        try{
            stm = con.prepareStatement("UPDATE funcionario SET funcao = ?, turno = ?, nome = ? WHERE cpf = ?");
            stm.setString(1,func.getFuncao() );
            stm.setString(2,func.getTurno() );
            stm.setString(3, func.getNome());
            stm.setString(4, func.getCpf());
            stm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void DeleteFuncionario(Funcionario func) throws SQLException{
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stm = null;
        try{
            stm = con.prepareStatement("DELETE FROM funcionario WHERE cpf = ?");
            stm.setString(1,func.getCpf());
            stm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
