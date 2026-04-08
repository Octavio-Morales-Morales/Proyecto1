/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moral
 */
public class Espacio extends Recursos {
    int capacidad = 0;
    String ubicacion = "";
    public Espacio(long idRecurso, String NombreRecurso, String DescripRecurso, boolean estado, int capacidad,String ubicacion ) {
        super(idRecurso, NombreRecurso, DescripRecurso, estado);
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }
    
}