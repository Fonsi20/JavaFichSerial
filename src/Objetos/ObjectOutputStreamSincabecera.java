/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author mallo
 */
public class ObjectOutputStreamSincabecera extends ObjectOutputStream {

    public ObjectOutputStreamSincabecera(OutputStream out) throws IOException {

        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        //borro la cabezera del siguiente objeto
        this.reset();
    }

}
