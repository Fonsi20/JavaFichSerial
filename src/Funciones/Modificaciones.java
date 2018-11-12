/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Excepciones.Validaciones;
import Objetos.*;
import java.io.*;

/**
 *
 * @author mallo
 */
public class Modificaciones implements Fichero, Leer {

    public static void modificaciones() throws IOException, ClassNotFoundException {

        float precio = 0;
        int er = 0, op = 0;
        if (fichero.exists()) {
            do {
                boolean en = false;
                File temp = new File("temporal.dat");
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp));
                CAutores autor = null;
                System.out.println("Título del libro a modificar:");
                String teclado = read.readLine();
                try {
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
                                        + "¿Desea modificar el precio de este libro?\n"
                                        + " [1] Sí\n"
                                        + " [0] No");
                                int me = Validaciones.menu(0, 1);
                                System.out.println();
                                if (me == 1) {
                                    do {
                                        er = 0;
                                        System.out.println("Introduce el nuevo precio;");
                                        try {
                                            precio = Float.parseFloat(read.readLine());
                                            System.out.println("\nModificación realizada con éxito\n");
                                        } catch (NumberFormatException e) {
                                            er = 1;
                                            System.out.println("\nERROR: Entrada no válida\n");
                                        }
                                    } while (er == 1);
                                    autor.getLibro().get(i).setPrecio(precio);
                                } else {
                                    System.out.println("Operación cancelada\n");
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
                ois.close();
                oos.close();
                fichero.delete();
                temp.renameTo(fichero);

                System.out.println("¿Desea modificar otro libro?\n"
                        + " [1] Sí \n"
                        + " [0] No");
                op = Validaciones.menu(0, 1);
                System.out.println();
            } while (op != 0);
        } else {
            System.out.println("ERROR: No hay ningún fichero registrado en nuestra base de datos");
        }

    }

}
