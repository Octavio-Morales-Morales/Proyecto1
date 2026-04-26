/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Config.ConexionBD;
import Model.Recurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author moral
 */
public class RecursosDAO {
    public void InsertarRecurso(Recurso recurso) {
        String sql = "INSERT INTO AAA_RECURSOS (ID_RECURSOS , NOMBRE, DESCRIPCION, ESTADO  ) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, recurso.getIdRecurso());
            ps.setString(2, recurso.getNombre());
            ps.setString(3, recurso.getDescripcion());
            ps.setString(3, recurso.getEstado());


            ps.executeUpdate();
            System.out.println("Se insertó el registro del Recurso correctamente.");

        } catch (Exception e) {
            System.out.println("Error al registrar Recurso: " + e.getMessage());
        }
    }
    public boolean EditarRecurso(Recurso recurso) {
        String sql = "UPDATE AAA_RECURSOS SET ID_RECURSOS = ?, NOMBRE = ?, DESCRIPCION = ?, ESTADO = ? WHERE ID_RECURSOS = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            
            ps.setString(1, recurso.getNombre());
            ps.setString(2, recurso.getDescripcion());
            ps.setString(4, recurso.getEstado());
            
            ps.setLong(3, recurso.getIdRecurso());

            int filasActualizadas = ps.executeUpdate();
            
            if (filasActualizadas > 0) {
                
                System.out.println("Recurso actualizado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró el Recurso para actualizar.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al editar Recurso: " + e.getMessage());
            return false;
        }
    }
    public boolean EliminarRecurso(Recurso recurso) {
        String sql = "DELETE FROM AAA_RECURSOS WHERE ID_RECURSOS = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setLong(1, recurso.getIdRecurso());
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("recurso con ID " + recurso.getIdRecurso() + " eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró ningún recurso con el ID: " + recurso.getIdRecurso());
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL al intentar eliminar recurso: " + e.getMessage());
            return false;
        }
    }
    
    public boolean BusquedaIDRecurso(Recurso recurso) {
        String sql = "SELECT COUNT(*) FROM AAA_RECURSOS WHERE ID_RECURSOS = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, recurso.getIdRecurso());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al consultar DB (Equipos): " + e.getMessage());
        }
        return false;
    }
    public void ListaRecurso() {
        String sql = "SELECT ID_RECURSOS , NOMBRE , DESCRIPCION, ESTADO  FROM AAA_RECURSOS ORDER BY ID_RECURSOS";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("--- LISTADO DE RECURSO ---");
            while (rs.next()) {
                System.out.println(
                    rs.getLong("ID_RECURSOS") + " | " +
                    rs.getString("NOMBRE") + " | " +
                    rs.getString("DESCRIPCION") + " | "+
                    rs.getString("ESTADO") + " | "   
                );
            }

        } catch (Exception e) {
            System.out.println("Error al listar los Equipos: " + e.getMessage());
        }
    }
  
}
