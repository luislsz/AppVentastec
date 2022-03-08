package javaapplication2;

import java.util.List;

public interface ItfFrmInventario {

    void setLdcfinal(List<DetalleCompra> ldcfinal);

    void setLdvfinal(List<DetalleVenta> ldvfinal);

    void evaltextYnum(java.awt.event.KeyEvent tyea);

    void evalnumdec(java.awt.event.KeyEvent ohynu);
    
    void evalnum(java.awt.event.KeyEvent ohynu);
    
    public void carga();
}
