/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

public class DetalleVenta implements ItfDetalleVenta {

    private Integer cantidadDetalle = null, idDetalle = null, producto_idproducto = null;
    private Double subtotal = null;
    private String ventas_codigoVentas = null, nombreproducto = null;
    public static DetalleVenta instancia = null;

    public DetalleVenta() {
    }

    public final static DetalleVenta getInstance() {
        if (instancia == null) {
            instancia = new DetalleVenta();
        }
        return instancia;
    }

    DetalleVenta(int cant, double subtotal1, int idproducto, String nomproducto, String codigoFactura) {
        cantidadDetalle = cant;
        subtotal = subtotal1;
        producto_idproducto = idproducto;
        ventas_codigoVentas = codigoFactura;
        nombreproducto = nomproducto;
    }
    @Override
    public Integer getCantidadDetalle() {
        return cantidadDetalle;
    }
    @Override
    public Double getSubtotal() {
        return subtotal;
    }
    @Override
    public String getVentas_codigoVentas() {
        return ventas_codigoVentas;
    }
    @Override
    public Integer getProducto_idproducto() {
        return producto_idproducto;
    }
    @Override
    public String getNombreproducto() {
        return nombreproducto;
    }

}
