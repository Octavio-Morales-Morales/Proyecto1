/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.Bitacora;

/**
 *
 * @author moral
 */
public interface BitacoraRepository {
   void InsertarBitacora(Bitacora bitacora);
   void ListaBitacora();
   boolean BusquedaID(Bitacora bitacora);
   boolean EliminarColumnaBitacora(Bitacora bitacora);
   boolean EditarBitacora(Bitacora bitacora);
   
}
