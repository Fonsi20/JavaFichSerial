/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Excepciones.Validaciones;
import Objetos.CAutores;
import Objetos.CLibros;
import Objetos.ObjectOutputStreamSincabecera;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author mallo
 */
public class Menus implements Leer, Fichero {

    public static int menuPrincipal() throws IOException {
        System.out.println("\n"
                + "                         BIENVENIDO                         \n"
                + "============================================================\n"
                + "Seleccione una opción: \n"
                + " \t[1] - Crear fichero\n"
                + " \t[2] - Registros\n"
                + " \t[3] - Modificaciones de libros\n"
                + " \t[4] - Bajas de libros \n"
                + " \t[5] - Consultas \n"
                + " \t[0] - Salir");
        int op = Validaciones.menu(0, 5);
        System.out.println();
        return op;
    }

    public static void menuAltas() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos;
        int opc = 0;
        if (fichero.exists()) {
            do {
                System.out.println("\n"
                        + "                         ALTAS                        \n"
                        + "============================================================\n"
                        + "Seleccione una opción: \n"
                        + " \t[1] - Altas Autores\n"
                        + " \t[2] - Altas Libros\n"
                        + " \t[0] - Salir\n");

                opc = Validaciones.menu(0, 2);

                if (opc == 1) {
                    oos = new ObjectOutputStreamSincabecera(new FileOutputStream(fichero, true));  //Este flujo solo se abre en las altas
                    CAutores autor = null;
                    autor = Altas.altasAutores(autor);
                    oos.writeObject(autor);
                    oos.close();
                }
                if (opc == 2) {
                    System.out.println("\n--- EN CONSTRUCCION ---\n");
                    //Altas.altasLibro();
                }
                if (opc == 0) {
                    System.out.println("\n--- Volvemos al menú princila ---\n");
                } else {
                    System.err.println("ERROR - Selecciona una opción válida");
                }
            } while (opc != 0);

        } else {
            System.out.println("ERROR: No hay ningún fichero registrado en nuestra base de datos");
        }

    }

    public static void consultas() throws IOException, FileNotFoundException, ClassNotFoundException {
        int op = 0;
        do {
            System.out.println("\n"
                    + "                       VISUALIZACIONES                         \n"
                    + "============================================================");
            System.out.println(
                    "Seleccione una opción: \n"
                    + " [1] Lista completa\n"
                    + " [2] Lista de libros\n"
                    + " [3] Consulta por autor\n"
                    + " [4] Consulta por ciudad\n"
                    + " [5] Consulta por precio\n"
                    + " [0] Retroceder");
            op = Validaciones.menu(0, 5);
            System.out.println();
            switch (op) {
                case 1:
                    Consultas.lista();
                    break;
                case 2:
                    Consultas.libro();
                    break;
                case 3:
                    Consultas.autor();
                    break;
                case 4:
                    Consultas.ciudad();
                    break;
                case 5:
                    Consultas.libroSuperior();
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }
}
