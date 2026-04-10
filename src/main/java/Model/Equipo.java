/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moral
 */
public class Equipo{
    long idEquipo=0;
    String NombreEquipo ="";
    String marca = "";
    String Serie = "";
    String DescripEquipo="";
    String estado= "";
    Reserva idReserva;
    public Equipo(){}
    
    public Equipo(long idEquipo, String NombreEquipo, String DescripEquipo, String estado, String marca, String Serie, Reserva idReserva ) {
        this.idEquipo= idEquipo;
        this.NombreEquipo= NombreEquipo;
        this.DescripEquipo= DescripEquipo;
        this.estado= estado;
        this.marca = marca;
        this.Serie = Serie;
        this.idReserva = idReserva;
        
    }
      public long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }
    public String getNombreEquipo() {
        return NombreEquipo;
    }

    public void setNombreEquipo(String NombreEquipo) {
        this.NombreEquipo = NombreEquipo;
    }
    public String getDescripEquipo() {
        return DescripEquipo;
    }

    public void setDescripEquipo(String DescripEquipo) {
        this.DescripEquipo = DescripEquipo;
    }
    public String getEstadoEquipo() {
        return estado;
    }

    public void setEstadoEquipo(String estado) {
        this.estado = estado;
    }
    public String getMarcaEquipo() {
        return marca;
    }

    public void setMarcaEquipo(String marca) {
        this.marca = marca;
    }
    public String getSerieEquipo() {
        return Serie;
    }

    public void setSerieEquipo(String Serie) {
        this.Serie = Serie;
    }
    public Reserva getIdReservaEquipo() {
        return idReserva;
    }

    public void setIdReservaEquipo(Reserva idReserva) {
        this.idReserva = idReserva;
    }

   
    
}
