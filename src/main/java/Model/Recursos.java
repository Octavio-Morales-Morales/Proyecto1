/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moral
 */
public class Recursos {
 long idRecurso =0;
 String NombreRecurso;
 String DescripRecurso;
 boolean estado;
 
 public Recursos(long idRecurso, String NombreRecurso, String DescripRecurso, boolean estado){
     this.idRecurso = idRecurso;
     this.NombreRecurso = NombreRecurso;
     this.DescripRecurso = DescripRecurso;
     this.estado = estado;
     
 }
}
