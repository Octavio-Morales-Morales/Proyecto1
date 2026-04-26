/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.Reserva;


/**
 *
 * @author moral
 */
public interface ReservaRepository {
    void InsertarReserva(Reserva reserva);
    boolean EditarReserva(Reserva reserva);
    boolean EliminarReserva(Reserva reserva);
    boolean BusquedaIDReserva(Reserva reserva);


}
