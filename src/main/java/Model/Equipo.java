/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moral
 */
public class Equipo extends Recurso{

    String marca = "";
    String Serie = "";
  
   
    public Equipo(){}
    
    public Equipo(long idRecurso, String NombreEquipo, String DescripEquipo, String estado, String marca, String Serie, Reserva idReserva ) {
        super(idRecurso, NombreEquipo, DescripEquipo, estado);
        this.marca = marca;
        this.Serie = Serie;
     
        
    }
    @Override 
    public String getNombre() {
        return nombre;
    }
    
    @Override 
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }
    
    @Override 
    public String getDescripcion(){
        return descripcion; 
    }
  
    @Override 
    public String getEstado() {
        return estado;
    }
    
    @Override 
    public void setEstado(String estado) {
        this.estado = estado; 
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


   
    
}
