/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadastro;
import Objects.Livro;
import com.mycompany.mavenproject1.ConnectionFactory;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Aruossav42
 */
public class CrudLivro {
    public void InsertLivro(Livro livro) throws SQLException {
	Connection con = ConnectionFactory.createConnection();
	PreparedStatement stm = null;
	try {
            stm = con.prepareStatement("INSERT INTO livro (autor, titulo) VALUES(?,?)");
            stm.setString(1, livro.getAutor());
            stm.setString(2, livro.getTitulo());
            stm.executeUpdate();
	}catch(SQLException e) {
            e.printStackTrace();
	}
    }
    public List<Livro> SelectLivro() throws SQLException{
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Livro> livros = new ArrayList<>();
        try{
            stm = con.prepareStatement("SELECT * FROM livro");
            rs = stm.executeQuery();
            while(rs.next()){
                Livro l = new Livro();
                l.setId(rs.getInt("idlivro"));
                l.setAutor(rs.getString("autor"));
                l.setTitulo(rs.getString("titulo"));
                livros.add(l);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return livros;
    }
    public void UpdateLivro(Livro livro) throws SQLException{
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stm = null;
        try{
            stm = con.prepareStatement("UPDATE livro SET autor = ? ,titulo = ? WHERE idlivro = ?");
            stm.setString(1, livro.getAutor());
            stm.setString(2, livro.getTitulo());
            stm.setInt(3, livro.getId());
            stm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void DeleteLivro(Livro livro) throws SQLException{
        Connection con = ConnectionFactory.createConnection();
        PreparedStatement stm = null;
        try{
            stm = con.prepareStatement("DELETE FROM livro WHERE idlivro = ?");
            stm.setInt(1, livro.getId());
            stm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

 }
