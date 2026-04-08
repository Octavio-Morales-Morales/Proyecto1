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
    Recursos recurso;
    long fechaInicio = 0;
    long fechaFin = 0;
    boolean estado;
    String motivo = " ";
    
public Reserva(long idReserva, Usuario usuario, Recursos recurso, long fechaInicio, long fechaFin, boolean estado, String motivo     ){
  this.idReserva = idReserva;
  this.usuario = usuario;
  this.recurso = recurso;
  this.fechaInicio = fechaInicio;
  this.fechaFin = fechaFin;
  this.estado = estado;
  this.motivo = motivo;
  
}

     
}
