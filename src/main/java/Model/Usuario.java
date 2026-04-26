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
long IDrolUsuario = 0;
String contraseña = "";

public Usuario(){
    
}

public Usuario(long idUsuario, String nombreUsuario, String contraseña, Long IDrolUsuario ){
this.idUsuario = idUsuario;
this.nombreUsuario = nombreUsuario;
this.contraseña = contraseña;
this.IDrolUsuario = rolUsuario.getIdRol();   
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
  
    public Long getIDRolUsuario() {
        return IDrolUsuario = rolUsuario.getIdRol();
    }
    public void setIDRolUsuario(long ID){
        this.IDrolUsuario = ID;
    }
    
    public String getContraseña() {
        return contraseña ;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
   
}  

