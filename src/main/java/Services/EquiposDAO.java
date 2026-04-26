/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Config.ConexionBD;
import Model.Equipo;
import Repository.EquipoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author moral
 */
public class EquiposDAO implements EquipoRepository{
    
    public void InsertarEquipo(Equipo equipo) {
        String sql = "INSERT INTO AAA_EQUIPOS (ID_RECURSOS, MARCA, SERIE ) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, equipo.getIdRecurso());
            ps.setString(2, equipo.getMarcaEquipo());
            ps.setString(3, equipo.getSerieEquipo());


            ps.executeUpdate();
            System.out.println("Se insertó el registro del Equipo correctamente.");

        } catch (Exception e) {
            System.out.println("Error al registrar Equipo: " + e.getMessage());
        }
    }
    public boolean EditarEquipo(Equipo equipo) {
        String sql = "UPDATE AAA_EQUIPOS SET ID_RECURSOS = ?, MARCA = ?,SERIE = ? WHERE ID_RECURSO = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            
            ps.setString(1, equipo.getMarcaEquipo());
            ps.setString(2, equipo.getSerieEquipo());
            ps.setLong(3, equipo.getIdRecurso());

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
        String sql = "DELETE FROM AAA_EQUIPOS WHERE ID_RECURSOS = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setLong(1, equipo.getIdRecurso());
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Equipo con ID " + equipo.getIdRecurso() + " eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró ningún equipo con el ID: " + equipo.getIdRecurso());
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL al intentar eliminar equipo: " + e.getMessage());
            return false;
        }
    }
    
    public boolean BusquedaIDEquipo(Equipo equipo) {
        String sql = "SELECT COUNT(*) FROM AAA_EQUIPOS WHERE ID_RECURSOS = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, equipo.getIdRecurso());
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
        String sql = "SELECT ID_RECURSOS , MARCA , SERIE FROM AAA_EQUIPOS ORDER BY ID_RECURSOS" ;

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("--- LISTADO DE EQUIPOS ---");
            while (rs.next()) {
                System.out.println(
                    rs.getLong("ID_EQUIPO") + " | " +
                    rs.getString("MARCA_EQUIPO") + " | " +
                    rs.getString("SERIE_EQUIPO") + " | "
                );
            }

        } catch (Exception e) {
            System.out.println("Error al listar los Equipos: " + e.getMessage());
        }
    }

}
