/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moral
 */
public class Equipo extends Recursos {
 
    String marca = "";
    String modelo = "";
    
    public Equipo(long idRecurso, String NombreRecurso, String DescripRecurso, boolean estado, String marca, String modelo ) {
        super(idRecurso, NombreRecurso, DescripRecurso, estado);
        this.marca = marca;
        this.modelo = modelo;
        
    }
    
}
