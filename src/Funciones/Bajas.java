/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Excepciones.Validaciones;
import Objetos.CAutores;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author mallo
 */
public class Bajas implements Fichero, Leer {

    public static void bajas() throws IOException, ClassNotFoundException {
        
        File temporal = new File("Temporal.dat");
        int op = 0;
        
        if (fichero.exists()) {
            do {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));//Si existe el fichero, abrimos flujo de lectura del fichero inicial
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temporal)); //y flujo de escritura del temporal. 
                String teclado = null;
                boolean en = false;
                System.out.println("Título del libro a borrar:");
                teclado = read.readLine();
                try {
                    CAutores autor = null;
                    do {
                        autor = (CAutores) ois.readObject();
                        for (int i = 0; i < autor.getLibro().size(); i++) {
                            if (teclado.compareToIgnoreCase(autor.getLibro().get(i).getTitulo()) == 0) {
                                en = true;
                                System.out.println("\nDatos del autor: \n"
                                        + "  Nombre:    " + autor.getNombre() + "\n"
                                        + "Datos del libro: \n"
                                        + "  ISBN:      " + autor.getLibro().get(i).getIsbn() + "\n"
                                        + "  Título:    " + autor.getLibro().get(i).getTitulo() + "\n"
                                        + "  Precio:    " + autor.getLibro().get(i).getPrecio() + "€\n"
                                        + "¿Desea borrar este libro?\n"
                                        + " [1] Sí\n"
                                        + " [0] No");
                                int me = Validaciones.menu(0,1);
                                if (me == 1) {
                                    autor.getLibro().remove(i);
                                    System.out.println("\nBorrado completado con éxito\n");
                                } else {
                                    System.out.println("\nOperación cancelada\n");
                                }
                            }
                        }
                        oos.writeObject(autor);
                    } while (true);
                } catch (EOFException e) {
                    if (en == false) {
                        System.out.println("\nERROR: El título introducido no se encuentra registrado en nuestra base de datos\n");
                    }
                }
                oos.close();//Se cierran ambos flujos
                ois.close();
                fichero.delete();
                temporal.renameTo(fichero);
                System.out.println("¿Desea eliminar otro libro?\n"
                        + " [1] Sí\n"
                        + " [0] No");
                op = Validaciones.menu(0,1);
                System.out.println();
            } while (op != 0);
        } else {
            System.out.println("ERROR: No hay ningún fichero registrado en nuestra base de datos");
        }
    }

}
