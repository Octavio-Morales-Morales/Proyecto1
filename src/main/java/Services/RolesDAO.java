/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Config.ConexionBD;
import Model.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author moral
 */
public class RolesDAO {

    public void InsertarRol(Rol rol) {
        String sql = "INSERT INTO AA_RES_ROLES (ID_ROL, NOMBRE_ROL) VALUES (?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, rol.getIdRol());
            ps.setString(2, rol.getNombreRol());

            ps.executeUpdate();
            System.out.println("Se insertó el Rol correctamente.");

        } catch (Exception e) {
            System.out.println("Error al registrar Rol: " + e.getMessage());
        }
    }

   
    public boolean EditarRol(Rol rol) {
        String sql = "UPDATE AA_RES_ROLES SET NOMBRE_ROL = ? WHERE ID_ROL = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, rol.getNombreRol());
            
            // El ID del rol va al final para el WHERE
            ps.setLong(2, rol.getIdRol());

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Rol actualizado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró el rol para actualizar.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al editar Rol: " + e.getMessage());
            return false;
        }
    }

    
    public boolean EliminarRol(Rol rol) {
        String sql = "DELETE FROM AA_RES_ROLES WHERE ID_ROL = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setLong(1, rol.getIdRol());
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Rol con ID " + rol.getIdRol() + " eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró ningún rol con el ID: " + rol.getIdRol());
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL al intentar eliminar rol: " + e.getMessage());
            return false;
        }
    }

    
    public boolean BusquedaIDRol(Rol rol) {
        String sql = "SELECT COUNT(*) FROM AA_RES_ROLES WHERE ID_ROL = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, rol.getIdRol());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al consultar DB (Roles): " + e.getMessage());
        }
        return false;
    }

   
    public void ListaRoles() {
        String sql = "SELECT ID_ROL, NOMBRE_ROL FROM AA_RES_ROLES ORDER BY ID_ROL";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("--- LISTADO DE ROLES ---");
            while (rs.next()) {
                System.out.println(
                    rs.getLong("ID_ROL") + " | " +
                    rs.getString("NOMBRE_ROL")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al listar los Roles: " + e.getMessage());
        }
    }
}  

