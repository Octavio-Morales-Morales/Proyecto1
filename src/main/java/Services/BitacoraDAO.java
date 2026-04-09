/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Config.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author moral
 */
public class BitacoraDAO {
  public void insertar(Cliente cliente) {
        String sql = "INSERT INTO cliente (identificacion, nombre, apellido, correo) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getIdentificacion());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getCorreo());

            ps.executeUpdate();
            System.out.println("Cliente registrado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al registrar cliente: " + e.getMessage());
        }
    }
    
    
    
}
