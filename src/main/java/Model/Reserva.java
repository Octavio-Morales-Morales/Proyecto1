/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moral
 */
public class Reserva {
    long idReserva =0;
    Usuario usuario ;
    long fechaInicio = 0;
    long fechaFin = 0;
    String estadoreserva= "";
    String motivo = " ";
    
public Reserva(long idReserva, Usuario usuario, long fechaInicio, long fechaFin, String estadoreserva, String motivo     ){
  this.idReserva = idReserva;
  this.usuario = usuario;
  this.fechaInicio = fechaInicio;
  this.fechaFin = fechaFin;
  this.estadoreserva = estadoreserva;
  this.motivo = motivo;
  
}
      public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public long getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(long fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public long getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(long fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getEstadoreserva() {
        return estadoreserva;
    }

    public void setcapacidadEspacio(String estadoreserva) {
        this.estadoreserva = estadoreserva;
    }
    public String getMotivoReserva() {
        return motivo;
    }

    public void setMotivoReserva(String motivo) {
        this.motivo = motivo;
    }
    

     
}
