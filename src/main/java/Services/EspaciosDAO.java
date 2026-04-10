/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Config.ConexionBD;
import Model.Espacio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author moral
 */
public class EspaciosDAO {
public void InsertarEspacio(Espacio espacio) {
        String sql = "INSERT INTO AA_RES_ESPACIOS (ID_ESPACIO, NOMBRE_ESPACIO, CAPACIDAD, UBICACION_ESPACIO, DESCRIPCION_ESPACIO, ID_RESERVA) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, espacio.getIdEspacio());
            ps.setString(2, espacio.getNombreEspacio());
            ps.setInt(3, espacio.getCapacidadEspacio()); // Usamos setInt para capacidad
            ps.setString(4, espacio.getUbicacionEspacio());
            ps.setString(5, espacio.getDescripEspacio());
            ps.setLong(6, espacio.getIdReservaEspacio().getIdReserva());

            ps.executeUpdate();
            System.out.println("Se insertó el registro del Espacio correctamente.");

        } catch (Exception e) {
            System.out.println("Error al registrar Espacio: " + e.getMessage());
        }
    }

  
    public boolean EditarEspacio(Espacio espacio) {
        String sql = "UPDATE AA_RES_ESPACIOS SET NOMBRE_ESPACIO = ?, CAPACIDAD = ?, UBICACION_ESPACIO = ?, DESCRIPCION_ESPACIO = ?, ID_RESERVA = ? WHERE ID_ESPACIO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, espacio.getNombreEspacio());
            ps.setInt(2, espacio.getCapacidadEspacio());
            ps.setString(3, espacio.getUbicacionEspacio());
            ps.setString(4, espacio.getDescripEspacio());
            ps.setLong(5, espacio.getIdReservaEspacio().getIdReserva());
            
            // El ID del espacio va al final para el WHERE
            ps.setLong(6, espacio.getIdEspacio());

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
        String sql = "DELETE FROM AA_RES_ESPACIOS WHERE ID_ESPACIO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setLong(1, espacio.getIdEspacio());
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Espacio con ID " + espacio.getIdEspacio() + " eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró ningún espacio con el ID: " + espacio.getIdEspacio());
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL al intentar eliminar espacio: " + e.getMessage());
            return false;
        }
    }

    
    public boolean BusquedaIDEspacio(Espacio espacio) {
        String sql = "SELECT COUNT(*) FROM AA_RES_ESPACIOS WHERE ID_ESPACIO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, espacio.getIdEspacio());
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
        String sql = "SELECT ID_ESPACIO, NOMBRE_ESPACIO, CAPACIDAD, UBICACION_ESPACIO, DESCRIPCION_ESPACIO, ID_RESERVA FROM AA_RES_ESPACIOS ORDER BY ID_ESPACIO";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("--- LISTADO DE ESPACIOS ---");
            while (rs.next()) {
                System.out.println(
                    rs.getLong("ID_ESPACIO") + " | " +
                    rs.getString("NOMBRE_ESPACIO") + " | Cap: " +
                    rs.getInt("CAPACIDAD") + " | " +
                    rs.getString("UBICACION_ESPACIO") + " | Reserva ID: " +
                    rs.getLong("ID_RESERVA")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al listar los Espacios: " + e.getMessage());
        }
    }
}
