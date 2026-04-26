/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;
/**
 *
 * @author moral
 */
public class Reserva {
    long idReserva =0;
    Usuario usuario ;
    Date fechaInicio;
    Date fechaFin;
    String estadoreserva= "";
    String motivo = " ";
    long RecursoID =0;
    
public Reserva(long idReserva, Usuario usuario, Date fechaInicio, Date fechaFin, String estadoreserva, String motivo, long RecursoID){
  this.idReserva = idReserva;
  this.usuario = usuario;
  this.fechaInicio = fechaInicio;
  this.fechaFin = fechaFin;
  this.estadoreserva = estadoreserva;
  this.motivo = motivo;
  this.RecursoID = RecursoID;
  
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
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getEstadoreserva() {
        return estadoreserva;
    }
   public void setEstadoreserva(String estadoreserva){
       this.estadoreserva = estadoreserva;
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
    
      public long getRecursoID() {
        return idReserva;
    }

    public void setRecursoID(long RecursoID) {
        this.RecursoID = RecursoID;
    }
     
}
