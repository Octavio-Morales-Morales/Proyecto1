/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Config.ConexionBD;
import Config.ConexionBD;
import Model.Reserva;
import Repository.ReservaRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moral
 */
public class ReservasDAO implements ReservaRepository {
    @Override
    public void InsertarReserva(Reserva reserva){
        String sql = "INSERT INTO AA_RES_RESERVAS (ID_RESERVA, ID_USUARIO, FECHA_INICIO, FECHA_FIN, ESTADO_RESERVA, MOTIVO_RESERVA) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, reserva.getIdReserva());
            ps.setLong(2, reserva.getUsuario());
            ps.setDate(3, new java.sql.Date( reserva.getFechaInicio().getTime()));
            ps.setDate(4, new java.sql.Date(reserva.getFechaFin().getTime()));
            
            ps.setString(5, reserva.getEstadoreserva());
            ps.setString(6, reserva.getMotivoReserva());

            ps.executeUpdate();
            
            System.out.println("Se insertó la Reserva correctamente.");
            
            } catch (Exception e) {
            System.out.println("Error al registrar Reserva: " + e.getMessage());
        }
    }
    public boolean EditarReserva(Reserva reserva) {
        String sql = "UPDATE AA_RES_RESERVAS SET ID_USUARIO = ?, FECHA_INICIO = ?, FECHA_FIN = ?, ESTADO_RESERVA = ?, MOTIVO_RESERVA = ? WHERE ID_RESERVA = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, reserva.getUsuario());
            ps.setDate(2, new java.sql.Date(reserva.getFechaInicio().getTime()));
            ps.setDate(3, new java.sql.Date(reserva.getFechaFin().getTime()));
            ps.setString(4, reserva.getEstadoreserva());
            ps.setString(5, reserva.getMotivoReserva());
            
            // El ID de la reserva va al final para el WHERE
            ps.setLong(6, reserva.getIdReserva());

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Reserva actualizada correctamente.");
                return true;
            } else {
                System.out.println("No se encontró la reserva para actualizar.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al editar Reserva: " + e.getMessage());
            return false;
        }
    }
    
    public boolean EliminarReserva(Reserva reserva) {
        String sql = "DELETE FROM AA_RES_RESERVAS WHERE ID_RESERVA = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setLong(1, reserva.getIdReserva());
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Reserva con ID " + reserva.getIdReserva() + " eliminada correctamente.");
                return true;
            } else {
                System.out.println("No se encontró ninguna reserva con el ID: " + reserva.getIdReserva());
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL al intentar eliminar reserva: " + e.getMessage());
            return false;
        }
    }
    public boolean BusquedaIDReserva(Reserva reserva) {
        String sql = "SELECT COUNT(*) FROM AA_RES_RESERVAS WHERE ID_RESERVA = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, reserva.getIdReserva());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al consultar DB (Reservas): " + e.getMessage());
        }
        return false;
    }
    public List<Reserva> obtenerListaReservas() {
    List<Reserva> lista = new ArrayList<>();
    String sql = "SELECT * FROM AA_RES_RESERVAS ORDER BY ID_RESERVAS";
    try (Connection conn = ConexionBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Reserva r = new Reserva();
            r.setIdReserva(rs.getLong("ID_RESERVAS"));
            r.setUsuario(rs.getLong("ID_USUARIO"));
            r.setFechaInicio(rs.getDate("FECHA_INICIO"));
            r.setFechaFin(rs.getDate("FECHA_FIN"));
            r.setEstadoreserva(rs.getString("ESTADO_RESERVA"));
            r.setMotivoReserva(rs.getString("MOTIVO_RESERVA"));
            r.setRecursoID(rs.getLong("ID_RECURSOS"));
            lista.add(r);
        }
    } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    return lista;
}

 
}
