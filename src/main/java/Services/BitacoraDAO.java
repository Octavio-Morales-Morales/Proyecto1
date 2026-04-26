/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Model.Bitacora;

import Config.ConexionBD;
import Repository.BitacoraRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author moral
 */
public class BitacoraDAO implements BitacoraRepository {
    
  public void InsertarBitacora(Bitacora bitacora) {
        String sql = "INSERT INTO AA_RES_BITACORA (ID_REGISTRO, ID_RESERVA, ID_USUARIO, ESTADO_RES, DETALLE, FECHA_REGISTRO) VALUES (?, ?, ?, ?, ?,?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, bitacora.getidBitacora());
            ps.setLong(2, bitacora.getreservaBitacora().getIdReserva() );
            ps.setLong(3, bitacora.getUsuarioBitacora().getIdUsuario());
            ps.setString(4, bitacora.getEstadoBitacora());
            ps.setString(5, bitacora.getDetalleBitacora());
            
        if (bitacora.getFechaRegistro() != null) {
            ps.setDate(6, new java.sql.Date(bitacora.getFechaRegistro().getTime()));
        } else {
            ps.setNull(6, java.sql.Types.DATE); // Por si la reserva no tiene fecha
        }
            ps.executeUpdate();
            System.out.println("Se inserto el registro en la Bitacora.");

        } catch (Exception e) {
            System.out.println("Error al registrar Bitacora: ");
        }
    }
    
     public void ListaBitacora() {
        String sql = "SELECT ID_REGISTRO, ID_RESERVA, ID_USUARIO, ESTADO_RES, DETALLE,FECHA_REGISTRO FROM cliente ORDER BY ID_REGISTRO";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                    rs.getInt("ID_REGISTRO") + " | " +
                    rs.getString("ID_RESERVA") + " | " +
                    rs.getString("ID_USUARIO") + " " +
                    rs.getString("ESTADO_RES") + " | " +
                    rs.getString("DETALLE")+ " | " +
                    rs.getString("FECHA_REGISTRO")        
                );
            }

        } catch (Exception e) {
            System.out.println("Error al listar la Bitacora: ");
        }
    }  
     
    public boolean BusquedaID(Bitacora bitacora){
        String sql = "SELECT COUNT(*) FROM AA_RES_BITACORA WHERE ID_REGISTRO = ?";
        try (Connection conn = ConexionBD.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setLong(1, bitacora.getidBitacora());
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                  return rs.getInt(1)> 0;
                }
            }
        }catch(Exception e){
            System.out.println("Error al consultar DB"+e.getMessage());
        }
        return false;
    } 
   public boolean EliminarColumnaBitacora(Bitacora bitacora){
       String sql = "DELETE FROM AA_RES_BITACORA WHERE ID_REGISTRO = ? ";
       try(Connection conn = ConexionBD.conectar();
               PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setLong(1,bitacora.getidBitacora());
           int filasAfectadas = ps.executeUpdate();
           if(filasAfectadas > 0 ){
          System.out.println("Registro con ID " + bitacora.getidBitacora() + " eliminado correctamente.");
            return true;     
           } else {
            System.out.println("No se encontró ningún registro con el ID: " + bitacora.getidBitacora());
            return false;   
           }
           
       }
     catch (SQLException e) {
        System.err.println("Error de SQL al intentar eliminar: " + e.getMessage());
        return false;
   }
}
   public boolean EditarBitacora(Bitacora bitacora){
       String sql = "UPDATE AA_RES_BITACORA SET ID_RESERVA = ?, ID_USUARIO = ?, ESTADO_RES = ?, DETALLE = ?,FECHA_REGISTRO = ? WHERE ID_REGISTRO = ?";
       try(Connection conn = ConexionBD.conectar();
       PreparedStatement ps = conn.prepareStatement(sql)){
           
        ps.setLong(1, bitacora.getreservaBitacora().getIdReserva());
        ps.setLong(2, bitacora.getUsuarioBitacora().getIdUsuario());
        ps.setString(3, bitacora.getEstadoBitacora());
        ps.setString(4, bitacora.getDetalleBitacora());
        
        
        if (bitacora.getFechaRegistro() != null) {
            ps.setDate(5, new java.sql.Date(bitacora.getFechaRegistro().getTime()));
        } else {
            ps.setNull(5, java.sql.Types.DATE); // Por si la reserva no tiene fecha
        }
        ps.setLong(6, bitacora.getidBitacora());
        
        int filasActualizadas = ps.executeUpdate();
        
        if (filasActualizadas > 0) {
            System.out.println("Bitácora actualizada correctamente.");
            return true;
       } else{
          System.out.println("No se encontró el registro para actualizar.");
            return false;  
        }
        
   }catch (Exception e) {
        System.out.println("Error al editar Bitácora: " + e.getMessage());
        return false;
    }
   
   }
}
