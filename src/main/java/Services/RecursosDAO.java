/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Config.ConexionBD;
import Model.Equipo;
import Model.Espacio;
import Model.Recurso;
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
public class RecursosDAO {
    public void InsertarRecurso(Recurso recurso) throws SQLException {
        String sqlPadre = "INSERT INTO AAA_RECURSOS (ID_RECURSOS , NOMBRE, DESCRIPCION, ESTADO  ) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar()){
            conn.setAutoCommit(false);
          try(PreparedStatement ps = conn.prepareStatement(sqlPadre)) {

            ps.setLong(1, recurso.getIdRecurso());
            ps.setString(2, recurso.getNombre());
            ps.setString(3, recurso.getDescripcion());
            ps.setString(4, recurso.getEstado());
            ps.executeUpdate();
          
             if (recurso instanceof Equipo) {
            Equipo eq = (Equipo) recurso;
            String sqlHijo = "INSERT INTO AAA_EQUIPOS (ID_RECURSOS, MARCA, SERIE) VALUES (?, ?, ?)";
            try (PreparedStatement psHijo = conn.prepareStatement(sqlHijo)) {
                psHijo.setLong(1, eq.getIdRecurso());
                psHijo.setString(2, eq.getMarcaEquipo());
                psHijo.setString(3, eq.getSerieEquipo());
                psHijo.executeUpdate();
            }
        } else if (recurso instanceof Espacio) {
            Espacio es = (Espacio) recurso;
            String sqlHijo = "INSERT INTO AAA_ESPACIOS (ID_RECURSOS, CAPACIDAD, UBICACION) VALUES (?, ?, ?)";
            try (PreparedStatement psHijo = conn.prepareStatement(sqlHijo)) {
                psHijo.setLong(1, es.getIdRecurso());
                psHijo.setLong(2, es.getCapacidadEspacio());
                psHijo.setString(3, es.getUbicacionEspacio());
                psHijo.executeUpdate();
            }
        }
            conn.commit(); 
            System.out.println("Inserción Recurso exitosa");
        } catch (Exception e) {
            conn.rollback();
            System.out.println("Error al registrar Recurso, pero se hizo rollback " + e.getMessage());
        } 
        }
        catch (Exception e) {
        System.err.println("Error de conexión: " + e.getMessage());
    }
          
    }
    public boolean EditarRecurso(Recurso recurso) throws SQLException {
        String sqlPadre = "UPDATE AAA_RECURSOS SET NOMBRE = ?, DESCRIPCION = ?, ESTADO = ? WHERE ID_RECURSOS = ?";
        try (Connection conn = ConexionBD.conectar()){
            conn.setAutoCommit(false);
            try(PreparedStatement ps = conn.prepareStatement(sqlPadre)) {

            
            ps.setString(1, recurso.getNombre());
            ps.setString(2, recurso.getDescripcion());
            ps.setString(3, recurso.getEstado());
            
            ps.setLong(4, recurso.getIdRecurso());

            int filasActualizadas = ps.executeUpdate();
            
            if (filasActualizadas > 0) {
                if (recurso instanceof Equipo) {
                    Equipo eq = (Equipo) recurso;
                    String sqlHijo = "UPDATE AAA_EQUIPOS SET MARCA = ?, SERIE = ? WHERE ID_RECURSOS = ?";
                    try (PreparedStatement psHijo = conn.prepareStatement(sqlHijo)) {
                        psHijo.setString(1, eq.getMarcaEquipo());
                        psHijo.setString(2, eq.getSerieEquipo());
                        psHijo.setLong(3, eq.getIdRecurso());
                        psHijo.executeUpdate();
                    }
                } 
                else if (recurso instanceof Espacio) {
                    Espacio es = (Espacio) recurso;
                    String sqlHijo = "UPDATE AAA_ESPACIOS SET CAPACIDAD = ?, UBICACION = ? WHERE ID_RECURSOS = ?";
                    try (PreparedStatement psHijo = conn.prepareStatement(sqlHijo)) {
                        psHijo.setLong(1, es.getCapacidadEspacio());
                        psHijo.setString(2, es.getUbicacionEspacio());
                        psHijo.setLong(3, es.getIdRecurso());
                        psHijo.executeUpdate();
                    }
                }
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
    }
    
    public boolean EliminarRecurso(Recurso recurso) throws SQLException {
        String sqlEquipo = "DELETE FROM AAA_EQUIPOS WHERE ID_RECURSOS = ?";
        String sqlEspacio = "DELETE FROM AAA_ESPACIOS WHERE ID_RECURSOS = ?";
        String sqlPadre = "DELETE FROM AAA_RECURSOS WHERE ID_RECURSOS = ?";
        
        try (Connection conn = ConexionBD.conectar()){
           conn.setAutoCommit(false);
            try {
                try(PreparedStatement psEq = conn.prepareStatement(sqlEquipo)) {
                psEq.setLong(1, recurso.getIdRecurso());
                 psEq.executeUpdate();
                }
                try (PreparedStatement psEs = conn.prepareStatement(sqlEspacio)) {
                 psEs.setLong(1, recurso.getIdRecurso());
                  psEs.executeUpdate();
                } 
                try (PreparedStatement psPadre = conn.prepareStatement(sqlPadre)) {
                psPadre.setLong(1, recurso.getIdRecurso());
            int filasAfectadas = psPadre.executeUpdate();
            
            if (filasAfectadas > 0) {
                conn.commit();
                System.out.println("recurso con ID " + recurso.getIdRecurso() + " eliminado correctamente.");
                return true;
            } else {
                conn.rollback();
                System.out.println("No se encontró ningún recurso con el ID: " + recurso.getIdRecurso());
                return false;
            }
                }
        } catch (SQLException e) {
            System.err.println("Error de SQL al intentar eliminar recurso: " + e.getMessage());
            return false;
        }
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
public List<Recurso> ListaRecursos() {
    List<Recurso> lista = new ArrayList<>();
    String sql = "SELECT R.*, E.MARCA, E.SERIE, S.CAPACIDAD, S.UBICACION " +
                 "FROM AAA_RECURSOS R " +
                 "LEFT JOIN AAA_EQUIPOS E ON R.ID_RECURSOS = E.ID_RECURSOS " +
                 "LEFT JOIN AAA_ESPACIOS S ON R.ID_RECURSOS = S.ID_RECURSOS " +
                 "ORDER BY R.ID_RECURSOS";

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Recurso r;
            if (rs.getString("MARCA") != null) {
                Equipo eq = new Equipo();
                eq.setMarcaEquipo(rs.getString("MARCA"));
                eq.setSerieEquipo(rs.getString("SERIE"));
                r = eq;
            } 
            else if (rs.getLong("CAPACIDAD") > 0 || rs.getString("UBICACION") != null) {
                Espacio es = new Espacio();
                es.setcapacidadEspacio(rs.getLong("CAPACIDAD"));
                es.setUbicacionEspacio(rs.getString("UBICACION"));
                r = es;
            } else {
                r = new Recurso() {};
            }

            // Llenamos los datos comunes del padre
            r.setIdRecurso(rs.getLong("ID_RECURSOS"));
            r.setNombre(rs.getString("NOMBRE"));
            r.setDescripcion(rs.getString("DESCRIPCION"));
            r.setEstado(rs.getString("ESTADO"));
            
            lista.add(r);
        }
    } catch (Exception e) {
        System.out.println("Error al obtener lista completa: " + e.getMessage());
    }
    return lista;
}
}
