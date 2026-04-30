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
long IDrolUsuario = 0;
String contraseña = "";

public Usuario(){
    
}

public Usuario(long idUsuario, String nombreUsuario, String contraseña, long IDrolUsuario ){
this.idUsuario = idUsuario;
this.nombreUsuario = nombreUsuario;
this.contraseña = contraseña;
this.IDrolUsuario = IDrolUsuario;   
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
  
    public long getIDRolUsuario() {
        return IDrolUsuario;
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

