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
String contraseña = "";

public Usuario(long idUsuario, String nombreUsuario, String contraseña, Rol rolUsuario ){
this.idUsuario = idUsuario;
this.nombreUsuario = nombreUsuario;
this.contraseña = contraseña;
this.rolUsuario = rolUsuario;   
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

    public void setRolUsuario(Rol rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
    public String getContraseña() {
        return contraseña ;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}  

