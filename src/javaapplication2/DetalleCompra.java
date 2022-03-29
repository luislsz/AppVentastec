/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

public class DetalleCompra implements ItfDetalleCompra {

    private Integer idDetalle = null, cantidadDetalle = null, producto_idproducto = null, idproveedor = null;
    private Double subtotal = null;
    private String compra_codigoCompra = null, nombreproduc = null, nombreprovee = null;
    public static DetalleCompra instancia = null;

    DetalleCompra(int t, double d, int idproducto, String nombreprod, String codigoFactura, int idproveedor1, String toString) {
        cantidadDetalle = t;
        subtotal = d;
        producto_idproducto = idproducto;
        compra_codigoCompra = codigoFactura;
        nombreproduc = nombreprod;
        idproveedor = idproveedor1;
        nombreprovee = toString;

    }

    public DetalleCompra() {
    }

    public final static DetalleCompra getInstance() {
        if (instancia == null) {
            instancia = new DetalleCompra();
        }
        return instancia;
    }
    @Override
    public String getNombreprovee() {
        return nombreprovee;
    }
    @Override
    public void setNombreprovee(String nombreprovee) {
        this.nombreprovee = nombreprovee;
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
    public Integer getCantidadDetalle() {
        return cantidadDetalle;
    }
    @Override
    public void setCantidadDetalle(Integer cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }
    @Override
    public Integer getProducto_idproducto() {
        return producto_idproducto;
    }
    @Override
    public void setProducto_idproducto(Integer producto_idproducto) {
        this.producto_idproducto = producto_idproducto;
    }
    @Override
    public Double getSubtotal() {
        return subtotal;
    }
    @Override
    public String getNombreproduc() {
        return nombreproduc;
    }
    @Override
    public void setNombreproduc(String nombreproduc) {
        this.nombreproduc = nombreproduc;
    }
    @Override
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    @Override
    public String getCompra_codigoCompra() {
        return compra_codigoCompra;
    }
    @Override
    public void setCompra_codigoCompra(String compra_codigoCompra) {
        this.compra_codigoCompra = compra_codigoCompra;
    }
}
