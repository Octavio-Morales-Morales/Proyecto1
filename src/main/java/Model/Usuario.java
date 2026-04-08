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
String correo ="";
Rol rolUsuario ;
boolean activo = false;

public Usuario(long idUsuario, String nombreUsuario, String correo, Rol rolUsuario, boolean activo ){
this.idUsuario = idUsuario;
this.nombreUsuario = nombreUsuario;
this.correo = correo;
this.rolUsuario = rolUsuario;
this.activo = activo;
    
}

public boolean activar(boolean activo){
    if(activo == false){
        return activo = true;
    }
    if(activo == true){
        return activo = false;
    }
    return activo;
}
    
}  

