/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Md5 implements ItfMd{

    @Override
    public String getEncoddedString(String texto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(texto.getBytes());
            byte[] hash = digest.digest();
            String encodded = toHexadecimal(hash);        
            return encodded;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Md5.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//private como predeterminado
    @Override
    public String toHexadecimal(byte[] datos) {
        String resultado = "";
        ByteArrayInputStream input = new ByteArrayInputStream(datos);
        String cadAux;
        boolean ult0 = false;
        int leido = input.read();
        while (leido != -1) {
            cadAux = Integer.toHexString(leido);
            if (cadAux.length() < 2) { //Hay que a�adir un 0
                resultado += "0";
                if (cadAux.length() == 0) {
                    ult0 = true;
                }
            } else {
                ult0 = false;
            }
            resultado += cadAux;
            leido = input.read();
        }
        if (ult0)//quitamos el 0 si es un caracter aislado
        {
            resultado =
                    resultado.substring(0, resultado.length() - 2) + resultado.charAt(resultado.length() - 1);
        }
        return resultado;
    }
}
