/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Config.ConexionBD;
import Model.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author moral
 */
public class EquiposDAO {
    
    public void InsertarEquipo(Equipo equipo) {
        String sql = "INSERT INTO AA_RES_EQUIPOS (ID_EQUIPO, NOMBRE_EQUIPO, MARCA_EQUIPO, DESCRIPCION_EQUIPO, SERIE_EQUIPO, ID_RESERVA) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, equipo.getIdEquipo());
            ps.setString(2, equipo.getNombreEquipo());
            ps.setString(3, equipo.getMarcaEquipo());
            ps.setString(4, equipo.getDescripEquipo());
            ps.setString(5, equipo.getSerieEquipo());
            ps.setLong(6, equipo.getIdReservaEquipo().getIdReserva());

            ps.executeUpdate();
            System.out.println("Se insertó el registro del Equipo correctamente.");

        } catch (Exception e) {
            System.out.println("Error al registrar Equipo: " + e.getMessage());
        }
    }
    public boolean EditarEquipo(Equipo equipo) {
        String sql = "UPDATE AA_RES_EQUIPOS SET NOMBRE_EQUIPO = ?, MARCA_EQUIPO = ?, DESCRIPCION_EQUIPO = ?, SERIE_EQUIPO = ?, ID_RESERVA = ? WHERE ID_EQUIPO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, equipo.getNombreEquipo());
            ps.setString(2, equipo.getMarcaEquipo());
            ps.setString(3, equipo.getDescripEquipo());
            ps.setString(4, equipo.getSerieEquipo());
            ps.setLong(5, equipo.getIdReservaEquipo().getIdReserva());
            
            // El ID del equipo va al final para el WHERE
            ps.setLong(6, equipo.getIdEquipo());

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Equipo actualizado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró el equipo para actualizar.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al editar Equipo: " + e.getMessage());
            return false;
        }
    }
    public boolean EliminarEquipo(Equipo equipo) {
        String sql = "DELETE FROM AA_RES_EQUIPOS WHERE ID_EQUIPO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setLong(1, equipo.getIdEquipo());
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Equipo con ID " + equipo.getIdEquipo() + " eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró ningún equipo con el ID: " + equipo.getIdEquipo());
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL al intentar eliminar equipo: " + e.getMessage());
            return false;
        }
    }
    public boolean BusquedaIDEquipo(Equipo equipo) {
        String sql = "SELECT COUNT(*) FROM AA_RES_EQUIPOS WHERE ID_EQUIPO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, equipo.getIdEquipo());
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
    public void ListaEquipos() {
        String sql = "SELECT ID_EQUIPOS, NOMBRE_EQUIPO, MARCA_EQUIPO, DESCRIPCION_EQUIPO, SERIE_EQUIPO, ID_RESERVA FROM AA_RES_EQUIPO ORDER BY ID_EQUIPO";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("--- LISTADO DE EQUIPOS ---");
            while (rs.next()) {
                System.out.println(
                    rs.getLong("ID_EQUIPO") + " | " +
                    rs.getString("NOMBRE_EQUIPO") + " | " +
                    rs.getString("MARCA_EQUIPO") + " | " +
                    rs.getString("SERIE_EQUIPO") + " | Reserva ID: " +
                    rs.getLong("ID_RESERVA")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al listar los Equipos: " + e.getMessage());
        }
    }

}
