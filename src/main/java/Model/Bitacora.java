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
   String accion = " ";
   Usuario usuario;
   long Fecha = 0;
   String Detalle = " ";
   
   
   public Bitacora(long idBitacora, Reserva reserva, String accion, Usuario usuario, long Fecha, String Detalle  ){
   this.idBitacora = idBitacora;
   this.reserva = reserva;
   this.accion = accion;
   this.usuario= usuario;
   this.Fecha=Fecha; 
   this.Detalle= Detalle;
   }
   
}