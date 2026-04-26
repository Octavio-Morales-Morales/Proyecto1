/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Config.ConexionBD;
import Model.Espacio;
import Repository.EspacioRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author moral
 */
public class EspaciosDAO implements EspacioRepository{
    
public void InsertarEspacio(Espacio espacio) {
        String sql = "INSERT INTO AAA_ESPACIOS (ID_RECURSO, CAPACIDAD, UBICACION) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, espacio.getIdRecurso());
            ps.setInt(2, espacio.getCapacidadEspacio()); // Usamos setInt para capacidad
            ps.setString(3, espacio.getUbicacionEspacio());

            ps.executeUpdate();
            System.out.println("Se insertó el registro del Espacio correctamente.");

        } catch (Exception e) {
            System.out.println("Error al registrar Espacio: " + e.getMessage());
        }
    }

  
    public boolean EditarEspacio(Espacio espacio) {
        String sql = "UPDATE AAA_ESPACIOS SET ID_RECURSO = ?, CAPACIDAD = ?, UBICACION = ? WHERE ID_RECURSO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            
            ps.setInt(1, espacio.getCapacidadEspacio());
            ps.setString(2, espacio.getUbicacionEspacio());
            
            ps.setLong(3, espacio.getIdRecurso());

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Espacio actualizado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró el espacio para actualizar.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al editar Espacio: " + e.getMessage());
            return false;
        }
    }

   
    public boolean EliminarEspacio(Espacio espacio) {
        String sql = "DELETE FROM AAA_ESPACIOS WHERE ID_RECURSO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setLong(1, espacio.getIdRecurso());
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Espacio con ID " + espacio.getIdRecurso() + " eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró ningún espacio con el ID: " + espacio.getIdRecurso());
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL al intentar eliminar espacio: " + e.getMessage());
            return false;
        }
    }

    
    public boolean BusquedaIDEspacio(Espacio espacio) {
        String sql = "SELECT COUNT(*) FROM AAA_ESPACIOS WHERE ID_RECURSO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, espacio.getIdRecurso());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al consultar DB (Espacios): " + e.getMessage());
        }
        return false;
    }

   
    public void ListaEspacios() {
        String sql = "SELECT ID_RECURSO, CAPACIDAD, UBICACION FROM AA_RES_ESPACIOS ORDER BY ID_RECURSO";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("--- LISTADO DE ESPACIOS ---");
            while (rs.next()) {
                System.out.println(
                    rs.getLong("ID_ESPACIO") + " | " +
                    rs.getInt("CAPACIDAD") + " | " +
                    rs.getString("UBICACION_ESPACIO") + " | " 
   
                );
            }

        } catch (Exception e) {
            System.out.println("Error al listar los Espacios: " + e.getMessage());
        }
    }
}
