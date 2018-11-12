/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fichero;

import Excepciones.Validaciones;
import Funciones.Fichero;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author mallo
 */
public class CrearFichero implements Fichero {

    public static void crear () throws IOException {
        ObjectOutputStream oos; //Se crea/abre el flujo de datos

        if (fichero.exists()) {
            System.out.println("\nATENCIÓN:\nYa existe un fichero registrado en nuestra base de datos. ¿Desea sobreescribirlo?\n"
                    + " [1] Sí\n"
                    + " [0] No");
            int op = Validaciones.menu(0, 1);
            
            if (op == 1) {
                oos = new ObjectOutputStream (new FileOutputStream(fichero)); //Se crea el fichero
                oos.close(); //Se cierra el flujo de datos
                System.out.println("\nFichero creado con éxito    \n");
                
            } else {
                System.out.println("\nOperación cancelada\n");
            }
        } else {
            oos = new ObjectOutputStream (new FileOutputStream(fichero));
            oos.close();
            System.out.println("\nFichero creado con éxito    \n");
        }

    }

}
