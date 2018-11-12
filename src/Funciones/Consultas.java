/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Objetos.CAutores;
import java.io.*;

/**
 *
 * @author mallo
 */
public class Consultas implements Fichero, Leer {

    static void lista() throws IOException {
        ObjectInputStream ois = null;
        if (fichero.exists()) {
            System.out.println("\n"
                    + "                       VISUALIZACIONES                         \n"
                    + "============================================================");
            System.out.printf("%1$-10s | %2$-35s | %3$-10s%n", "DNI", "NOMBRE", "CIUDAD");
            try {
                ois = new ObjectInputStream(new FileInputStream(fichero));
                CAutores autor;
                do {
                    autor = (CAutores) ois.readObject();
                    System.out.printf("%1$-10s | %2$-35s | %3$-10s%n", autor.getDni(), autor.getNombre(), autor.getCiudad());
                    if (!autor.getLibro().isEmpty()) {
                        System.out.println(""
                                + "---------------------------OBRAS----------------------------");
                        System.out.printf("%1$-10s | %2$-35s | %3$-10s%n", "ISBN", "TITULO", "PRECIO");
                    }
                    for (int i = 0; i < autor.getLibro().size(); i++) {
                        System.out.printf("%1$-10s | %2$-35s | %3$-6.2f€%n", autor.getLibro().get(i).getIsbn(), autor.getLibro().get(i).getTitulo(), autor.getLibro().get(i).getPrecio());
                    }
                    System.out.println("------------------------------------------------------------");
                } while (true);
            } catch (EOFException e) {
                System.out.println("\n                      Fin de la lista     \n");
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            ois.close();
        } else {
            System.out.println("ERROR: No hay ningún fichero registrado en nuestra base de datos");
        }
    }

    static void autor() throws IOException, ClassNotFoundException {
        if (fichero.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            CAutores autor = null;
            boolean en = false;
            System.out.println("Nombre del autor a consultar:");
            String teclado = read.readLine();
            try {
                do {
                    autor = (CAutores) ois.readObject();
                    if (teclado.compareToIgnoreCase(autor.getNombre()) == 0) {
                        en = true;
                        System.out.println("\n"
                                + "                       VISUALIZACIONES                         \n"
                                + "============================================================");
                        System.out.printf("%1$-10s | %2$-35s | %3$-10s%n", "DNI", "NOMBRE", "CIUDAD");
                        System.out.printf("%1$-10s | %2$-35s | %3$-10s%n", autor.getDni(), autor.getNombre(), autor.getCiudad());
                        System.out.println(""
                                + "---------------------------OBRAS----------------------------");
                        if (autor.getLibro().isEmpty()) {
                            System.out.println("                No hay obras registrada     ");
                        } else {
                            System.out.printf("%1$-10s | %2$-35s | %3$-10s%n", "ISBN", "TITULO", "PRECIO");
                        }
                        for (int i = 0; i < autor.getLibro().size(); i++) {
                            System.out.printf("%1$-10s | %2$-35s | %3$-6.2f€%n", autor.getLibro().get(i).getIsbn(), autor.getLibro().get(i).getTitulo(), autor.getLibro().get(i).getPrecio());
                        }
                        System.out.println();
                    }
                } while (true);
            } catch (EOFException e) {
                if (en == false) {
                    System.out.println("\nERROR: El autor no se encuentra registrado en nuestra base de datos\n");
                }
            }
            ois.close();
        } else {
            System.out.println("ERROR: No hay ningún fichero registrado en nuestra base de datos");
        }
    }

    static void ciudad() throws IOException, ClassNotFoundException {
        if (fichero.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            CAutores autor = null;
            boolean en = false;
            System.out.println("Ciudad a consultar:");
            String teclado = read.readLine();
            try {
                System.out.println("\n"
                        + "                       VISUALIZACIONES                         \n"
                        + "============================================================");
                do {
                    autor = (CAutores) ois.readObject();
                    if (teclado.compareToIgnoreCase(autor.getCiudad()) == 0) {
                        en = true;
                        System.out.printf("%1$-10s | %2$-35s | %3$-10s%n", "DNI", "NOMBRE", "CIUDAD");
                        System.out.printf("%1$-10s | %2$-35s | %3$-10s%n", autor.getDni(), autor.getNombre(), autor.getCiudad());
                        System.out.println(""
                                + "---------------------------OBRAS----------------------------");
                        if (autor.getLibro().isEmpty()) {
                            System.out.println("                No hay obras registrada     ");
                        } else {
                            System.out.printf("%1$-10s | %2$-35s | %3$-10s%n", "ISBN", "TITULO", "PRECIO");
                        }
                        for (int i = 0; i < autor.getLibro().size(); i++) {
                            System.out.printf("%1$-10s | %2$-35s | %3$-6.2f€%n", autor.getLibro().get(i).getIsbn(), autor.getLibro().get(i).getTitulo(), autor.getLibro().get(i).getPrecio());
                        }
                        System.out.println("------------------------------------------------------------");
                    }
                } while (true);
            } catch (EOFException e) {
                if (en == false) {
                    System.out.println("\nERROR: La ciudad no se encuentra registrada en nuestra base de datos\n");
                }
            }
            ois.close();
        } else {
            System.out.println("ERROR: No hay ningún fichero registrado en nuestra base de datos");
        }
    }

    static void libroSuperior() throws FileNotFoundException, IOException, ClassNotFoundException {
        if (fichero.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            CAutores autor = null;
            boolean en = false;
            int c = 0;
            System.out.println("Precio mínimo de los libros:");
            float teclado = Float.parseFloat(read.readLine());
            try {
                System.out.println("\n"
                        + "                       VISUALIZACIONES                         \n"
                        + "=====================================================================");
                do {
                    autor = (CAutores) ois.readObject();
                    for (int i = 0; i < autor.getLibro().size(); i++) {
                        if (autor.getLibro().get(i).getPrecio() > teclado) {
                            en = true;
                            if (c == 0) {
                                System.out.printf("%1$-5s | %2$-31s | %3$-20s | %4$-10s%n", "ISBN", "TITULO", "AUTOR", "PRECIO");
                            }
                            System.out.printf("%1$-5s | %2$-31s | %3$-20s | %4$-6.2f€%n", autor.getLibro().get(i).getIsbn(), autor.getLibro().get(i).getTitulo(), autor.getNombre(), autor.getLibro().get(i).getPrecio());
                            c++;
                        }
                    }
                } while (true);
            } catch (EOFException e) {
                if (en == false) {
                    System.out.println("\nERROR: No hay libros que superen ese precio en nuestra base de datos\n");
                }
            }
            ois.close();
        } else {
            System.out.println("ERROR: No hay ningún fichero registrado en nuestra base de datos");
        }
    }

    static void libro() throws FileNotFoundException, IOException, ClassNotFoundException {

        if (fichero.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            CAutores autor;
            System.out.println("\n"
                    + "                          LIBROS                         \n"
                    + "============================================================");
            System.out.printf("%1$-10s | %2$-35s | %3$-10s%n", "ISBN", "TITULO", "PRECIO");
            try {
                autor = (CAutores) ois.readObject();
                for (int i = 0; i < autor.getLibro().size(); i++) {
                    System.out.printf("%1$-10s | %2$-35s | %3$-6.2f€%n", autor.getLibro().get(i).getIsbn(), autor.getLibro().get(i).getTitulo(), autor.getLibro().get(i).getPrecio());
                }
            } catch (EOFException e) {
                System.out.println();
                ois.close();
            }
        } else {
            System.out.println("ERROR: No hay ningún fichero registrado en nuestra base de datos");
        }

    }

}
