/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Objetos.CAutores;
import java.io.IOException;
import Excepciones.Validaciones;
import Objetos.CLibros;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author mallo
 */
public class Altas implements Fichero, Leer {

    public static CAutores altasAutores(CAutores autor) throws IOException, ClassNotFoundException {

        int opc, opc2, err;
        String nombre, dni, ciudad, isbn, titulo;
        float precio = 0;

        //Add AUTOR
        do {
            System.out.println("Introduce DNI:");
            dni = read.readLine();
            err = Validaciones.dni(dni);
        } while (err == 1);
        System.out.println("Introduce el nombre del autor:");
        nombre = read.readLine();
        System.out.println("Introduce la ciudad del autor:");
        ciudad = read.readLine();
        autor = new CAutores(nombre, dni, ciudad);
        System.out.println("¿Desea registrar algún libro de este autor?\n"
                + " [1] Sí \n"
                + " [0] No");
        opc = Validaciones.menu(0, 1);

        //Add LIBRO
        if (opc == 1) {
            do {
                CLibros libro = null;
                do {
                    System.out.println("Introduce ISBN del libro:");
                    isbn = read.readLine();
                    err = Validaciones.isbn(isbn);
                } while (err == 1);
                System.out.println("Título:");
                titulo = read.readLine();
                do {
                    err = 0;
                    System.out.println("Introduce el precio del libro " + titulo + ":");
                    try {
                        precio = Float.parseFloat(read.readLine());
                    } catch (NumberFormatException e) {
                        err = 1;
                        System.out.println("\nERROR: Entrada no válida\n");
                    }
                } while (err == 1);
                libro = new CLibros(isbn, titulo, precio);
                autor.getLibro().add(libro);
                System.out.println("\n¿Desea registrar otro libro para este autor?\n"
                        + " [1] Sí\n"
                        + " [0] No");
                opc2 = Validaciones.menu(0, 1);
                System.out.println();
            } while (opc2 != 0);
        } else {
            System.out.println("\n    Autor añadido con éxito   \n");
        }
        return autor;

    }

    public static void altasLibro() throws IOException, ClassNotFoundException {

        File temp = new File("temporal.dat");
        String isbn = null, titulo = null;
        float precio = 0;
        int er = 0;
        boolean en = false;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp));
        CAutores autor = null;
        CLibros libro = null;
        System.out.println("Introduce el DNI del autor:");
        String teclado = read.readLine();
        try {
            do {
                autor = (CAutores) ois.readObject();
                if (teclado.compareToIgnoreCase(autor.getDni()) == 0) {
                    en = true;
                    do {
                        System.out.println("ISBN:");
                        isbn = read.readLine();
                        er = Validaciones.isbn(isbn);
                    } while (er == 1);
                    System.out.println("Título:");
                    titulo = read.readLine();
                    do {
                        er = 0;
                        System.out.println("Precio:");
                        try {
                            precio = Float.parseFloat(read.readLine());
                        } catch (NumberFormatException e) {
                            er = 1;
                            System.out.println("\nERROR: Entrada no válida\n");
                        }
                    } while (er == 1);
                    libro = new CLibros(isbn, titulo, precio);
                    autor.getLibro().add(libro);
                }
            } while (true);
        } catch (EOFException e) {
            if (en == false) {
                System.out.println("\nERROR: El autor no se encuentra registrado en nuestra base de datos\n");
            }
        }

        try {
            do {
                autor = (CAutores) ois.readObject();
                oos.writeObject(autor);
            } while (true);
        } catch (EOFException e) {
        }

        oos.close();
        ois.close();
        fichero.delete();
        temp.renameTo(fichero);
    }
}
