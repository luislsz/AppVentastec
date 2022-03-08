
package javaapplication2;

public interface ItfDetalleCompra {
           String getNombreprovee();
           void setNombreprovee(String nombreprovee);
           Integer getIdproveedor();
           void setIdproveedor(Integer idproveedor);
           Integer getCantidadDetalle();
           void setCantidadDetalle(Integer cantidadDetalle);
           Integer getProducto_idproducto();
           void setProducto_idproducto(Integer producto_idproducto);
           Double getSubtotal();
           String getNombreproduc();
           void setNombreproduc(String nombreproduc);
           void setSubtotal(Double subtotal);
           String getCompra_codigoCompra();
           void setCompra_codigoCompra(String compra_codigoCompra);
}
