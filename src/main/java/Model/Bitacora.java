/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moral
 */
public class Bitacora {
   long idBitacora = 0;
   Reserva reserva;
   
   Usuario usuario;
   String Estado= "";
   String Detalle = " ";
   
   public Bitacora(){}
   
   public Bitacora(long idBitacora, Reserva reserva, Usuario usuario,String Estado, String Detalle  ){
   this.idBitacora = idBitacora;
   this.reserva = reserva;

   this.usuario= usuario;
   this.Estado=Estado; 
   this.Detalle= Detalle;
   }
    public long getidBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(int idBitacora) {
        this.idBitacora = idBitacora;
    }
    public Reserva getreservaBitacora() {
        return reserva;
    }

    public void setIdreservaBitacora(Reserva reserva) {
        this.reserva = reserva;
    }
    public String getEstadoBitacora() {
        return Estado;
    }

    public void setEstadoBitacora(String accion) {
        this.Estado = accion;
    }
    public Usuario getUsuarioBitacora() {
        return usuario;
    }

    public void setUsuarioBitacora(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDetalleBitacora() {
        return Detalle;
    }

    public void setDetalleBitacora(String Detalle) {
        this.Detalle = Detalle;
    }
    
   

}