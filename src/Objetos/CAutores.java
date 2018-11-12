/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author mallo
 */
public class CAutores implements Serializable {

    private String nombre, dni, ciudad;
    private ArrayList<CLibros> Libro;

    public CAutores() {
    }

    public CAutores(String nombre, String dni, String ciudad) {
        this.nombre = nombre;
        this.dni = dni;
        this.ciudad = ciudad;
        this.Libro = new ArrayList<CLibros>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<CLibros> getLibro() {
        return Libro;
    }

    public void setLibro(ArrayList<CLibros> Libro) {
        this.Libro = Libro;
    }

    @Override
    public String toString() {
        return "CAutores{" + "nombre=" + nombre + ", dni=" + dni + ", ciudad=" + ciudad + ", Libro=" + Libro + '}';
    }

}
