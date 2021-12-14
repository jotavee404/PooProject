/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Aruossav42
 */
public class Livro {
    private int idlivro;
    private String autor;
    private String titulo;
    
    public Livro() {
    }
	
    public int getId() {
	return idlivro;
    }public void setId(int id) {
	this.idlivro = id;
    }public String getAutor() {
	return autor;
    }public void setAutor(String Autor) {
	this.autor = Autor;
    }public String getTitulo() {
	return titulo;
    }public void setTitulo(String Titulo) {
	this.titulo = Titulo;
    }
	
	@Override
	public String toString() {
		return "Id: " + idlivro + " | Autor: " + autor + " | Título: " + titulo;
	}
}

