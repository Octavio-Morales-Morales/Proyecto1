/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moral
 */
public class Espacio {
    long idEspacio=0;
    String NombreEspacio = "";
    String DescripEspacio = "";
    String estado = "";
    int capacidad = 0;
    String ubicacion = "";
    Reserva idReserva;
    public Espacio(){}
    public Espacio(long idEspacio, String NombreEspacio, String DescripEspacio, String estado, int capacidad,String ubicacion, Reserva idReserva ) {
        this.idEspacio= idEspacio;
        this.NombreEspacio= NombreEspacio;
        this.DescripEspacio= DescripEspacio;
        this.estado= estado;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.idReserva = idReserva;
    }
    
      public long getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(long idEspacio) {
        this.idEspacio = idEspacio;
    }
    public String getNombreEspacio() {
        return NombreEspacio;
    }

    public void setNombreEspacio(String NombreEspacio) {
        this.NombreEspacio = NombreEspacio;
    }
    public String getDescripEspacio() {
        return DescripEspacio;
    }

    public void setDescripEspacio(String DescripEspacio) {
        this.DescripEspacio = DescripEspacio;
    }
    public String getEstadoEspacio() {
        return estado;
    }

    public void setEstadoEspacio(String estado) {
        this.estado = estado;
    }
    public int getCapacidadEspacio() {
        return capacidad;
    }

    public void setcapacidadEspacio(int capacidad) {
        this.capacidad = capacidad;
    }
    public String getUbicacionEspacio() {
        return ubicacion;
    }

    public void setUbicacionEspacio(String ubicacion) {
        this.ubicacion = ubicacion;
    }
             public Reserva getIdReservaEspacio() {
        return idReserva;
    }

    public void setIdReservaEspacio(Reserva idReserva) {
        this.idReserva = idReserva;
    }

   
}