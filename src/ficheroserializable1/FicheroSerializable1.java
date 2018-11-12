/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroserializable1;

import Fichero.CrearFichero;
import Funciones.*;
import java.io.IOException;

/**
 *
 * @author mallo
 */
public class FicheroSerializable1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int op = 0;
        do {
            op = Menus.menuPrincipal();
            switch (op) {
                case 1:
                    CrearFichero.crear();
                    break;
                case 2:
                    Menus.menuAltas();
                    break;
                case 3:
                    Modificaciones.modificaciones();
                    break;
                case 4:
                    Bajas.bajas();
                    break;
                case 5:
                    Menus.consultas();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (op != 0);
    }

}
