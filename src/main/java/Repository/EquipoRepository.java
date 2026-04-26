/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.Equipo;

/**
 *
 * @author moral
 */
public interface EquipoRepository {
    void InsertarEquipo(Equipo equipo);
    boolean EditarEquipo(Equipo equipo);
    boolean EliminarEquipo(Equipo equipo);
    boolean BusquedaIDEquipo(Equipo equipo);
    void ListaEquipos();
}
