/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Proveedor extends Thread implements ItfProveedor{

    private Integer idproveedor = null;
    private String nombreprov = null, Concepto = null;
    static final private String sqlinsert = "insert into proveedor(nombre,concepto) values(?,?)";
    static final private String sqldelete = "delete from proveedor where idproveedor=?";
    public static Proveedor instancia = null;

    public Proveedor() {
    }

    public final static Proveedor getInstance() {
        if (instancia == null) {
            instancia = new Proveedor();
        }
        return instancia;
    }
@Override
    public Integer getIdproveedor() {
        return idproveedor;
    }
@Override
    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }
@Override
    public String getNombreprov() {
        return nombreprov;
    }
@Override
    public void setNombreprov(String nombreprov) {
        this.nombreprov = nombreprov;
    }
@Override
    public String getConcepto() {
        return Concepto;
    }
@Override
    public void setConcepto(String Concepto) {
        this.Concepto = Concepto;
    }

    @Override
    public void run() {
         Basededatos bd= Basededatos.getInstance();
        if (bd.conectar() != null) {
            if (new ClaseEstado().estadoReg() == true && idproveedor == 0) {
                try {
                    PreparedStatement ps = bd.conn.
                            prepareStatement(sqlinsert);

                    ps.setString(1, nombreprov);
                    ps.setString(2, Concepto);
                    ps.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    bd.desconectar();

                }
            } else if (new ClaseEstado().estadoElim() == true && idproveedor > 0) {
                if (0 == JOptionPane.showConfirmDialog(null, "confirmar")) {
                    try {
                        PreparedStatement ps = bd.conn.
                                prepareStatement(sqldelete);
                        ps.setInt(1, idproveedor);
                        ps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        bd.desconectar();
                        idproveedor = 0;
                    }

                }
            }

        }
        try {
            this.stop();

        } catch (Exception ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
