/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import javax.swing.JOptionPane;

public class ClaseMensaje {

    private final static String noencontrado = "parametros no encontrados";
    private final static String error = "error en el envio o procesamiento de los parametros ";
    private final static String aprovado = "registro exitoso";
    private final static String eliminado = "eliminado exitoso";
    private final static String actualizado = "cambios exitosos";

    public static final void miMensajeAprovado() {
        JOptionPane.showMessageDialog(null, aprovado, "mensaje", 1);
    }

    public static final void miMensajeEliminado() {
        JOptionPane.showMessageDialog(null, eliminado, "mensaje", 2);
    }

    public static final void miMensajeActualizado() {
        JOptionPane.showMessageDialog(null, actualizado, "mensaje", 1);
    }

    public static final void miMensajeError() {
        JOptionPane.showMessageDialog(null, error, "mensaje", 0);
    }

    public static final void miMensajeNoEncontrado() {
        JOptionPane.showMessageDialog(null, noencontrado, "mensaje", 2);
    }
}
