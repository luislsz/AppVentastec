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

public class Cliente extends Thread implements ItfCliente {

    private Integer idcliente = null;
    private String cedula = null, correo = null, nombres = null, apellidos = null, telefono = null;
    static final private String sqlinsert = "insert into cliente(idcliente, cedula, correo, nombres, apellidos,telefono) values(?,?,?,?,?,?)";
    static final private String sqlupdate = "update cliente set cedula=?, correo=?, nombres=?, apellidos=?,telefono=? where idcliente=?";
    static final private String sqldelete = "delete from cliente where idcliente=?";
    public static Cliente instancia=null;

    

    public final static Cliente getInstance(){
    if (instancia == null) {
            instancia = new Cliente();
        }
        return instancia;
    }
    @Override
    public Integer getIdcliente() {
        return idcliente;
    }
@Override
    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }
@Override
    public String getCedula() {
        return cedula;
    }
@Override
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
@Override
    public String getCorreo() {
        return correo;
    }
@Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }
@Override
    public String getNombres() {
        return nombres;
    }
@Override
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
@Override
    public String getApellidos() {
        return apellidos;
    }
@Override
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
@Override
    public String getTelefono() {
        return telefono;
    }
@Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public void run() {
        Basededatos bd= Basededatos.getInstance();
        Md5 desencrip = new Md5();
        String cript = desencrip.getEncoddedString(cedula);
        if (bd.conectar() != null) {
            if (new ClaseEstado().estadoReg() == true && idcliente == 0) {
                try {

                    PreparedStatement ps = bd.conn.
                            prepareStatement(sqlinsert);

                    ps.setInt(1, idcliente);
                    ps.setString(2, cript);
                    ps.setString(3, correo);
                    ps.setString(4, nombres);
                    ps.setString(5, apellidos);
                    ps.setString(6, telefono);
                    ps.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    bd.desconectar();

                }
            } else if (new ClaseEstado().estadoElim() == true && (idcliente > 0 && null == correo && null == cedula)) {
                if (0 == JOptionPane.showConfirmDialog(null, "confirmar")) {
                    try {
                        PreparedStatement ps = bd.conn.
                                prepareStatement(sqldelete);
                        ps.setInt(1, idcliente);
                        ps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        bd.desconectar();
                        idcliente = 0;
                    }

                }
            } else if (new ClaseEstado().estadoAct() == true && (idcliente > 0 && null != cedula && "" != cedula)) {
                try {
                    PreparedStatement ps = bd.conn.
                            prepareStatement(sqlupdate);

                    ps.setString(1, cript);
                    ps.setString(2, correo);
                    ps.setString(3, nombres);
                    ps.setString(4, apellidos);
                    ps.setString(5, telefono);
                    ps.setInt(6, idcliente);
                    ps.executeUpdate();
                    idcliente = 0;
                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    bd.desconectar();

                }
            }
        }
        try {
            this.stop();

        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
