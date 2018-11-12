/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author mallo
 */
public class misExcepciones extends Exception {

    private String error;

    public misExcepciones() {
        super();
    }

    public misExcepciones(String message) {
        super(message);
        this.error = message;
    }

    public String getError() {
        return error;
    }
}
