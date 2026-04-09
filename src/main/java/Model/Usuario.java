/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author moral
 */
public class Usuario {
long idUsuario = 0;   
String nombreUsuario = "" ;
Rol rolUsuario ;
String activo = "";

public Usuario(long idUsuario, String nombreUsuario, Rol rolUsuario, String activo ){
this.idUsuario = idUsuario;
this.nombreUsuario = nombreUsuario;
this.rolUsuario = rolUsuario;
this.activo = activo;
    
}

  public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public Rol getRolUsuario() {
        return rolUsuario;
    }

    public void setFechaInicio(Rol rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
    public String getActivo() {
        return activo ;
    }

    public void setFechaFin(String activo) {
        this.activo = activo;
    }
    
}  

