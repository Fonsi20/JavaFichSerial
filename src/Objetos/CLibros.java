/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;

/**
 *
 * @author mallo
 */
public class CLibros implements Serializable {

    private String isbn, titulo;
    private float precio;

    public CLibros() {
    }

    public CLibros(String isbn, String titulo, float precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.precio = precio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "CLibros{" + "isbn=" + isbn + ", titulo=" + titulo + ", precio=" + precio + '}';
    }

}
