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

public class Producto extends Thread implements ItfProducto{

    private Integer stock = null;
    private Integer idProducto = null;
    private String nombre = null, descripcion = null, marca = null, modelo = null, tipo = null, gama = null, procesador = null, memoriaInterna = null, memoriaExterna = null;
    private Double valor = null;
    static final private String sqlinsert = "insert into producto(nombre, descripcion, stock, valor, marca, modelo, tipo, gama, procesador, memoriaInterna, memoriaExterna) values(?,?,?,?,?,?,?,?,?,?,?)";
    static final private String sqlupdate = "update producto set nombre=?, descripcion=?, stock=?, valor=?, marca=?, modelo=?, tipo=?, gama=?, procesador=?, memoriaInterna=?, memoriaExterna=? where idproducto=?";
    static final private String sqldelete = "delete from producto where idproducto=?";
    public static Producto instancia = null;

    public Producto() {
    }

    public final static Producto getInstance() {
        if (instancia == null) {
            instancia = new Producto();
        }
        return instancia;
    }
@Override
    public Integer getStock() {
        return stock;
    }
@Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }
@Override
    public Integer getIdProducto() {
        return idProducto;
    }
@Override
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
@Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
@Override
    public String getDescripcion() {
        return descripcion;
    }
@Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
@Override
    public String getMarca() {
        return marca;
    }
@Override
    public void setMarca(String marca) {
        this.marca = marca;
    }
@Override
    public String getModelo() {
        return modelo;
    }
@Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
@Override
    public String getTipo() {
        return tipo;
    }
@Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
@Override
    public String getGama() {
        return gama;
    }
@Override
    public void setGama(String gama) {
        this.gama = gama;
    }
@Override
    public String getProcesador() {
        return procesador;
    }
@Override
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
@Override
    public String getMemoriaInterna() {
        return memoriaInterna;
    }
@Override
    public void setMemoriaInterna(String memoriaInterna) {
        this.memoriaInterna = memoriaInterna;
    }
@Override
    public String getMemoriaExterna() {
        return memoriaExterna;
    }
@Override
    public void setMemoriaExterna(String memoriaExterna) {
        this.memoriaExterna = memoriaExterna;
    }
@Override
    public Double getValor() {
        return valor;
    }
@Override
    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public void run() {
    Basededatos bd= Basededatos.getInstance();
        if (bd.conectar() != null) {

            if (new ClaseEstado().estadoReg() == true && idProducto == 0) {
                try {

                    PreparedStatement ps = bd.conn.
                            prepareStatement(sqlinsert);

                    ps.setString(1, nombre);
                    ps.setString(2, descripcion);
                    ps.setInt(3, stock);
                    ps.setDouble(4, valor);
                    ps.setString(5, marca);
                    ps.setString(6, modelo);
                    ps.setString(7, tipo);
                    ps.setString(8, gama);
                    ps.setString(9, procesador);
                    ps.setString(10, memoriaInterna);
                    ps.setString(11, memoriaExterna);
                    ps.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    bd.desconectar();
                    nombre = null;
                }
            } else if (new ClaseEstado().estadoElim() == true && idProducto > 0) {
                if (0 == JOptionPane.showConfirmDialog(null, "confirmar")) {
                    try {
                        PreparedStatement ps = bd.conn.
                                prepareStatement(sqldelete);
                        ps.setInt(1, idProducto);
                        ps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        bd.desconectar();
                        idProducto = 0;
                    }

                }
            } else if (new ClaseEstado().estadoAct() == true && null != nombre && (idProducto > 0 && !"".equals(nombre))) {
                try {
                    PreparedStatement ps = bd.conn.
                            prepareStatement(sqlupdate);
                    ps.setString(1, nombre);
                    ps.setString(2, descripcion);
                    ps.setInt(3, stock);
                    ps.setDouble(4, valor);
                    ps.setString(5, marca);
                    ps.setString(6, modelo);
                    ps.setString(7, tipo);
                    ps.setString(8, gama);
                    ps.setString(9, procesador);
                    ps.setString(10, memoriaInterna);
                    ps.setString(11, memoriaExterna);
                    ps.setInt(12, idProducto);
                    ps.executeUpdate();
                    idProducto = 0;
                } catch (SQLException vc) {
                    Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, vc);
                } finally {
                    bd.desconectar();
                    nombre = null;
                }
            }
        }

        try {
            this.stop();

        } catch (Exception th) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, th);
        }

    }

}
