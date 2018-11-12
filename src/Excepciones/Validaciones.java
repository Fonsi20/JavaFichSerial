package Excepciones;

import Funciones.Fichero;
import Funciones.Leer;
import Objetos.CAutores;
import Objetos.CLibros;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author mallo
 */
public class Validaciones implements Leer, Fichero {

    public static int menu(int i, int z) throws IOException {

        int op = 0, er = 0;
        do {
            er = 0;
            try {
                op = Integer.parseInt(read.readLine());
                if (op > z || op < i) {
                    er = 1;
                    System.out.println("\nERROR: Opción no disponible\n\nSeleccione otra opción:");
                }
            } catch (NumberFormatException e) {
                er = 1;
                System.out.println("\nERROR: Entrada no válida\n\nSeleccione otra opción:");
            }
        } while (er == 1);
        return op;

    }

    public static int dni(String dni) throws IOException, ClassNotFoundException {

        int er = 0;
        try {
            if (dni.length() != 9) {
                er = 1;
                throw new misExcepciones("\nERROR: Longitud no válida. El DNI debe tener 9 caracteres de largo\n");
            }
            if (!dni.substring(0, 8).matches("[0-9]*")) {
                er = 1;
                throw new misExcepciones("\nERROR: Entrada no válida. Los primeros 8 dígitos del DNI deben ser caracteres numéricos\n");
            }
            if (!dni.substring(8).matches("[A-Za-z]")) {
                er = 1;
                throw new misExcepciones("\nERROR: Entrada no válida. El último dígito debe ser una letra\n");
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            CAutores autor;
            do {
                autor = (CAutores) ois.readObject();
                if (dni.compareToIgnoreCase(autor.getDni()) == 0) {
                    er = 1;
                    throw new misExcepciones("\nERROR: El autor ya se encuentra registado en nuestra base de datos\n");
                }
            } while (true);
        } catch (EOFException e) {
        } catch (misExcepciones e) {
            System.out.println(e.getMessage());
        }
        return er;

    }

    public static int isbn(String isbn) throws IOException, ClassNotFoundException {

        int er = 0;
        try {
            if (isbn.length() != 4) {
                er = 1;
                throw new misExcepciones("\nERROR: Longitud no válida. El ISBN debe tener 4 caracteres de largo\n");
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            CLibros libro;
            do {
                libro = (CLibros) ois.readObject();
                if (isbn.compareToIgnoreCase(libro.getIsbn()) == 0) {
                    er = 1;
                    throw new misExcepciones("\nERROR: El libro ya se encuentra registado en nuestra base de datos\n");
                }
            } while (true);
        } catch (EOFException e) {
        } catch (misExcepciones e) {
            System.err.println(e.getMessage());
        }
        return er;
    }
}
