/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moral
 */
public abstract class Recurso {
    
    protected long idRecurso;
    protected String nombre;
    protected String descripcion;
    protected String estado; 

    public Recurso() {}

    public Recurso(long idRecurso, String nombre, String descripcion, String estado) {
        this.idRecurso = idRecurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    
    public long getIdRecurso(){
        return idRecurso; }
    public void setIdRecurso(long idRecurso) {
        this.idRecurso = idRecurso; }
    public String getNombre() {
        return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre; }
    public String getDescripcion(){
        return descripcion; }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion; }
    public String getEstado() {
        return estado; }
    public void setEstado(String estado) {
        this.estado = estado; }
}

