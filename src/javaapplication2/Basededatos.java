/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Basededatos {

    protected static Connection conn;
    private static final String ruta = "jdbc:mysql://localhost:3306/dbventastec";
    private static final String root = "root";
    private static final String passw = "";

    protected static final Connection conectar() {
        boolean res = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    ruta, root, passw);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Basededatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Basededatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    protected static final void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Basededatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
