
package javaapplication2;

public interface ItfCliente {
   Integer getIdcliente();
   void setIdcliente(Integer idcliente);
   String getCedula();
   void setCedula(String cedula);
   String getCorreo();
   void setCorreo(String correo);
   String getNombres();
   void setNombres(String nombres);
   String getApellidos();
   void setApellidos(String apellidos);
   String getTelefono() ;
   void setTelefono(String telefono);
   void run();
}
