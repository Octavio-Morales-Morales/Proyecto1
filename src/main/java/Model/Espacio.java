/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moral
 */
public class Espacio extends Recurso {

    int capacidad = 0;
    String ubicacion = "";

    public Espacio(){}
    public Espacio(long idRecurso, String NombreEspacio, String DescripEspacio, String estado, int capacidad,String ubicacion ) {
     super(idRecurso, NombreEspacio, DescripEspacio, estado);
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
      
        
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


   
}