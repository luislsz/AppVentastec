package javaapplication2;

public interface ItfProducto {
    
    Integer getStock();
    void setStock(Integer stock);
    Integer getIdProducto();
    void setIdProducto(Integer idProducto);
    String getNombre();
    void setNombre(String nombre);
    String getDescripcion();
    void setDescripcion(String descripcion);
    String getMarca();
    void setMarca(String marca);
    String getModelo();
    void setModelo(String modelo);
    String getTipo();
    void setTipo(String tipo);
    String getGama();
    void setGama(String gama);
    String getProcesador();
    void setProcesador(String procesador);
    String getMemoriaInterna();
    void setMemoriaInterna(String memoriaInterna);
    String getMemoriaExterna();
    void setMemoriaExterna(String memoriaExterna);
    Double getValor();
    void setValor(Double valor);
    void run();
}
